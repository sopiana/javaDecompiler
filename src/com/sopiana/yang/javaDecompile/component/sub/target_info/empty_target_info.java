package com.sopiana.yang.javaDecompile.component.sub.target_info;

public class empty_target_info extends target_info{
	public static empty_target_info getInstance(byte[]classFileData, int offset)
	{
		return new empty_target_info();
	}
	public int getSize() { return 0; }
}
