package generic;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.lang.Math;

import generic.Operand.OperandType;


public class Simulator {
		
	static FileInputStream inputcodeStream = null;
	
	public static void setupSimulation(String assemblyProgramFile)
	{	
		int firstCodeAddress = ParsedProgram.parseDataSection(assemblyProgramFile);
		ParsedProgram.parseCodeSection(assemblyProgramFile, firstCodeAddress);
		ParsedProgram.printState();
	}
	
	public static void assemble(String objectProgramFile)
	{
		//TODO your assembler code
		//1. open the objectProgramFile in binary mode
        
		//2. write the firstCodeAddress to the file
        try {
		File file = new File(objectProgramFile);
		FileOutputStream fos = null;
        	fos = new FileOutputStream(file);
        	DataOutputStream os = new DataOutputStream(fos);
             
            // Writes bytes from the specified byte array to this file output stream 
        	os.writeInt(ParsedProgram.firstCodeAddress);
 
        
        
			//3. write the data to the file
	        System.out.println(ParsedProgram.firstCodeAddress);
	        System.out.println(ParsedProgram.mainFunctionAddress);
	        System.out.println(ParsedProgram.data.size());
	        System.out.println(ParsedProgram.code.size());
	        for(int i=0; i<ParsedProgram.firstCodeAddress; i++) {
	        	os.writeInt(ParsedProgram.data.get(i));
	        }
	        
			//4. assemble one instruction at a time, and write to the file
	        for(int i=0;i<ParsedProgram.code.size();i++) {
	        	System.out.println(ParsedProgram.code.get(i));
	        	System.out.println(ParsedProgram.code.get(i).operationType.ordinal());
	        	if(ParsedProgram.code.get(i).operationType.ordinal() < 22 && ParsedProgram.code.get(i).operationType.ordinal()%2 == 0 ) {
	        		int opCode = (int) (ParsedProgram.code.get(i).operationType.ordinal() * Math.pow(2,27));
	        		int source1 = (int) (ParsedProgram.code.get(i).sourceOperand1.value * Math.pow(2, 22));
	        		int source2 = (int) (ParsedProgram.code.get(i).sourceOperand2.value * Math.pow(2, 17));
	        		int dest = (int) (ParsedProgram.code.get(i).destinationOperand.value * Math.pow(2, 12));
	        		int instruction = opCode + source1 + source2 + dest;
	        		System.out.println(instruction);
	        		os.writeInt(instruction);
	        	}
	        	else if(ParsedProgram.code.get(i).operationType.ordinal() < 22 && ParsedProgram.code.get(i).operationType.ordinal()%2 == 1 ) {
	        		int opCode = (int) (ParsedProgram.code.get(i).operationType.ordinal() * Math.pow(2,27));
	        		int source1 = (int) (ParsedProgram.code.get(i).sourceOperand1.value * Math.pow(2, 22));
	        		int dest = (int) (ParsedProgram.code.get(i).destinationOperand.value * Math.pow(2, 17));
	        		int imm = (int) (ParsedProgram.code.get(i).sourceOperand2.value);
	        		if(imm<0) {
	        			imm = (int) (Math.pow(2,17) + imm);
	        		}
	        		int instruction = opCode + source1 + dest + imm;
	        		System.out.println(instruction);
	        		os.writeInt(instruction);
	        	}
	        	else if(ParsedProgram.code.get(i).operationType.ordinal() > 21 && ParsedProgram.code.get(i).operationType.ordinal() < 24) {
	        		long opCode = (long) (ParsedProgram.code.get(i).operationType.ordinal() * Math.pow(2,27));
	        		long source1 = (long) (ParsedProgram.code.get(i).sourceOperand1.value * Math.pow(2, 22));
	        		long dest = (long) (ParsedProgram.code.get(i).destinationOperand.value * Math.pow(2, 17));
	        		long source2;
	        		if(ParsedProgram.code.get(i).sourceOperand2.labelValue.isEmpty())
					{
						//absolute immediate
	        			source2 = (long) (ParsedProgram.code.get(i).sourceOperand2.value);
	        			
					}
					else
					{
						//label / symbol
						int value = ParsedProgram.symtab.get(ParsedProgram.code.get(i).sourceOperand2.labelValue);
						source2 = value;
					}
	        		long instruction = opCode + source1 + dest + source2;
	        		System.out.println(instruction);
	        		os.writeInt((int) instruction);
	        	}
	        	else if(ParsedProgram.code.get(i).operationType.ordinal() > 24 && ParsedProgram.code.get(i).operationType.ordinal() < 29) {
	        		long opCode = (long) (ParsedProgram.code.get(i).operationType.ordinal() * Math.pow(2,27));
	        		long source1 = (long) (ParsedProgram.code.get(i).sourceOperand1.value * Math.pow(2, 22));
	        		long source2 = (long) (ParsedProgram.code.get(i).sourceOperand2.value * Math.pow(2, 17));
	        		
	        		long dest;
	        		if(ParsedProgram.code.get(i).destinationOperand.labelValue.isEmpty())
					{
						//absolute immediate
	        			dest = (long) (ParsedProgram.code.get(i).destinationOperand.value);
					}
					else
					{
						//label / symbol
						int value = ParsedProgram.symtab.get(ParsedProgram.code.get(i).destinationOperand.labelValue);
						int PC = ParsedProgram.code.get(i).programCounter;
						System.out.println(ParsedProgram.symtab);
						dest = value - PC;
						if(dest<0) {
							dest = (long) (Math.pow(2,17) + dest);
						}
					}
	        		long instruction = opCode + source1 + dest + source2;
	        		System.out.println(instruction);
	        		os.writeInt((int) instruction);
	        	}
	        	else if(ParsedProgram.code.get(i).operationType.ordinal() == 24) {
	        		long opCode = (long) (ParsedProgram.code.get(i).operationType.ordinal() * Math.pow(2,27));
	        		long dest;
	        		if(ParsedProgram.code.get(i).destinationOperand.labelValue.isEmpty())
					{
						//absolute immediate
	        			dest = (long) (ParsedProgram.code.get(i).destinationOperand.value);
					}
					else
					{
						int value = ParsedProgram.symtab.get(ParsedProgram.code.get(i).destinationOperand.labelValue);
						int PC = ParsedProgram.code.get(i).programCounter;
						System.out.println(ParsedProgram.symtab);
						dest = value - PC;
						System.out.println("jmp dst " + dest);
						if(dest<0) {
							dest = (long) (Math.pow(2,22) + dest);
						}
					}
	        		long instruction = opCode + dest;
	        		System.out.println(instruction);
	        		os.writeInt((int) instruction);
	        		
	        	}
	        	else if(ParsedProgram.code.get(i).operationType.ordinal() == 29) {
	        		long opCode = (long) (ParsedProgram.code.get(i).operationType.ordinal() * Math.pow(2,27));
	        		long dest = 0;
	        		long instruction = opCode + dest;
	        		System.out.println(instruction);
	        		os.writeInt((int) instruction);
	        		
	        	}
	        }
	        
			//5. close the file
	        // Close the Streams here!
	        os.close();
	            if (fos != null){
	                try {
	                    fos.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        catch (IOException ioe) {
            System.out.println("Exception while writing file " + ioe);
        }
	}
	
}
	
