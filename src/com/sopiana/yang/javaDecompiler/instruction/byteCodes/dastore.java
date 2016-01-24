package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class dastore extends instruction
{
	public static final opcodeTable ins = opcodeTable._dastore;
	
	public static dastore getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid dastore opcode");
		dastore res = new dastore();
		res.offset = offset;
		res.opcode = codes[offset];
		return res;
	}
	public byte[] getData() { return new byte[]{opcode}; }
	public int getSize() { return 1; }
	public String getMnemonic() { return ins.mnemonic; }
}
