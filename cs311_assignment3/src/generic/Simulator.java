package generic;

import java.io.*;
import processor.Clock;
import processor.Processor;
//import processor.memorysystem.MainMemory;

public class Simulator {
		
	static Processor processor;
	static boolean simulationComplete;
	
	public static void setupSimulation(String assemblyProgramFile, Processor p)
	{
		Simulator.processor = p;
		loadProgram(assemblyProgramFile);
		
		simulationComplete = false;
	}
	
	static void loadProgram(String assemblyProgramFile)
	{
		//int i = processor.getMainMemory().getWord(12);
		//MainMemory mainMem = new MainMemrory();
		/*
		 * TODO
		 * 1. load the program into memory according to the program layout described
		 *    in the ISA specification
		 * 2. set PC to the address of the first instruction in the main
		 * 3. set the following registers:
		 *     x0 = 0
		 *     x1 = 65535
		 *     x2 = 65535
		 */
		// Leaving the first code address, write all the following information in each line.
		// Takes as arg an input stream.
		try(DataInputStream din = new DataInputStream(new FileInputStream(assemblyProgramFile))){
			int mem_row;
			int address = 0;
			
			// Read the first 8 bytes of the file and set it to PC. (First Code Address)
			mem_row = din.readInt();
			Simulator.processor.getRegisterFile().setProgramCounter(mem_row);
			System.out.println("Program Counter: "+ Simulator.processor.getRegisterFile().getProgramCounter());
			
			while(din.available() > 0) { // Checking how many more bytes can be read.
				
				// Reads 32bits at once! (Int)
				mem_row = din.readInt();
				Simulator.processor.getMainMemory().setWord(address, mem_row);
				address += 1; // Incrementing the address value.
			}
			
			// Check out the contents of the main mem here
			String mem = Simulator.processor.getMainMemory().getContentsAsString(0, address-1);
			System.out.println(mem);
			
		} catch(IOException e) {
			System.out.println("Cannot open the given file. Error while opening the assembly file" + assemblyProgramFile);
			return;
		}
		
		
		// Now set the registers x1 and x2 as 65535.
		Simulator.processor.getRegisterFile().setValue(0, 0);
		Simulator.processor.getRegisterFile().setValue(1, 65535);
		Simulator.processor.getRegisterFile().setValue(2, 65535);
	}
	
	public static void simulate()
	{
		while(simulationComplete == false)
		{
			processor.getIFUnit().performIF();
			Clock.incrementClock();
			processor.getOFUnit().performOF();
			Clock.incrementClock();
			processor.getEXUnit().performEX();
			Clock.incrementClock();
			processor.getMAUnit().performMA();
			Clock.incrementClock();
			processor.getRWUnit().performRW();
			Clock.incrementClock();
		}
		
		// TODO
		// set statistics
	}
	
	public static void setSimulationComplete(boolean value)
	{
		simulationComplete = value;
	}
}
