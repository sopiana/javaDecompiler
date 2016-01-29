package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_Integer_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_Integer_info</code> structures represent 4- byte numeric <code>int</code> constants:</p>
 * <code>CONSTANT_Integer_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 bytes;<br>
 * } </code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_Integer_info extends cp_info
{
	/**
	 * <p>The <code>value</code> item of the <code>CONSTANT_Integer_info</code> structure represents the value
	 * of the <code>int</code> constant. The bytes of the value are stored in big-endian (high byte first) order.</p>
	 */
	private int value;
	/**
	 * Factory method to generate a <code>CONSTANT_Integer_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_Float_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 4 bytes of <code>value</code> representing the value of the <code>int</code> constant.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_Integer_info</code> tag
	 */
	public static CONSTANT_Integer_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_Integer_info res = new CONSTANT_Integer_info();
		if(classFileData[offset]!=cp_info.CONSTANT_Integer)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.value = Util.byte2Int(classFileData,offset);
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
     * Accessor method to <code>value</code> field
     * 
     * <p>The <code>value</code> item of the <code>CONSTANT_Integer_info</code> structure represents the value
	 * of the <code>int</code> constant. The bytes of the value are stored in big-endian (high byte first) order.</p>
     * @return value of <code>value</code> field
     */
	public int getValue() { return value; }
}
