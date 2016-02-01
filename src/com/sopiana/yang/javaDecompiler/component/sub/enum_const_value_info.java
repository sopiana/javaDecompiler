package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 *  Provides abstraction for <code>enum_const_value_info</code> item
 * 
 * <p>The <code>enum_const_value_info</code> is a fixed-length sub-element structure used in <code>element_value </code> item.
 * The <code>enum_const_value</code> item denotes an <code>enum</code> constant as the value of this element-value pair.</p>
 * <p>The <code>enum_const_value_info</code> structure has the following format:</p>
 * <code>enum_const_value_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 type_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 const_name_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class enum_const_value_info 
{
	/**
	 * <p>The value of the <code>type_name_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a field descriptor. 
	 * The <code>constant_pool</code> entry gives the internal form of the binary name of the type of the <code>enum</code> constant 
	 * represented by this <code>element_value</code> structure.</p>
	 */
	private short type_name_index;
	/**
	 * <p>The value of the <code>const_name_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure. The <code>constant_pool</code> entry 
	 * gives the simple name of the <code>enum</code> constant represented by this <code>element_value</code> structure.</p>
	 */
	private short const_name_index;
	/**
	 * Factory method to generate a <code>enum_const_value_info</code> instance.
	 * 
	 * <p>The <code>enum_const_value_info</code> is a fixed-length sub-element structure used in <code>element_value </code> item.
	 * The <code>enum_const_value</code> item denotes an <code>enum</code> constant as the value of this element-value pair.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>enum_const_value_info</code>
	 */
	public static enum_const_value_info getInstance(byte[]classFileData, int offset)
	{
		enum_const_value_info res = new enum_const_value_info();
		res.type_name_index = Util.byte2Short(classFileData,offset); offset+=2;
		res.const_name_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>enum_const_value_info</code> entry components</p>
	 * @return size of <code>enum_const_value_info</code> entry
	 */
	public int getSize() { return 4; }
	/**
	 * Accessor method to <code>type_name_index</code> field
	 * 
	 * <p>The value of the <code>type_name_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a field descriptor. 
	 * The <code>constant_pool</code> entry gives the internal form of the binary name of the type of the <code>enum</code> constant 
	 * represented by this <code>element_value</code> structure.</p>
	 * @return value of <code>type_name_index</code> field
	 */
	public short getType_name_index() { return type_name_index; }
	/**
	 * Accessor method to <code>const_name_index</code> field
	 * 
	 * <p>The value of the <code>const_name_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure. The <code>constant_pool</code> entry 
	 * gives the simple name of the <code>enum</code> constant represented by this <code>element_value</code> structure.</p>
	 * @return value of <code>const_name_index</code> field
	 */
	public short getConst_name_index(){ return const_name_index; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		try
		{
			res+=indentStr+" type_name: "+cp_info.getName(type_name_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" type_name_index: @"+ type_name_index+"\n";
		}
		try
		{
			res+=indentStr+" const_name: "+cp_info.getName(const_name_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" const_name_index: @"+ const_name_index+"\n";
		}
		return res;
	}
}
