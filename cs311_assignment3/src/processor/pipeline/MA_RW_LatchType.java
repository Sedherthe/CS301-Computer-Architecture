package processor.pipeline;

public class MA_RW_LatchType {
	
	boolean RW_enable;
	boolean isEnd;
	boolean isBranch;
	int loadResult;
	int rd;
	boolean isLoad;
	boolean isALUResult;
	int ALUResult;
	
	public MA_RW_LatchType()
	{
		RW_enable = false;
	}

	public boolean isRW_enable() {
		return RW_enable;
	}

	public void setRW_enable(boolean rW_enable) {
		RW_enable = rW_enable;
	}
	
	public int getLoadResult() {
		return this.loadResult;
	}
	public void setLoadResult(int loadResult) {
		this.loadResult = loadResult;
	}
	
	public boolean getIsEnd() {
		return this.isEnd;
	}
	public void setIsEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	public boolean getIsBranch() {
		return this.isBranch;
	}
	public void setIsBranch(boolean isBranch) {
		this.isBranch = isBranch;
	}
	
	public int getRd() {
		return this.rd;
	}
	public void setRd(int rd) {
		this.rd = rd;
	}
	
	public boolean getIsLoad() {
		return this.isLoad;
	}
	public void setIsLoad(boolean isLoad) {
		this.isLoad = isLoad;
	}
	
	public int getALUResult() {
		return this.ALUResult;
	}
	public void setALUResult(int ALUresult) {
		this.ALUResult = ALUresult;
	}
	
	public boolean getIsALUResult() {
		return this.isALUResult;
	}
	public void setIsALUResult(boolean isALUresult) {
		this.isALUResult = isALUresult;
	}

}
