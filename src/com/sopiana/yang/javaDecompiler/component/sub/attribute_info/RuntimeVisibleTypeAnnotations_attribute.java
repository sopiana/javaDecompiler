package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.annotation_info;
import com.sopiana.yang.javaDecompiler.component.sub.type_annotation_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class RuntimeVisibleTypeAnnotations_attribute extends attribute_info
{
	private short num_annotations;
	private type_annotation_info annotations[];	//num_annotations
	public static RuntimeVisibleTypeAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeVisibleTypeAnnotations_attribute res = new RuntimeVisibleTypeAnnotations_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.num_annotations = Util.byte2Short(info); offset+=2;
		res.annotations = new type_annotation_info[res.num_annotations];
		for(int i=0;i<res.num_annotations;++i)
		{
			res.annotations[i] = type_annotation_info.getInstance(info, offset);
			offset+=res.annotations[i].getSize();
		}
		return res;
	}
	public static RuntimeVisibleTypeAnnotations_attribute getInstance(attribute_info attrib) throws decompilerException
	{
		return getInstance((short)(attrib.getAttribute_name_index()), attrib.getAttribute_length(), attrib.getInfo());
	}
}
