package processor.pipeline;

public class OF_EX_LatchType {
	
	boolean EX_enable;
	int rs1;
	int rs2;
	int rd;
	int imm;
	boolean is_imm;

	public OF_EX_LatchType()
	{
		EX_enable = false;
	}

	public boolean isEX_enable() {
		return EX_enable;
	}

	public void setEX_enable(boolean eX_enable) {
		EX_enable = eX_enable;
	}

	public int getRs1() {
		return rs1;
	}

	public void setRs1(int rs1) {
		this.rs1 = rs1;
	}

	public int getRs2() {
		return rs2;
	}

	public void setRs2(int rs2) {
		this.rs2 = rs2;
	}

	public int getRd() {
		return rd;
	}

	public void setRd(int rd) {
		this.rd = rd;
	}

	public int getImm() {
		return imm;
	}

	public void setImm(int imm) {
		this.imm = imm;
	}

	public boolean isIs_imm() {
		return is_imm;
	}

	public void setIs_imm(boolean is_imm) {
		this.is_imm = is_imm;
	}
}
