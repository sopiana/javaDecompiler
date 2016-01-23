package com.sopiana.yang.javaDecompile.component.sub;

public class type_path_info 
{
	private byte path_length;
	private path_info path[];	//path_length
	public static type_path_info getInstance(byte[]classFileData, int offset)
	{
		type_path_info res = new type_path_info();
		res.path_length = classFileData[offset++];
		res.path = new path_info[res.path_length&0xFF];
		for(int i=0; i<res.path.length;++i)
		{
			res.path[i] = path_info.getInstance(classFileData,offset);
			offset = res.path[i].getSize();
		}
		return res;
	}
	
	public int getSize() 
	{
		int res = 1;
		for(int i=0;i<path.length;++i)
		{
			res+=path[i].getSize();
		}
		return res;
	}
}
