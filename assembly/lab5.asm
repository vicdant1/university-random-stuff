	.data
str1:	.asciiz "DIGITE A TEMPERATURA: "
str2:	.asciiz "ATENÇÃO: TEMPERATURA ACIMA DO LIMITE PERMITIDO!!!"
str3:	.asciiz "FRIOZIN BOM"

	.text
	.globl main
	
main:
	# Setando temperatura minima
	li $t1 -15
	
	#Imprimir str1
	li $v0, 4
	la $a0, str1
	syscall
	
	#receber a temperatura
	li $v0, 5
	syscall
	move $t0, $v0
	
	slt $t2, $t0, $t1	
	bne $t2, $zero, friozin
		
	#Imprimir str2
	li $v0, 4
	la $a0, str2
	syscall
	
	j fim
	
friozin:
	#Imprimir o str3
	li $v0, 4
	la $a0, str3
	syscall

fim:
	#Encerrar
	li $v0, 10
	syscall
	
