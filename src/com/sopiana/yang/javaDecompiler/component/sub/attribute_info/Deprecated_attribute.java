package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;

public class Deprecated_attribute extends attribute_info
{
	public static Deprecated_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		Deprecated_attribute res = new Deprecated_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		return res;
	}
	public static Deprecated_attribute getInstance(attribute_info attrib)
	{
		return getInstance(attrib.getAttribute_name_index(), attrib.getAttribute_length(), attrib.getInfo());
	}
}
