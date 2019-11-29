import copy

from walnut.ast import Ast

from arrayinit import new_array
from checker import checker
from codesymtab import CodeSymtab
import constants
from util import is_multi_def
from varinfo import LocalInfo
from walnutsys import sys_coord


class CodeChecker:

    def __init__(self):
        #cache primitive types
        self.Int = checker.types.get('Int')
        self.Real = checker.types.get('Real')
        self.String = checker.types.get('String')
        self.Void = checker.types.get('Void')
        self.Nil = checker.types.get(constants.NIL_TYPE)
        self.Error = checker.types.error()

    def check_and_xform(self, klass):
        """check and destructively transform all static function asts in
           klass.fns and all method asts in klass.methods.

           klass is an instance of ClassType.  klass.get(name) returns
           information about name defined within klass.  This will be
           a StaticFieldInfo instance for a static field, a
           InstanceFieldInfo for a instance field and a FunctionInfo
           instance for a method or static fn.

           Use checker.types to access information about global types
           like classes.

           Use checker.errors.add(...) to report errors.

        """
        for ast in klass.fns:
            self.check_and_xform_function(klass, ast, 'fn')
        for ast in klass.methods:
            self.check_and_xform_function(klass, ast, 'method')


    def check_and_xform_function(self, klass, ast, kind):
        assert(ast.tag == 'DEFN')
        name = ast.name
        info = klass.get(name)
        assert(info.kind == kind)
        #uncomment prints to see what the fns look like
        #print('*** %s %s.%s: %s' % (kind, klass.name, name, info.type))
        #print('AST:\n', ast)


        self.do_decls(ast.kids[2])
        self.do_type_visit(klass, ast, kind)
        self.check_ret_type(ast)
        #self.init_lr(ast.kids[2])
        self.do_l_r_values(ast.kids[2])
        self.insert_deref(ast.kids[2])


    def check_ret_type(self, ast):
        if ast.name == "f":
            pass
        else:
            return
        #print("-----in check_ret_type------")
        if ast.tag == "DEFN":
            type_obj = checker.types.get(ast.kids[0].type_name)
            self.check_ret_type_helper(ast, type_obj)

    def check_ret_type_helper(self, ast, type_obj):
        if ast.tag == "RETURN":
            #print("found return")
            #-------------------------------------------------------------
                
            lhs_type = type_obj
            rhs_type = ast.kids[0].type 

            l_kind = lhs_type.kind
            r_kind = rhs_type.kind
            if lhs_type.name == rhs_type.name:
                #print("types match")
                pass
            else:
                if l_kind == "class":
                   
                    if r_kind == "class":
               
                        if rhs_type.is_subtype_of(lhs_type):
                            pass
                        else:
                            msg = 'Return value is not assignable to declared ret type'
                            checker.errors.add(ast.coord, 'INVALID_RET_TYPE', msg)
                    elif r_kind == "nil":
                        pass
                
                else:
                    msg = 'Return value is not assignable to declared ret type'
                    checker.errors.add(ast.coord, 'INVALID_RET_TYPE', msg)
            #------------------------------------------------------------ 
        for k in ast.kids: self.check_ret_type_helper(k, type_obj)
  


    #def init_lr(self, ast):
    #    self.init_lr_helper(ast)


    #def init_lr_helper(self, ast):
    #    ast.needs_lvalue = False
    #    for k in ast.kids: self.init_lr_helper(k)


    def do_l_r_values(self, ast):

        
        self.l_r_recurse(ast, False)

        

    def l_r_recurse(self, ast, needs_l_value):
        #print("-------------in l_r_recurse --------------")
        #------------------------------down----------------------------------
        #print(ast)
        #if ast.tag == "INDEX":
        #    ast.kids[0].needs_lvalue = True
        #elif ast.tag == "ASSIGN":
        #    ast.kids[0].needs_lvalue = True
        #elif ast.tag == "ACCESS":
        #    ast..kids[0].needs_lvalue = True
        #elif ast.tag == "STATIC_ACCESS":
        #    ast.needs_lvalue = True
        #elif ast.tag == "APP":
        #    ast.needs_lvalue = True
        if ast.tag == "INDEX":
            self.l_r_recurse(ast.kids[0], True)
            for k in range(1, len(ast.kids)): self.l_r_recurse(ast.kids[k], False)
        elif ast.tag == "ASSIGN":
            self.l_r_recurse(ast.kids[0], True)
            for k in range(1, len(ast.kids)): self.l_r_recurse(ast.kids[k], False)
        elif ast.tag == "ACCESS":
            self.l_r_recurse(ast.kids[0], True)
            for k in range(1, len(ast.kids)): self.l_r_recurse(ast.kids[k], False)
        elif ast.tag == "APP":
            self.l_r_recurse(ast.kids[0], True)
            for k in range(1, len(ast.kids)): self.l_r_recurse(ast.kids[k], False)
        
        #------------------------------end Down------------------------------
        else:
            for k in range(len(ast.kids)): self.l_r_recurse(ast.kids[k], False)
        #--------------------------UP----------------------------------------

        #print("-------up--------")

        kids_copy = []
        for i in range(len(ast.kids)):
            
            if ast.kids[i].tag == "ID" and needs_l_value == False:
                kid_copy = copy.copy(ast.kids[i])
                coord = kid_copy.coord
                typ = kid_copy.type
                deref_ast = Ast("DEREF", kids = [kid_copy], coord=coord, type=typ)
                kids_copy.append(deref_ast)
            else:
                kid_copy = copy.copy(ast.kids[i])
                kids_copy.append(kid_copy)
        ast.kids = kids_copy
        

        #----------------------------END up-----------------------------------
    

    def do_type_visit(self, klass, ast, kind):
        #if ast.name == "f":# or ast.name == "Sub":
        #    pass
        #else:
        #    return
        symtab = CodeSymtab()
        symtab.begin_scope()
        if kind == "method":
            self_type = klass.type
            super_type = checker.types.get(klass.parent)
            self_info = LocalInfo("self", False, self_type, klass.coord)
            super_info = LocalInfo("super", False, super_type, klass.coord)
            symtab.put("self", self_info)
            symtab.put("super", super_info)
        self.type_visit(symtab, ast)
    
    def type_visit(self, env, ast):
        #print("\t" + "DOWN")
        tag = ast.tag
        coord = ast.coord
        # do stuff on the way down possibly updating the env
