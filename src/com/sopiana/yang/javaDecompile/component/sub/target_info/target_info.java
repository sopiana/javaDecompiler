package com.sopiana.yang.javaDecompile.component.sub.target_info;

import com.sopiana.yang.javaDecompile.component.decompilerException;

public abstract class target_info 
{
	public static target_info getInstance(byte targetType, byte[]classFileData, int offset) throws decompilerException
	{
		switch(targetType)
		{
			case 0x00:
			case 0x01:
				return type_parameter_target_info.getInstance(classFileData,offset);
			case 0x10:
				return supertype_target_info.getInstance(classFileData,offset);
			case 0x11:
			case 0x12:
				return type_parameter_bound_target_info.getInstance(classFileData,offset);
			case 0x13:
			case 0x14:
			case 0x15:
				return empty_target_info.getInstance(classFileData,offset);
			case 0x16:
				return formal_parameter_target_info.getInstance(classFileData,offset);
			case 0x17:
				return throws_target_info.getInstance(classFileData,offset);
			case 0x40:
			case 0x41:
				return localvar_target_info.getInstance(classFileData,offset);
			case 0x42:
				return catch_target_info.getInstance(classFileData,offset);
			case 0x43:
			case 0x44:
			case 0x45:
			case 0x46:
				return offset_target_info.getInstance(classFileData,offset);
			case 0x47:
			case 0x48:
			case 0x49:
			case 0x4A:
			case 0x4B:
				return type_argument_target_info.getInstance(classFileData,offset);
			default:
				throw new decompilerException("target_type is not a valid target_info item");
		}
	}
	
	public abstract int getSize();
}
