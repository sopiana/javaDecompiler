package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.element_value;
/**
 * Provides abstraction for <code>AnnotationDefault_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>AnnotationDefault attribute</code> is a variable-length attribute in the <code>attributes</code> table of certain 
 * <code>method_info</code> structures, namely those representing elements of annotation types. The <code>AnnotationDefault</code> attribute 
 * records the default value for the element represented by the <code>method_info</code> structure. The Java Virtual Machine must make this 
 * default value available so it can be applied by appropriate reflective APIs.</p>
 * <p>There may be at most one <code>AnnotationDefault</code> attribute in the attributes table of a <code>method_info</code> structure which 
 * represents an element of an annotation type.</p>
 * <p>The <code>AnnotationDefault</code> attribute has the following format:</p>
 * <code>AnnotationDefault_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;element_value default_value;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class AnnotationDefault_attribute extends attribute_info
{
	/**
	 * The <code>default_value</code> item represents the default value of the annotation type element represented by the <code>method_info</code> 
	 * structure enclosing this <code>AnnotationDefault</code> attribute.
	 */
	private element_value default_value;
	/**
	 * Factory method to generate a <code>CONSTANT_Class_info</code> instance from given array of byte in specific offset.
	 * 
	 * <p>The <code>AnnotationDefault attribute</code> is a variable-length attribute in the <code>attributes</code> table of certain 
	 * <code>method_info</code> structures, namely those representing elements of annotation types. It started with 2 bytes of <code>name_index</code>, 
	 * 2 bytes of <code>attribute_length</code> and variable-length <code>default_value</code></p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>CONSTANT_Class_info</code>
	 * @throws decompilerException decompilerException if supplied <code>classFileData</code> has invalid <code>CONSTANT_Class_info</code> tag
	 */
	public static AnnotationDefault_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
 	{
 		int offset = 0;
 		AnnotationDefault_attribute res = new AnnotationDefault_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.default_value = element_value.getInstance(info, offset);
 		return res;
 	}
	/**
	 * Accessor method to <code>element_value</code> field
	 * 
	 * <p>The <code>default_value</code> item represents the default value of the annotation type element represented by the <code>method_info</code> 
	 * structure enclosing this <code>AnnotationDefault</code> attribute.</p>
	 * @return value of <code>element_value</code> field
	 */
	public element_value getDefault_value() { return default_value; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+"default_value:\n";
		res+=default_value.toString(indent+1, constant_pool);
		return res;
	}
}
