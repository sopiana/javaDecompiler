package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.target_info.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class type_annotation_info 
{
	private byte target_type;
	private target_info target;
	private type_path_info target_path;
	private short type_index;
	private short num_element_value_pairs;
	private element_value_pairs_info element_value_pairs[];	//num_element_value_pairs
	
	public static type_annotation_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		type_annotation_info res = new type_annotation_info();
		res.target_type = classFileData[offset++];
		res.target = target_info.getInstance(res.target_type,classFileData, offset);
		offset+=res.target.getSize();
		res.target_path = type_path_info.getInstance(classFileData, offset);
		offset += res.target_path.getSize();
		res.type_index = Util.byte2Short(classFileData,offset); offset+=2;
		res.num_element_value_pairs = Util.byte2Short(classFileData,offset); offset+=2;
		res.element_value_pairs = new element_value_pairs_info[res.num_element_value_pairs];
		for(int i=0;i<res.num_element_value_pairs;++i)
		{
			res.element_value_pairs[i] = element_value_pairs_info.getInstance(classFileData, offset);
			offset+=res.element_value_pairs[i].getSize();
		}
		return res;
	}
	
	public int getSize()
	{
		int res = 5;
		res+=target.getSize();
		res+=target_path.getSize();
		for(int i=0;i<num_element_value_pairs;++i)
		{
			res+=element_value_pairs[i].getSize();
		}
		return res;
	}
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		//TODO finish this method
		return null;
	}
}
