package com.sopiana.yang.javaDecompiler.component.sub.verification_type;

import com.sopiana.yang.javaDecompiler.component.decompilerException;

public class Null_variable_info extends verification_type_info
{
	public static final Null_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_Null)
		{
			Null_variable_info res = new Null_variable_info();
			res.tag = ITEM_Null;
			return res;
		}
		throw new decompilerException("Arguments passed is not type of Null_variable_info");
	}

	public int getSize() { return 1; }
}
