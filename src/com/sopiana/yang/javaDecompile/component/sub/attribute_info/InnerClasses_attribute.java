package com.sopiana.yang.javaDecompile.component.sub.attribute_info;

import com.sopiana.yang.javaDecompile.component.attribute_info;
import com.sopiana.yang.javaDecompile.component.sub.InnerClass_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class InnerClasses_attribute extends attribute_info
{
	private short number_of_classes;
	private InnerClass_info classes[]; //number_of_classes
	public static InnerClasses_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) 
	{
		int offset = 0;
		InnerClasses_attribute res = new InnerClasses_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.number_of_classes = Util.byte2Short(info);offset+=2;
		res.classes = new InnerClass_info[res.number_of_classes];
		for(int i=0; i<res.number_of_classes;++i)
		{
			res.classes[i] = InnerClass_info.getInstance(info, offset);
			offset+=res.classes[i].getSize();
		}
		return res;
	}
}
