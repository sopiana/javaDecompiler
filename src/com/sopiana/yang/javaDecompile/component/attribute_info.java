package com.sopiana.yang.javaDecompile.component;

import java.util.Arrays;

import com.sopiana.yang.javaDecompile.util.Util;

public class attribute_info {
	private short attribute_name_index;
    private int attribute_length;
    private byte info[];	//attribute_length
    
	public static attribute_info getInstance(byte[]classFileData, int offset)
	{
		attribute_info res = new attribute_info();
		res.attribute_name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.attribute_length = Util.byte2Int(classFileData,offset);offset+=4;
		res.info = Arrays.copyOfRange(classFileData, offset, offset+res.attribute_length);
		return res;
	}
	public int getSize()
	{
		return 6+attribute_length;
	}
}
