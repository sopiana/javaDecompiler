package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.sub.local_variable_type_table_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class LocalVariableTypeTable_attribute extends attribute_info
{
	private short local_variable_type_table_length;
	private local_variable_type_table_info local_variable_type_table[];	//local_variable_type_table_length
	public static LocalVariableTypeTable_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) 
	{
		int offset = 0;
		LocalVariableTypeTable_attribute res = new LocalVariableTypeTable_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.local_variable_type_table_length = Util.byte2Short(info);offset+=2;
		res.local_variable_type_table = new local_variable_type_table_info[res.local_variable_type_table_length];
		for(int i=0;i<res.local_variable_type_table_length;++i)
		{
			res.local_variable_type_table[i] = local_variable_type_table_info.getInstance(info, offset);
			offset += res.local_variable_type_table[i].getSize();
		}
		return res;
	}
	public static LocalVariableTypeTable_attribute getInstance(attribute_info attrib)
	{
		return getInstance(attrib.getAttribute_name_index(), attrib.getAttribute_length(), attrib.getInfo());
	}
}
