.data
totalSlot: 0
aSlot: 16
bSlot: 0
eMessage: .asciiz "Error: Performing this operation would cause arithmetic overflow."
aMessage: .asciiz "The answer is: "
.text
j main

main: #loads the numbers for multiplication and tests for arithmetic overflow, negatives or zero.
lw $s0,aSlot
lw $s1,bSlot
bge $s0,65535,error
bge $s1,65535,error
blt $s0,0,aNegative
beq $s0,0,zero
beq $s1,0,zero

loop: #tests if a is odd.
and $t1,$s0,1
beq $t1,1,addToTotal 
j loop2

aNegative: #this handles situations where only one number is negative, by swapping it so that the positive number is always halved.
ble $s0,-65535,error
blt $s1,0,bNegative
lw $s0,bSlot
lw $s1,aSlot
j loop

addToTotal: #if a is odd, the value of b is added to the total.
add $s2,$s2,$s1
j loop2

loop2: #this halves a and doubles b, until a is 1.
srl $s0,$s0,1
add $s1,$s1,$s1
bgt $s0,1,loop 
j print

bNegative: #this handles situations where both numbers are negative, by flipping the numbers to positive.
ble $s1,-65535,error
add $t2,$s1,0
sub $s1,$s1,$t2
sub $s1,$s1,$t2
add $t3,$s0,0
sub $s0,$s0,$t3
sub $s0,$s0,$t3
j loop

zero: #this handles if one or both values are zero, by setting the total to zero.
add $s1,$zero,$zero
add $s2,$zero,$zero
j print

error: #prints if the multiplication would result in arithmetic overflow.
li $v0,4
la $a0,eMessage
syscall
j end

print: #performs the final addition of b to the total, and outputs the result.
add $s2,$s1,$s2
sw $s2,totalSlot
li $v0,4
la $a0, aMessage
syscall
li $v0,1
add $a0,$s2,$zero
syscall

end:
nop
