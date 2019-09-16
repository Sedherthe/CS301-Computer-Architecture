	.data
a:
	10000
b:
	20
	.text
main:
	load %x0, $a, %x4
	addi %x0, -1, %x0
	end
