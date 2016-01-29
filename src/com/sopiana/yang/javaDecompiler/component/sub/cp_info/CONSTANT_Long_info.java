package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_Long_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_Long_info</code> represent 8-byte numeric double constants:</p>
 * <code>CONSTANT_Long_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 high_bytes;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 low_bytes;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_Long_info extends cp_info
{
	/**
	 * <p>The unsigned <code>high_bytes</code> and <code>low_bytes</code> items of the <code>CONSTANT_Long_info</code> structure 
	 * together represent the value of the <code>long</code> constant<br>
	 * <code>((long) high_bytes &lt;&lt; 32) + low_bytes</code><br>
	 * where the bytes of each of <code>high_bytes</code> and <code>low_bytes</code> are stored in big-endian (high byte first) 
	 * order.</p>
	 */
	private long value;
	/**
	 * Factory method to generate a <code>CONSTANT_Long_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_Long_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 4 bytes of <code>high_bytes</code> and 4 bytes of <code>low_bytes</code> describing the value of entry.
	 * These two 4 bytes value then will be converted to <code>long</code> value.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_Long_info</code> tag
	 */
	public static CONSTANT_Long_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_Long_info res = new CONSTANT_Long_info();
		if(classFileData[offset]!=cp_info.CONSTANT_Long)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.value = Util.byte2Int(classFileData,offset)<<32; offset+=4;
		res.value |= Util.byte2Int(classFileData,offset);
		return res;
    }
	
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Showing <code>constant_pool</code> entry in 8-bit cells byte including size of <code>tag</code> and <code>info[]</code>
	 * components</p>
	 * @return size of <code>constant_pool</code> entry
	 */
	public int getSize() { return 9; }
	/**
	 * Accessor method to <code>value</code> field
	 * 
	 * <p>The unsigned <code>high_bytes</code> and <code>low_bytes</code> items of the <code>CONSTANT_Long_info</code> structure 
	 * together represent the value of the <code>long</code> constant<br>
	 * <code>((long) high_bytes &lt;&lt; 32) + low_bytes</code><br>
	 * where the bytes of each of <code>high_bytes</code> and <code>low_bytes</code> are stored in big-endian (high byte first) 
	 * order.</p>
	 * @return value of <code>value</code> field
	 */
	public long getValue() { return value; }
}
