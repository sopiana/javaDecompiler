package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class CONSTANT_Class_info extends cp_info 
{
	
	private short name_index;
	
	public static CONSTANT_Class_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Class_info res = new CONSTANT_Class_info();
		res.tag = classFileData[offset++];
		res.name_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	
	@Override
	public int getSize() 
	{
		return 3;
	}
	public short getName_index() { return name_index; }
}
