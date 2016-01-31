package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_NameAndType_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_NameAndType_info</code> structure is used to represent a field or method, without indicating 
 * which class or interface type it belongs to:</p>
 * <code>CONSTANT_NameAndType_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 descriptor_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_NameAndType_info extends cp_info
{
	/**
	 * The value of the <code>name_index</code>item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing 
	 * either the special method name <code>&lt;init&gt;<code> or a valid unqualified name denoting a field or method.
	 */
	private short name_index;
	/**
	 * The value of the <code>descriptor_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing 
	 * a valid field descriptor or method descriptor.
	 */
	private short descriptor_index;
	/**
	 * Factory method to generate a <code>CONSTANT_NameAndType_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_NameAndType_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 2 bytes of  <code>name_index</code> and 2 bytes of <code>descriptor_index</code> representing a method descriptor.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_MethodType_info</code> tag
	 */
	public static CONSTANT_NameAndType_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_NameAndType_info res = new CONSTANT_NameAndType_info();
		if(classFileData[offset]!=cp_info.CONSTANT_NameAndType)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.descriptor_index = Util.byte2Short(classFileData,offset);
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
	 * Accessor method to <code>name_index</code> field
	 * 
	 * <p>SThe value of the <code>name_index</code>item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing 
	 * either the special method name <code>&lt;init&gt;</code> or a valid unqualified name denoting a field or method.</p>
	 * @return value of <code>name_index</code> field
	 */
	public short getName_index() { return name_index; }
	/**
	 * Accessor method to <code>descriptor_index</code> field
	 * 
	 * <p>The value of the <code>descriptor_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing 
	 * a valid field descriptor or method descriptor.</p>
	 * @return value of <code>descriptor_index</code> field
	 */
	public short getDescriptor_index() { return descriptor_index; }

	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res="";
		res+=indentStr+" tag: CONSTANT_NameAndType_info"+"\n";
		try
		{
			res+=indentStr+" name_index:"+cp_info.getName(name_index,constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" name_index: "+name_index+"\n";
		}
		try
		{
			res+=indentStr+" descriptor_index:"+cp_info.getName(descriptor_index,constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" descriptor_index: "+descriptor_index+"\n";
		}
		return res;
	}
}
