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
/**
 * Provides abstraction for <code>constant_pool</code> item
 * 
 * <p>Java Virtual Machine instructions do not rely on the run-time layout of classes, interfaces, class instances, or 
 * arrays. Instead, instructions refer to symbolic information in the <code>constant_pool</code> table.</p>
 * <p>All <code>constant_pool</code> table entries have the following general format:</p>
 * <code>cp_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 info[];<br>
 * } </code>
 * @author yang.sopiana
 *
 */
public abstract class cp_info extends class_info{
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Class</code> type
	 */
	public static final byte CONSTANT_Class = 7;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Fieldref</code> type
	 */
	public static final byte CONSTANT_Fieldref = 9;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Methodref</code> type
	 */
	public static final byte CONSTANT_Methodref = 10;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_InterfaceMethodref</code> type
	 */
	public static final byte CONSTANT_InterfaceMethodref = 11;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_String</code> type
	 */
	public static final byte CONSTANT_String = 8;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Integer</code> type
	 */
	public static final byte CONSTANT_Integer = 3;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Float</code> type
	 */
	public static final byte CONSTANT_Float = 4;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Long</code> type
	 */
	public static final byte CONSTANT_Long = 5;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Double</code> type
	 */
	public static final byte CONSTANT_Double = 6;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_NameAndType</code> type
	 */
	public static final byte CONSTANT_NameAndType = 12;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_Utf8</code> type
	 */
	public static final byte CONSTANT_Utf8 = 1;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_MethodHandle</code> type
	 */
	public static final byte CONSTANT_MethodHandle = 15;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_MethodType</code> type
	 */
	public static final byte CONSTANT_MethodType = 16;
	/**
	 * Tag value showing that a <code>constant_pool</code> entry is a <code>CONSTANT_InvokeDynamic</code> type
	 */
	public static final byte CONSTANT_InvokeDynamic = 18;
	
	/**
	 * <code>cp_info</code> component showing the type of <code>constant_pool</code> entry type
	 */
	protected byte tag;
	
	/**
	 * Return name of a component get from <code>constant_pool</code> table of a class
	 * 
	 * <p>The method supplied by <code>constant_pool</code> entry index, and <code>constant_pool</code> table,
	 * the <code>constant_pool</code> entry ant that index should be <code>CONSTANT_Utf8_info</code> type. Unless
	 * the method will throw <code>decompilerException</code></p>
	 * @param index <code>constant_pool</code> entry index 
	 * @param constant_pool <code>constant_pool</code> table
	 * @return String value from <code>constant_pool</code> entry at specified index
	 * @throws decompilerException if the <code>constant_pool</code> entry at specified index is not <code>CONSTANT_Utf8_info</code> type
	 */
	public static String getName(int index,cp_info[]constant_pool) throws decompilerException
	{
		if(constant_pool[index] instanceof CONSTANT_Utf8_info)
		{
			return ((CONSTANT_Utf8_info)constant_pool[index]).getString();
		}
		throw new decompilerException("constant_pool entry in specified argument is not CONSTANT_Utf8_info");
	}
	
	/**
	 * Factory method to generate a <code>constant_pool</code> entry from given array of byte in specific offset.
	 * 
	 * <p>Each item in the <code>constant_pool</code> entry must begin with a 1-byte <code>tag</code> indicating the
	 * kind of cp_info entry. The contents of the info array vary with the value of tag. 
	 * The valid tags and their values are listed in the <code>CONSTANT_xx</code> range. Each tag byte must be followed 
	 * by two or more bytes giving information about the specific constant. The format of the additional information 
	 * varies with the tag value.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return <code>cp_info</code> instance according to each tag
	 */
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
	/**
	 * Accessor method to <code>tag</code> field
	 * 
	 * <p>The <code>tag</code> field showing the type of <code>constant_pool</code> entry type</p>
	 * @return tag of <code>constant_pool</code> entry
	 */
	public byte getTag() { return tag; }
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Showing <code>constant_pool</code> entry in 8-bit cells byte including size of <code>tag</code> and <code>info[]</code>
	 * components</p>
	 * @return size of <code>constant_pool</code> entry
	 */
	public abstract int getSize();
}
