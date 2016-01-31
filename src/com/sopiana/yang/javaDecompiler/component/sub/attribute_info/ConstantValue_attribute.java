package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>ConstantValue_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>ConstantValue_attribute</code> is a fixed-length attribute in the <code>attributes</code> table of a <code>field_info</code> 
 * structure. A <code>ConstantValue_attribute</code> represents the value of a constant expression, and is used as follows:</p>
 * <ul>
 * <li>If the <code>ACC_STATIC flag</code> in the <code>access_flags</code> item of the <code>field_info</code> structure is set, then the 
 * field represented by the <code>field_info</code> structure is assigned the value represented by its <code>ConstantValue_attribute<code> 
 * as part of the initialization of the class or interface declaring the field. This occurs prior to the invocation of the class or interface 
 * initialization method of that class or interface.</li>
 * <li>Otherwise, the Java Virtual Machine must silently ignore the attribute </li>
 * </ul>
 * <p>There may be at most one <code>ConstantValue_attribute</code> in the <code>attributes</code> table of a <code>field_info</code> structure.</p>
 * <p>The <code>ConstantValue_attribute</code> has the following format:</p>
 * <code>ConstantValue_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 constantvalue_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class ConstantValue_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>constantvalue_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index gives the constant value represented by this attribute. </p>
	 */
	private short constantvalue_index;
	/**
	 * Factory method to generate a <code>ConstantValue_attribute</code> instance.
	 * 
	 * <p>The <code>ConstantValue_attribute </code> is a fixed-length attribute in the <code>attributes</code> table represents 
	 * the value of a constant expression</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>ConstantValue_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>BootstrapMethods_attribute</code> format
	 */
	public static ConstantValue_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		ConstantValue_attribute res = new ConstantValue_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.constantvalue_index = Util.byte2Short(info);
		return res;
	}
	/**
	 * Accessor method to <code>constantvalue_index</code> field
	 * 
	 * <p>The value of the <code>constantvalue_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index gives the constant value represented by this attribute. </p>
	 * @return value of <code>constantvalue_index</code> field
	 */
	public short getConstantvalue_index() { return this.constantvalue_index; }

	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		try
    	{
    		res+=indentStr+" constantvalue: \n";
    		res+=constant_pool[constantvalue_index].toString(indent+1, constant_pool)+"\n";
    	}
    	catch(Exception e)
    	{
    		res+=indentStr+" constantvalue_index: @"+constantvalue_index+"\n";
    	}
		return res;
	}
}
