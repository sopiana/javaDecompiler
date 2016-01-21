package com.sopiana.yang.javaDecompile.subComponent;

import com.sopiana.yang.javaDecompile.component.cp_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class CONSTANT_Fieldref_info extends cp_info{
	private short class_index;
	private short name_and_type_index;
	
	public static CONSTANT_Fieldref_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Fieldref_info res = new CONSTANT_Fieldref_info();
		res.tag = classFileData[offset++];
		res.class_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.name_and_type_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	public int getSize() { return 5; }

}
