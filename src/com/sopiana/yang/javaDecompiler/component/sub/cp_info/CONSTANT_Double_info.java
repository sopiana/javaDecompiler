package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>CONSTANT_Double_info</code> item in <code>constant_pool</code> table
 * 
 * <p>The <code>CONSTANT_Double_info</code> represent 8-byte numeric double constants:</p>
 * <code>CONSTANT_Double_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 high_bytes;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 low_bytes;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class CONSTANT_Double_info extends cp_info
{
	/**
	 * <p>The <code>value</code> represented by the <code>CONSTANT_Double_info</code> structure is determined as follows. 
	 * The <code>high_bytes</code> and <code>low_bytes</code> items are converted into the <code>long</code> constant bits, 
	 * which is equal to:<br>
	 * <code>((long) high_bytes &lt;&lt; 32) + low_bytes</code></p>
	 * <p>Then:</p>
	 * <ul>
	 * <li>If bits is 0x7ff0000000000000L, the double value will be positive infinity.</li>
	 * <li>If bits is 0xfff0000000000000L, the double value will be negative infinity.</li>
	 * <li>If bits is in the range 0x7ff0000000000001L through 0x7fffffffffffffffL or in the range 0xfff0000000000001L 
	 * through 0xffffffffffffffffL, the double value will be <code>NaN</code>.</li>
	 * <li>In all other cases, let <i>s</i>, <i>e</i>, and <i>m</i> be three values that might be computed from bits:<br>
	 * <code>int s = ((bits &gt;&gt; 63) == 0) ? 1 : -1;<br>
	 * int e = (int)((bits &gt;&gt; 52) &amp; 0x7ffL);<br>
	 * long m = (e == 0) ? (bits &amp; 0xfffffffffffffL) &lt;&lt; 1 :  (bits &amp; 0xfffffffffffffL) | 0x10000000000000L;</code></li>
	 * </ul>
	 * <p>Then the floating-point value equals the double value of the mathematical expression <i>s</i> · <i>m</i> · 2 <sup><i>e</i>-1075</sup>.</p>
	 */
	private double value;
	/**
	 * Factory method to generate a <code>CONSTANT_Double_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>Each <code>CONSTANT_Double_info</code> should begin with 1 byte of <code>tag</code> describing type of <code>constant_pool</code> entry, 
	 * followed by 4 bytes of <code>high_bytes</code> and 4 bytes of <code>low_bytes</code> describing the value of entry.
	 * These two 4 bytes value then will be converted to <code>double</code> value.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_Double_info</code> tag
	 */
	public static CONSTANT_Double_info getInstance(byte[] classFileData, int offset) throws decompilerException
    {
		CONSTANT_Double_info res = new CONSTANT_Double_info();
		if(classFileData[offset]!=cp_info.CONSTANT_Double)
			throw new decompilerException("Invalid tag found in inputed arguments");
		res.tag = classFileData[offset++];
		long temp = Util.byte2Int(classFileData,offset)<<32; offset+=4;
		temp |= Util.byte2Int(classFileData,offset);
		res.value = Double.longBitsToDouble(temp);
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
     * <p>The <code>value</code> represented by the <code>CONSTANT_Double_info</code> structure is determined as follows. 
	 * The <code>high_bytes</code> and <code>low_bytes</code> items are converted into the <code>long</code> constant bits, 
	 * which is equal to:<br>
	 * <code>((long) high_bytes &lt;&lt; 32) + low_bytes</code></p>
	 * <p>Then:</p>
	 * <ul>
	 * <li>If bits is 0x7ff0000000000000L, the double value will be positive infinity.</li>
	 * <li>If bits is 0xfff0000000000000L, the double value will be negative infinity.</li>
	 * <li>If bits is in the range 0x7ff0000000000001L through 0x7fffffffffffffffL or in the range 0xfff0000000000001L 
	 * through 0xffffffffffffffffL, the double value will be <code>NaN</code>.</li>
	 * <li>In all other cases, let <i>s</i>, <i>e</i>, and <i>m</i> be three values that might be computed from bits:<br>
	 * <code>int s = ((bits &gt;&gt; 63) == 0) ? 1 : -1;<br>
	 * int e = (int)((bits &gt;&gt; 52) &amp; 0x7ffL);<br>
	 * long m = (e == 0) ? (bits &amp; 0xfffffffffffffL) &lt;&lt; 1 :  (bits &amp; 0xfffffffffffffL) | 0x10000000000000L;</code></li>
	 * </ul>
	 * <p>Then the floating-point value equals the double value of the mathematical expression <i>s</i> · <i>m</i> · 2 <sup><i>e</i>-1075</sup>.</p>
     * @return value of <code>value</code> field
     */
	public double getValue() { return value; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res="";
		res+=indentStr+" tag: CONSTANT_Double_info"+"\n";
		res+=indentStr+" value:" +value+"\n";
		return res;
	}
}
