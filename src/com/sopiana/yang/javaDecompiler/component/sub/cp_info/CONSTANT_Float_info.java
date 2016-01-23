package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class CONSTANT_Float_info extends cp_info{
	private float value;
	
	public static CONSTANT_Float_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Float_info res = new CONSTANT_Float_info();
		res.tag = classFileData[offset++];
		res.value = Float.intBitsToFloat(Util.byte2Int(classFileData, offset));
		return res;
    }
	public int getSize() { return 5; }
	public float getValue() { return value; }
}
