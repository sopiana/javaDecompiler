package com.sopiana.yang.javaDecompile.component.sub.cp_info;

import com.sopiana.yang.javaDecompile.component.cp_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class CONSTANT_Double_info extends cp_info{
	
	private double value;
	
	public static CONSTANT_Double_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Double_info res = new CONSTANT_Double_info();
		res.tag = classFileData[offset++];
		long temp = Util.byte2Int(classFileData,offset)<<32; offset+=4;
		temp |= Util.byte2Int(classFileData,offset);
		res.value = Double.longBitsToDouble(temp);
		return res;
    }
	public int getSize() { return 9; }
	public double getValue() { return value; }
}
