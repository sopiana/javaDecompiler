package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.cp_info;

/**
 * 
 * @author yang.sopiana
 *
 */
public class type_path_info 
{
	/**
	 * The value of the path_length item gives the number of entries in the path array:
• If the value ofpath_length is 0, then the annotation appears directly on the type
itself.
• If the value of path_length is non-zero, then each entry in the path array
represents an iterative, left-to-right step towards the precise location of the
annotation in an array type, nested type, or parameterized type. (In an array
type, the iteration visits the array type itself, then its component type, then the
component type of that component type, and so on, until the element type is
reached.) Each entry contains the following two items:
	 */
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
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		//TODO change to abstract method
		return null;
	}
}