# DOWN -------------------------------------------------------------------------
        if tag == "PARAM":
            self.handle_param(env, ast)
        if tag == "INIT_PARAM":
            msg = 'params dont support initialization'
            checker.errors.add(coord, 'INIT_PARAM', msg)
            self.handle_param(env, ast)
        if tag == "DECLS":
            self.handle_decls(env, ast)
        if tag == "DECL":
            self.handle_decl(env, ast)
        if tag == "BLOCK":
            self.handle_block_down(env, ast)
        if tag == "INT" or tag == "REAL" or tag == "STRING" or tag == "NIL":
            self.handle_literal(env, ast)
        if tag == "NEW_ARRAY":
           self.handle_new_arr(env, ast)
        
            
# END DOWN ---------------------------------------------------------------------
        for k in ast.kids: self.type_visit(env, k)
        # do stuff on the way up the ast
        # this is where type checking and type annotation will occur
# UP ---------------------------------------------------------------------------        
        #print("\t" + "UP")

        if tag == "ID":
            self.handle_id(env, ast)
        if tag == "BLOCK":
            self.handle_block_up(env, ast)
        if tag == "OP1":
            self.handle_op1(env, ast)
        if tag == "OP2":
            self.handle_op2(env, ast)
        if tag == "ASSIGN":
            self.handle_assign(env, ast)
        if tag == "CAST":
            self.handle_cast(env, ast)
        if tag == "IF":
            self.handle_cond(env, ast)
        if tag == "WHILE":
            self.handle_cond(env, ast)
        if tag == "INDEX":
            self.handle_index(env, ast)
        if tag == "NEW_OBJ":
            self.handle_new_obj(env, ast)
        if tag == "ACCESS":
            self.handle_access(env, ast)
        if tag == "STATIC_ACCESS":
            self.handle_static_access(env, ast)
        if tag == "RETURN":
            self.handle_return(env, ast)
        if tag == "APP":
           self.handle_app(env, ast)
        
