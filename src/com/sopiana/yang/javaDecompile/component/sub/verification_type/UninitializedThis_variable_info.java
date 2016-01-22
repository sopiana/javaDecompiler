package com.sopiana.yang.javaDecompile.component.sub.verification_type;

import com.sopiana.yang.javaDecompile.component.decompilerException;

public class UninitializedThis_variable_info extends verification_type_info
{
	public static final UninitializedThis_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_UninitializedThis)
		{
			UninitializedThis_variable_info res = new UninitializedThis_variable_info();
			res.tag = ITEM_UninitializedThis;
			return res;
		}
		throw new decompilerException("Arguments passed is not type of UninitializedThis_variable_info");
	}

	public int getSize() { return 1; }
}
