package com.sopiana.yang.javaDecompile.component;

import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Class_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Double_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Fieldref_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Float_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Integer_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_InterfaceMethodref_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_InvokeDynamic_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Long_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_MethodHandle_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_MethodType_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Methodref_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_NameAndType_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_String_info;
import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Utf8_info;

public abstract class cp_info {
	public static final byte CONSTANT_Class = 7;
	public static final byte CONSTANT_Fieldref = 9;
	public static final byte CONSTANT_Methodref = 10;
	public static final byte CONSTANT_InterfaceMethodref = 11;
	public static final byte CONSTANT_String = 8;
	public static final byte CONSTANT_Integer = 3;
	public static final byte CONSTANT_Float = 4;
	public static final byte CONSTANT_Long = 5;
	public static final byte CONSTANT_Double = 6;
	public static final byte CONSTANT_NameAndType = 12;
	public static final byte CONSTANT_Utf8 = 1;
	public static final byte CONSTANT_MethodHandle = 15;
	public static final byte CONSTANT_MethodType = 16;
	public static final byte CONSTANT_InvokeDynamic = 18;
	
	protected byte tag;
	
	public static cp_info getInstance(byte[]classFileData, int offset)
	{
		switch (classFileData[offset]) 
		{
			case CONSTANT_Class:
				return CONSTANT_Class_info.getInstance(classFileData, offset);
			case CONSTANT_Fieldref:
				return CONSTANT_Fieldref_info.getInstance(classFileData, offset);
			case CONSTANT_Methodref:
				return CONSTANT_Methodref_info.getInstance(classFileData, offset);
			case CONSTANT_InterfaceMethodref:
				return CONSTANT_InterfaceMethodref_info.getInstance(classFileData, offset);
			case CONSTANT_String:
				return CONSTANT_String_info.getInstance(classFileData, offset);
			case CONSTANT_Integer:
				return CONSTANT_Integer_info.getInstance(classFileData, offset);
			case CONSTANT_Float:
				return CONSTANT_Float_info.getInstance(classFileData, offset);
			case CONSTANT_Long:
				return CONSTANT_Long_info.getInstance(classFileData, offset);
			case CONSTANT_Double:
				return CONSTANT_Double_info.getInstance(classFileData, offset);
			case CONSTANT_NameAndType:
				return CONSTANT_NameAndType_info.getInstance(classFileData, offset);
			case CONSTANT_Utf8:
				return CONSTANT_Utf8_info.getInstance(classFileData, offset);
			case CONSTANT_MethodHandle:
				return CONSTANT_MethodHandle_info.getInstance(classFileData, offset);
			case CONSTANT_MethodType:
				return CONSTANT_MethodType_info.getInstance(classFileData, offset);
			case CONSTANT_InvokeDynamic:
				return CONSTANT_InvokeDynamic_info.getInstance(classFileData, offset);
			default:
				return null;
		}
	}
	public abstract int getSize();
	public String getType(){return this.getClass().getName();}
}