# END UP -----------------------------------------------------------------------    
    
    def handle_app(self, env, ast):
        #print("----------In handle_app----------")
        ret_type_obj = ast.kids[0].type.ret_type
        ast.type = ret_type_obj

    def insert_deref(self, ast):
        #print("------in insert_deref-------")
        pass
        

    
    def do_decls(self, ast):
        #print("___________in do_decls____________")
        assign_asts = []
        kids_copy = []
        if ast.tag == "BLOCK":
            for i in range(len(ast.kids)):
                if ast.kids[i].tag=="BLOCK":
                    self.do_decls(ast.kids[i])
                    kid_copy = copy.copy(ast.kids[i]) 
                    kids_copy.append(kid_copy) 
                elif ast.kids[i].tag=="DECLS":
                    decls_copy = copy.copy(ast.kids[i])
                    for j in range(len(ast.kids[i].kids)):
                        if ast.kids[i].kids[j].tag=="INIT_DECL":
                            decls_copy.kids[j].tag = "DECL"
                            id_name = ast.kids[i].kids[j].name 
                            id_coord = ast.kids[i].kids[j].coord
                            id_ast = Ast("ID", coord=id_coord, name=id_name)
                            assign_exp = ast.kids[i].kids[j].kids[0]
                            assign_coord = ast.kids[i].kids[j].kids[0].coord 
                            assign_ast = Ast("ASSIGN", [id_ast, assign_exp], coord=assign_coord)
                            decls_copy.kids[j].kids = [] 
                            assign_asts.append(assign_ast)
                        else:
                            pass

                    kids_copy.append(decls_copy)
                    for i in assign_asts:
                        kids_copy.append(i)
                    assign_asts = []
                else:

                    kid_copy = copy.copy(ast.kids[i]) 
                    kids_copy.append(kid_copy) 
        ast.kids = kids_copy



    def handle_param(self, env, ast): 
        name = ast.name
        if is_multi_def(env, name, ast.coord):
            #print("multidef found")
            pass
        else:

            param_type = ast.kids[0].type_name
            type_for_symtab = checker.types.get(param_type)
            param_info = LocalInfo(name, False, type_for_symtab, ast.coord)
            env.put(name, param_info)



    def handle_return(self, env, ast):
        #print("----------handle return----------")
        type_obj = ast.kids[0].type
        if type_obj:
            ast.type = type_obj
        else:
            msg = 'Error with handling the specified return type'
            checker.errors.add(ast.coord, 'UNDEFINED_RETURN_TYPE', msg)



    def handle_static_access(self, env, ast):
        #print("-------in handle_static_access------")
        type_obj = checker.types.get(ast.type_name)

        name = ast.name
        info = type_obj.get(name)

        if info:
            ast.type = info.type
        else:
            msg = 'There is not a static definition in the namespace for that id'
            checker.errors.add(ast.coord, 'UNDEFINED_ID', msg)

    def handle_access(self, env, ast):
        #print("--------in handle_access-------")
        type_obj = ast.kids[0].type 
        name = ast.name
        info = type_obj.get(name)
        if info:
            if info.kind == "method":
                pass
            ast.type = info.type
            ast.kind = info.kind

        else:
            msg = 'There is not a definition in the namespace for that id'
            checker.errors.add(ast.coord, 'UNDEFINED_ID', msg)



    def handle_new_obj(self, env, ast):
        #print("--------in handle_new_obj-------")
        type_obj = checker.types.get(ast.type_name)
        ast.type = type_obj


    def handle_index(self, env, ast):
        #print("-------in handle_index-------")
        arr_id = ast.kids[0]
        arr_type = arr_id.type
        arr_type_name = arr_type.name
        arr_info = env.get(ast.kids[0].name) 
        type_obj = checker.types.get(ast.kids[0].type.name)
        ast.type = type_obj

    def handle_new_arr(self, env, ast):
        #print("-----in handle_new_array----")
        ast.type = checker.types.get(ast.type_name)

    
    def handle_decls(self, env, ast):
        #print("----------in handle_decls----------")
        if ast.kind == "const":
            msg = 'Illegal use of \'const\''
            checker.errors.add(coord, 'BAD_CONST', msg)
        decls_type = ast.kids[0].type_name
        rank = ast.kids[0].rank
        decls_type = decls_type 
        type_for_symtab = checker.types.get(decls_type, rank)
        if type_for_symtab:
            for i in range(1, len(ast.kids)):
                ast.kids[i].type = type_for_symtab 
                ast.kids[i].type_name = decls_type
        else:
            for i in range(1, len(ast.kids)): 
                ast.kids[i].type = self.Error 
                ast.kids[i].type_name = "error" 
            msg = 'Declaration using an undefined type'
            checker.errors.add(ast.coord, 'UNKNOWN_TYPE', msg)
    
    def handle_decl(self, env, ast):
        #print("---------------------------in handle_decl----------------------------")
        name = ast.name
        if is_multi_def(env, name, ast.coord):
            #print("multidef found")
            pass
        else:
            param_info = LocalInfo(name, False, ast.type, ast.coord) 
            env.put(name, param_info)                   
        
                    
    def handle_id(self, env, ast):
        #print("----------in handle_id----------")  
        name = ast.name
        info = env.get(name)
        if info:
            ast.type = info.type 
            type_name = info.type.name 
            ast.type_name = type_name
        else:
            msg = 'Undefined name'
            checker.errors.add(ast.coord, 'UNDEFINED_NAME', msg)


    def handle_block_down(self, env, ast):
        #print("----------in block_down----------")
        env.begin_scope()


    def handle_block_up(self, env, ast):
        #print("----------in block up----------")
        env.end_scope()


    def handle_literal(self, env, ast):
        #print("----------in literal----------")
        lit_type = "";
        if ast.tag == "INT":  
            lit_type = "Int"
        elif ast.tag == "REAL":
            lit_type = "Real"
        elif ast.tag == "STRING":
            lit_type = "String"
        elif ast.tag == "NIL":
            lit_type = "$Nil"
        type_for_symtab = checker.types.get(lit_type)
        ast.type = type_for_symtab 

    def handle_op1(self, env, ast):
        #print("----------in handle_op1----------")
        if ast.op == "NEG":
            #print("NEG found")
            op_type = ast.kids[0].type.name 
            if op_type == "Int" or op_type == "Real":
                #print("real or int found")
                ast.type = ast.kids[0].type 
            else:
                msg = 'Invalid type for unary NEG operator' 
                checker.errors.add(ast.coord, 'INVALID_TYPE', msg)
                pass
        if ast.op == "NOT":
            #print("NOT found")
            o = ast.kids[0].type
            op_type = ast.kids[0].type.name  
            if op_type == "Int":
                ast.type = ast.kids[0].type 
            else:
                msg = 'Invalid type for unary NOT operator'
                checker.errors.add(ast.coord, 'INVALID_TYPE', msg)



    def handle_op2(self, env, ast):
        #print("----------in handle_op2----------")
        if(ast.op == "ADD"):
            self.add_check(env, ast)
        elif(ast.op == "SUB"):
            self.sub_check(env, ast)
        elif(ast.op == "MUL"):
            self.mul_check(env, ast)
        elif(ast.op == "DIV"):
            self.div_check(env, ast)
        elif(ast.op == "REM"):
            self.rem_check(env, ast)
       
        elif(ast.op == "LT"):
            self.compare_check(env, ast)
        elif(ast.op == "GT"):
            self.comare_check(env, ast)
        elif(ast.op == "LE"):
            self.compare_check(env, ast)
        elif(ast.op == "GE"):
            self.compare_check(env, ast)
        elif(ast.op == "AND"):
            self.and_or_check(env, ast)
        elif(ast.op == "OR"):
            self.and_or_check(env, ast)
        elif(ast.op =="EQ"):
            self.eq_neq_check(env, ast)
        elif(ast.op =="NE"):
            self.eq_neq_check(env, ast)

   
    
    def and_or_check(self, env, ast):
        #print("-------------in and_or_check--------------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name
        if l_type_name == "Int" and r_type_name == "Int":
            ast.type = checker.types.get("Int")
        else:
            msg = 'Unmatched operands for logical comparator operator'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)
        

    def eq_neq_check(self, env, ast):
        #print("-----------in eq_neq_check------------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name
        l_kind = l_type.kind
        r_kind = r_type.kind
        if l_kind == "primitive" and r_kind == "primitive":
            if l_type_name == "Int" and r_type_name == "Int":
                ast.type = checker.types.get("Int")
            elif l_type_name == "Real" and r_type_name == "Real":
                ast.type = checker.types.get("Int")
            elif l_type_name == "String" and r_type_name == "String":
                ast.type = checker.types.get("Int")
            else:
                msg = 'Unmatched operands for logical comparator operator'
                checker.errors.add(ast.coord, 'INVALID_TYPE', msg)
        else:
           #print("objType clause")
           pass


 
    def compare_check(self, env, ast):
        #print("----------in compare_check----------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name

        if l_type_name == "Int" and r_type_name == "Int":
            ast.type = checker.types.get("Int")
        elif l_type_name == "Real" and r_type_name == "Real":
            ast.type = checker.types.get("Int")
        elif l_type_name == "String" and r_type_name == "String":
            ast.type = checker.types.get("Int")
        else:
            msg = 'Unmatched operands for logical comparator operator'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)



    def rem_check(self, env, ast):
        #print("----------in rem_check----------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name
        if l_type_name == "Int" and r_type_name == "Int":
            ast.type = checker.types.get("Int")
        else:
            msg = 'Unmatched operands for % operator'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)

    def div_check(self, env, ast):
        #print("----------in div_check----------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name
        if l_type_name == "Int" and r_type_name == "Int":
            ast.type = checker.types.get("Int")
        elif l_type_name == "Real" and r_type_name == "Real":
            ast.type = checker.types.get("Real")
        else:
            msg = 'Unmatched operands for / operator'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)

    def mul_check(env, ast):
        #print("----------in mul_check----------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name

        if l_type_name == "Int" and r_type_name == "Int":
            ast.type = checker.types.get("Int")
        elif l_type_name == "Real" and r_type_name == "Real":
            ast.type = checker.types.get("Real")
        elif l_type_name == "Int" and r_type_name == "String":
            ast.type = checker.types.get("String")
        elif l_type_name == "String" and r_type_name == "Int":
            ast.type = checker.types.get("String")
        else:
            msg = 'Unmatched operands for * operator'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)
        


    def sub_check(env, ast):
        #print("----------in sub_check----------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name

        if l_type_name == "Int" and r_type_name == "Int":
            ast.type = checker.types.get("Int")
        elif l_type_name == "Real" and r_type_name == "Real":
            ast.type = checker.types.get("Real")
        else:
            msg = 'Unmatched operands for - operator'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)

    def add_check(self, env, ast):
        #print("----------in add_check----------")
        l_op = ast.kids[0]
        r_op = ast.kids[1]
        l_type = l_op.type
        r_type = r_op.type
        l_type_name = l_type.name
        r_type_name = r_type.name
        if l_type_name == "Int" and r_type_name == "Int":
            ast.type = checker.types.get("Int")
        elif l_type_name == "Real" and r_type_name == "Real":
            ast.type = checker.types.get("Real")
        elif l_type_name == "String" and r_type_name == "String":
            ast.type = checker.types.get("String")
        else:
            msg = 'Unmatched operands for + operator'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)
        

    def handle_assign(self, env, ast): 
        #print("----------in handle assign----------")
        lhs_type = ast.kids[0].type 
        rhs_type = ast.kids[1].type 

        l_kind = lhs_type.kind
        r_kind = rhs_type.kind
        if lhs_type.name == rhs_type.name:
            ast.type = checker.types.get(lhs_type.name)
        else:
            if l_kind == "class":
                if r_kind == "class":
                    if rhs_type.is_subtype_of(lhs_type):
                        ast.type = checker.types.get(lhs_type.name)
                    else:
                        msg = 'Invalid implicit RHS To LHS Class conversion'
                        checker.errors.add(ast.coord, 'UNMATCHED_TYPES', msg)
                elif r_kind == "nil":
                    ast.type = checker.types.get("$Nil")
            else:
                msg = 'Invalid implicit RHS To LHS conversion'
                checker.errors.add(ast.coord, 'UNMATCHED_TYPES', msg)
         


    def handle_cast(self, env, ast):
        #print("----------in handle_cast----------")
        type_to_cast_to = checker.types.get(ast.kids[0].type_name)
        type_being_casted = ast.kids[1].type 
        lkind = type_to_cast_to.kind
        rkind = type_being_casted.kind
        if lkind == "primitive" and rkind == "primitive":
            lkind_type_str = ast.kids[0].type_name
            rkind_type_str = type_being_casted.name  
            if lkind_type_str == "Int" or lkind_type_str == "Real":
               if rkind_type_str == "Int" or rkind_type_str == "Real":
                   ast.type = type_to_cast_to 
               else:
                   msg = 'Invalid primitive type cast'
                   checker.errors.add(ast.coord, 'INVALID_CAST', msg)
            else:
                msg = 'Invalid primitive type cast'
                checker.errors.add(ast.coord, 'INVALID_CAST', msg)
        elif lkind == "class" and rkind == "class":
            if ( type_to_cast_to.is_subtype_of(type_being_casted) or
                type_being_casted.is_subtype_of(type_to_cast_to) ):
                ast.type = type_to_cast_to
                

    def handle_cond(self, env, ast):
        #print("--------in handle_cond-------")
        cond = ast.kids[0]
        cond_type = cond.type
        cond_type_name = cond_type.name
        if(cond_type_name == "Int"): 
            ast.type = checker.types.get("Int")
        else:
            msg = 'Conditional statement must have type Int'
            checker.errors.add(ast.coord, 'INVALID_TYPE', msg)

