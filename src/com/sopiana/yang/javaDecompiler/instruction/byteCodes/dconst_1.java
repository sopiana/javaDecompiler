package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class dconst_1 extends instruction
{
	public static final opcodeTable ins = opcodeTable._dconst_1;
	
	public static dconst_1 getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid dconst_1 opcode");
		dconst_1 res = new dconst_1();
		res.offset = offset;
		res.opcode = codes[offset];
		return res;
	}
	public byte[] getData() { return new byte[]{opcode}; }
	public int getSize() { return 1; }
	public String getMnemonic() { return ins.mnemonic; }
}
