package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class enum_const_value_info 
{
	/**
	 * The value of the type_name_index item must be a valid index into the
constant_pool table. The constant_pool entry at that index must be
a CONSTANT_Utf8_info structure (§4.4.7) representing a field descriptor
(§4.3.2). The constant_pool entry gives the internal form of the binary
name of the type of the enum constant represented by this element_value
structure (§4.2.1).
	 */
	private short type_name_index;
	/**
	 * The value of the const_name_index item must be a valid index into the
constant_pool table. The constant_pool entry at that index must be a
CONSTANT_Utf8_info structure (§4.4.7). The constant_pool entry gives
the simple name of the enum constant represented by this element_value
structure.
	 */
	private short const_name_index;
	public static enum_const_value_info getInstance(byte[]classFileData, int offset)
	{
		enum_const_value_info res = new enum_const_value_info();
		res.type_name_index = Util.byte2Short(classFileData,offset); offset+=2;
		res.const_name_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	
	public int getSize() { return 4; }
	public short getType_name_index() { return type_name_index; }
	public short getConst_name_index(){ return const_name_index; }
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		//TODO finish this method
		return null;
	}
}
