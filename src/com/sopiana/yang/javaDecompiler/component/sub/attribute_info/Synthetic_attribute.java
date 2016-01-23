package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;

public class Synthetic_attribute extends attribute_info
{
	public static Synthetic_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		Synthetic_attribute res = new Synthetic_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		return res;
	}
	public static Synthetic_attribute getInstance(attribute_info attrib)
	{
		return getInstance((short)(attrib.getAttribute_name_index()), attrib.getAttribute_length(), attrib.getInfo());
	}
}
