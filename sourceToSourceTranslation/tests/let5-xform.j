	.class	public cs572/Tl0
	.super	java/lang/Object
;;; h/3
	.method	static h(III)I
	.limit	locals 3
	.limit	stack 16
	iload	0
	iload	1
	imul	
	iload	0
	iload	1
	iadd	
	iload	2
	imul	
	iload	2
	iload	0
	invokestatic	cs572/Tl0/_0(IIII)I
	ldc	22
	iload	2
	invokestatic	cs572/Tl0/_2(III)I
	ireturn	
	.end	method ;; h/3
;;; 
;;; _0/4
	.method	static _0(IIII)I
	.limit	locals 4
	.limit	stack 12
	iload	0
	iload	1
	iadd	
	iload	2
	irem	
	iload	3
	iload	2
	iadd	
	iadd	
	ireturn	
	.end	method ;; _0/4
;;; 
;;; _1/3
	.method	static _1(III)I
	.limit	locals 3
	.limit	stack 8
	iload	0
	iload	1
	isub	
	iload	2
	iadd	
	ireturn	
	.end	method ;; _1/3
;;; 
;;; _2/3
	.method	static _2(III)I
	.limit	locals 3
	.limit	stack 12
	iload	0
	iload	1
	iadd	
	iload	0
	iload	2
	iadd	
	ldc	3
	iload	2
	invokestatic	cs572/Tl0/_1(III)I
	isub	
	ireturn	
	.end	method ;; _2/3
;;; 
;;; main/0
	.method	public static main([Ljava/lang/String;)V
	.limit	stack 12
	ldc	3
	ldc	4
	ldc	5
	invokestatic	cs572/Tl0/h(III)I
	invokestatic	cs572/Util/out(I)V
	return	
	.end	method ;;main/0
;;; 

