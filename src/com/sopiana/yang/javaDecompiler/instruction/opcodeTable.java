package com.sopiana.yang.javaDecompiler.instruction;

public enum opcodeTable 
{
	_aconst_null((byte)0x1,"aconst_null"),
	_dconst_0	((byte)0x0e,"dconst_0"),
	_dconst_1	((byte)0x0f,"dconst_1"),
	_bipush		((byte)0x10,"bipush"),
	_dload		((byte)0x18,"dload"),
	_aload		((byte)0x19,"aload"),
	_dload_0	((byte)0x26,"dload_0"),
	_dload_1	((byte)0x27,"dload_1"),
	_dload_2	((byte)0x28,"dload_2"),
	_dload_3	((byte)0x29,"dload_3"),
	_aload_0	((byte)0x2a,"aload_0"),
	_aload_1	((byte)0x2b,"aload_1"),
	_aload_2	((byte)0x2c,"aload_2"),
	_aload_3	((byte)0x2d,"aload_3"),
	_daload		((byte)0x31,"daload"),
	_aaload		((byte)0x32,"aaload"),
	_baload		((byte)0x33,"baload"),
	_caload		((byte)0x34,"caload"),
	_astore		((byte)0x3a,"astore"),
	_astore_0	((byte)0x4b,"astore_0"),
	_astore_1	((byte)0x4c,"astore_1"),
	_astore_2	((byte)0x4d,"astore_2"),
	_astore_3	((byte)0x4e,"astore_3"),
	_dastore	((byte)0x52,"dastore"),
	_aastore	((byte)0x53,"aastore"),
	_bastore	((byte)0x54,"bastore"),
	_castore	((byte)0x55,"castore"),
	_dadd		((byte)0x63,"dadd"),
	_ddiv		((byte)0x6f,"ddiv"),
	_d2i		((byte)0x8e,"d2i"),
	_d2l		((byte)0x8f,"d2l"),
	_d2f		((byte)0x90,"d2f"),
	_dcmpl		((byte)0x97,"dcmpl"),
	_dcmpg		((byte)0x98,"dcmpg"),
	_areturn	((byte)0xb0,"areturn"),
	_anewarray	((byte)0xbd,"anewarray"),
	_arraylength((byte)0xbe,"arraylength"),
	_athrow		((byte)0xbf,"athrow"),
	_checkcast	((byte)0xc0,"checkcast");
	public byte opcode;
	public String mnemonic;
	private opcodeTable(byte opcode,String mnemonic)
	{
		this.opcode = opcode;
		this.mnemonic = mnemonic;
	}
}
