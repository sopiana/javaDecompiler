package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class SourceFile_attribute extends attribute_info
{
	private short sourcefile_index;
	
	public static SourceFile_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		SourceFile_attribute res = new SourceFile_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.sourcefile_index = Util.byte2Short(info);
		return res;
	}
	public static SourceFile_attribute getInstance(attribute_info attrib)
	{
		return getInstance(attrib.getAttribute_name_index(), attrib.getAttribute_length(), attrib.getInfo());
	}
	public short getSourcefile_index() { return this.sourcefile_index; }
}
