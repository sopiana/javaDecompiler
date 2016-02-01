package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>element_value_pairs_info</code> item
 * 
 * <p>The <code>element_value_pairs_info</code> is a variable-length sub-element structure used in <code>annotation</code> item.
 * Each value of the <code>element_value_pairs</code> table represents a single element value pair in the <code>annotation</code> 
 * represented by annotation structure. </p>
 * <p>The <code>element_value_pairs_info</code> structure has the following format:</p>
 * <code>element_value_pairs_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 element_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;element_value value;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class element_value_pairs_info 
{
	/**
	 * <p>The value of the <code>element_name_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure. The <code>constant_pool</code> 
	 * entry denotes the name of the element of the element-value pair represented by this <code>element_value_pairs</code> entry.</p>
	 * <p><small>In other words, the entry denotes an element of the annotation type specified by <code>type_index</code>.</small></p>
	 */
	private short element_name_index;
	/**
	 * <p>The value of the <code>value</code> item represents the value of the element-value pair represented by this <code>element_value_pairs</code> entry.</p>
	 */
	private element_value value;
	/**
	 * Factory method to generate a <code>element_value_pairs_info</code> instance.
	 * 
	 * <p>The <code>element_value_pairs_info</code> is a variable-length sub-element structure used in <code>annotation</code> item.
	 * Each value of the <code>element_value_pairs</code> table represents a single element value pair in the <code>annotation</code> 
	 * represented by annotation structure. </p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>element_value_pairs_info</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>element_value_pairs_info</code> format
	 */
	public static element_value_pairs_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		element_value_pairs_info res = new element_value_pairs_info();
		res.element_name_index = Util.byte2Short(classFileData,offset); offset+=2;
		res.value = element_value.getInstance(classFileData, offset);
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>element_value_pairs_info</code> entry components</p>
	 * @return size of <code>element_value_pairs_info</code> entry
	 */
	public int getSize() { return 2+value.getSize(); }
	/**
	 * Accessor method to <code>element_name_index</code> field
	 * 
	 * <p>The value of the <code>element_name_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure. The <code>constant_pool</code> 
	 * entry denotes the name of the element of the element-value pair represented by this <code>element_value_pairs</code> entry.</p>
	 * <p><small>In other words, the entry denotes an element of the annotation type specified by <code>type_index</code>.</small></p>
	 * @return value of <code>element_name_index</code> field
	 */
	public short getElement_name_index() { return element_name_index; }
	/**
	 * Accessor method to <code>value</code> field
	 * 
	 * <p>The value of the <code>value</code> item represents the value of the element-value pair represented by this <code>element_value_pairs</code> entry.</p>
	 * @return value of <code>value</code> field
	 */
	public element_value getValue() { return value; }
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		try
		{
			res+=indentStr+" element_name: "+cp_info.getName(element_name_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" element_name_index: @"+ element_name_index+"\n";
		}
		res+=indentStr+" value: \n";
		res+=value.toString(indent+1, constant_pool);
		return res;
	}
}
