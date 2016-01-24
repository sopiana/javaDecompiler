package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class dload_3 extends instruction
{
	public static final opcodeTable ins = opcodeTable._dload_3;
	
	public static dload_3 getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid dload_3 opcode");
		dload_3 res = new dload_3();
		res.offset = offset;
		res.opcode = codes[offset];
		return res;
	}
	public byte[] getData() { return new byte[]{opcode}; }
	public int getSize() { return 1; }
	public String getMnemonic() { return ins.mnemonic; }
}