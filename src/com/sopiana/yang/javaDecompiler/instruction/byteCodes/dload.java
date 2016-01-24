package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class dload extends instruction
{
	public static final opcodeTable ins = opcodeTable._dload;
	private byte index;
	public static dload getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid dload opcode");
		dload res = new dload();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = codes[offset];
		return res;
	}
	public byte getIndex() { return index; }
	public byte[] getData() { return new byte[]{opcode,index}; }
	public int getSize() { return 2; }
	public String getMnemonic() { return ins.mnemonic; }
	
}