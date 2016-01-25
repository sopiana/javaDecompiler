package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class ConstantValue_attribute extends attribute_info
{
	private short constantvalue_index;
	
	public static ConstantValue_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		ConstantValue_attribute res = new ConstantValue_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.constantvalue_index = Util.byte2Short(info);
		return res;
	}
	
	public short getConstantvalue_index() { return this.constantvalue_index; }
}
