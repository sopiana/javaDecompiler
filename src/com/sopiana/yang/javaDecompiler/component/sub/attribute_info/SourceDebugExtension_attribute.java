package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import java.util.Arrays;
import com.sopiana.yang.javaDecompiler.component.attribute_info;


public class SourceDebugExtension_attribute extends attribute_info{
	private byte debug_extension[];	//attribute_length
	public static SourceDebugExtension_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		SourceDebugExtension_attribute res = new SourceDebugExtension_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.debug_extension = Arrays.copyOf(info, attribute_length);
		return res;
	}
	public byte[] getDebug_extension() { return Arrays.copyOf(debug_extension, attribute_length); }
	public static SourceDebugExtension_attribute getInstance(attribute_info attrib)
	{
		return getInstance(attrib.getAttribute_name_index(), attrib.getAttribute_length(), attrib.getInfo());
	}
}