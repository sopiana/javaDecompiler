package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>localvar_target_info</code> item
 * 
 * <p>The <code>localvar_target</code> item indicates that an annotation appears on the type in a local variable declaration, including 
 * a variable declared as a resource in a try with-resources statement.</p>
 * <p>The <code>localvar_target_info</code> structure has the following format:</p>
 * <code>localvar_target_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 table_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 start_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} table[table_length];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class localvar_target_info extends target_info
{
	/**
	 * <p>The value of the <code>table_length</code> item gives the number of entries in the table array.</p>
	 */
	private short table_length;
	/**
	 * <p>Each entry indicates a range of code array offsets within which a local variable has a value. It also indicates the index into the 
	 * local variable array of the current frame at which that local variable can be found.</p>
	 */
	private table_info table[];	//table_length
	/**
	 * Factory method to generate a <code>localvar_target_info</code> instance.
	 * 
	 * <p>The <code>localvar_target</code> item indicates that an annotation appears on the type in a local variable declaration, including 
	 * a variable declared as a resource in a try with-resources statement.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>localvar_target_info</code>
	 */
	public static localvar_target_info getInstance(byte[]classFileData, int offset)
	{
		localvar_target_info res = new localvar_target_info();
		res.table_length =  Util.byte2Short(classFileData,offset); offset += 2;
		res.table = new table_info[res.table_length];
		for(int i=0;i<res.table_length;++i)
		{
			res.table[i] = table_info.getInstance(classFileData, offset);
			offset+= res.table[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>localvar_target_info</code> entry components</p>
	 * @return size of <code>localvar_target_info</code> entry
	 */
	public int getSize() {
		int res = 2;
		for(int i=0;i<table_length;++i)
		{
			res += table[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>table_length</code> field
	 * 
	 * <p>The value of the <code>table_length</code> item gives the number of entries in the table array.</p>
	 * @return value of <code>table_length</code> field
	 */
	public short getTable_length() { return table_length; }
	/**
	 * Accessor method to <code>table</code> field
	 * 
	 * <p>Each entry indicates a range of code array offsets within which a local variable has a value. It also indicates the index into the 
	 * local variable array of the current frame at which that local variable can be found.</p>
	 * @return value of <code>table</code> field
	 */
	public table_info[] getTable() { return table; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = class_info.getIndent(indent);
		String res= indentStr+" table_length: "+table_length+"\n";
		for(int i=0;i<table.length;++i)
		{
			res+="table["+i+"]:\n";
			res+=table[i].toString(indent+1,constant_pool);
		}
		return res;
	}
}
