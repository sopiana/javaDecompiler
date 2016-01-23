package com.sopiana.yang.javaDecompiler.component.sub.target_info;

public class type_parameter_bound_target_info extends target_info
{
	private byte type_parameter_index;
	private byte bound_index;
	public static type_parameter_bound_target_info getInstance(byte[]classFileData, int offset)
	{
		type_parameter_bound_target_info res = new type_parameter_bound_target_info();
		res.type_parameter_index = classFileData[offset++];
		res.bound_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 2; }
	public byte getType_parameter_index() { return type_parameter_index; }
	public byte getBound_index() { return bound_index; }
}
