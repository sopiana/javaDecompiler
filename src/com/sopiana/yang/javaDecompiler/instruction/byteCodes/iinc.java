package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class iinc extends instruction
{
	public static final opcodeTable ins = opcodeTable._iinc;
	private byte index;
	private byte constant;
	public static iinc getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		iinc res = new iinc();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = codes[offset++];
		res.constant = codes[offset];
		return res;
	}
	public byte getIndex() { return index; }
	public byte getConstant() { return constant; }
	public byte[] getData() { return new byte[]{opcode,index,constant}; }
	public int getSize() { return 3; }
	public String getMnemonic() { return ins.mnemonic; }
}
