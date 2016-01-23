package com.sopiana.yang.javaDecompile.component.sub.attribute_info;

import com.sopiana.yang.javaDecompile.component.attribute_info;
import com.sopiana.yang.javaDecompile.component.decompilerException;
import com.sopiana.yang.javaDecompile.component.sub.element_value;
import com.sopiana.yang.javaDecompile.util.Util;

public class AnnotationDefault_attribute extends attribute_info
{
	private short attribute_name_index;
	private int attribute_length;
	private element_value default_value;
	public static AnnotationDefault_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
 	{
 		int offset = 0;
 		AnnotationDefault_attribute res = new AnnotationDefault_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.attribute_name_index = Util.byte2Short(info); offset+=2;
 		res.attribute_length = Util.byte2Int(info, offset); offset+=4;
 		res.default_value = element_value.getInstance(info, offset);
 		return res;
 	}
}
