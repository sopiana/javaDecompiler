package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>local_variable_type_table_info</code> item
 * 
 * <p>The <code>local_variable_type_table_info</code> is a fixed-length sub-element structure used in <code>LocalVariableTypeTable</code> item. 
 * Each entry in the <code>local_variable_type_table</code> array indicates a range of <code>code</code> array offsets within which 
 * a local variable has a value. It also indicates the index into the local variable array of the current frame at which that local 
 * variable can be found.</p>
 * <p>The <code>local_variable_type_table_info</code> structure has the following format:</p>
 * <code>local_variable_type_table_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 start_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 signature_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class local_variable_type_table_info 
{
	/**
	 * <p>The value of <code>start_pc</code> must be a valid index into the <code>code</code> array of this <code>Code_attribute</code> and 
	 * must be the index of the opcode of an instruction.</p>
	 */
	private short start_pc;
	/**
	 * <p>The value of <code>start_pc + length</code> must either be a valid index into the <code>code</code> array of this <code>Code_attribute</code> 
	 * and be the index of the opcode of an instruction, or it must be the first index beyond the end of that <code>code</code> array.</p>
	 */
	private short length;
	/**
	 * <p>The value of the <code>name_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must contain a <code>CONSTANT_Utf8_info</code> structure representing a valid unqualified name denoting a local 
	 * variable.</p>
	 */
	private short name_index;
	/**
	 * <p>The value of the <code>signature_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must contain a <code>CONSTANT_Utf8_info</code> structure representing a field signature which encodes the type of a 
	 * local variable in the source program.</p>
	 */
	private short signature_index;
	/**
	 * <p>The given local variable must be at index in the local variable array of the current frame.</p>
	 * <p>If the local variable at index is of type <code>double</code> or <code>long</code>, it occupies both <code>index</code> and 
	 * <code>index + 1</code>.</p>
	 */
	private short index;
	/**
	 * Factory method to generate a <code>local_variable_type_table_info</code> instance.
	 * 
	 * <p>The <code>local_variable_type_table_info</code> is a fixed-length sub-element structure used in <code>LocalVariableTypeTable</code> item. 
	 * Each entry in the <code>local_variable_type_table</code> array indicates a range of <code>code</code> array offsets within which 
	 * a local variable has a value. It also indicates the index into the local variable array of the current frame at which that local 
	 * variable can be found.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>local_variable_type_table_info</code>
	 */
	public static local_variable_type_table_info getInstance(byte[]classFileData, int offset)
	{
		local_variable_type_table_info res= new local_variable_type_table_info();
		res.start_pc = Util.byte2Short(classFileData,offset);offset+=2;
		res.length = Util.byte2Short(classFileData,offset);offset+=2;
		res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.signature_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.index = Util.byte2Short(classFileData,offset);
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>local_variable_type_table_info</code> entry components</p>
	 * @return size of <code>local_variable_type_table_info</code> entry
	 */
	public int getSize() { return 10; }
	/**
	 * Accessor method to <code>start_pc</code> field
	 * 
	 * <p>The value of <code>start_pc</code> must be a valid index into the <code>code</code> array of this <code>Code_attribute</code> and 
	 * must be the index of the opcode of an instruction.</p>
	 * @return value of <code>start_pc</code> field
	 */
	public short getStart_pc() { return start_pc; }
	/**
	 * Accessor method to <code>length</code> field
	 * 
	 * <p>The value of <code>start_pc + length</code> must either be a valid index into the <code>code</code> array of this <code>Code_attribute</code> 
	 * and be the index of the opcode of an instruction, or it must be the first index beyond the end of that <code>code</code> array.</p>
	 * @return value of <code>length</code> field
	 */
	public short getLength() { return length; }
	/**
	 * Accessor method to <code>name_index</code> field
	 * 
	 * <p>The value of the <code>name_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must contain a <code>CONSTANT_Utf8_info</code> structure representing a valid unqualified name denoting a local 
	 * variable.</p>
	 * @return value of <code>name_index</code> field
	 */
	public short getName_index() { return name_index; }
	/**
	 * Accessor method to <code>signature_index</code> field
	 * 
	 * <p>The value of the <code>signature_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must contain a <code>CONSTANT_Utf8_info</code> structure representing a field signature which encodes the type of a 
	 * local variable in the source program.</p>
	 * @return value of <code>signature_index</code> field
	 */
	public short getSignature_index() { return signature_index; }
	/**
	 * Accessor method to <code>index</code> field
	 * 
	 * <p>The given local variable must be at index in the local variable array of the current frame.</p>
	 * <p>If the local variable at index is of type <code>double</code> or <code>long</code>, it occupies both <code>index</code> and 
	 * <code>index + 1</code>.</p>
	 * @return value of <code>index</code> field
	 */
	public short getIndex() { return index; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" start_pc: "+start_pc+"\n";
		res+=indentStr+" length: "+length+"\n";
		try
		{
			res+=indentStr+" name_index: "+cp_info.getName(name_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" name_index: @"+ name_index+"\n";
		}
		try
		{
			res+=indentStr+" signature_index: "+cp_info.getName(signature_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" signature_index: @"+ signature_index+"\n";
		}
		res+=indentStr+" index: "+index+"\n";
		return res;
	}
}
