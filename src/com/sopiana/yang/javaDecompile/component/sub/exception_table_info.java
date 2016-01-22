package com.sopiana.yang.javaDecompile.component.sub;

import com.sopiana.yang.javaDecompile.util.Util;

public class exception_table_info
{
	private short start_pc;
	private short end_pc;
	private short handler_pc;
	private short catch_type;
	
	public static exception_table_info getInstance(byte[]classFileData, int offset)
	{
		exception_table_info res = new exception_table_info();
		res.start_pc = Util.byte2Short(classFileData,offset); offset+=2;
		res.end_pc = Util.byte2Short(classFileData,offset);offset+=2;
		res.handler_pc = Util.byte2Short(classFileData,offset);offset+=2;
		res.catch_type = Util.byte2Short(classFileData,offset);offset+=2;
		return res;
	}
	
	public int getSize() { return 8; }
	public short getStart_pc() { return start_pc; }
	public short getEnd_pc() { return end_pc; }
	public short getHandler_pc() { return handler_pc; }
	public short getCatch_type() { return catch_type; }
}
