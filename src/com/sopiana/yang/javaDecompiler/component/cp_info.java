package com.sopiana.yang.javaDecompiler.component;

import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Class_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Double_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Fieldref_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Float_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Integer_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_InterfaceMethodref_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_InvokeDynamic_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Long_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_MethodHandle_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_MethodType_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Methodref_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_NameAndType_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_String_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Utf8_info;

public abstract class cp_info extends class_info{
	
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
		cp_info res=null;
		switch (classFileData[offset]) 
		{
			case CONSTANT_Class:
				res = CONSTANT_Class_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_Fieldref:
				res = CONSTANT_Fieldref_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_Methodref:
				res = CONSTANT_Methodref_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_InterfaceMethodref:
				res = CONSTANT_InterfaceMethodref_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_String:
				res = CONSTANT_String_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_Integer:
				res = CONSTANT_Integer_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_Float:
				res = CONSTANT_Float_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_Long:
				res = CONSTANT_Long_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_Double:
				res = CONSTANT_Double_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_NameAndType:
				res = CONSTANT_NameAndType_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_Utf8:
				res = CONSTANT_Utf8_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_MethodHandle:
				res = CONSTANT_MethodHandle_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_MethodType:
				res = CONSTANT_MethodType_info.getInstance(classFileData, offset);
				break;
			case CONSTANT_InvokeDynamic:
				res = CONSTANT_InvokeDynamic_info.getInstance(classFileData, offset);
				break;
			default:
				return res;
		}
		res.offset = offset;
		return res;
	}
	public abstract int getSize();
	public String getType(){return this.getClass().getName();}
}
