package com.sopiana.yang.javaDecompile.component.sub.cp_info;

import com.sopiana.yang.javaDecompile.component.cp_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class CONSTANT_NameAndType_info extends cp_info{
	private short name_index;
	private short descriptor_index;
	
	public static CONSTANT_NameAndType_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_NameAndType_info res = new CONSTANT_NameAndType_info();
		res.tag = classFileData[offset++];
		res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.descriptor_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	public int getSize() { return 5; }
	public short getName_index() { return name_index; }
	public short getDescriptor_index() { return descriptor_index; }
}
