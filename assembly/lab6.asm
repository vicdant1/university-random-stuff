	.data
str1:	.asciiz "Digite o valor de x: "
str2:	.asciiz "i: "
str3:   .asciiz "\n"

	.text
	.globl main
	
main:
	# setando valores para x e i
	li $t0 0 # x
	li $t1 0 # i
	
	#Imprimir str1
	li $v0, 4
	la $a0, str1
	syscall
	
	#receber o valor de x
	li $v0, 5
	syscall
	move $t0, $v0
	
	loop:
		slt $t3, $t0, $t1
		bne $t3, $zero, fim
		li $v0, 4
		la $a0, str2
		syscall
		
		li $v0, 1
		move $a0, $t1
		syscall
		
		li $v0, 4
		la $a0, str3
		syscall
		
		addi $t1, $t1, 1
		
		
		j loop
				
fim:
	#Encerrar
	li $v0, 10
	syscall
	
