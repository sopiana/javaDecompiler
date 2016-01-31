package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;

/**
 * Provides abstraction for <code>CONSTANT_InvokeDynamic_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_InvokeDynamic_info</code> structure is used by an invokedynamic instruction to specify a 
 * bootstrap method, the dynamic invocation name, the argument and return types of the call, and optionally, a 
 * sequence of additional constants called <i>static arguments</i> to the bootstrap method.</p>
 * <code>CONSTANT_InvokeDynamic_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 bootstrap_method_attr_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 name_and_type_index;<br>
 * }</code>
 */
public class CONSTANT_InvokeDynamic_info extends cp_info
{
	/**
	 * <p>The value of the <code>bootstrap_method_attr_index</code> item must be a valid index into the 
	 * <code>bootstrap_methods</code> array of the bootstrap method table of this class file.</p>
	 */
	private short bootstrap_method_attr_index;
	/**
	 * <p>The value of the <code>name_and_type_index</code> item must be a valid index into the 
	 * <code>constant_pool</code> table. The <code>constant_pool</code> entry at that index must be a 
	 * <code>CONSTANT_NameAndType_info</code> structure representing a method name and method descriptor.</p>
	 */
	private short name_and_type_index;
	/**
	 * Factory method to generate a <code>CONSTANT_InvokeDynamic_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_InvokeDynamic_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 2 bytes of <code>bootstrap_method_attr_index</code> representing the bootstrap method, 
	 * and 2 bytes of <code>name_and_type_index</code> indicating the name and descriptor of the field or method.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_InvokeDynamic_info</code> tag
	 */
	public static CONSTANT_InvokeDynamic_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_InvokeDynamic_info res = new CONSTANT_InvokeDynamic_info();
		if(classFileData[offset]!=cp_info.CONSTANT_InvokeDynamic)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.bootstrap_method_attr_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.name_and_type_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Showing <code>constant_pool</code> entry in 8-bit cells byte including size of <code>tag</code> and <code>info[]</code>
	 * components</p>
	 * @return size of <code>constant_pool</code> entry
	 */
	public int getSize() { return 5; }
	/**
	 * Accessor method to <code>class_index</code> field
	 * 
	 * <p>The value of the <code>bootstrap_method_attr_index</code> item must be a valid index into the 
	 * <code>bootstrap_methods</code> array of the bootstrap method table of this class file.</p>
	 * @return value of <code>bootstrap_method_attr_index</code> field
	 */
	public short getBootstrap_method_attr_index() { return bootstrap_method_attr_index; }
	/**
	 * Accessor method to <code>name_and_type_index</code> field
	 * 
	 * <p>The value of the <code>name_and_type_index</code> item must be a valid index into the 
	 * <code>constant_pool</code> table. The <code>constant_pool</code> entry at that index must be a 
	 * <code>CONSTANT_NameAndType_info</code> structure representing a method name and method descriptor.</p>
	 * @return value of <code>name_and_type_index</code> field
	 */
	public short getName_and_type_index() { return name_and_type_index; }

	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res="";
		res+=indentStr+" tag: CONSTANT_InvokeDynamic_info"+"\n";
		//TODO: learn about this
		res+=indentStr+" bootstrap_method_attr_index:" +bootstrap_method_attr_index+"\n";
		try
		{
			res+=indentStr+" name_and_type_index:"+cp_info.getName(((CONSTANT_NameAndType_info)constant_pool[name_and_type_index]).getName_index(),constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" name_and_type_index"+name_and_type_index+"\n";
		}
		return res;
	}
}
