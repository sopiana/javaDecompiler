package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.parameter_annotations_info;

public class RuntimeInvisibleParameterAnnotations_attribute extends attribute_info{
	private byte num_parameters;
	private parameter_annotations_info parameter_annotations[];	//num_parameters
	public static RuntimeInvisibleParameterAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeInvisibleParameterAnnotations_attribute res = new RuntimeInvisibleParameterAnnotations_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.num_parameters = info[offset++];
		res.parameter_annotations = new parameter_annotations_info[res.num_parameters];
		for(int i=0;i<res.num_parameters;++i)
		{
			res.parameter_annotations[i] = parameter_annotations_info.getInstance(info, offset);
			offset += res.parameter_annotations[i].getSize();
		}
		return res;
	}
	public static RuntimeInvisibleParameterAnnotations_attribute getInstance(attribute_info attrib) throws decompilerException
	{
		return getInstance(attrib.getAttribute_name_index(), attrib.getAttribute_length(), attrib.getInfo());
	}
}
