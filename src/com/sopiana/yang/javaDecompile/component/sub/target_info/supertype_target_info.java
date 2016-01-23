package com.sopiana.yang.javaDecompile.component.sub.target_info;

import com.sopiana.yang.javaDecompile.util.Util;

public class supertype_target_info extends target_info
{
	private short supertype_index;
	public static supertype_target_info getInstance(byte[]classFileData, int offset)
	{
		supertype_target_info res = new supertype_target_info();
		res.supertype_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 2; }
	public short getSupertype_index() { return supertype_index; }
	
}
