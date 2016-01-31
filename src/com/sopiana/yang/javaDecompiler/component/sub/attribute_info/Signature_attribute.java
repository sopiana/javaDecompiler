package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>Signature_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>Signature_attribute</code> is a fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure. A <code>Signature_attribute</code> records a signature for a class, interface, 
 * constructor, method, or field whose declaration in the Java programming language uses type variables or parameterized types. </p>
 * <p>The <code>Signature_attribute</code> has the following format:</p>
 * <code>Signature_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 signature_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class Signature_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>signature_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info structure</code> representing a class signature if this <code>Signature_attribute</code> is an 
	 * attribute of a <code>ClassFile</code> structure; a method signature if this <code>Signature_attribute</code> is an attribute of a <code>method_info</code> 
	 * structure; or a field signature otherwise.</p>
	 */
	private short signature_index;
	/**
	 * Factory method to generate a <code>Signature_attribute</code> instance.
	 * 
	 * <p>The <code>Signature_attribute</code> is a fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
	 * <code>field_info</code>, or <code>method_info</code> structure. A <code>Signature_attribute</code> records a signature for a class, interface, 
	 * constructor, method, or field whose declaration in the Java programming language uses type variables or parameterized types. </p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>Signature_attribute</code>
	 */
	public static Signature_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		Signature_attribute res = new Signature_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.signature_index = Util.byte2Short(info);
		return res;
		
	}
	/**
	 * Accessor method to <code>signature_index</code> field
	 * 
	 * <p>The value of the <code>signature_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info structure</code> representing a class signature if this <code>Signature_attribute</code> is an 
	 * attribute of a <code>ClassFile</code> structure; a method signature if this <code>Signature_attribute</code> is an attribute of a <code>method_info</code> 
	 * structure; or a field signature otherwise.</p>
	 * @return value of <code>signature_index</code> field
	 */
	public short getSignature_index() { return this.signature_index; }

	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" signature_index: @"+signature_index+"\n";
		res+=constant_pool[signature_index].toString(indent+1, constant_pool);
		return res;
	}
}
