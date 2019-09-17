package processor.pipeline;

import processor.Processor;

public class Execute {
	Processor containingProcessor;
	OF_EX_LatchType OF_EX_Latch;
	EX_MA_LatchType EX_MA_Latch;
	EX_IF_LatchType EX_IF_Latch;
	ALUnit ALU;
	int ALUResult;
	
	public Execute(Processor containingProcessor, OF_EX_LatchType oF_EX_Latch, EX_MA_LatchType eX_MA_Latch, EX_IF_LatchType eX_IF_Latch, ALUnit ALU, int ALUResult)
	{
		this.containingProcessor = containingProcessor;
		this.OF_EX_Latch = oF_EX_Latch;
		this.EX_MA_Latch = eX_MA_Latch;
		this.EX_IF_Latch = eX_IF_Latch;
		this.ALU = ALU;
		this.ALUResult = ALUResult;
	}
	
	public void performEX()
	{
		//TODO
		System.out.println(containingProcessor.getRegisterFile().getProgramCounter() + " PC!!!!!!");
		System.out.println(ALU.getOprand());
		System.out.println(ALU.getIsR2IType());
		System.out.println(ALU.getIsRIType() + " is RIType");
		System.out.println("Into to Exec Unit");
		if(ALU.getIsR3Type()) {
			int rs1 = OF_EX_Latch.getRs1();
			int rs2 = OF_EX_Latch.getRs2();
			int rd = OF_EX_Latch.getRd();
			EX_MA_Latch.setRd(rd);
			
			switch(ALU.getOprand()) {
			case 0:
				this.ALUResult =  ALU.add(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				System.out.println("Executed Add");
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 2:
				this.ALUResult = ALU.sub(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				System.out.println("Executed Sub");
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 4:
				this.ALUResult = ALU.mult(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 6:
				this.ALUResult = ALU.div(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				containingProcessor.getRegisterFile().setValue(31, containingProcessor.getRegisterFile().getValue(rs1)%containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 8:
				this.ALUResult = ALU.and(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 10:
				this.ALUResult = ALU.or(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 12:
				this.ALUResult =ALU.xor(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 14:
				this.ALUResult = ALU.compare(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 16:
				this.ALUResult = ALU.shiftLeft(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 18:
				this.ALUResult = ALU.shiftRight(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 20:
				this.ALUResult = ALU.arithmaticShift(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rs2));
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			}
		}
		else if(ALU.getIsR2IType()) {
			int rs1 = OF_EX_Latch.getRs1();
			int rd = OF_EX_Latch.getRd();
			int imm = OF_EX_Latch.getImm();
			EX_MA_Latch.setRd(rd);
			
			switch(ALU.getOprand()) {
			case 1:
				System.out.println(imm + containingProcessor.getRegisterFile().getValue(rs1));
				System.out.println("ALUResult = " + ALU.add(containingProcessor.getRegisterFile().getValue(rs1), imm));
				this.ALUResult = ALU.add(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 3:
				this.ALUResult = ALU.sub(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 5:
				this.ALUResult = ALU.mult(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				break;
			case 7:
				this.ALUResult = ALU.div(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsStore(false);
				containingProcessor.getRegisterFile().setValue(31, containingProcessor.getRegisterFile().getValue(rs1)%imm);
				break;
			case 9:
				this.ALUResult = ALU.and(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				break;
			case 11:
				this.ALUResult = ALU.or(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsLoad(false);
				break;
			case 13:
				this.ALUResult = ALU.xor(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				break;
			case 15:
				this.ALUResult = ALU.compare(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsEnd(false);
				break;
			case 17:
				this.ALUResult = ALU.shiftLeft(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setIsEnd(false);
				break;
			case 19:
				this.ALUResult = ALU.shiftRight(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsLoad(false);
				break;
			case 21:
				this.ALUResult = ALU.arithmaticShift(containingProcessor.getRegisterFile().getValue(rs1), imm);
				EX_MA_Latch.setIsALUResult(true);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsLoad(false);
				break;
			case 22:
				EX_MA_Latch.setIsLoad(true);
				EX_MA_Latch.setIsStore(false);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsALUResult(false);
				System.out.println(imm + " Imm");
				EX_MA_Latch.setImm(imm);
				EX_MA_Latch.setRs1(rs1);
				break;
			case 23:
				EX_MA_Latch.setIsStore(true);
				EX_MA_Latch.setIsEnd(false);
				EX_MA_Latch.setIsLoad(false);
				EX_MA_Latch.setImm(imm);
				EX_MA_Latch.setRs1(rs1);
				break;
			case 25:
				EX_MA_Latch.setIsALUResult(false);
				System.out.println("TO Check: " + OF_EX_Latch.getIs_negative());
				if(ALU.beq(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rd))) {
					if(OF_EX_Latch.getIs_negative()) {
						int immCompliment = (int) Math.pow(2, 17) - imm;
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() - immCompliment - 1);
						OF_EX_Latch.setIs_negative(false);
					}
					else {
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() + imm - 1);					
					}
				}
				break;
			case 26:
				EX_MA_Latch.setIsALUResult(false);
				System.out.println("BNE Imm is :" + imm);
				if(ALU.bne(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rd))) {
					if(OF_EX_Latch.getIs_negative()) {
						int immCompliment = (int) Math.pow(2, 17) - imm;
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() - immCompliment - 1);
						OF_EX_Latch.setIs_negative(false);
					}
					else {
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() + imm - 1);					
					}
				}
				break;
			case 27:
				EX_MA_Latch.setIsALUResult(false);
				System.out.println(ALU.blt(containingProcessor.getRegisterFile().getValue(rd), containingProcessor.getRegisterFile().getValue(rs1)) + " Evaluation of blt");
				if(ALU.blt(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rd))) {
					System.out.println("The old program counter is : ");
					System.out.println("BLT Imm is :" + imm);
					System.out.println(containingProcessor.getRegisterFile().getProgramCounter());
					
					
					if(OF_EX_Latch.getIs_negative() ) {
						int immCompliment = (int) Math.pow(2, 17) - imm;
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() - immCompliment - 1);
						System.out.println("The updated Program counter is : ");
						System.out.println(containingProcessor.getRegisterFile().getProgramCounter() - immCompliment);
						OF_EX_Latch.setIs_negative(false);
					}
					else {
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() + imm - 1);
						System.out.println("The updated Program counter is : ");
						System.out.println(containingProcessor.getRegisterFile().getProgramCounter());
					}
				}
				break;
			case 28:
				EX_MA_Latch.setIsALUResult(false);
				System.out.println("BGT Imm is :" + imm);
				if(ALU.bgt(containingProcessor.getRegisterFile().getValue(rs1), containingProcessor.getRegisterFile().getValue(rd))) {
					if(OF_EX_Latch.getIs_negative()) {
						int immCompliment = (int) Math.pow(2, 17) - imm;
						System.out.println("Imm complement.");
						System.out.println(immCompliment);
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() - immCompliment - 1);
						OF_EX_Latch.setIs_negative(false);
					}
					else {
						containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() + imm - 1);					
					}
				}
				break;
			}
			
		}
		else if(ALU.getIsRIType()) {
			int rd = OF_EX_Latch.getRd();
			int imm = OF_EX_Latch.getImm();
			System.out.println(ALU.getOprand() + " Is endgame");
			if(ALU.getOprand() == 24) {
				if(OF_EX_Latch.getIs_negative()) {
					int immCompliment = (int) Math.pow(2, 22) - imm;
					containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() - immCompliment + containingProcessor.getRegisterFile().getValue(rd) - 1);
					OF_EX_Latch.setIs_negative(false);
				}
				else {
					containingProcessor.getRegisterFile().setProgramCounter(containingProcessor.getRegisterFile().getProgramCounter() + imm + containingProcessor.getRegisterFile().getValue(rd) - 1);					
				}
			}
			else if(ALU.getOprand() == 29) {
				EX_MA_Latch.setIsEnd(true);
				System.out.println("Into the endgame " + EX_MA_Latch.getIsEnd());
			}
		}
		EX_MA_Latch.setALUResult(this.ALUResult);
		OF_EX_Latch.setEX_enable(false);
		EX_MA_Latch.setMA_enable(true);
		//System.out.println(containingProcessor.getRegisterFile().getContentsAsString());
	}

}
