package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Double_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Float_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Integer_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Long_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Null_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Object_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Top_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.UninitializedThis_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Uninitialized_variable_info;
/**
 * A verification type specifies the type of either one or two locations, where a location
is either a single local variable or a single operand stack entry. A verification type
is represented by a discriminated union, verification_type_info, that consists
of a one-byte tag, indicating which item of the union is in use, followed by zero or
more bytes, giving more information about the tag.
union verification_type_info {
 Top_variable_info;
 Integer_variable_info;
 Float_variable_info;
 Long_variable_info;
 Double_variable_info;
 Null_variable_info;
 UninitializedThis_variable_info;
 Object_variable_info;
 Uninitialized_variable_info;
}
 * @author yang
 *
 */
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
