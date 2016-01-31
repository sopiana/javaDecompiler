package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.line_number_table_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class LineNumberTable_attribute extends attribute_info
{
	private short line_number_table_length;
	private line_number_table_info line_number_table[];	//line_number_table_length
	public static LineNumberTable_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) 
	{
		int offset = 0;
		LineNumberTable_attribute res = new LineNumberTable_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.line_number_table_length = Util.byte2Short(info);offset+=2;
		res.line_number_table = new line_number_table_info[res.line_number_table_length];
		for(int i=0;i<res.line_number_table_length;++i)
		{
			res.line_number_table[i] = line_number_table_info.getInstance(info, offset);
			offset+=res.line_number_table[i].getSize();
		}
		return res;
	}
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
