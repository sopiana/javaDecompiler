package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class CONSTANT_Integer_info extends cp_info{
	private int value;
	
	public static CONSTANT_Integer_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Integer_info res = new CONSTANT_Integer_info();
		res.tag = classFileData[offset++];
		res.value = Util.byte2Int(classFileData,offset);
		return res;
    }
	public int getSize() { return 5; }
	public int getValue() { return value; }
}
