package processor.pipeline;

import processor.Processor.*;

public class ALUnit {
	int Oprand;
	boolean isImm;
	boolean isR3Type;
	boolean isR2IType;
	boolean isRIType;
	
	public ALUnit(int default_oprand, boolean default_IsImm, boolean type) {
		this.Oprand = default_oprand;
		this.isImm = default_IsImm;
		this.isR3Type = type;
		this.isR2IType = type;
		this.isRIType = type;
	}
	
	public void setOprand(int oprand) {
		this.Oprand = oprand;
	}
	public int getOprand() {
		return this.Oprand;
	}
	
	public void setIsImm(boolean isImm) {
		this.isImm = isImm;
	}
	public boolean getIsImm() {
		return this.isImm;
	}
	
	public boolean getIsR3Type() {
		return this.isR3Type;
	}
	public void setIsR3Type(boolean isR3Type) {
		this.isR3Type = isR3Type;
	}
	
	public boolean getIsR2IType() {
		return this.isR2IType;
	}
	public void setIsR2IType(boolean isR2IType) {
		this.isR2IType = isR2IType;
	}
	
	public boolean getIsRIType() {
		return this.isRIType;
	}
	public void setIsRIType(boolean isRIType) {
		this.isRIType = isRIType;
	}
	
	public int add(int v1, int v2) {
		int sum = 0;
		sum = v1 + v2;
		return sum;
	}
	
	public int sub(int v1, int v2) {
		int diff = 0;
		diff  = v1 - v2;
		return diff;
	}
	
	public int mult(int v1, int v2) {
		int product = 1;
		product = v1 * v2;
		return product;
	}
	
	public int div(int v1, int v2) {
		int quotient = 1;
		quotient = v1 / v2;
		return quotient;
	}
	
	public int and(int v1, int v2) {
		int result = 0;
		result = v1 & v2;
		return result;
	}
	
	public int or(int v1, int v2) {
		int result = 0;
		result = v1 | v2;
		return result;
	}
	
	public int xor(int v1, int v2) {
		int result = 0;
		result = v1 ^ v2;
		return result;
	}
	
	public int compare(int v1, int v2) {
		int result = 0;
		result = (v1 < v2) ? 1 : 0;
		return result;
	}
	
	public int shiftLeft(int v1, int v2) {
		int result = 0;
		result = v1 << v2;
		return result;
	}
	
	public int shiftRight(int v1, int v2) {
		int result = 0;
		result = v1 >>> v2;
		return result;
	}
	
	public int arithmaticShift(int v1, int v2) {
		int result = 0;
		result = v1 >> v2;
		return result;
	}
	
	public boolean beq(int v1, int v2) {
		boolean result = false;
		result = (v1 == v2)? true:false;
		return result;
	}
	
	public boolean bgt(int v1, int v2) {
		boolean result = false;
		result = (v1 > v2)? true:false;
		return result;
	}
	
	public boolean blt(int v1, int v2) {
		System.out.println("Values are blt: ");
		System.out.println(v1);
		System.out.println(v2);
		boolean result = false;
		result = (v1 < v2)? true:false;
		System.out.println(result);
		return result;
	}
	
	public boolean bne(int v1, int v2) {
		boolean result = false;
		result = (v1 != v2)? true:false;
		return result;
	}

}
