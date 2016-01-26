package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class goto_w extends instruction
{
	public static final opcodeTable ins = opcodeTable._goto_w;
	private int branch;
	public static goto_w getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		goto_w res = new goto_w();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.branch = Util.byte2Int(codes,offset);
		return res;
	}
	public int getBranch() { return branch; }
	public byte[] getData() { 
		short highShort = Util.getHighShort(branch);
		short lowShort = Util.getLowShort(branch);
		return new byte[]{opcode,Util.getHighByte((highShort)),Util.getLowByte(highShort),
				Util.getHighByte((lowShort)),Util.getLowByte(lowShort)}; }
	public int getSize() { return 5; }
	public String getMnemonic() { return ins.mnemonic+String.format(" #%08x", branch); }
}
