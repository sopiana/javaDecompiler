package com.sopiana.yang.javaDecompiler.component.sub.verification_type;

import com.sopiana.yang.javaDecompiler.component.decompilerException;

public class Long_variable_info extends verification_type_info
{
	public static final Long_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_Long)
		{
			Long_variable_info res = new Long_variable_info();
			res.tag = ITEM_Long;
			return res;
		}
		throw new decompilerException("Arguments passed is not type of Long_variable_info");
	}

	public int getSize() { return 1; }
}
