package com.sopiana.yang.javaDecompile.component.sub;

import com.sopiana.yang.javaDecompile.util.Util;

public class line_number_table_info {
	private short start_pc;
	private short line_number;
	public static line_number_table_info getInstance(byte[]classFileData, int offset)
	{
		line_number_table_info res = new line_number_table_info();
		res.start_pc = Util.byte2Short(classFileData,offset); offset+=2;
		res.line_number = Util.byte2Short(classFileData,offset);
		return res;
	}
	public short getStart_pc() { return start_pc; }
	public short getLine_number() { return line_number; }
	public int getSize() { return 4; }
}
