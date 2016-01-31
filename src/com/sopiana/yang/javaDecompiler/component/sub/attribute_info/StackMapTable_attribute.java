package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.frame.stack_map_frame;
import com.sopiana.yang.javaDecompiler.util.Util;

public class StackMapTable_attribute extends attribute_info
{
	private short number_of_entries;
	private stack_map_frame entries[];	//number_of_entries
	
	public static StackMapTable_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
	{
		int offset = 0;
		StackMapTable_attribute res = new StackMapTable_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.number_of_entries = Util.byte2Short(info); offset+=2;
		res.entries = new stack_map_frame[res.number_of_entries];
		for(int i=0;i<res.number_of_entries;++i)
		{
			res.entries[i] = stack_map_frame.getInstance(info,offset);
			offset += res.entries[i].getSize();
		}
		return res;
	}

	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
