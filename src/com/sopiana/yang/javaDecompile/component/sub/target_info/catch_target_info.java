package com.sopiana.yang.javaDecompile.component.sub.target_info;

import com.sopiana.yang.javaDecompile.util.Util;

public class catch_target_info extends target_info
{
	private short exception_table_index;
	public static catch_target_info getInstance(byte[]classFileData, int offset)
	{
		catch_target_info res = new catch_target_info();
		res.exception_table_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 2; }
	public short getException_table_index() { return exception_table_index; }
}
