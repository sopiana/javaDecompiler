package com.sopiana.yang.javaDecompile.subComponent;

import com.sopiana.yang.javaDecompile.component.cp_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class CONSTANT_Long_info extends cp_info{
	private long value;
	
	public static CONSTANT_Long_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Long_info res = new CONSTANT_Long_info();
		res.tag = classFileData[offset++];
		res.value = Util.byte2Int(classFileData,offset)<<32; offset+=4;
		res.value |= Util.byte2Int(classFileData,offset);
		return res;
    }
	public int getSize() { return 9; }
}
