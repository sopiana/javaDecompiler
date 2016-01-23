package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.util.Util;

public class local_variable_type_table_info {
	private short start_pc;
	private short length;
	private short name_index;
	private short signature_index;
	private short index;
	public static local_variable_type_table_info getInstance(byte[]classFileData, int offset)
	{
		local_variable_type_table_info res= new local_variable_type_table_info();
		res.start_pc = Util.byte2Short(classFileData,offset);offset+=2;
		res.length = Util.byte2Short(classFileData,offset);offset+=2;
		res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.signature_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public short getStart_pc() { return start_pc; }
	public short getLength() { return length; }
	public short getName_index() { return name_index; }
	public short getSignature_index() { return signature_index; }
	public short getIndex() { return index; }
	public int getSize() { return 10; }
}
