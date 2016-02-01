package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>exception_table_info</code> item
 * 
 * <p>The <code>enum_const_value_info</code> is a fixed-length sub-element structure used in <code>Code_attribute</code> item. Each entry in the 
 * <code>exception_table</code> array describes one exception handler in the <code>code</code> array. The order of the handlers in the 
 * <code>exception_table</code> array is significant.</p>
 * <p>The <code>exception_table_info</code> structure has the following format:</p>
 * <code>exception_table_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 start_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 end_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 handler_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 catch_type;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class exception_table_info
{
	/**
	 * <p>The values of the two items <code>start_pc</code> and <code>end_pc</code> indicate the ranges in the code array at which the exception 
	 * handler is active. The value of <code>start_pc</code> must be a valid index into the <code>code</code> array of the opcode of an instruction.</p>
	 */
	private short start_pc;
	/**
	 * <p>The values of the two items <code>start_pc</code> and <code>end_pc</code> indicate the ranges in the code array at which the exception 
	 * handler is active. The value of <code>end_pc</code> either must be a valid index into the <code>code</code> array of the opcode of an instruction or must be 
	 * equal to <code>code_length</code>, the <code>length</code> of the <code>code</code> array. </p>
	 */
	private short end_pc;
	/**
	 * <p>The value of the <code>handler_pc</code> item indicates the start of the exception handler. The value of the item must be a valid index 
	 * into the <code>code</code> array and must be the index of the opcode of an instruction.</p>
	 */
	private short handler_pc;
	/**
	 * <p>If the value of the <code>catch_type</code> item is nonzero, it must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing a class of exceptions 
	 * that this exception handler is designated to catch. The exception handler will be called only if the thrown exception is an instance of the 
	 * given class or one of its subclasses.</p>
	 */
	private short catch_type;
	/**
	 * Factory method to generate a <code>exception_table_info</code> instance.
	 * 
	 * <p>The <code>enum_const_value_info</code> is a fixed-length sub-element structure used in <code>Code_attribute</code> item. Each entry in the 
	 * <code>exception_table</code> array describes one exception handler in the <code>code</code> array. The order of the handlers in the 
	 * <code>exception_table</code> array is significant.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>exception_table_info</code>
	 */
	public static exception_table_info getInstance(byte[]classFileData, int offset)
	{
		exception_table_info res = new exception_table_info();
		res.start_pc = Util.byte2Short(classFileData,offset); offset+=2;
		res.end_pc = Util.byte2Short(classFileData,offset);offset+=2;
		res.handler_pc = Util.byte2Short(classFileData,offset);offset+=2;
		res.catch_type = Util.byte2Short(classFileData,offset);offset+=2;
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>exception_table_info</code> entry components</p>
	 * @return size of <code>exception_table_info</code> entry
	 */
	public int getSize() { return 8; }
	/**
	 * Accessor method to <code>start_pc</code> field
	 * 
	 * <p>The values of the two items <code>start_pc</code> and <code>end_pc</code> indicate the ranges in the code array at which the exception 
	 * handler is active. The value of <code>start_pc</code> must be a valid index into the <code>code</code> array of the opcode of an instruction.</p>
	 * @return value of <code>start_pc</code> field
	 */
	public short getStart_pc() { return start_pc; }
	/**
	 * Accessor method to <code>end_pc</code> field
	 * 
	 * <p>The values of the two items <code>start_pc</code> and <code>end_pc</code> indicate the ranges in the code array at which the exception 
	 * handler is active. The value of <code>end_pc</code> either must be a valid index into the <code>code</code> array of the opcode of an instruction or must be 
	 * equal to <code>code_length</code>, the <code>length</code> of the <code>code</code> array. </p>
	 * @return value of <code>end_pc</code> field
	 */
	public short getEnd_pc() { return end_pc; }
	/**
	 * Accessor method to <code>handler_pc</code> field
	 * 
	 * <p>The value of the <code>handler_pc</code> item indicates the start of the exception handler. The value of the item must be a valid index 
	 * into the <code>code</code> array and must be the index of the opcode of an instruction.</p>
	 * @return value of <code>handler_pc</code> field
	 */
	public short getHandler_pc() { return handler_pc; }
	/**
	 * Accessor method to <code>catch_type</code> field
	 * 
	 * <p>If the value of the <code>catch_type</code> item is nonzero, it must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing a class of exceptions 
	 * that this exception handler is designated to catch. The exception handler will be called only if the thrown exception is an instance of the 
	 * given class or one of its subclasses.</p>
	 * @return value of <code>catch_type</code> field
	 */
	public short getCatch_type() { return catch_type; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" start_pc: "+start_pc+"\n";
		res+=indentStr+" end_pc: "+end_pc+"\n";
		res+=indentStr+" handler_pc: "+handler_pc+"\n";
		res+=indentStr+" catch_type: "+constant_pool[catch_type].toString(indent+1, constant_pool);
		return res;
	}
}
