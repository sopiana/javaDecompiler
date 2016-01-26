package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class fload extends instruction
{
	public static final opcodeTable ins = opcodeTable._fload;
	private byte index;
	public static fload getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		fload res = new fload();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = codes[offset];
		return res;
	}
	public byte getIndex() { return index; }
	public byte[] getData() { return new byte[]{opcode,index}; }
	public int getSize() { return 2; }
	public String getMnemonic() { return ins.mnemonic+String.format(" @%02x", index); }
	
}