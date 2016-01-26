package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class newarray extends instruction
{
	public static final opcodeTable ins = opcodeTable._newarray;
	private byte atype;
	public static newarray getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		newarray res = new newarray();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.atype = codes[offset];
		return res;
	}
	public short getAtype() { return atype; }
	public byte[] getData() { return new byte[]{opcode, atype}; }
	public int getSize() { return 2; }
	public String getMnemonic() { return ins.mnemonic+String.format(" @%02x", atype); }
}
