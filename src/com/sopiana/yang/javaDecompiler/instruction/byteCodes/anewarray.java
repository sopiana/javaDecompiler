package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class anewarray extends instruction
{
	public static final opcodeTable ins = opcodeTable._anewarray;
	private short index;
	public static anewarray getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid anewarray opcode");
		anewarray res = new anewarray();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = Util.byte2Short(codes,offset);
		return res;
	}
	public short getIndex() { return index; }
	public byte[] getData() { return new byte[]{opcode,Util.getHighByte(index),Util.getLowByte(index)}; }
	public int getSize() { return 3; }
	public String getMnemonic() { return ins.mnemonic; }
}
