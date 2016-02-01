package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;

public class element_value_pairs_info 
{
	/**
	 * The value of the element_name_index item must be a valid index into
the constant_pool table. The constant_pool entry at that index must
be a CONSTANT_Utf8_info structure (§4.4.7). The constant_pool
entry denotes the name of the element of the element-value pair
represented by this element_value_pairs entry.
In other words, the entry denotes an element of the annotation type specified by
type_index.
	 */
	private short element_name_index;
	/**
	 * The value of the value item represents the value of the element-value
pair represented by this element_value_pairs entry.
	 */
	private element_value value;
	
	public static element_value_pairs_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		element_value_pairs_info res = new element_value_pairs_info();
		res.element_name_index = Util.byte2Short(classFileData,offset); offset+=2;
		res.value = element_value.getInstance(classFileData, offset);
		return res;
	}
	
	public int getSize() { return 2+value.getSize(); }
	public short getElement_name_index() { return element_name_index; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		//TODO finish this method
		return null;
	}
}
