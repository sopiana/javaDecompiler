package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class CONSTANT_Methodref_info extends cp_info{
	private short class_index;
	private short name_and_type_index;
	
	public static CONSTANT_Methodref_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Methodref_info res = new CONSTANT_Methodref_info();
		res.tag = classFileData[offset++];
		res.class_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.name_and_type_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	public int getSize() { return 5; }
	public short getClass_index() { return class_index; }
	public short getName_and_type_index() { return name_and_type_index; }
}
