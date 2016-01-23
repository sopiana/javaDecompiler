package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;

public class array_value_info 
{
	private short num_values;
	private element_value values[];	//num_values
	public static array_value_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		array_value_info res = new array_value_info();
		res.num_values = Util.byte2Short(classFileData,offset); offset+=2;
		res.values = new element_value[res.num_values];
		
		for(int i=0;i<res.num_values;++i)
		{
			res.values[i] = element_value.getInstance(classFileData, offset);
			offset+=res.values[i].getSize();
		}
		return res;
	}
	
	public int getSize() 
	{ 
		int res = 2;
		for(int i=0;i<num_values;++i)
		{
			res+=values[i].getSize();
		}
		return res;
	}
}
