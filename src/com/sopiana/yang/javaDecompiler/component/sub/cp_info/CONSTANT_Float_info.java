package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_Double_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_Float_info</code> structures represent 4- byte numeric <code>float</code> constants:</p>
 * <code>CONSTANT_Float_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 bytes;<br>
 * } </code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_Float_info extends cp_info
{
	/**
	 * <p>The <code>value</code> item of the <code>CONSTANT_Float_info</code> structure represents the value of the <code>float</code> 
	 * constant in IEEE 754 floating-point single format. The bytes of the single format representation are stored in 
	 * big-endian (high byte first) order.</p>
	 * <p>The value represented by the <code>CONSTANT_Float_info</code> structure is determined as follows. 
	 * The bytes of the value are first converted into an <code>int</code> constant bits. Then:</p>
	 * <ul>
	 * <li>If bits is 0x7f800000, the float value will be positive infinity.</li>
	 * <li>If bits is 0xff800000, the float value will be negative infinity.</li>
	 * <li>If bits is in the range 0x7f800001 through 0x7fffffff or in the range 0xff800001 through 0xffffffff, the 
	 * float value will be <code>NaN</code>.</li>
	 * <li>In all other cases, let <i>s</i>, <i>e</i>, and <i>m</i> be three values that might be computed from bits:<br>
	 * <code>int s = ((bits &gt;&gt; 31) == 0) ? 1 : -1;<br>
	 * int e = ((bits &gt;&gt; 23) &amp; 0xff);<br>
	 * int m = (e == 0) ? (bits &amp; 0x7fffff) &lt;&lt; 1 : (bits &amp; 0x7fffff) | 0x800000;</code><br>
	 * Then the float value equals the result of the mathematical expression <i>s</i> · <i>m</i> · 2 <sup><i>e</i>-150</sup>.
	 * </li></ul>
	 */
	private float value;
	/**
	 * Factory method to generate a <code>CONSTANT_Float_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_Float_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 4 bytes of <code>value</code> representing the float value in IEEE 754 floating-point single format.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_Float_info</code> tag
	 */
	public static CONSTANT_Float_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_Float_info res = new CONSTANT_Float_info();
		if(classFileData[offset]!=cp_info.CONSTANT_Float)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		res.value = Float.intBitsToFloat(Util.byte2Int(classFileData, offset));
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
     * <p>The <code>value</code> item of the <code>CONSTANT_Float_info</code> structure represents the value of the <code>float</code> 
	 * constant in IEEE 754 floating-point single format. The bytes of the single format representation are stored in 
	 * big-endian (high byte first) order.</p>
	 * <p>The value represented by the <code>CONSTANT_Float_info</code> structure is determined as follows. 
	 * The bytes of the value are first converted into an <code>int</code> constant bits. Then:</p>
	 * <ul>
	 * <li>If bits is 0x7f800000, the float value will be positive infinity.</li>
	 * <li>If bits is 0xff800000, the float value will be negative infinity.</li>
	 * <li>If bits is in the range 0x7f800001 through 0x7fffffff or in the range 0xff800001 through 0xffffffff, the 
	 * float value will be <code>NaN</code>.</li>
	 * <li>In all other cases, let <i>s</i>, <i>e</i>, and <i>m</i> be three values that might be computed from bits:<br>
	 * <code>int s = ((bits &gt;&gt; 31) == 0) ? 1 : -1;<br>
	 * int e = ((bits &gt;&gt; 23) &amp; 0xff);<br>
	 * int m = (e == 0) ? (bits &amp; 0x7fffff) &lt;&lt; 1 : (bits &amp; 0x7fffff) | 0x800000;</code><br>
	 * Then the float value equals the result of the mathematical expression <i>s</i> · <i>m</i> · 2 <sup><i>e</i>-150</sup>.
	 * </li></ul>
     * @return value of <code>value</code> field
     */
	public float getValue() { return value; }
}
