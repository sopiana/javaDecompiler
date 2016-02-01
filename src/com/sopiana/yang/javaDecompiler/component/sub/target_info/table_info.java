package com.sopiana.yang.javaDecompiler.component.sub.target_info;

import com.sopiana.yang.javaDecompiler.util.Util;

public class table_info 
{
	private short start_pc;
	private short length;
	private short index;
	public static table_info getInstance(byte[]classFileData, int offset)
	{
		table_info res = new table_info();
		res.start_pc = Util.byte2Short(classFileData,offset); offset+=2;
		res.length = Util.byte2Short(classFileData,offset); offset+=2;
		res.index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 6; }
	public short getStart_pc() { return start_pc; }
	public short getLength() { return length; }
	public short getIndex() { return index; }
}
