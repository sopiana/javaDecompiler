package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_MethodType_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_MethodType_info</code> structure is used to represent a method type:</p>
 * <code>CONSTANT_Methodref_info {<br>
 * &nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;u2 descriptor_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_MethodType_info extends cp_info
{
	/**
	 * The value of the <code>descriptor_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing 
	 * a method descriptor.
	 */
	private short descriptor_index;
	/**
	 * Factory method to generate a <code>CONSTANT_MethodType_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_MethodType_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 2 bytes of <code>descriptor_index</code> representing representing a method descriptor.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_MethodType_info</code> tag
	 */
	public static CONSTANT_MethodType_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_MethodType_info res = new CONSTANT_MethodType_info();
		if(classFileData[offset]!=cp_info.CONSTANT_MethodType)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
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
	public int getSize() { return 3; }
	/**
	 * Accessor method to <code>descriptor_index</code> field
	 * 
	 * <p>The value of the <code>descriptor_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing 
	 * a method descriptor.</p>
	 * @return value of <code>descriptor_index</code> field
	 */
	public short getDescriptor_index() { return descriptor_index; }
}
