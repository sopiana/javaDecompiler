package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>parameters_info</code> item
 * 
 * <p>The <code>parameters_info</code> is a fixed-length sub-element structure used in <code>MethodParameters_attribute</code> 
 * item. Each entry in the <code>parameters_info</code> table represents the parameter information.</p>
 * <p>The <code>parameters_info</code> structure has the following format:</p>
 * <code>parameters_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 access_flags;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class parameters_info 
{
	/**
	 * Indicates that the formal parameter was declared final.
	 */
	public static final short ACC_FINAL = 0x0010; 
	/**
	 * Indicates that the formal parameter was not explicitly or implicitly declared in source code, according to the specification of the 
	 * language in which the source code was written. (The formal parameter is an implementation artifact of the compiler which produced this class file.)
	 */
	public static final short ACC_SYNTHETIC = 0x1000;
	/**
	 * Indicates that the formal parameter was implicitly declared in source code, according to the specification of the language in which 
	 * the source code was written (JLS §13.1). (The formal parameter is mandated by a language specification, so all compilers for the language must emit it.)
	 */
	public static final short ACC_MANDATED = (short)0x8000;

	/**
	 * <p>The value of the <code>name_index</code> item must either be zero or a valid index into the <code>constant_pool table</code>. If 
	 * the value of the <code>name_index</code> item is zero, then this parameters element indicates a formal parameter with no name.</p>
	 * <p>If the value of the <code>name_index</code> item is nonzero, the <code>constant_pool</code> entry at that index must be a 
	 * <code>CONSTANT_Utf8_info</code> structure representing a valid unqualified name denoting a formal parameter.
	 */
	private short name_index;
	/**
	 * <p>The value of the <code>inner_class_access_flags</code> item is a mask of flags used to denote access permissions to and properties of 
	 * a parameter</p>
	 */
	private short access_flags;
	/**
	 * Factory method to generate a <code>parameters_info</code> instance.
	 * 
	 * <p>The <code>parameters_info</code> is a fixed-length sub-element structure used in <code>MethodParameters_attribute</code> 
	 * item. Each entry in the <code>parameters_info</code> table represents the parameter information.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>parameters_info</code>
	 */
	public static parameters_info getInstance(byte[]classFileData, int offset)
	{
		parameters_info res = new parameters_info();
		res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.access_flags = Util.byte2Short(classFileData,offset);
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>parameters_info</code> entry components</p>
	 * @return size of <code>parameters_info</code> entry
	 */
	public int getSize() { return 4; }
	/**
	 * Accessor method to <code>name_index</code> field
	 * 
	 * <p>The value of the <code>name_index</code> item must either be zero or a valid index into the <code>constant_pool table</code>. If 
	 * the value of the <code>name_index</code> item is zero, then this parameters element indicates a formal parameter with no name.</p>
	 * <p>If the value of the <code>name_index</code> item is nonzero, the <code>constant_pool</code> entry at that index must be a 
	 * <code>CONSTANT_Utf8_info</code> structure representing a valid unqualified name denoting a formal parameter.</p>
	 * @return value of <code>name_index</code> field
	 */
	public short getName_index() { return name_index; }
	/**
	 * Accessor method to <code>access_flags</code> field
	 * 
	 * <p>The value of the <code>inner_class_access_flags</code> item is a mask of flags used to denote access permissions to and properties of 
	 * a parameter</p>
	 * @return value of <code>access_flags</code> field
	 */
	public short getAccess_flags() { return access_flags; }
	
	public static String getAccessModifier(short access_flag)
	{
		String res="";
		if((access_flag & ACC_FINAL) == ACC_FINAL)
			res += "final ";
		return res;
	}
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" name_index: "+name_index+"\n";
		res+=indentStr+" access_flags: "+access_flags+" "+getAccessModifier(access_flags)+"\n";
		return res;
	}
}
