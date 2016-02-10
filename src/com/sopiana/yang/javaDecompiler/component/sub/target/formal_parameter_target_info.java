package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
/**
 * Provides abstraction for <code>formal_parameter_target_info</code> item
 * 
 * <p>The <code>formal_parameter_target</code> item indicates that an annotation appears on the type in a formal parameter declaration of a 
 * method, constructor, or lambda expression.</p>
 * <p>The <code>formal_parameter_target_info</code> structure has the following format:</p>
 * <code>formal_parameter_target_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 formal_parameter_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class formal_parameter_target_info extends target_info
{
	/**
	 * <p>The value of the <code>formal_parameter_index</code> item specifies which formal parameter declaration has an annotated type. A 
	 * formal_parameter_index value of 0 specifies the first formal parameter declaration.</p>
	 * <p><small>The <code>formal_parameter_target</code> item records that a formal parameter's type is annotated, but does not record the 
	 * type itself. The type may be found by inspecting the method descriptor of the <code>method_info</code> structure enclosing the 
	 * <code>RuntimeVisibleTypeAnnotations</code> attribute. A <code>formal_parameter_index</code> value of 0 indicates the first parameter 
	 * descriptor in the method descriptor.</small></p>
	 */
	private byte formal_parameter_index;
	/**
	 * Factory method to generate a <code>formal_parameter_target_info</code> instance.
	 * 
	 * <p>The <code>formal_parameter_target</code> item indicates that an annotation appears on the type in a formal parameter declaration of a 
	 * method, constructor, or lambda expression.</p> 
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>formal_parameter_target_info</code>
	 */
	public static formal_parameter_target_info getInstance(byte[]classFileData, int offset)
	{
		formal_parameter_target_info res = new formal_parameter_target_info();
		res.formal_parameter_index = classFileData[offset];
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>formal_parameter_target_info</code> entry components</p>
	 * @return size of <code>formal_parameter_target_info</code> entry
	 */
	public int getSize() { return 1; }
	/**
	 * Accessor method to <code>formal_parameter_index</code> field
	 * 
	 * <p>The value of the <code>formal_parameter_index</code> item specifies which formal parameter declaration has an annotated type. A 
	 * formal_parameter_index value of 0 specifies the first formal parameter declaration.</p>
	 * <p><small>The <code>formal_parameter_target</code> item records that a formal parameter's type is annotated, but does not record the 
	 * type itself. The type may be found by inspecting the method descriptor of the <code>method_info</code> structure enclosing the 
	 * <code>RuntimeVisibleTypeAnnotations</code> attribute. A <code>formal_parameter_index</code> value of 0 indicates the first parameter 
	 * descriptor in the method descriptor.</small></p>
	 * @return value of <code>formal_parameter_index</code> field
	 */
	public byte getFormal_parameter_index() { return formal_parameter_index; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = class_info.getIndent(indent);
		String res= indentStr+" formal_parameter_index: "+formal_parameter_index+"\n";
		return res;
	}
}
