package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.util.Util;

public class InnerClass_info 
{
	private short inner_class_info_index;
	private short outer_class_info_index;
	private short inner_name_index;
	private short inner_class_access_flags;
	public static InnerClass_info getInstance(byte[]classFileData, int offset)
	{
		InnerClass_info res = new InnerClass_info();
		res.inner_class_info_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.outer_class_info_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.inner_name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.inner_class_access_flags = Util.byte2Short(classFileData,offset);offset+=2;
		return res;
	}
	public int getSize() { return 8; }
	public short getInner_class_info_index() { return inner_class_info_index; }  
	public short getOuter_class_info_index() { return outer_class_info_index; }
	public int getInner_name_index() { return inner_name_index&0xFFFF; }
	public short getInner_class_access_flags() { return inner_class_access_flags; }
}
