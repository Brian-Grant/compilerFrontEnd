	.class	public cs572/Tl0
	.super	java/lang/Object
;;; g/3
	.method	static g(III)I
	.limit	locals 3
	.limit	stack 12
	iload	0
	ldc	2
	iadd	
	iload	0
	iload	1
	iload	2
	iadd	
	imul	
	iload	2
	invokestatic	cs572/Tl0/_0(III)I
	ireturn	
	.end	method ;; g/3
;;; 
;;; _0/3
	.method	static _0(III)I
	.limit	locals 3
	.limit	stack 8
	iload	0
	iload	2
	iadd	
	iload	2
	isub	
	ireturn	
	.end	method ;; _0/3
;;; 
;;; main/0
	.method	public static main([Ljava/lang/String;)V
	.limit	stack 12
	ldc	2
	ldc	2
	ldc	3
	invokestatic	cs572/Tl0/g(III)I
	invokestatic	cs572/Util/out(I)V
	return	
	.end	method ;;main/0
;;; 

