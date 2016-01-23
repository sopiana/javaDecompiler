package com.sopiana.yang.javaDecompile.component.sub;

import com.sopiana.yang.javaDecompile.component.decompilerException;
import com.sopiana.yang.javaDecompile.util.Util;

public class element_value 
{
	private byte tag;
	//==>begin of union
	private short const_value_index;
	private enum_const_value_info enum_const_value;
	private short class_info_index;
	private annotation_info annotation_value;
	private array_value_info array_value;
	//==>end of union
	public static element_value getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		element_value res = new element_value();
		res.tag = classFileData[offset++];
		switch((char)(res.tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				res.const_value_index = Util.byte2Short(classFileData,offset);
				break;
			case 'e':
				res.enum_const_value = enum_const_value_info.getInstance(classFileData, offset);
				break;
			case 'c':
				res.class_info_index = Util.byte2Short(classFileData,offset);
				break;
			case '@':
				res.annotation_value = annotation_info.getInstance(classFileData, offset);
				break;
			case '[':
				res.array_value = array_value_info.getInstance(classFileData, offset);
				break;
			default:
				throw new decompilerException("unsupported tag on element_value entry");
		}
		return res;
	}
	
	public int getSize() 
	{
		int res=1;
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
			case 'c':
				res+=2;
				break;
			case 'e':
				res+=enum_const_value.getSize();
				break;
			case '@':
				res+=annotation_value.getSize();
				break;
			case '[':
			default:
				res+=array_value.getSize();
				break;
		}
		return res;
	}
	public byte getTag() { return tag; }
	public short getConst_value_index() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				return const_value_index;
			case 'e':
				throw new decompilerException("Not a const_value_index type, use getEnum_const_value() instead");
			case 'c':
				throw new decompilerException("Not a const_value_index type, use getClass_info_index() instead");
			case '@':
				throw new decompilerException("Not a const_value_index type, use getAnnotation_value() instead");
			case '[':
			default:
				throw new decompilerException("Not a const_value_index type, use getArray_value() instead");
		}
	}
	
	public enum_const_value_info getEnum_const_value() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a enum_const_value type, use getConst_value_index() instead");
			case 'e':
				return enum_const_value;
			case 'c':
				throw new decompilerException("Not a enum_const_value type, use getClass_info_index() instead");
			case '@':
				throw new decompilerException("Not a enum_const_value type, use getAnnotation_value() instead");
			case '[':
			default:
				throw new decompilerException("Not a enum_const_value type, use getArray_value() instead");
		}
	}
	public short getClass_info_index() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a class_info_index type, use getConst_value_index() instead");
			case 'e':
				throw new decompilerException("Not a class_info_index type, use getClass_info_index() instead");
			case 'c':
				return class_info_index;
			case '@':
				throw new decompilerException("Not a class_info_index type, use getAnnotation_value() instead");
			case '[':
			default:
				throw new decompilerException("Not a class_info_index type, use getArray_value() instead");
		}
	}
	public annotation_info getAnnotation_value() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a annotation type, use getConst_value_index() instead");
			case 'e':
				throw new decompilerException("Not a annotation type, use getClass_info_index() instead");
			case 'c':
				throw new decompilerException("Not a annotation type, use getEnum_const_value() instead");
			case '@':
				return annotation_value;
			case '[':
			default:
				throw new decompilerException("Not a annotation type, use getArray_value() instead");
		}
	}
	public array_value_info getArray_value() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a array_value type, use getConst_value_index() instead");
			case 'e':
				throw new decompilerException("Not a array_value type, use getClass_info_index() instead");
			case 'c':
				throw new decompilerException("Not a array_value type, use getEnum_const_value() instead");
			case '[':
				return array_value;
			case '@':
			default:
				throw new decompilerException("Not a array_value type, use getAnnotation_value() instead");
		}
	}
}
