package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.InnerClass_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>InnerClasses_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>InnerClasses_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
 * structure.</p>
 * <p>If the constant pool of a class or interface <i>C</i> contains at least one <code>CONSTANT_Class_info</code> entry which represents a 
 * class or interface that is not a member of a package, then there must be exactly one <code>InnerClasses_attribute</code> in the attributes 
 * table of the <code>ClassFile</code> structure for <i>C</i>.</p>
 * <p>The <code>InnerClasses_attribute</code> has the following format:</p>
 * <code>InnerClasses_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 number_of_classes;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ 
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 inner_class_info_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 outer_class_info_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 inner_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 inner_class_access_flags;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} classes[number_of_classes];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class InnerClasses_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>number_of_classes</code> item indicates the number of entries in the <code>classes</code> array</p>
	 */
	private short number_of_classes;
	/**
	 * <p>Every <code>CONSTANT_Class_info</code> entry in the <code>constant_pool</code> table which represents a class or interface <i>C</i> 
	 * that is not a package member must have exactly one corresponding entry in the classes array.</p>
	 * <p><small>If a class or interface has members that are classes or interfaces, its <code>constant_pool</code> table (and hence its 
	 * <code>InnerClasses_attribute</code>) must refer to each such member, even if that member is not otherwise mentioned by the class.</small></p>
	 * <p><small>In addition, the <code>constant_pool</code> table of every nested class and nested interface must refer to its enclosing 
	 * class, so altogether, every nested class and nested interface will have <code>InnerClasses</code> information for each enclosing class 
	 * and for each of its own nested classes and interfaces.</small></p>
	 */
	private InnerClass_info classes[]; //number_of_classes
	/**
	 * Factory method to generate a <code>InnerClasses_attribute</code> instance.
	 * 
	 * <p>The <code>InnerClasses_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
	 * structure, indicates the structure of inner class</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>InnerClasses_attribute</code>
	 */
	public static InnerClasses_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) 
	{
		int offset = 0;
		InnerClasses_attribute res = new InnerClasses_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.number_of_classes = Util.byte2Short(info);offset+=2;
		res.classes = new InnerClass_info[res.number_of_classes];
		for(int i=0; i<res.number_of_classes;++i)
		{
			res.classes[i] = InnerClass_info.getInstance(info, offset);
			offset+=res.classes[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>number_of_classes</code> field
	 * 
	 * <p>The value of the <code>number_of_classes</code> item indicates the number of entries in the <code>classes</code> array</p>
	 * @return value of <code>number_of_classes</code> field
	 */
	public short getNumber_of_classes() { return number_of_classes; }
	/**
	 * Accessor method to <code>classes</code> field
	 * 
	 * <p>Every <code>CONSTANT_Class_info</code> entry in the <code>constant_pool</code> table which represents a class or interface <i>C</i> 
	 * that is not a package member must have exactly one corresponding entry in the classes array.</p>
	 * <p><small>If a class or interface has members that are classes or interfaces, its <code>constant_pool</code> table (and hence its 
	 * <code>InnerClasses_attribute</code>) must refer to each such member, even if that member is not otherwise mentioned by the class.</small></p>
	 * <p><small>In addition, the <code>constant_pool</code> table of every nested class and nested interface must refer to its enclosing 
	 * class, so altogether, every nested class and nested interface will have <code>InnerClasses</code> information for each enclosing class 
	 * and for each of its own nested classes and interfaces.</small></p>
	 * @return value of <code>classes</code> field
	 */
	public InnerClass_info[] getClasses() { return classes; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" number_of_classes: "+number_of_classes+"\n";
		for(int i=0;i<number_of_classes;++i)
		{
			res+=indentStr+" classes["+i+"]: \n";
			res+=classes[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
