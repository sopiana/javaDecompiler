package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>array_value_info</code> item in <code>element_value</code> structure
 * 
 * <p>The <code>array_value_info</code> is sub-element structure used in <code>element_value</code> item, if the <code>tag</code> item in
 * <code>element_value</code> is a '<code>[</code>' character. The <code>array_value</code> item denotes an array as the value of an element-value 
 * pair.</p>
 * <p>The <code>array_value_info</code> structure has the following format:</p>
 * <code>array_value_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_values;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;element_value values[num_values];<br>
 * }</code>
 * @author yang.sopiana
 * 
 */
public class array_value_info 
{
	/**
	 * <p>The value of the <code>num_values</code> item gives the number of elements in the array represented by this <code>element_value</code> structure.</p>
	 */
	private short num_values;
	/**
	 * <p>Each value in the <code>values</code> table gives the corresponding element of the array represented by an <code>element_value</code> structure.</p>
	 */
	private element_value values[];	//num_values
	/**
	 * Factory method to generate a <code>array_value_info</code> entry from given array of byte in specific offset.
	 * 
	 * <p>The <code>array_value_info</code> is sub-element structure used in <code>element_value</code> item, if the <code>tag</code> item in
	 * <code>element_value</code> is a '<code>[</code>' character. The <code>array_value</code> item denotes an array as the value of an element-value 
	 * pair.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>array_value_info</code>
	 * @throws decompilerException if supplied <code>classFileData</code> is not a Valid <code>array_value_info</code>
	 */
	public static array_value_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		array_value_info res = new array_value_info();
		res.num_values = Util.byte2Short(classFileData,offset); offset+=2;
		res.values = new element_value[res.num_values];
		
		for(int i=0;i<res.num_values;++i)
		{
			res.values[i] = element_value.getInstance(classFileData, offset);
			offset+=res.values[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>array_value_info</code> entry components</p>
	 * @return size of <code>array_value_info</code> entry
	 */
	public int getSize() 
	{ 
		int res = 2;
		for(int i=0;i<num_values;++i)
		{
			res+=values[i].getSize();
		}
		return res;
	}
	 /**
     * Accessor method to <code>num_values</code> field
     * 
	 * <p>The value of the <code>num_values</code> item gives the number of elements in the array represented by this <code>element_value</code> structure.</p>
	 * @return value of <code>num_values</code> field
	 */
	public short getNum_values() { return num_values; }
	 /**
     * Accessor method to <code>values</code> field
     * 
	 * <p>Each value in the <code>values</code> table gives the corresponding element of the array represented by an <code>element_value</code> structure.</p>
	 * @return value of <code>values</code> field
	 */
	public element_value[] getValues() { return values; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" num_values: "+num_values+"\n";
		for(int i=0;i<num_values;++i)
		{
			res+=indentStr+"values["+i+"]:\n";
			res+=values[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
