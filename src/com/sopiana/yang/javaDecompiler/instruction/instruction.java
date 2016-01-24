package com.sopiana.yang.javaDecompiler.instruction;

public abstract class instruction 
{
	protected byte opcode;
	protected int offset;
	public byte getOpcode() { return opcode; }
	public int getOffset() { return offset; }
	public abstract byte[] getData();
	public abstract int getSize();
	public abstract String getMnemonic();
}
