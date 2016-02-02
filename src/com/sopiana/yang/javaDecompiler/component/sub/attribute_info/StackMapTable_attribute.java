package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.stack_map_frame;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>StackMapTable_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>StackMapTable_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>Code_attribute</code>. 
 * A <code>StackMapTable_attribute</code> is used during the process of verification by type checking.</p>
 * <p>There may be at most one <code>StackMapTable_attribute</code> in the <code>attributes</code> table of a <code>Code_attribute</code>.</p>
 * <p>The <code>StackMapTable_attribute</code> has the following format:</p>
 * <code>StackMapTable_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 number_of_entries;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;stack_map_frame entries[number_of_entries];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class StackMapTable_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>number_of_entries</code> item gives the number of <code>stack_map_frame</code> entries in the 
	 * <code>entries</code> table.</p>
	 */
	private short number_of_entries;
	/**
	 * <p>Each entry in the <code>entries</code> table describes one stack map frame of the method. The order of the stack map frames in the 
	 * entries table is significant.</p>
	 */
	private stack_map_frame entries[];	//number_of_entries
	/**
	 * Factory method to generate a <code>StackMapTable_attribute</code> instance.
	 * 
	 * <p>The <code>StackMapTable_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>Code_attribute</code>. 
	 * A <code>StackMapTable_attribute</code> is used during the process of verification by type checking.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>StackMapTable_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>StackMapTable_attribute</code> format
	 */
	public static StackMapTable_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
	{
		int offset = 0;
		StackMapTable_attribute res = new StackMapTable_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.number_of_entries = Util.byte2Short(info); offset+=2;
		res.entries = new stack_map_frame[res.number_of_entries];
		for(int i=0;i<res.number_of_entries;++i)
		{
			res.entries[i] = stack_map_frame.getInstance(info,offset);
			offset += res.entries[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>number_of_entries</code> field
	 * 
	 * <p>The value of the <code>number_of_entries</code> item gives the number of <code>stack_map_frame</code> entries in the 
	 * <code>entries</code> table.</p>
	 * @return value of <code>number_of_entries</code> field
	 */
	public short getNumber_of_entries() { return number_of_entries; }
	/**
	 * Accessor method to <code>entries</code> field
	 * 
	 * <p>Each entry in the <code>entries</code> table describes one stack map frame of the method. The order of the stack map frames in the 
	 * entries table is significant.</p>
	 * @return value of <code>entries</code> field
	 */
	public stack_map_frame[] getEntries() { return entries; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" number_of_entries: "+number_of_entries+"\n";
		for(int i=0;i<number_of_entries;++i)
		{
			res+=indentStr+" annotations["+i+"]: \n";
			res+=entries[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
