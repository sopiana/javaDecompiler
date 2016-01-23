package com.sopiana.yang.javaDecompile.component.sub;

import com.sopiana.yang.javaDecompile.util.Util;

public class parameters_info {
	private short name_index;
	private short access_flags;
	public static parameters_info getInstance(byte[]classFileData, int offset)
	{
		parameters_info res = new parameters_info();
		res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.access_flags = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 4; }
}
