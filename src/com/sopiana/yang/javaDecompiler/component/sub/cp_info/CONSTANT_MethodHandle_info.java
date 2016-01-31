package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_MethodHandle_info</code> item in <code>constant_pool</code> table
 * 
* <p>The <code>CONSTANT_MethodHandle_info</code> structure is used to represent a method handle:</p>
 * <code>CONSTANT_MethodHandle_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 reference_kind;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 reference_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_MethodHandle_info extends cp_info
{
	/**
	 * <p>The value of the <code>reference_kind</code> item must be in the range 1 to 9. The value denotes the kind 
	 * of this method handle, which characterizes its bytecode behavior.</p>
	 */
	private byte reference_kind;
	/**
	 * The value of the <code>reference_index</code> item must be a valid index into the <code>constant_pool</code> table.
	 */
	private short reference_index;
	/**
	 * Factory method to generate a <code>CONSTANT_MethodHandle_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_MethodHandle_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 1 byte of <code>reference_kind</code> and 2 bytes of <code>reference_index</code>.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_MethodHandle_info</code> tag
	 */
	public static CONSTANT_MethodHandle_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_MethodHandle_info res = new CONSTANT_MethodHandle_info();
		if(classFileData[offset]!=cp_info.CONSTANT_MethodHandle)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.reference_kind = classFileData[offset++];
		res.reference_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Showing <code>constant_pool</code> entry in 8-bit cells byte including size of <code>tag</code> and <code>info[]</code>
	 * components</p>
	 * @return size of <code>constant_pool</code> entry
	 */
	public int getSize() { return 4; }
	/**
     * Accessor method to <code>value</code> field
     * 
     * <p>The value of the <code>reference_kind</code> item must be in the range 1 to 9. The value denotes the kind 
	 * of this method handle, which characterizes its bytecode behavior.</p>
     * @return value of <code>reference_kind</code> field
     */
	public byte getReference_kind() { return reference_kind; }
	/**
     * Accessor method to <code>value</code> field
     * 
     * <p>The value of the <code>reference_index</code> item must be a valid index into the <code>constant_pool</code> table.</p>
     * @return value of <code>reference_index</code> field
     */
	public short getReference_index() { return reference_index; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res="";
		res+=indentStr+" tag: CONSTANT_MethodHandle_info"+"\n";
		//TODO: learn about this
		res+=indentStr+" reference_kind:" +reference_kind+"\n";
		try
		{
			res+=indentStr+" reference_index:"+cp_info.getName(reference_index,constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" reference_index"+reference_index+"\n";
		}
		return res;
	}
}
