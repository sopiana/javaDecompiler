package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
/**
 * Provides abstraction for <code>Synthetic_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>Synthetic_attribute</code> is a fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure. A class member that does not appear in the source code must be marked using 
 * a <code>Synthetic_attribute</code>, or else it must have its <code>ACC_SYNTHETIC</code> flag set. The only exceptions to this requirement are 
 * compiler-generated methods which are not considered implementation artifacts, namely the instance initialization method representing a default 
 * constructor of the Java programming language, the class initialization method, and the <code>Enum.values()</code> and <code>Enum.valueOf()</code> 
 * methods.</p>
 * <p>The <code>Synthetic_attribute</code> has the following format:</p>
 * <code>Synthetic_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class Synthetic_attribute extends attribute_info
{
	/**
	 * Factory method to generate a <code>Synthetic_attribute</code> instance.
	 * 
	 * <p>The <code>Synthetic_attribute</code> is a fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
	 * <code>field_info</code>, or <code>method_info</code> structure. A class member that does not appear in the source code must be marked using 
	 * a <code>Synthetic_attribute</code>, or else it must have its <code>ACC_SYNTHETIC</code> flag set.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @return instance of <code>Synthetic_attribute</code>
	 */
	public static Synthetic_attribute getInstance(short attribute_name_index, int attribute_length)
	{
		Synthetic_attribute res = new Synthetic_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		return res;
	}

	public String toString(int indent, cp_info[] constant_pool) {
		return super.toString(indent, constant_pool);
	}
}
