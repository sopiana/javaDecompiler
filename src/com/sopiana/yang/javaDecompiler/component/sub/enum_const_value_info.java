package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.util.Util;

public class enum_const_value_info {
	private short type_name_index;
	private short const_name_index;
	public static enum_const_value_info getInstance(byte[]classFileData, int offset)
	{
		enum_const_value_info res = new enum_const_value_info();
		res.type_name_index = Util.byte2Short(classFileData,offset); offset+=2;
		res.const_name_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	
	public int getSize() { return 4; }
	public short getType_name_index() { return type_name_index; }
	public short getConst_name_index(){ return const_name_index; }
}
