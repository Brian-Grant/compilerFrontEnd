	.class	public cs572/Tl0
	.super	java/lang/Object
;;; f/2
	.method	static f(II)I
	.limit	locals 2
	.limit	stack 12
	iload	0
	iload	1
	iadd	
	iload	0
	iload	1
	isub	
	iload	0
	iload	1
	invokestatic	cs572/Tl0/_0(IIII)I
	ireturn	
	.end	method ;; f/2
;;; 
;;; _0/4
	.method	static _0(IIII)I
	.limit	locals 4
	.limit	stack 12
	iload	0
	iload	0
	imul	
	iload	0
	iload	2
	imul	
	iload	2
	iload	2
	imul	
	iload	0
	iload	1
	imul	
	iadd	
	iadd	
	iadd	
	ireturn	
	.end	method ;; _0/4
;;; 
;;; main/0
	.method	public static main([Ljava/lang/String;)V
	.limit	stack 12
	ldc	2
	ldc	3
	invokestatic	cs572/Tl0/f(II)I
	invokestatic	cs572/Util/out(I)V
	return	
	.end	method ;;main/0
;;; 

