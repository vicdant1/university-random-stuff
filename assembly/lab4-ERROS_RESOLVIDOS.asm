	.data
str1:	.asciiz "Digite o primeiro numero: "
str2:	.asciiz "Digite o segundo numero: "
str3:	.asciiz "Numeros iguais! "
str4:	.asciiz "Numeros diferentes! "

	.text
	.globl main

main:
	#Imprimir str1
	li $v0, 4
	la $a0, str1
	syscall
	
	#receber o numero do terminal
	li $v0, 5
	syscall
	move $t0, $v0
	
	#Imprimir str2
	li $v0, 4
	la $a0, str2
	syscall
	
	#receber o numero do terminal
	li $v0, 5
	syscall
	move $t2, $v0 
	
	beq $t0, $t2, iguais
	
	#Imprimir str4
	li $v0, 4
	la $a0, str4
	syscall
	
	j fim
	
iguais:
	#Imprimir o str3
	li $v0, 4
	la $a0, str3
	syscall

fim:
	#Encerrar
	li $v0, 10
	syscall
	
