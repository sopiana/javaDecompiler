package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_Methodref_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_Methodref_info</code> represent description of a field in a class:</p>
 * <code>CONSTANT_Methodref_info {<br>
 * &nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;u2 class_index;<br>
 * &nbsp;&nbsp;&nbsp;u2 name_and_type_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_Methodref_info extends cp_info
{
	/**
	 * <p>The value of the <code>class_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing 
	 * a class or interface type that has the field or method as a member.</p>
	 * <p>The <code>class_index</code> item of a <code>CONSTANT_InterfaceMethodref_info</code> structure must be an 
	 * interface type.</p>
	 */
	private short class_index;
	/**
	 * The value of the <code>name_and_type_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The constant_pool entry at that index must be a <code>CONSTANT_NameAndType_info</code> structure. This <code>constant_pool</code> 
	 * entry indicates the name and descriptor of the field or method.
	 */
	private short name_and_type_index;
	/**
	 * Factory method to generate a <code>CONSTANT_Methodref_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_Methodref_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 2 bytes of <code>class_index</code> representing a class or interface type that has the field or method as a member, 
	 * and 2 bytes of <code>name_and_type_index</code> indicating the name and descriptor of the field or method.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_Methodref_info</code> tag
	 */
	public static CONSTANT_Methodref_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_Methodref_info res = new CONSTANT_Methodref_info();
		if(classFileData[offset]!=cp_info.CONSTANT_Methodref)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.class_index = Util.byte2Short(classFileData,offset);offset+=2;
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
	 * <p>The value of the <code>class_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing 
	 * a class or interface type that has the field or method as a member.</p>
	 * <p>The <code>class_index</code> item of a <code>CONSTANT_InterfaceMethodref_info</code> structure must be an 
	 * interface type.</p>
	 * @return value of <code>class_index</code> field
	 */
	public short getClass_index() { return class_index; }
	/**
	 * Accessor method to <code>name_and_type_index</code> field
	 * 
	 * <p>The value of the <code>name_and_type_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The constant_pool entry at that index must be a <code>CONSTANT_NameAndType_info</code> structure. This <code>constant_pool</code> 
	 * entry indicates the name and descriptor of the field or method.</p>
	 * @return value of <code>name_and_type_index</code> field
	 */
	public short getName_and_type_index() { return name_and_type_index; }
}
