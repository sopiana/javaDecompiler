package com.sopiana.yang.javaDecompiler.instruction;

public enum opcodeTable 
{
	_aconst_null((byte)0x1,"aconst_null"),
	_aload((byte)0x19,"aload"),
	_aload_0((byte)0x2a,"aload_0"),
	_aload_1((byte)0x2b,"aload_1"),
	_aaload((byte)0x32,"aaload"),
	_aastore((byte)0x53,"aastore");
	public byte opcode;
	public String mnemonic;
	private opcodeTable(byte opcode,String mnemonic)
	{
		this.opcode = opcode;
		this.mnemonic = mnemonic;
	}
}
