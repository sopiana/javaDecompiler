package com.sopiana.yang.javaDecompiler.component.sub.verification_type;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type_info;

public class Double_variable_info extends verification_type_info
{
	public static final Double_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_Double)
		{
			Double_variable_info res = new Double_variable_info();
			res.tag = ITEM_Double;
			return res;
		}
		throw new decompilerException("Arguments passed is not type of Double_variable_info");
	}

	public int getSize() { return 1; }
}
