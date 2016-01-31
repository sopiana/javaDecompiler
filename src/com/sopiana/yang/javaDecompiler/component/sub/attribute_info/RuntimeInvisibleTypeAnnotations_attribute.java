package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.type_annotation_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class RuntimeInvisibleTypeAnnotations_attribute extends attribute_info
{
	private short num_annotations;
	private type_annotation_info annotations[];	//num_annotations
	public static RuntimeInvisibleTypeAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeInvisibleTypeAnnotations_attribute res = new RuntimeInvisibleTypeAnnotations_attribute();
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
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
