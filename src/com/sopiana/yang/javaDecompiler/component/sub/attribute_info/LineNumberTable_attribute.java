package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.line_number_table_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>LineNumberTable_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>LineNumberTable_attribute</code> is an optional variable-length attribute in the <code>attributes</code> table of a 
 * <code>Code_attribute</code>. It may be used by debuggers to determine which part of the code array corresponds to a given line number in 
 * the original source file.</p>
 * <p>If multiple <code>LineNumberTable_attributes</code> are present in the <code>attributes</code> table of a <code>Code_attribute</code>, 
 * then they may appear in any order.</p>
 * <p>There may be more than one <code>LineNumberTable_attribute</code> per line of a source file in the attributes table of a <code>Code_attribute</code>. 
 * That is, <code>LineNumberTable_attributes</code> may together represent a given line of a source file, and need not be one-to-one with 
 * source lines.</p>
 * <p>The <code>LineNumberTable_attribute</code> has the following format:</p>
 * <code>LineNumberTable_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 line_number_table_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ 
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 start_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 line_number;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} line_number_table[line_number_table_length];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class LineNumberTable_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>line_number_table_length</code> item indicates the number of entries in the <code>line_number_table</code> array.</p>
	 */
	private short line_number_table_length;
	/**
	 * <p>Each entry in the <code>line_number_table</code> array indicates that the line number in the original source file changes at a given 
	 * point in the code array. Each <code>line_number_table</code> entry must contain the following two items, <code>start_pc</code> and <code>line_number.</code></p>
	 */
	private line_number_table_info line_number_table[];	//line_number_table_length
	
	/**
	 * Factory method to generate a <code>LineNumberTable_attribute</code> instance.
	 * 
	 * <p>The <code>LineNumberTable_attribute</code> is an optional variable-length attribute in the <code>attributes</code> table of a 
	 * <code>Code_attribute</code>. It may be used by debuggers to determine which part of the code array corresponds to a given line number in 
	 * the original source file.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>LineNumberTable_attribute</code>
	 */
	public static LineNumberTable_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) 
	{
		int offset = 0;
		LineNumberTable_attribute res = new LineNumberTable_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.line_number_table_length = Util.byte2Short(info);offset+=2;
		res.line_number_table = new line_number_table_info[res.line_number_table_length];
		for(int i=0;i<res.line_number_table_length;++i)
		{
			res.line_number_table[i] = line_number_table_info.getInstance(info, offset);
			offset+=res.line_number_table[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>line_number_table_length</code> field
	 * 
	 * <p>The value of the <code>line_number_table_length</code> item indicates the number of entries in the <code>line_number_table</code> array.</p>
	 * @return value of <code>line_number_table_length</code> field
	 */
	public short getLine_number_table_length() { return line_number_table_length; }
	/**
	 * Accessor method to <code>line_number_table</code> field
	 * 
	 * <p>Each entry in the <code>line_number_table</code> array indicates that the line number in the original source file changes at a given 
	 * point in the code array. Each <code>line_number_table</code> entry must contain the following two items, <code>start_pc</code> and <code>line_number.</code></p>
	 * @return value of <code>line_number_table</code> field
	 */
	public line_number_table_info[] getLine_number_table() { return line_number_table; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" line_number_table_length: "+line_number_table_length+"\n";
		for(int i=0;i<line_number_table_length;++i)
		{
			res+=indentStr+" line_number_table["+i+"]: \n";
			res+=line_number_table[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
