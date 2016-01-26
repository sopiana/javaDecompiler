package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class new_ extends instruction
{
	public static final opcodeTable ins = opcodeTable._new;
	private short index;
	public static new_ getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		new_ res = new new_();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = Util.byte2Short(codes,offset);
		return res;
	}
	public short getIndex() { return index; }
	public byte[] getData() { return new byte[]{opcode,Util.getHighByte(index),Util.getLowByte(index)}; }
	public int getSize() { return 3; }
	public String getMnemonic() { return ins.mnemonic+String.format(" @%04x", index); }
}
