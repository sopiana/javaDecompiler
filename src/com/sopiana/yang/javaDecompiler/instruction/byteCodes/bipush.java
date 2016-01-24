package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class bipush extends instruction
{
	public static final opcodeTable ins = opcodeTable._bipush;
	private byte value;
	public static bipush getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid bipush opcode");
		bipush res = new bipush();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.value = codes[offset];
		return res;
	}
	public byte getValue() { return value; }
	public byte[] getData() { return new byte[]{opcode,value}; }
	public int getSize() { return 2; }
	public String getMnemonic() { return ins.mnemonic; }

}
