package com.sopiana.yang.javaDecompile.component.sub.target_info;

public class formal_parameter_target_info extends target_info
{
	private byte formal_parameter_index;
	public static formal_parameter_target_info getInstance(byte[]classFileData, int offset)
	{
		formal_parameter_target_info res = new formal_parameter_target_info();
		res.formal_parameter_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 1; }
	public byte getFormal_parameter_index() { return formal_parameter_index; }
}
