package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import java.util.Arrays;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.sub.exception_table_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class Code_attribute extends attribute_info
{
	private short max_stack;
	private short max_locals;
	private int code_length;
	private byte code[];	//code_length
	private short exception_table_length;
	private exception_table_info exception_table[]; //exception_table_length
 	private short attributes_count;
 	private attribute_info attributes[];			//attributes_count
 	
 	public static Code_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
 	{
 		int offset = 0;
 		Code_attribute res = new Code_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.max_stack = Util.byte2Short(info,offset); offset+=2;
 		res.max_locals = Util.byte2Short(info,offset); offset+=2;
 		res.code_length = Util.byte2Int(info,offset); offset+=4; 
 		res.code = Arrays.copyOfRange(info, offset, offset+res.code_length); offset+=res.code_length;
 		res.exception_table_length = Util.byte2Short(info,offset); offset+=2;
 		res.exception_table = new exception_table_info[res.exception_table_length];
 		for(int i=0;i<res.exception_table_length;++i)
 		{
 			res.exception_table[i] = exception_table_info.getInstance(info, offset);
 			offset += res.exception_table[i].getSize();
 		}
 		res.attributes_count = Util.byte2Short(info,offset); offset+=2;
 		res.attributes = new attribute_info[res.attributes_count];
 		for(int i=0;i<res.attributes_count;++i)
 		{
 			res.attributes[i] = attribute_info.getInstance(info, offset);
 			offset += res.attributes[i].getSize();
 		}
 		return res;
 	}
 	
 	public static Code_attribute getInstance(attribute_info attrib)
	{
		return getInstance((short)(attrib.getAttribute_name_index()), attrib.getAttribute_length(), attrib.getInfo());
	}
}
