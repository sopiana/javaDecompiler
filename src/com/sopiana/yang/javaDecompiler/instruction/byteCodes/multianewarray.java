package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class multianewarray extends instruction
{
	public static final opcodeTable ins = opcodeTable._multianewarray;
	private short index;
	private byte dimensions;
	public static multianewarray getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		multianewarray res = new multianewarray();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = Util.byte2Short(codes,offset);offset+=2;
		res.dimensions = codes[offset];
		return res;
	}
	public short getIndex() { return index; }
	public byte getDimensions() { return dimensions; }
	public byte[] getData() { return new byte[]{opcode,Util.getHighByte(index),Util.getLowByte(index),dimensions}; }
	public int getSize() { return 4; }
	public String getMnemonic() { return ins.mnemonic; }
}