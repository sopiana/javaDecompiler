package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class CONSTANT_MethodHandle_info extends cp_info{
	private byte reference_kind;
	private short reference_index;
	
	public static CONSTANT_MethodHandle_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_MethodHandle_info res = new CONSTANT_MethodHandle_info();
		res.tag = classFileData[offset++];
		res.reference_kind = classFileData[offset++];
		res.reference_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	public int getSize() { return 4; }
	public byte getReference_kind() { return reference_kind; }
	public short getReference_index() { return reference_index; }
}