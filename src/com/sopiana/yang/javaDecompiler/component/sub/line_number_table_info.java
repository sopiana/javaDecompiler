package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>line_number_table_info</code> item
 * 
 * <p>The <code>line_number_table_info</code> is a fixed-length sub-element structure used in <code>LineNumberTable_attribute</code> item. Each entry in the line_number_table array indicates that the line number
 * in the original source file changes at a given point in the code array.</p>
 * <p>The <code>line_number_table_info</code> structure has the following format:</p>
 * <code>exception_table_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 start_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 line_number;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class line_number_table_info 
{
	/**
	 * <p>The value of the <code>start_pc</code> item must indicate the index into the <code>code</code> array at which the code for a new line in 
	 * the original source file begins. The value of <code>start_pc</code> must be less than the value of the <code>code_length</code> item of the 
	 * <code>Code_attribute</code> of which this <code>LineNumberTable</code> is an attribute.
	 */
	private short start_pc;
	/**
	 * <p>The value of the <code>line_number</code> item must give the corresponding line number in the original source file.</p>
	 */
	private short line_number;
	/**
	 * Factory method to generate a <code>line_number_table_info</code> instance.
	 * 
	 * <p>The <code>line_number_table_info</code> is a fixed-length sub-element structure used in <code>LineNumberTable_attribute</code> item. Each entry in the line_number_table array indicates that the line number
	 * in the original source file changes at a given point in the code array.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>line_number_table_info</code>
	 */
	public static line_number_table_info getInstance(byte[]classFileData, int offset)
	{
		line_number_table_info res = new line_number_table_info();
		res.start_pc = Util.byte2Short(classFileData,offset); offset+=2;
		res.line_number = Util.byte2Short(classFileData,offset);
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>line_number_table_info</code> entry components</p>
	 * @return size of <code>line_number_table_info</code> entry
	 */
	public int getSize() { return 4; }
	/**
	 * Accessor method to <code>start_pc</code> field
	 * 
	 * <p>The value of the <code>start_pc</code> item must indicate the index into the <code>code</code> array at which the code for a new line in 
	 * the original source file begins. The value of <code>start_pc</code> must be less than the value of the <code>code_length</code> item of the 
	 * <code>Code_attribute</code> of which this <code>LineNumberTable</code> is an attribute.</p>
	 * @return value of <code>start_pc</code> field
	 */
	public short getStart_pc() { return start_pc; }
	/**
	 * Accessor method to <code>line_number</code> field
	 * 
	 * <p>The value of the <code>line_number</code> item must give the corresponding line number in the original source file.</p>
	 * @return value of <code>line_number</code> field
	 */
	public short getLine_number() { return line_number; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" start_pc: "+start_pc+"\n";
		res+=indentStr+" line_number: "+line_number+"\n";
		return res;
	}
}
