package com.sopiana.yang.javaDecompiler.component.sub.target_info;

import com.sopiana.yang.javaDecompiler.util.Util;

public class type_argument_target_info extends target_info
{
	private short offset;
	private byte type_argument_index;
	public static type_argument_target_info getInstance(byte[]classFileData, int offset)
	{
		type_argument_target_info res = new type_argument_target_info();
		res.offset = Util.byte2Short(classFileData,offset); offset +=2;
		res.type_argument_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 3; }
	public short getOffset() { return offset; }
	public byte getType_argument_index() { return type_argument_index; }
}
