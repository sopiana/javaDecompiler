package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class dload_0 extends instruction
{
	public static final opcodeTable ins = opcodeTable._dload_0;
	
	public static dload_0 getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid dload_0 opcode");
		dload_0 res = new dload_0();
		res.offset = offset;
		res.opcode = codes[offset];
		return res;
	}
	public byte[] getData() { return new byte[]{opcode}; }
	public int getSize() { return 1; }
	public String getMnemonic() { return ins.mnemonic; }
}