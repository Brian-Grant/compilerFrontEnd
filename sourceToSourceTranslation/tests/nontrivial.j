	.class	public cs572/Tl0
	.super	java/lang/Object
;;; f/3
	.method	static f(III)I
	.limit	locals 3
	.limit	stack 12
	iload	0
	iload	0
	iadd	
	iload	1
	if_icmpgt	L3
	iconst_0	
	goto	L4
L3:
	iconst_1	
L4:
	ifeq	L1
	iload	0
	ldc	2
	isub	
	iload	1
	iload	2
	imul	
	iload	1
	invokestatic	cs572/Tl0/f(III)I
	goto	L2
L1:
	iload	0
	iload	1
	iload	2
	idiv	
	isub	
L2:
	ireturn	
	.end	method ;; f/3
;;; 
;;; main/0
	.method	public static main([Ljava/lang/String;)V
	.limit	stack 12
	ldc	2
	ldc	3
	ldc	4
	invokestatic	cs572/Tl0/f(III)I
	invokestatic	cs572/Util/out(I)V
	return	
	.end	method ;;main/0
;;; 

