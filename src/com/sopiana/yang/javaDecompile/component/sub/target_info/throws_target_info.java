package com.sopiana.yang.javaDecompile.component.sub.target_info;

import com.sopiana.yang.javaDecompile.util.Util;

public class throws_target_info extends target_info
{
	private short throws_type_index;
	public static throws_target_info getInstance(byte[]classFileData, int offset)
	{
		throws_target_info res = new throws_target_info();
		res.throws_type_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 2; }
	public short getThrows_type_index() { return throws_type_index; }
}
