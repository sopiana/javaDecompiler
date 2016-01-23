package com.sopiana.yang.javaDecompiler.component.sub.verification_type;

import com.sopiana.yang.javaDecompiler.component.decompilerException;

public abstract class verification_type_info 
{
	public static final byte ITEM_Top = 0;
	public static final byte ITEM_Integer = 1;
	public static final byte ITEM_Float = 2;
	public static final byte ITEM_Double = 3;
	public static final byte ITEM_Long = 4;
	public static final byte ITEM_Null = 5;
	public static final byte ITEM_UninitializedThis = 6;
	public static final byte ITEM_Object = 7;
	public static final byte ITEM_Uninitialized = 8;
	protected byte tag;
	
	public static verification_type_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		switch(classFileData[offset])
		{
			case ITEM_Top:
				return Top_variable_info.getInstance(classFileData,offset);
			case ITEM_Integer:
				return Integer_variable_info.getInstance(classFileData, offset);
			case ITEM_Double:
				return Double_variable_info.getInstance(classFileData, offset);
			case ITEM_Float:
				return Float_variable_info.getInstance(classFileData, offset);
			case ITEM_Long:
				return Long_variable_info.getInstance(classFileData, offset);
			case ITEM_Null:
				return Null_variable_info.getInstance(classFileData, offset);
			case ITEM_UninitializedThis:
				return UninitializedThis_variable_info.getInstance(classFileData, offset);
			case ITEM_Object:
				return Object_variable_info.getInstance(classFileData, offset);
			case ITEM_Uninitialized:
				return Uninitialized_variable_info.getInstance(classFileData, offset);
			default:
				throw new decompilerException("Arguments passed is not type of verification_type_info");
		}
	}
	
	public abstract int getSize();
}
