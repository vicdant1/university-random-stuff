	.data
	
nums:	.byte 4,3,2,1
	.half 8,7,6,5
	.word 1,2,3,4
	.word 12
letters: .asciiz "EFG"
pal:	 .word 9

	.text
	.globl main
	
main:	li $v0, 10	#sys call for exit
	syscall



