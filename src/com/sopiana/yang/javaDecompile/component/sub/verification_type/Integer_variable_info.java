package com.sopiana.yang.javaDecompile.component.sub.verification_type;

import com.sopiana.yang.javaDecompile.component.decompilerException;

public class Integer_variable_info extends verification_type_info
{
	public static final Integer_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_Integer)
		{
			Integer_variable_info res = new Integer_variable_info();
			res.tag = ITEM_Integer;
			return res;
		}
		throw new decompilerException("Arguments passed is not type of Integer_variable_info");
	}

	public int getSize() { return 1; }
}
