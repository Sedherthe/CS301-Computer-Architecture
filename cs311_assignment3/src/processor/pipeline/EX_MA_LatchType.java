package processor.pipeline;

public class EX_MA_LatchType {
	
	boolean MA_enable;
	boolean isLoad;
	boolean isStore;
	int imm;
	int rs1;
	int rd;
	int ALUResult;
	boolean isEnd;
	boolean isBranch;
	boolean isALUResult;
	
	public EX_MA_LatchType()
	{
		MA_enable = false;
	}

	public boolean isMA_enable() {
		return MA_enable;
	}

	public void setMA_enable(boolean mA_enable) {
		MA_enable = mA_enable;
	}
	
	public void setIsLoad(boolean isLoad) {
		this.isLoad = isLoad;
	}
	public boolean getIsLoad() {
		return this.isLoad;
	}
	
	public void setIsStore(boolean isStore) {
		this.isStore = isStore;
	}
	public boolean getIsStore() {
		return this.isStore;
	}
	
	public int getImm() {
		return this.imm;
	}
	public void setImm(int imm) {
		this.imm = imm;
	}
	
	public int getRs1() {
		return this.rs1;
	}
	public void setRs1(int rs1) {
		this.rs1 = rs1;
	}
	
	public int getRd() {
		return this.rd;
	}
	public void setRd(int rd) {
		this.rd = rd;
	}
	
	public void setIsEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	public boolean getIsEnd() {
		return this.isEnd;
	}
	
	public void setALUResult(int ALUResult) {
		this.ALUResult = ALUResult;
	}
	public int getALUResult() {
		return this.ALUResult;
	}
	
	public boolean getIsBranch() {
		return this.isBranch;
	}
	public void setIsBranch(boolean isBranch) {
		this.isBranch = isBranch;
	}
	
	public boolean getIsALUResult() {
		return this.isALUResult;
	}
	public void setIsALUResult(boolean isALUResult) {
		this.isALUResult = isALUResult;
	}

}
