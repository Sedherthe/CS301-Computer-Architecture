package processor.pipeline;

import processor.Processor;

public class MemoryAccess {
	Processor containingProcessor;
	EX_MA_LatchType EX_MA_Latch;
	MA_RW_LatchType MA_RW_Latch;
	
	public MemoryAccess(Processor containingProcessor, EX_MA_LatchType eX_MA_Latch, MA_RW_LatchType mA_RW_Latch)
	{
		this.containingProcessor = containingProcessor;
		this.EX_MA_Latch = eX_MA_Latch;
		this.MA_RW_Latch = mA_RW_Latch;
	}
	
	public void performMA()
	{
		//TODO
		System.out.println("Into the MA stage");
		System.out.println(EX_MA_Latch.getIsEnd());
		if(EX_MA_Latch.getIsEnd()) {
			MA_RW_Latch.setIsEnd(true);
		}
		else if(EX_MA_Latch.getIsBranch()) {
			MA_RW_Latch.setIsBranch(true);
		}
		else if(EX_MA_Latch.getIsLoad()) {
			int loadResult = 0;
			loadResult = containingProcessor.getMainMemory().getWord(EX_MA_Latch.getImm() + containingProcessor.getRegisterFile().getValue(EX_MA_Latch.getRs1()));
			MA_RW_Latch.setLoadResult(loadResult);
			MA_RW_Latch.setIsLoad(true);
			MA_RW_Latch.setIsEnd(false);
			MA_RW_Latch.setRd(EX_MA_Latch.getRd());
			System.out.println("loadResult: " + loadResult);
		}
		else if(EX_MA_Latch.getIsStore()) {
			int storeResult = containingProcessor.getRegisterFile().getValue(EX_MA_Latch.getRs1());
			containingProcessor.getMainMemory().setWord(EX_MA_Latch.getImm() + containingProcessor.getRegisterFile().getValue(EX_MA_Latch.getRd()), storeResult);
		}
		else if(EX_MA_Latch.getIsALUResult()) {
			MA_RW_Latch.setRd(EX_MA_Latch.getRd());
			MA_RW_Latch.setIsALUResult(true);
			MA_RW_Latch.setIsEnd(false);
			MA_RW_Latch.setIsLoad(false);
			MA_RW_Latch.setALUResult(EX_MA_Latch.getALUResult());
			System.out.println("MA ALUResult: " + EX_MA_Latch.getALUResult());
		}
		EX_MA_Latch.setMA_enable(false);
		MA_RW_Latch.setRW_enable(true);
	}

}
