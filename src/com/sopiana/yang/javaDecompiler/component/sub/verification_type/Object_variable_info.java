package com.sopiana.yang.javaDecompiler.component.sub.verification_type;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class Object_variable_info extends verification_type_info
{
	private short cpool_index;
	public static final Object_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_Object)
		{
			Object_variable_info res = new Object_variable_info();
			res.tag = ITEM_Object;
			res.cpool_index = Util.byte2Short(classFileData,offset+1);
			return res;
		}
		throw new decompilerException("Arguments passed is not type of Object_variable_info");
	}

	public int getSize() { return 3; }
	public short getCpool_index() { return cpool_index; }
}
