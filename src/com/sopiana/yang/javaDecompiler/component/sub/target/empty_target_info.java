package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;

public class empty_target_info extends target_info{
	public static empty_target_info getInstance(byte[]classFileData, int offset)
	{
		return new empty_target_info();
	}
	public int getSize() { return 0; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
