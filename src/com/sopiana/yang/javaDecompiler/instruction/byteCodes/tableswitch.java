package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class tableswitch extends instruction
{
	public static final opcodeTable ins = opcodeTable._tableswitch;
	private int padding;
	private int defaultbyte;
	private int lowValue;
	private int highValue;
	private int[]jumpOffset;
	public static tableswitch getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		tableswitch res = new tableswitch();
		res.offset = offset;
		res.opcode = codes[offset];
		res.padding = Util.byte2Int(codes, offset); offset+=4;
		res.defaultbyte = Util.byte2Int(codes, offset); offset+=4;
		res.lowValue = Util.byte2Int(codes, offset);offset+=4;
		res.highValue = Util.byte2Int(codes, offset);offset+=4;
		res.jumpOffset = new int[res.highValue-res.lowValue+1];
		for(int i=0;i<res.jumpOffset.length;++i)
		{
			res.jumpOffset[i] = Util.byte2Int(codes, offset);offset+=4;
		}
		return res;
	}
	public int getPadding() { return padding; }
	public int getDefaultbyte() { return defaultbyte; }
	public int getLowValue() { return lowValue; }
	public int gethighValue() { return highValue; }
	public int[]getJumpOffset() { return jumpOffset; }
	public byte[] getData() 
	{
		byte[] res = new byte[getSize()];
		int offset = 0;
		res[offset++] = opcode;
		offset = Util.intToByteArray(padding, res, offset);
		offset = Util.intToByteArray(defaultbyte, res, offset);
		offset = Util.intToByteArray(lowValue, res, offset);
		offset = Util.intToByteArray(highValue, res, offset);
		for(int i=0;i<jumpOffset.length;++i)
		{
			offset = Util.intToByteArray(jumpOffset[i], res, offset);
		}
		return res;
	}
	public int getSize() {
		return 17+(highValue-lowValue+1)*4;
	}
	public String getMnemonic() { return ins.mnemonic; }
}