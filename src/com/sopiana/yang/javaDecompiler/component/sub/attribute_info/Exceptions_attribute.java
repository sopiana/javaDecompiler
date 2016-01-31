package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>Exceptions_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>Exceptions_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>method_info</code> 
 * structure. The <code>Exceptions_attribute</code> indicates which checked exceptions a method may throw.</p>
 * <p>There may be at most one <code>Exceptions_attribute</code> in the <code>attributes</code> table of a <code>method_info</code> structure.</p>
 * <p>The <code>Exceptions_attribute</code> has the following format:</p>
 * <code>Exceptions_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 number_of_exceptions;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 exception_index_table[number_of_exceptions];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class Exceptions_attribute extends attribute_info
{
	/**
	 * <p>The value of <code>the number_of_exceptions</code> item indicates the number of entries in the <code>exception_index_table</code>.</p>
	 */
	private short number_of_exceptions;
	/**
	 * <p>Each value in the <code>exception_index_table</code> array must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing a class type that this 
	 * method is declared to throw.</p>
	 * <small><p>A method should throw an exception only if at least one of the following three criteria is met:</p>
	 * <ul>
	 * <li>The exception is an instance of <code>RuntimeException</code> or one of its subclasses.</li>
	 * <li>The exception is an instance of <code>Error</code> or one of its subclasses.</li>
	 * <li>The exception is an instance of one of the <code>exception</code> classes specified in the <code>exception_index_table</code> 
	 * just described, or one of their subclasses.</li>
	 * </ul>
	 * <p>These requirements are not enforced in the Java Virtual Machine; they are enforced only at compile time.</p></small>
	 */
	private short exception_index_table[];	//number_of_exceptions
	/**
	 * Factory method to generate a <code>Exceptions_attribute</code> instance.
	 * 
	 * <p>The <code>Exceptions_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>method_info</code>
	 * structure. The <code>Exceptions_attribute</code> indicates which checked exceptions a method may throw.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>Exceptions_attribute</code>
	 */
	public static Exceptions_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		int offset = 0;
		Exceptions_attribute res = new Exceptions_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.number_of_exceptions = Util.byte2Short(info);offset+=2;
		res.exception_index_table = new short[res.number_of_exceptions];
		for(int i=0;i<res.number_of_exceptions;++i)
		{
			res.exception_index_table[i] = Util.byte2Short(info,offset);
			offset+=2;
		}
		return res;
	}
	/**
	 * Accessor method to <code>number_of_exceptions</code> field
	 * 
	 * <p>The value of <code>the number_of_exceptions</code> item indicates the number of entries in the <code>exception_index_table</code>.</p>
	 * @return value of <code>number_of_exceptions</code> field
	 */
	public short number_of_exceptions() { return number_of_exceptions; }
	/**
	 * Accessor method to <code>exception_index_table</code> field
	 * 
	 * <p>Each value in the <code>exception_index_table</code> array must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing a class type that this 
	 * method is declared to throw.</p>
	 * <p><small>A method should throw an exception only if at least one of the following three criteria is met:</small></p>
	 * 
	 * <ul>
	 * <li><small>The exception is an instance of <code>RuntimeException</code> or one of its subclasses.</small></li>
	 * <li><small>The exception is an instance of <code>Error</code> or one of its subclasses.</small></li>
	 * <li><small>The exception is an instance of one of the <code>exception</code> classes specified in the <code>exception_index_table</code> 
	 * just described, or one of their subclasses.</small></li>
	 * </ul>
	 * <p><small>These requirements are not enforced in the Java Virtual Machine; they are enforced only at compile time.</small></p>
	 * @return value of <code>exception_index_table</code> field
	 */
	public short[] exception_index_table() { return exception_index_table; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" number_of_exceptions: "+number_of_exceptions+"\n";
		for(int i=0;i<number_of_exceptions;++i)
		{
			res+=indentStr+" exception_index_table["+i+"]: \n";
			res+=constant_pool[exception_index_table[i]].toString(indent+1, constant_pool);
		}
		return res;
	}
}
