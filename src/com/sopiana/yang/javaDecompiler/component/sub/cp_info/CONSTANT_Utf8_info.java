package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_NameAndType_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_NameAndType_info</code> structure is used to represent constant string values:</p>
 * <code>CONSTANT_Utf8_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 bytes[length];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_Utf8_info extends cp_info
{
	/**
	 * The value of the <code>length</code> item gives the number of bytes in the <code>bytes</code> array (not the 
	 * length of the resulting string).
	 */
	private short length;
	/**
	 * The <code>bytes</code> array contains the bytes of the string. 
	 * <ul>
	 * <li>No byte may have the value (byte)0.</li>
	 * <li>No byte may lie in the range (byte)0xf0 to (byte)0xff.</li>
	 * </ul>
	 * <p>String content is encoded in modified UTF-8. Modified UTF-8 strings are encoded so that code point sequences that 
	 * contain only non-null ASCII characters can be represented using only 1 byte per code point, but all code points in 
	 * the Unicode codespace can be represented. Modified UTF-8 strings are not null-terminated. </p>
	 */
	private byte bytes[];
	/**
	 * Factory method to generate a <code>CONSTANT_Utf8_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_NameAndType_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 2 bytes <code>length</code> describing length of the <code>bytes</code> array and variable length of 
	 * <code>bytes</code> representing the String in UTF-8 format.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_MethodType_info</code> tag
	 */
	public static CONSTANT_Utf8_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_Utf8_info res = new CONSTANT_Utf8_info();
		if(classFileData[offset]!=cp_info.CONSTANT_Utf8)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.length = Util.byte2Short(classFileData,offset); offset+=2;
		res.bytes = Arrays.copyOfRange(classFileData, offset, offset+res.length);
		return res;
    }
	/**
	 * Accessor method to <code>constant_pool</code> field
	 * 
	 * <p>The value of the <code>length</code> item gives the number of bytes in the <code>bytes</code> array (not the 
	 * length of the resulting string).</p>
	 * @return value of <code>constant_pool</code> field
	 */
	public int getSize() { return 3+length;}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Showing <code>constant_pool</code> entry in 8-bit cells byte including size of <code>tag</code> and <code>info[]</code>
	 * components</p>
	 * @return value of <code>length</code> field
	 */
	public short getLength() { return length; }
	/**
	 * Return String format of <code>bytes</code> field
	 * 
	 * <p>The <code>bytes</code> array contains the bytes of the string. </p>
	 * <ul>
	 * <li>No byte may have the value (byte)0.</li>
	 * <li>No byte may lie in the range (byte)0xf0 to (byte)0xff.</li>
	 * </ul>
	 * <p>String content is encoded in modified UTF-8. Modified UTF-8 strings are encoded so that code point sequences that 
	 * contain only non-null ASCII characters can be represented using only 1 byte per code point, but all code points in 
	 * the Unicode codespace can be represented. Modified UTF-8 strings are not null-terminated. </p>
	 * @return value of <code>bytes</code> field in UTF-8 format String
	 * @throws decompilerException if byte format is not supported UTF-8 encoding
	 */
	public String getString() throws decompilerException
	{
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new decompilerException("invalid CONSTANT_Utf8_info encoding format");
		}
	}
}
