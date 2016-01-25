package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.sub.local_variable_table_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class LocalVariableTable_attribute extends attribute_info
{
	private short local_variable_table_length;
	private local_variable_table_info local_variable_table[];	//local_variable_table_length
	
	public static LocalVariableTable_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) 
	{
		int offset = 0;
		LocalVariableTable_attribute res = new LocalVariableTable_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.local_variable_table_length = Util.byte2Short(info);offset+=2;
		res.local_variable_table = new local_variable_table_info[res.local_variable_table_length];
		for(int i=0;i<res.local_variable_table_length;++i)
		{
			res.local_variable_table[i] = local_variable_table_info.getInstance(info, offset);
			offset += res.local_variable_table[i].getSize();
		}
		return res;
	}
}
