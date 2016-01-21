package com.sopiana.yang.javaDecompile.subComponent;

import com.sopiana.yang.javaDecompile.component.cp_info;
import com.sopiana.yang.javaDecompile.util.Util;

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

}
