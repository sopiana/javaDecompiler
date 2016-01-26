package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class if_icmpeq extends instruction
{
	public static final opcodeTable ins = opcodeTable._if_icmpeq;
	private short branch;
	public static if_icmpeq getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		if_icmpeq res = new if_icmpeq();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.branch = Util.byte2Short(codes,offset);
		return res;
	}
	public short getBranch() { return branch; }
	public byte[] getData() { return new byte[]{opcode,Util.getHighByte(branch),Util.getLowByte(branch)}; }
	public int getSize() { return 3; }
	public String getMnemonic() { return ins.mnemonic+String.format(" #%04x", branch); }
}
