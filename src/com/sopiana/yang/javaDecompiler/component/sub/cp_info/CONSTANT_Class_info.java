package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_Class_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_Class_info</code> structure is used to represent a class or an interface:</p>
 * <code>CONSTANT_Class_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 name_index;<br>
 * }</code>
 * @author yang.sopiana
 */
public class CONSTANT_Class_info extends cp_info 
{
	/**
	 * The value of the <code>name_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure 
	 * representing a valid binary class or interface name encoded in internal form.
	 */
	private short name_index;
	/**
	 * Factory method to generate a <code>CONSTANT_Class_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_Class_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 2 bytes of <code>name_index</code> describing class or interface's name.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_Class_info</code> tag
	 */
	public static CONSTANT_Class_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_Class_info res = new CONSTANT_Class_info();
		if(classFileData[offset]!=cp_info.CONSTANT_Class)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.name_index = Util.byte2Short(classFileData,offset);
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
     * Accessor method to <code>name_index</code> field
     * 
     * <p>The value of the <code>name_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure 
	 * representing a valid binary class or interface name encoded in internal form.</p>
     * @return value of <code>access_flags</code> field
     */
	public short getName_index() { return name_index; }

	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res="";
		res+=indentStr+" tag: CONSTANT_Class \n";
		try
		{
			res+=indentStr+" Name : "+cp_info.getName(name_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" Name index : "+ name_index+"\n";
		}
		return res;
	}
}
