package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class invokeinterface extends instruction
{
	public static final opcodeTable ins = opcodeTable._invokeinterface;
	private short index;
	private byte count;
	private byte padding;
	public static invokeinterface getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		invokeinterface res = new invokeinterface();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = Util.byte2Short(codes,offset);offset+=2;
		res.count = codes[offset++];
		res.padding = codes[offset];
		if(res.padding!=0)
			throw new instructionException("supplied code has invalid "+ins.mnemonic+" padding");
		return res;
	}
	public short getIndex() { return index; }
	public byte getCount() { return count; }
	public byte getPadding() { return padding; }
	public byte[] getData() { return new byte[]{opcode,Util.getHighByte(index),Util.getLowByte(index),
			count, padding}; }
	public int getSize() { return 5; }
	public String getMnemonic() { return ins.mnemonic; }
}