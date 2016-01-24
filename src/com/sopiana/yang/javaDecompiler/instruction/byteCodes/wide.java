package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class wide extends instruction
{
	public static final opcodeTable ins = opcodeTable._wide;
	private byte opcodeTarget;
	private short index;
	private short constValue;
	public static wide getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		wide res = new wide();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.opcodeTarget = codes[offset++];
		res.index = Util.byte2Short(codes,offset);
		if(res.opcodeTarget==opcodeTable._iinc.opcode)
		{
			offset+=2;
			res.constValue = Util.byte2Short(codes,offset);
		}
		offset+=2;
		return res;
	}
	public byte getOpcodeTarget() { return opcodeTarget; }
	public short getIndex() { return index; }
	public short getConstValue() { return constValue; }
	public byte[] getData() 
	{ 
		byte[] res = new byte[getSize()];
		int offset = 0;
		res[offset++] = opcode;
		res[offset++] = opcodeTarget;
		res[offset++] = (byte)((index&0xFF00)>>8);
		res[offset++] = (byte)(index&0x00FF);
		if(offset<res.length)
		{
			res[offset++] = (byte)((constValue&0xFF00)>>8);
			res[offset] = (byte)(constValue&0x00FF);
		}
		return res;
	}
	public int getSize() { 
		if(opcodeTarget==opcodeTable._iinc.opcode)
		{
			return 6;
		}
		return 5;
	}
	public String getMnemonic() { return ins.mnemonic; }
}