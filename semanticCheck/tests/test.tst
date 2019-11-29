PROGRAM coord=test.walnut:1:0
  CLASS coord=mainclass.py:18:0 super_name=Object type_name=$Main
    DEFN coord=test.walnut:24:0 isStatic=True kind=function name=f
      TYPE coord=test.walnut:24:0 rank=0 type_name=Int
      PARAMS coord=test.walnut:24:6
        PARAM coord=test.walnut:24:6 name=n
          TYPE coord=test.walnut:24:6 rank=0 type_name=Int
        PARAM coord=test.walnut:24:13 name=p
          TYPE coord=test.walnut:24:13 rank=0 type_name=Int
      BLOCK coord=test.walnut:24:20
        DECLS coord=test.walnut:27:1 isStatic=False kind=var
          TYPE coord=test.walnut:27:5 rank=0 type_name=Int
          DECL coord=test.walnut:27:9 name=a type=Int type_name=Int
          DECL coord=test.walnut:27:12 name=b type=Int type_name=Int
          DECL coord=test.walnut:27:15 name=c type=Int type_name=Int
          DECL coord=test.walnut:27:21 name=d type=Int type_name=Int
          DECL coord=test.walnut:27:28 name=e type=Int type_name=Int
        ASSIGN coord=test.walnut:27:18 type=Int
          DEREF coord=test.walnut:27:15 type=Int
            ID coord=test.walnut:27:15 name=c type=Int type_name=Int
          INT coord=test.walnut:27:18 type=Int value=7
        ASSIGN coord=test.walnut:27:25 type=Int
          DEREF coord=test.walnut:27:21 type=Int
            ID coord=test.walnut:27:21 name=d type=Int type_name=Int
          INT coord=test.walnut:27:25 type=Int value=4
        ASSIGN coord=test.walnut:28:5 type=Int
          DEREF coord=test.walnut:28:1 type=Int
            ID coord=test.walnut:28:1 name=e type=Int type_name=Int
          INT coord=test.walnut:28:5 type=Int value=1
        DECLS coord=test.walnut:30:4 isStatic=False kind=var
          TYPE coord=test.walnut:30:8 rank=0 type_name=Int
          DECL coord=test.walnut:30:12 name=zz type=Int type_name=Int
        ASSIGN coord=test.walnut:30:17 type=Int
          DEREF coord=test.walnut:30:12 type=Int
            ID coord=test.walnut:30:12 name=zz type=Int type_name=Int
          INT coord=test.walnut:30:17 type=Int value=21
        ASSIGN coord=test.walnut:32:9 type=Int
          DEREF coord=test.walnut:32:1 type=Int
            ID coord=test.walnut:32:1 name=a type=Int type_name=Int
          OP2 coord=test.walnut:32:9 op=ADD type=Int
            DEREF coord=test.walnut:32:5 type=Int
              ID coord=test.walnut:32:5 name=c type=Int type_name=Int
            DEREF coord=test.walnut:32:9 type=Int
              ID coord=test.walnut:32:9 name=d type=Int type_name=Int
        ASSIGN coord=test.walnut:34:5 type=Int
          DEREF coord=test.walnut:34:1 type=Int
            ID coord=test.walnut:34:1 name=a type=Int type_name=Int
          INT coord=test.walnut:34:5 type=Int value=22
        ASSIGN coord=test.walnut:36:8 type=Int
          DEREF coord=test.walnut:36:4 type=Int
            ID coord=test.walnut:36:4 name=b type=Int type_name=Int
          INT coord=test.walnut:36:8 type=Int value=4
        ASSIGN coord=test.walnut:37:24 type=Int
          DEREF coord=test.walnut:37:4 type=Int
            ID coord=test.walnut:37:4 name=e type=Int type_name=Int
          OP2 coord=test.walnut:37:24 op=ADD type=Int
            OP2 coord=test.walnut:37:20 op=ADD type=Int
              OP2 coord=test.walnut:37:16 op=ADD type=Int
                OP2 coord=test.walnut:37:12 op=ADD type=Int
                  DEREF coord=test.walnut:37:8 type=Int
                    ID coord=test.walnut:37:8 name=a type=Int type_name=Int
                  DEREF coord=test.walnut:37:12 type=Int
                    ID coord=test.walnut:37:12 name=b type=Int type_name=Int
                DEREF coord=test.walnut:37:16 type=Int
                  ID coord=test.walnut:37:16 name=c type=Int type_name=Int
              DEREF coord=test.walnut:37:20 type=Int
                ID coord=test.walnut:37:20 name=d type=Int type_name=Int
            DEREF coord=test.walnut:37:24 type=Int
              ID coord=test.walnut:37:24 name=e type=Int type_name=Int
        DECLS coord=test.walnut:46:1 isStatic=False kind=var
          TYPE coord=test.walnut:46:5 rank=1 type_name=String
          DECL coord=test.walnut:46:14 name=arr type=String[] type_name=String
        ASSIGN coord=test.walnut:46:20 type=String
          DEREF coord=test.walnut:46:14 type=String[]
            ID coord=test.walnut:46:14 name=arr type=String[] type_name=String
          NEW_ARRAY coord=test.walnut:46:20 rank=1 type=String type_name=String
            INT coord=test.walnut:46:27 type=Int value=3
        ASSIGN coord=test.walnut:47:10 type=String
          INDEX coord=test.walnut:47:1 type=String
            ID coord=test.walnut:47:1 name=arr type=String[] type_name=String
            INT coord=test.walnut:47:5 type=Int value=0
          STRING coord=test.walnut:47:10 type=String value="word"
        STATIC_ACCESS coord=test.walnut:61:1 name=stat type=Int type_name=Sub
        IF coord=test.walnut:87:4 type=Int
          INT coord=test.walnut:87:7 type=Int value=1
          BLOCK coord=test.walnut:87:9
            WHILE coord=test.walnut:88:2 type=Int
              INT coord=test.walnut:88:8 type=Int value=4
              BLOCK coord=test.walnut:88:10
                RETURN coord=test.walnut:89:3 type=Int
                  INT coord=test.walnut:89:10 type=Int value=3
          BLOCK coord=test.walnut:91:1
        DECLS coord=test.walnut:93:4 isStatic=False kind=var
          TYPE coord=test.walnut:93:8 rank=0 type_name=Sup
          DECL coord=test.walnut:93:12 name=s type=Sup type_name=Sup
        ASSIGN coord=test.walnut:93:16 type=Sup
          DEREF coord=test.walnut:93:12 type=Sup
            ID coord=test.walnut:93:12 name=s type=Sup type_name=Sup
          NEW_OBJ coord=test.walnut:93:16 type=Sup type_name=Sup
            REAL coord=test.walnut:93:20 type=Real value=2.3
            REAL coord=test.walnut:93:25 type=Real value=9.3
        ACCESS coord=test.walnut:94:4 kind=instance name=x type=Real
          DEREF coord=test.walnut:94:4 type=Sup
            ID coord=test.walnut:94:4 name=s type=Sup type_name=Sup
        APP coord=test.walnut:95:1 type=Real
          ACCESS coord=test.walnut:95:1 kind=method name=thing type=()->Real
            ID coord=test.walnut:95:1 name=s type=Sup type_name=Sup
        APP coord=test.walnut:96:4 type=Int
          STATIC_ACCESS coord=test.walnut:96:4 name=g type=(Int,Int)->Int type_name=$Main
          INT coord=test.walnut:96:6 type=Int value=3
          INT coord=test.walnut:96:9 type=Int value=4
        RETURN coord=test.walnut:97:4 type=Int
          DEREF coord=test.walnut:97:11 type=Int
            ID coord=test.walnut:97:11 name=a type=Int type_name=Int
    DEFN coord=test.walnut:99:0 isStatic=True kind=function name=g
      TYPE coord=test.walnut:99:0 rank=0 type_name=Int
      PARAMS coord=test.walnut:99:6
        PARAM coord=test.walnut:99:6 name=p
          TYPE coord=test.walnut:99:6 rank=0 type_name=Int
        PARAM coord=test.walnut:99:13 name=q
          TYPE coord=test.walnut:99:13 rank=0 type_name=Int
      BLOCK coord=test.walnut:99:19
        RETURN coord=test.walnut:100:1 type=Int
          INT coord=test.walnut:100:8 type=Int value=111
    DEFN coord=mainclass.py:32:0 isStatic=True kind=function name=$main
      TYPE coord=mainclass.py:28:0 rank=0 type_name=Void
      PARAMS coord=mainclass.py:29:0
      BLOCK coord=mainclass.py:30:0
        APP coord=mainclass.py:38:0 type=Void
          STATIC_ACCESS coord=mainclass.py:37:0 name=$staticInit type=()->Void type_name=$Main
        APP coord=mainclass.py:38:0 type=Void
          STATIC_ACCESS coord=mainclass.py:37:0 name=$staticInit type=()->Void type_name=Sup
        APP coord=mainclass.py:38:0 type=Void
          STATIC_ACCESS coord=mainclass.py:37:0 name=$staticInit type=()->Void type_name=Sub
        APP coord=mainclass.py:38:0 type=Void
          STATIC_ACCESS coord=mainclass.py:37:0 name=$staticInit type=()->Void type_name=Sys
        APP coord=mainclass.py:38:0 type=Void
          STATIC_ACCESS coord=mainclass.py:37:0 name=$staticInit type=()->Void type_name=Array
    DEFN coord=mainclass.py:18:0 isStatic=True kind=function name=$staticInit
      TYPE coord=mainclass.py:18:0 rank=0 type_name=Void
      PARAMS coord=mainclass.py:18:0
      BLOCK coord=mainclass.py:18:0
  CLASS coord=test.walnut:3:0 super_name=Object type_name=Sup
    DECLS coord=test.walnut:4:4 isStatic=False kind=var
      TYPE coord=test.walnut:4:8 rank=0 type_name=Real
      DECL coord=test.walnut:4:13 name=x
      DECL coord=test.walnut:4:16 name=y
    DEFN coord=constructor.py:142:0 isStatic=True kind=function name=Sup
      TYPE coord=constructor.py:139:0 rank=0 type_name=Sup
      PARAMS coord=test.walnut:5:8
        PARAM coord=test.walnut:5:8 name=x
          TYPE coord=test.walnut:5:8 rank=0 type_name=Real
        PARAM coord=test.walnut:5:16 name=y
          TYPE coord=test.walnut:5:16 rank=0 type_name=Real
      BLOCK coord=constructor.py:138:0:2:4
        DECLS coord=constructor.py:138:0:3:6 isStatic=False kind=var
          TYPE coord=constructor.py:138:0:3:10 rank=0 type_name=Sup
          DECL coord=constructor.py:138:0:3:14 name=self type=Sup type_name=Sup
        ASSIGN coord=constructor.py:138:0:3:27 type=Sup
          DEREF coord=constructor.py:138:0:3:14 type=Sup
            ID coord=constructor.py:138:0:3:14 name=self type=Sup type_name=Sup
          CAST coord=constructor.py:138:0:3:27 type=Sup
            TYPE coord=constructor.py:138:0:3:22 rank=0 type_name=Sup
            APP coord=constructor.py:138:0:3:27 type=Object
              STATIC_ACCESS coord=constructor.py:138:0:3:27 name=allocObject type=(Int)->Object type_name=Sys
              TYPE_ID coord=constructor.py:132:0 rank=0 type_name=Sup
        APP coord=constructor.py:131:0 type=Sup
          ACCESS coord=constructor.py:129:0 kind=method name=$instanceInit_Sup type=(Real,Real)->Sup
            ID coord=constructor.py:128:0 name=self type=Sup type_name=Sup
          DEREF coord=constructor.py:126:0 type=Real
            ID coord=constructor.py:126:0 name=x type=Real type_name=Real
          DEREF coord=constructor.py:126:0 type=Real
            ID coord=constructor.py:126:0 name=y type=Real type_name=Real
        RETURN coord=constructor.py:138:0:5:6 type=Sup
          DEREF coord=constructor.py:138:0:5:13 type=Sup
            ID coord=constructor.py:138:0:5:13 name=self type=Sup type_name=Sup
    DEFN coord=test.walnut:3:0 isStatic=True kind=function name=$staticInit
      TYPE coord=test.walnut:3:0 rank=0 type_name=Void
      PARAMS coord=test.walnut:3:0
      BLOCK coord=test.walnut:3:0
    DEFN coord=test.walnut:9:4 isStatic=False kind=function name=thing
      TYPE coord=test.walnut:9:4 rank=0 type_name=Real
      PARAMS coord=test.walnut:9:15
      BLOCK coord=test.walnut:9:17
        RETURN coord=test.walnut:9:19 type=Real
          REAL coord=test.walnut:9:26 type=Real value=0.0
    DEFN coord=test.walnut:5:4 isStatic=False kind=function name=$instanceInit_Sup
      TYPE coord=test.walnut:5:4 rank=0 type_name=Sup
      PARAMS coord=test.walnut:5:8
        PARAM coord=test.walnut:5:8 name=x
          TYPE coord=test.walnut:5:8 rank=0 type_name=Real
        PARAM coord=test.walnut:5:16 name=y
          TYPE coord=test.walnut:5:16 rank=0 type_name=Real
      BLOCK coord=test.walnut:5:24
        ASSIGN coord=test.walnut:6:11 type=Real
          ACCESS coord=test.walnut:6:2 kind=instance name=x type=Real
            ID coord=test.walnut:6:2 name=self type=Sup type_name=Sup
          DEREF coord=test.walnut:6:11 type=Real
            ID coord=test.walnut:6:11 name=x type=Real type_name=Real
        ASSIGN coord=test.walnut:7:17 type=Real
          ACCESS coord=test.walnut:7:8 kind=instance name=y type=Real
            ID coord=test.walnut:7:8 name=self type=Sup type_name=Sup
          DEREF coord=test.walnut:7:17 type=Real
            ID coord=test.walnut:7:17 name=y type=Real type_name=Real
        RETURN coord=constructor.py:158:0 type=Sup
          DEREF coord=constructor.py:157:0 type=Sup
            ID coord=constructor.py:157:0 name=self type=Sup type_name=Sup
  CLASS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:1:0 super_name=Object type_name=Sys
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:2 isStatic=True kind=function name=allocObject
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:9 rank=0 type_name=Object
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:28
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:28 name=classId
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:28 rank=0 type_name=Int
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:41
        RETURN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:43 type=$Nil
          NIL coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:7:50 type=$Nil value=nil
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:3 isStatic=True kind=function name=allocArray
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:10 rank=0 type_name=Object
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:28
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:28 name=arrayClassId
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:28 rank=0 type_name=Int
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:46 name=elementClassId
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:46 rank=0 type_name=Int
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:66 name=n
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:66 rank=0 type_name=Int
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:18:73
        RETURN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:19:5 type=$Nil
          NIL coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:19:12 type=$Nil value=nil
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:3 isStatic=True kind=function name=strCat
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:10 rank=0 type_name=String
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:24
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:24 name=s1
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:24 rank=0 type_name=String
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:35 name=s2
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:35 rank=0 type_name=String
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:46
        RETURN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:48 type=String
          STRING coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:23:55 type=String value=""
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:3 isStatic=True kind=function name=strRepeat
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:10 rank=0 type_name=String
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:27
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:27 name=s1
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:27 rank=0 type_name=String
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:38 name=repeatCount
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:38 rank=0 type_name=Int
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:55
        RETURN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:57 type=String
          STRING coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:24:64 type=String value=""
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:3 isStatic=True kind=function name=strEq
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:10 rank=0 type_name=Int
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:20
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:20 name=s1
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:20 rank=0 type_name=String
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:31 name=s2
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:31 rank=0 type_name=String
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:42
        RETURN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:44 type=Int
          INT coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:27:51 type=Int value=0
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:3 isStatic=True kind=function name=strLt
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:10 rank=0 type_name=Int
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:20
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:20 name=s1
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:20 rank=0 type_name=String
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:31 name=s2
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:31 rank=0 type_name=String
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:42
        RETURN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:44 type=Int
          INT coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:28:51 type=Int value=0
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:3 isStatic=True kind=function name=strLeq
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:10 rank=0 type_name=Int
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:21
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:21 name=s1
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:21 rank=0 type_name=String
        PARAM coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:32 name=s2
          TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:32 rank=0 type_name=String
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:43
        RETURN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:45 type=Int
          INT coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:29:52 type=Int value=0
    DEFN coord=constructor.py:142:0 isStatic=True kind=function name=Sys
      TYPE coord=constructor.py:139:0 rank=0 type_name=Sys
      PARAMS coord=constructor.py:23:0
      BLOCK coord=constructor.py:138:0:2:4
        DECLS coord=constructor.py:138:0:3:6 isStatic=False kind=var
          TYPE coord=constructor.py:138:0:3:10 rank=0 type_name=Sys
          DECL coord=constructor.py:138:0:3:14 name=self type=Sys type_name=Sys
        ASSIGN coord=constructor.py:138:0:3:27 type=Sys
          DEREF coord=constructor.py:138:0:3:14 type=Sys
            ID coord=constructor.py:138:0:3:14 name=self type=Sys type_name=Sys
          CAST coord=constructor.py:138:0:3:27 type=Sys
            TYPE coord=constructor.py:138:0:3:22 rank=0 type_name=Sys
            APP coord=constructor.py:138:0:3:27 type=Object
              STATIC_ACCESS coord=constructor.py:138:0:3:27 name=allocObject type=(Int)->Object type_name=Sys
              TYPE_ID coord=constructor.py:132:0 rank=0 type_name=Sys
        APP coord=constructor.py:131:0 type=Sys
          ACCESS coord=constructor.py:129:0 kind=method name=$instanceInit_Sys type=()->Sys
            ID coord=constructor.py:128:0 name=self type=Sys type_name=Sys
        RETURN coord=constructor.py:138:0:5:6 type=Sys
          DEREF coord=constructor.py:138:0:5:13 type=Sys
            ID coord=constructor.py:138:0:5:13 name=self type=Sys type_name=Sys
    DEFN coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:1:0 isStatic=True kind=function name=$staticInit
      TYPE coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:1:0 rank=0 type_name=Void
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:1:0
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/sys.walnut:1:0
    DEFN coord=constructor.py:26:0 isStatic=False kind=function name=$instanceInit_Sys
      TYPE coord=constructor.py:22:0 rank=0 type_name=Sys
      PARAMS coord=constructor.py:23:0
      BLOCK coord=constructor.py:24:0
        RETURN coord=constructor.py:158:0 type=Sys
          DEREF coord=constructor.py:157:0 type=Sys
            ID coord=constructor.py:157:0 name=self type=Sys type_name=Sys
  CLASS coord=/home/brian/cs572/lib/walnut/sys/array.walnut:1:0 super_name=Object type_name=Array
    DECLS coord=/home/brian/cs572/lib/walnut/sys/array.walnut:3:2 isStatic=False kind=var
      TYPE coord=/home/brian/cs572/lib/walnut/sys/array.walnut:3:6 rank=0 type_name=Int
      DECL coord=/home/brian/cs572/lib/walnut/sys/array.walnut:3:10 name=length
    DEFN coord=constructor.py:142:0 isStatic=True kind=function name=Array
      TYPE coord=constructor.py:139:0 rank=0 type_name=Array
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:8
        PARAM coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:8 name=len
          TYPE coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:8 rank=0 type_name=Int
      BLOCK coord=constructor.py:138:0:2:4
        DECLS coord=constructor.py:138:0:3:6 isStatic=False kind=var
          TYPE coord=constructor.py:138:0:3:10 rank=0 type_name=Array
          DECL coord=constructor.py:138:0:3:16 name=self type=Array type_name=Array
        ASSIGN coord=constructor.py:138:0:3:31 type=Array
          DEREF coord=constructor.py:138:0:3:16 type=Array
            ID coord=constructor.py:138:0:3:16 name=self type=Array type_name=Array
          CAST coord=constructor.py:138:0:3:31 type=Array
            TYPE coord=constructor.py:138:0:3:24 rank=0 type_name=Array
            APP coord=constructor.py:138:0:3:31 type=Object
              STATIC_ACCESS coord=constructor.py:138:0:3:31 name=allocObject type=(Int)->Object type_name=Sys
              TYPE_ID coord=constructor.py:132:0 rank=0 type_name=Array
        APP coord=constructor.py:131:0 type=Array
          ACCESS coord=constructor.py:129:0 kind=method name=$instanceInit_Array type=(Int)->Array
            ID coord=constructor.py:128:0 name=self type=Array type_name=Array
          DEREF coord=constructor.py:126:0 type=Int
            ID coord=constructor.py:126:0 name=len type=Int type_name=Int
        RETURN coord=constructor.py:138:0:5:6 type=Array
          DEREF coord=constructor.py:138:0:5:13 type=Array
            ID coord=constructor.py:138:0:5:13 name=self type=Array type_name=Array
    DEFN coord=/home/brian/cs572/lib/walnut/sys/array.walnut:1:0 isStatic=True kind=function name=$staticInit
      TYPE coord=/home/brian/cs572/lib/walnut/sys/array.walnut:1:0 rank=0 type_name=Void
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/array.walnut:1:0
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/array.walnut:1:0
    DEFN coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:2 isStatic=False kind=function name=$instanceInit_Array
      TYPE coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:2 rank=0 type_name=Array
      PARAMS coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:8
        PARAM coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:8 name=len
          TYPE coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:8 rank=0 type_name=Int
      BLOCK coord=/home/brian/cs572/lib/walnut/sys/array.walnut:5:17
        ASSIGN coord=/home/brian/cs572/lib/walnut/sys/array.walnut:6:18 type=Int
          ACCESS coord=/home/brian/cs572/lib/walnut/sys/array.walnut:6:4 kind=instance name=length type=Int
            ID coord=/home/brian/cs572/lib/walnut/sys/array.walnut:6:4 name=self type=Array type_name=Array
          DEREF coord=/home/brian/cs572/lib/walnut/sys/array.walnut:6:18 type=Int
            ID coord=/home/brian/cs572/lib/walnut/sys/array.walnut:6:18 name=len type=Int type_name=Int
        RETURN coord=constructor.py:158:0 type=Array
          DEREF coord=constructor.py:157:0 type=Array
            ID coord=constructor.py:157:0 name=self type=Array type_name=Array
  CLASS coord=test.walnut:13:0 super_name=Sup type_name=Sub
    DECLS coord=test.walnut:15:1 isStatic=False kind=var
      TYPE coord=test.walnut:15:5 rank=0 type_name=Int
      DECL coord=test.walnut:15:9 name=a
      DECL coord=test.walnut:15:12 name=b
    DECLS coord=test.walnut:14:1 isStatic=True kind=var
      TYPE coord=test.walnut:14:12 rank=0 type_name=Int
      DECL coord=test.walnut:14:16 name=stat
    DEFN coord=constructor.py:142:0 isStatic=True kind=function name=Sub
      TYPE coord=constructor.py:139:0 rank=0 type_name=Sub
      PARAMS coord=test.walnut:16:6
        PARAM coord=test.walnut:16:6 name=a
          TYPE coord=test.walnut:16:6 rank=0 type_name=Int
        PARAM coord=test.walnut:16:13 name=b
          TYPE coord=test.walnut:16:13 rank=0 type_name=Int
        PARAM coord=test.walnut:16:20 name=x
          TYPE coord=test.walnut:16:20 rank=0 type_name=Real
        PARAM coord=test.walnut:16:28 name=y
          TYPE coord=test.walnut:16:28 rank=0 type_name=Real
      BLOCK coord=constructor.py:138:0:2:4
        DECLS coord=constructor.py:138:0:3:6 isStatic=False kind=var
          TYPE coord=constructor.py:138:0:3:10 rank=0 type_name=Sub
          DECL coord=constructor.py:138:0:3:14 name=self type=Sub type_name=Sub
        ASSIGN coord=constructor.py:138:0:3:27 type=Sub
          DEREF coord=constructor.py:138:0:3:14 type=Sub
            ID coord=constructor.py:138:0:3:14 name=self type=Sub type_name=Sub
          CAST coord=constructor.py:138:0:3:27 type=Sub
            TYPE coord=constructor.py:138:0:3:22 rank=0 type_name=Sub
            APP coord=constructor.py:138:0:3:27 type=Object
              STATIC_ACCESS coord=constructor.py:138:0:3:27 name=allocObject type=(Int)->Object type_name=Sys
              TYPE_ID coord=constructor.py:132:0 rank=0 type_name=Sub
        APP coord=constructor.py:131:0 type=Sub
          ACCESS coord=constructor.py:129:0 kind=method name=$instanceInit_Sub type=(Int,Int,Real,Real)->Sub
            ID coord=constructor.py:128:0 name=self type=Sub type_name=Sub
          DEREF coord=constructor.py:126:0 type=Int
            ID coord=constructor.py:126:0 name=a type=Int type_name=Int
          DEREF coord=constructor.py:126:0 type=Int
            ID coord=constructor.py:126:0 name=b type=Int type_name=Int
          DEREF coord=constructor.py:126:0 type=Real
            ID coord=constructor.py:126:0 name=x type=Real type_name=Real
          DEREF coord=constructor.py:126:0 type=Real
            ID coord=constructor.py:126:0 name=y type=Real type_name=Real
        RETURN coord=constructor.py:138:0:5:6 type=Sub
          DEREF coord=constructor.py:138:0:5:13 type=Sub
            ID coord=constructor.py:138:0:5:13 name=self type=Sub type_name=Sub
    DEFN coord=test.walnut:13:0 isStatic=True kind=function name=$staticInit
      TYPE coord=test.walnut:13:0 rank=0 type_name=Void
      PARAMS coord=test.walnut:13:0
      BLOCK coord=test.walnut:13:0
        ASSIGN coord=test.walnut:14:16 type=Int
          STATIC_ACCESS coord=test.walnut:14:16 name=stat type=Int type_name=Sub
          INT coord=test.walnut:14:23 type=Int value=123
    DEFN coord=test.walnut:21:1 isStatic=False kind=function name=stuff
      TYPE coord=test.walnut:21:1 rank=0 type_name=Int
      PARAMS coord=test.walnut:21:11
        PARAM coord=test.walnut:21:11 name=a
          TYPE coord=test.walnut:21:11 rank=0 type_name=Int
        PARAM coord=test.walnut:21:18 name=b
          TYPE coord=test.walnut:21:18 rank=0 type_name=Real
      BLOCK coord=test.walnut:21:26
        RETURN coord=test.walnut:21:28 type=Int
          INT coord=test.walnut:21:35 type=Int value=1
    DEFN coord=test.walnut:16:2 isStatic=False kind=function name=$instanceInit_Sub
      TYPE coord=test.walnut:16:2 rank=0 type_name=Sub
      PARAMS coord=test.walnut:16:6
        PARAM coord=test.walnut:16:6 name=a
          TYPE coord=test.walnut:16:6 rank=0 type_name=Int
        PARAM coord=test.walnut:16:13 name=b
          TYPE coord=test.walnut:16:13 rank=0 type_name=Int
        PARAM coord=test.walnut:16:20 name=x
          TYPE coord=test.walnut:16:20 rank=0 type_name=Real
        PARAM coord=test.walnut:16:28 name=y
          TYPE coord=test.walnut:16:28 rank=0 type_name=Real
      BLOCK coord=test.walnut:16:35
        APP coord=constructor.py:102:0 type=Sup
          ACCESS coord=constructor.py:100:0 kind=method name=$instanceInit_Sup type=(Real,Real)->Sup
            ID coord=constructor.py:97:0 name=super type=Sup type_name=Sup
          DEREF coord=test.walnut:17:8 type=Real
            ID coord=test.walnut:17:8 name=x type=Real type_name=Real
          DEREF coord=test.walnut:17:11 type=Real
            ID coord=test.walnut:17:11 name=y type=Real type_name=Real
        ASSIGN coord=test.walnut:18:14 type=Int
          ACCESS coord=test.walnut:18:5 kind=instance name=a type=Int
            ID coord=test.walnut:18:5 name=self type=Sub type_name=Sub
          DEREF coord=test.walnut:18:14 type=Int
            ID coord=test.walnut:18:14 name=a type=Int type_name=Int
        ASSIGN coord=test.walnut:19:11 type=Int
          ACCESS coord=test.walnut:19:2 kind=instance name=b type=Int
            ID coord=test.walnut:19:2 name=self type=Sub type_name=Sub
          DEREF coord=test.walnut:19:11 type=Int
            ID coord=test.walnut:19:11 name=b type=Int type_name=Int
        RETURN coord=constructor.py:158:0 type=Sub
          DEREF coord=constructor.py:157:0 type=Sub
            ID coord=constructor.py:157:0 name=self type=Sub type_name=Sub
