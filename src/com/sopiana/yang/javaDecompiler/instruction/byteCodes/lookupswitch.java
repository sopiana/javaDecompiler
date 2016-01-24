package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;
import com.sopiana.yang.javaDecompiler.util.Util;

public class lookupswitch extends instruction
{
	public static final opcodeTable ins = opcodeTable._lookupswitch;
	private int padding;
	private int defaultbyte;
	private int npairs;
	private int[][]matchOffset_pairs;
	public static lookupswitch getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		lookupswitch res = new lookupswitch();
		res.offset = offset;
		res.opcode = codes[offset];
		res.padding = Util.byte2Int(codes, offset); offset+=4;
		res.defaultbyte = Util.byte2Int(codes, offset); offset+=4;
		res.npairs = Util.byte2Int(codes, offset);offset+=4;
		res.matchOffset_pairs = new int[res.npairs][2];
		for(int i=0;i<res.npairs;++i)
		{
			res.matchOffset_pairs[i][0] = Util.byte2Int(codes, offset);offset+=4;
			res.matchOffset_pairs[i][1] = Util.byte2Int(codes, offset);offset+=4;
		}
		return res;
	}
	public int getPadding() { return padding; }
	public int getDefaultbyte() { return defaultbyte; }
	public int getNpairs() { return npairs; }
	public int[][]getMatchOffset_pairs() { return matchOffset_pairs; }
	public byte[] getData() 
	{
		byte[] res = new byte[getSize()];
		int offset = 0;
		res[offset++] = opcode;
		offset = Util.intToByteArray(padding, res, offset);
		offset = Util.intToByteArray(defaultbyte, res, offset);
		offset = Util.intToByteArray(npairs, res, offset);
		for(int i=0;i<npairs;++i)
		{
			offset = Util.intToByteArray(matchOffset_pairs[i][0], res, offset);
			offset = Util.intToByteArray(matchOffset_pairs[i][1], res, offset);
		}
		return res;
	}
	public int getSize() {
		return 13+npairs*8;
	}
	public String getMnemonic() { return ins.mnemonic; }
}