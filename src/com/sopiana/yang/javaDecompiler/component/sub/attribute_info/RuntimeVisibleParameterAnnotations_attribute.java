package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.parameter_annotations_info;

public class RuntimeVisibleParameterAnnotations_attribute extends attribute_info{
	private byte num_parameters;
	private parameter_annotations_info parameter_annotations[];	//num_parameters
	public static RuntimeVisibleParameterAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeVisibleParameterAnnotations_attribute res = new RuntimeVisibleParameterAnnotations_attribute();
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
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
