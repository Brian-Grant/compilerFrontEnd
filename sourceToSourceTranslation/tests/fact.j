	.class	public cs572/Tl0
	.super	java/lang/Object
;;; fact/1
	.method	static fact(I)I
	.limit	locals 1
	.limit	stack 16
	iload	0
	ldc	1
	if_icmple	L3
	iconst_0	
	goto	L4
L3:
	iconst_1	
L4:
	ifeq	L1
	ldc	1
	goto	L2
L1:
	iload	0
	iload	0
	ldc	1
	isub	
	invokestatic	cs572/Tl0/fact(I)I
	imul	
L2:
	ireturn	
	.end	method ;; fact/1
;;; 
;;; max/2
	.method	static max(II)I
	.limit	locals 2
	.limit	stack 8
	iload	0
	iload	1
	if_icmpgt	L7
	iconst_0	
	goto	L8
L7:
	iconst_1	
L8:
	ifeq	L5
	iload	0
	goto	L6
L5:
	iload	1
L6:
	ireturn	
	.end	method ;; max/2
;;; 
;;; main/0
	.method	public static main([Ljava/lang/String;)V
	.limit	stack 16
	ldc	5
	invokestatic	cs572/Tl0/fact(I)I
	ldc	100
	invokestatic	cs572/Tl0/max(II)I
	invokestatic	cs572/Util/out(I)V
	return	
	.end	method ;;main/0
;;; 

