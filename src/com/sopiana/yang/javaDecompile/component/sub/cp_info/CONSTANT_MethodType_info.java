package com.sopiana.yang.javaDecompile.component.sub.cp_info;

import com.sopiana.yang.javaDecompile.component.cp_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class CONSTANT_MethodType_info extends cp_info{
	private short descriptor_index;
	
	public static CONSTANT_MethodType_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_MethodType_info res = new CONSTANT_MethodType_info();
		res.tag = classFileData[offset++];
		res.descriptor_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	public int getSize() { return 3; }
	public short getDescriptor_index() { return descriptor_index; }
}
