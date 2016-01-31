package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.InnerClass_info;
import com.sopiana.yang.javaDecompiler.util.Util;

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
	public short getNumber_of_classes() { return number_of_classes; }
	public InnerClass_info[] getClasses() { return classes; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
