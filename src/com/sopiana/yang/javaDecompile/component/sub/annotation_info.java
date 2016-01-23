package com.sopiana.yang.javaDecompile.component.sub;

import com.sopiana.yang.javaDecompile.component.decompilerException;
import com.sopiana.yang.javaDecompile.util.Util;

public class annotation_info {
	private short type_index;
	private short num_element_value_pairs;
	private element_value_pairs_info element_value_pairs[];	//num_element_value_pairs
	public static annotation_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		annotation_info res = new annotation_info();
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
		int res = 4;
		for(int i=0;i<num_element_value_pairs;++i)
		{
			res+=element_value_pairs[i].getSize();
		}
		return res; 
	}
	
	public short getType_index() { return type_index; }
	public short getNum_element_value_pairs() { return num_element_value_pairs; }
}
