package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class sipush extends instruction
{
	public static final opcodeTable ins = opcodeTable._sipush;
	private short value;
	public static sipush getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		sipush res = new sipush();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.value = Util.byte2Short(codes, offset);
		return res;
	}
	public short getValue() { return value; }
	public byte[] getData() { return new byte[]{opcode,Util.getHighByte(value),Util.getLowByte(value)}; }
	public int getSize() { return 3; }
	public String getMnemonic() { return ins.mnemonic+String.format(" %04x", value); }

}
