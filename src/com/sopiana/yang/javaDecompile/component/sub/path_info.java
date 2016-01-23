package com.sopiana.yang.javaDecompile.component.sub;

public class path_info {
	private byte type_path_kind;
	private byte type_argument_index;
	public static path_info getInstance(byte[]classFileData, int offset)
	{
		path_info res = new path_info();
		res.type_path_kind = classFileData[offset++];
		res.type_argument_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 2; }
	public byte getType_path_kind() { return type_path_kind; }
	public byte getType_argument_index() { return type_argument_index; }
}
