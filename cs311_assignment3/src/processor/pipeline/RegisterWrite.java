package processor.pipeline;

import generic.Simulator;
import processor.Processor;

public class RegisterWrite {
	Processor containingProcessor;
	MA_RW_LatchType MA_RW_Latch;
	IF_EnableLatchType IF_EnableLatch;
	
	public RegisterWrite(Processor containingProcessor, MA_RW_LatchType mA_RW_Latch, IF_EnableLatchType iF_EnableLatch)
	{
		this.containingProcessor = containingProcessor;
		this.MA_RW_Latch = mA_RW_Latch;
		this.IF_EnableLatch = iF_EnableLatch;
	}
	
	public void performRW()
	{
		if(MA_RW_Latch.isRW_enable())
		{
			//TODO
			System.out.println("Into the RW stage");
			if(MA_RW_Latch.getIsEnd()) {
				System.out.println("SimulationComplete");
				// if instruction being processed is an end instruction, call Simulator.setSimulationComplete(true);
				Simulator.setSimulationComplete(true);
			}
			else if(MA_RW_Latch.getIsBranch()) {
				
			}
			else if(MA_RW_Latch.getIsLoad()) {
				//Store the loadResult in specified register
				containingProcessor.getRegisterFile().setValue(MA_RW_Latch.getRd(), MA_RW_Latch.getLoadResult());
			}
			else if(MA_RW_Latch.getIsALUResult()) {
				System.out.println("This is Rd in RW: " + MA_RW_Latch.getRd());
				containingProcessor.getRegisterFile().setValue(MA_RW_Latch.getRd(), MA_RW_Latch.getALUResult());
				MA_RW_Latch.setIsALUResult(false);
			}
			
			
			MA_RW_Latch.setRW_enable(false);
			IF_EnableLatch.setIF_enable(true);
		}
		System.out.println(containingProcessor.getRegisterFile().getContentsAsString());
	}

}
