package com.sopiana.yang.javaDecompiler.component.sub.verification_type;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class Uninitialized_variable_info extends verification_type_info
{
	private short offset;
	public static final Uninitialized_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_Uninitialized)
		{
			Uninitialized_variable_info res = new Uninitialized_variable_info();
			res.tag = ITEM_Uninitialized;
			res.offset = Util.byte2Short(classFileData,offset+1);
			return res;
		}
		throw new decompilerException("Arguments passed is not type of Uninitialized_variable_info");
	}

	public int getSize() { return 3; }
	public short getOffset() { return offset; }
}
