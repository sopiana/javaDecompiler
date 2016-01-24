package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class jsr_w extends instruction
{
	public static final opcodeTable ins = opcodeTable._jsr_w;
	private int branch;
	public static jsr_w getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		jsr_w res = new jsr_w();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.branch = Util.byte2Int(codes,offset);
		return res;
	}
	public int getBranch() { return branch; }
	public byte[] getData() { 
		short highShort = (short)((branch&0xFFFF0000)>>16);
		short lowShort = (short)(branch&0x0000FFFF);
		return new byte[]{opcode,Util.getHighByte((highShort)),Util.getLowByte(highShort),
				Util.getHighByte((lowShort)),Util.getLowByte(lowShort)}; }
	public int getSize() { return 5; }
	public String getMnemonic() { return ins.mnemonic; }
}
