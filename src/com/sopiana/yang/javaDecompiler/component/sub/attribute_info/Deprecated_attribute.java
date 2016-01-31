package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
/**
 * Provides abstraction for <code>Deprecated_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>Deprecated_attribute</code> is an optional fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure. A class, interface, method, or field may be marked using a <code>Deprecated_attribute</code> 
 * to indicate that the class, interface, method, or field has been superseded.</p>
 * <p>A run-time interpreter or tool that reads the class file format, such as a compiler, can use this marking to advise the user that 
 * a superseded class, interface, method, or field is being referred to. The presence of a Deprecated attribute does not alter the semantics 
 * of a class or interface.</p>
 * <p>The <code>Deprecated_attribute</code> has the following format:</p>
 * <code>Deprecated_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class Deprecated_attribute extends attribute_info
{
	/**
	 * Factory method to generate a <code>Deprecated_attribute</code> instance.
	 * 
	 * <p>The <code>Deprecated_attribute</code> is an optional fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
	 * <code>field_info</code>, or <code>method_info</code> structure. A class, interface, method, or field may be marked using a <code>Deprecated_attribute</code> 
	 * to indicate that the class, interface, method, or field has been superseded.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @return instance of <code>Deprecated_attribute</code>
	 */
	public static Deprecated_attribute getInstance(short attribute_name_index, int attribute_length)
	{
		Deprecated_attribute res = new Deprecated_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		return res;
	}
	
	public String toString(int indent, cp_info[] constant_pool) 
	{
		return super.toString(indent, constant_pool);
	}
}
