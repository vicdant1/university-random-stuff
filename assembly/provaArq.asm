.data
str1: .asciiz "Digite o valor de x: "
str2: .asciiz "Resultado: "
str3: .asciiz "Valor de D: "
    .text
    .globl main

main:
    # x - s0
    # r - s1
    # d - s2
    # s - s3
    # t - t0
    
    li $s1, 1
    li $s2, 2
    li $s3, 4
    li $t0, 0

    li $v0, 4
    la $a0, str1
    syscall
    
    li $v0, 5
    syscall
    move $s0, $v0
    
    loop:
    	addi $s1, $s1, 1
    	addi $s2, $s2, 2
    	
    	add $s3, $s3, $s2
    	addi $s3, $s3, 1
    	
    	sgt $t1, $s3, $s0
    	beq $t1, 1, if
    	returning_point:
    	beq $t1, $zero, else
fim:
    li $v0, 4
    la $a0, str2
    syscall
    
    li $v0, 1
    move $a0, $s1
    syscall
    
    li $v0,10
    syscall
    
if:
    li $t0, 1
    j returning_point
else:
    li $t0, 0
    j loop
