package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
/**
 * Provides abstraction for <code>SourceDebugExtension_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>SourceDebugExtension_attribute</code> is an optional attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
 * structure.</p>
 * <p>There may be at most one <code>SourceDebugExtension_attribute</code> in the <code>attributes</code> table of a <code>ClassFile</code> 
 * structure.</p>
 * <p>The <code>SourceDebugExtension_attribute</code> has the following format:</p>
 * <code>SourceDebugExtension_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 debug_extension[attribute_length];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class SourceDebugExtension_attribute extends attribute_info
{
	/**
	 * <p>The <code>debug_extension</code> array holds extended debugging information which has no semantic effect on the Java Virtual Machine. 
	 * The information is represented using a modified UTF-8 string with no terminating zero byte.</p>
	 */
	private byte debug_extension[];	//attribute_length
	
	/**
	 * Factory method to generate a <code>SourceDebugExtension_attribute</code> instance.
	 * 
	 * <p>The <code>SourceDebugExtension_attribute</code> is an optional attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
	 * structure, holds extended debugging information which has no semantic effect on the Java Virtual Machine. </p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>SourceDebugExtension_attribute</code>
	 */
	public static SourceDebugExtension_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		SourceDebugExtension_attribute res = new SourceDebugExtension_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.debug_extension = Arrays.copyOf(info, attribute_length);
		return res;
	}
	/**
	 * Accessor method to <code>debug_extension</code> field
	 * 
	 * <p>The <code>debug_extension</code> array holds extended debugging information which has no semantic effect on the Java Virtual Machine. 
	 * The information is represented using a modified UTF-8 string with no terminating zero byte.</p>
	 * @return value of <code>debug_extension</code> field
	 */
	public byte[] getDebug_extension() { return debug_extension;}
	
	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		try 
		{
			res+=indentStr+" debug_extension: "+new String(debug_extension, "UTF-8")+"\n";
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
			res+=indentStr+" debug_extension: "+debug_extension.toString()+"\n";
		}
		return res;
	}
}
