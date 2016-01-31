package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>EnclosingMethod_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>EnclosingMethod_attribute</code> is a fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
 * structure. A class must have an <code>EnclosingMethod_attribute</code> if and only if it represents a local class or an anonymous class.</p>
 * <p>There may be at most one <code>EnclosingMethod_attribute</code> in the <code>attributes</code> table of a <code>ClassFile</code> structure.</p>
 * <p>The <code>EnclosingMethod_attribute</code> has the following format:</p>
 * <code>EnclosingMethod_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 class_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 method_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class EnclosingMethod_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>class_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Class_info</code> structure representing the innermost class that encloses the declaration of 
	 * the current class.</p>
	 */
	private short class_index;
	/**
	 * <p>If the current class is not immediately enclosed by a method or constructor, then the value of the <code>method_index</code> item 
	 * must be zero.<p>
	 * <p><small>In particular, <code>method_index</code> must be zero if the current class was immediately enclosed in source code by an 
	 * instance initializer, static initializer, instance variable initializer, or class variable initializer. (The first two concern both 
	 * local classes and anonymous classes, while the last two concern anonymous classes declared on the right hand side of a field assignment.)</small></p>
	 * <p>Otherwise, the value of the <code>method_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_NameAndType_info</code> structure representing the name and type 
	 * of a method in the class referenced by the <code>class_index</code> attribute above.</p>
	 * <p><small>It is the responsibility of a Java compiler to ensure that the method identified via the <code>method_index</code> is indeed 
	 * the closest lexically enclosing method of the class that contains this <code>EnclosingMethod_attribute</code>.</small></p>
	 */
	private short method_index;
	/**
	 * Factory method to generate a <code>EnclosingMethod_attribute</code> instance.
	 * 
	 * <p>The <code>EnclosingMethod_attribute</code> is a fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
	 * structure. A class must have an <code>EnclosingMethod_attribute</code> if and only if it represents a local class or an anonymous class.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>EnclosingMethod_attribute</code>
	 */
	public static EnclosingMethod_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		int offset = 0;
		EnclosingMethod_attribute res = new EnclosingMethod_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.class_index = Util.byte2Short(info);offset+=2;
		res.method_index = Util.byte2Short(info, offset);
		return res;
		
	}
	/**
	 * Accessor method to <code>class_index</code> field
	 * 
	 * <p>The value of the <code>class_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Class_info</code> structure representing the innermost class that encloses the declaration of 
	 * the current class.</p>
	 * @return value of <code>class_index</code> field
	 */
	public short getClass_index() { return this.class_index; }
	/**
	 * Accessor method to <code>method_index</code> field
	 * 
	 * <p>If the current class is not immediately enclosed by a method or constructor, then the value of the <code>method_index</code> item 
	 * must be zero.</p>
	 * <p><small>In particular, <code>method_index</code> must be zero if the current class was immediately enclosed in source code by an 
	 * instance initializer, static initializer, instance variable initializer, or class variable initializer. (The first two concern both 
	 * local classes and anonymous classes, while the last two concern anonymous classes declared on the right hand side of a field assignment.)</small></p>
	 * <p>Otherwise, the value of the <code>method_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_NameAndType_info</code> structure representing the name and type 
	 * of a method in the class referenced by the <code>class_index</code> attribute above.</p>
	 * <p><small>It is the responsibility of a Java compiler to ensure that the method identified via the <code>method_index</code> is indeed 
	 * the closest lexically enclosing method of the class that contains this <code>EnclosingMethod_attribute</code>.</small></p>
	 * @return value of <code>method_index</code> field
	 */
	public short getMethod_index(){ return this.method_index; }

	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" class_index: \n";
		res+=constant_pool[class_index].toString(indent+1, constant_pool)+"\n";
		res+=indentStr+" method_index: "+method_index+"\n";
		return res;
	}
}
