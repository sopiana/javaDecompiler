package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import java.util.Arrays;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class Exceptions_attribute extends attribute_info
{
	private short number_of_exceptions;
	private short exception_index_table[];	//number_of_exceptions
	public static Exceptions_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		int offset = 0;
		Exceptions_attribute res = new Exceptions_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.number_of_exceptions = Util.byte2Short(info);offset+=2;
		res.exception_index_table = new short[res.number_of_exceptions];
		for(int i=0;i<res.number_of_exceptions;++i)
		{
			res.exception_index_table[i] = Util.byte2Short(info,offset);
			offset+=2;
		}
		return res;
	}
	public short number_of_exceptions() { return number_of_exceptions; }
	public short[] exception_index_table() { return Arrays.copyOf(exception_index_table, number_of_exceptions); }
}
