package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;

public class element_value_pairs_info {
	private short element_name_index;
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
}
