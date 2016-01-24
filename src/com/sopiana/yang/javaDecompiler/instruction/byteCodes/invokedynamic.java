package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class invokedynamic extends instruction
{
	public static final opcodeTable ins = opcodeTable._invokedynamic;
	private short index;
	private short padding;
	public static invokedynamic getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		invokedynamic res = new invokedynamic();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = Util.byte2Short(codes,offset);offset+=2;
		res.padding = Util.byte2Short(codes,offset);
		if(res.padding!=0)
			throw new instructionException("supplied code has invalid "+ins.mnemonic+" padding");
		return res;
	}
	public short getIndex() { return index; }
	public short getPadding() { return padding; }
	public byte[] getData() { return new byte[]{opcode,Util.getHighByte(index),Util.getLowByte(index),
			Util.getHighByte(padding),Util.getLowByte(padding)}; }
	public int getSize() { return 5; }
	public String getMnemonic() { return ins.mnemonic; }
}
