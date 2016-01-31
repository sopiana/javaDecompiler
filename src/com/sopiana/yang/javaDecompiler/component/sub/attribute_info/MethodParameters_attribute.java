package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.parameters_info;
/**
 * Provides abstraction for <code>MethodParameters_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>MethodParameters_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>method_info</code> 
 * structure. A <code>MethodParameters_attribute</code> records information about the formal parameters of a method, such as their names.</p>
 * <p>There may be at most one <code>MethodParameters_attribute</code> in the <code>attributes</code> table of a <code>method_info</code> structure.</p>
 * <p>The <code>MethodParameters_attribute</code> has the following format:</p>
 * <code>MethodParameters_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 parameters_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ 
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 access_flags;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} parameters[parameters_count];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class MethodParameters_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>parameters_count</code> item indicates the number of parameter descriptors in the method descriptor 
	 * referenced by the <code>descriptor_index</code> of the attribute's enclosing <code>method_info</code> structure.</p>
	 */
	private byte parameters_count;
	/**
	 * <p>Each entry in the <code>parameters</code> array contains the following pair of items <code>name_index</code>, <code>access_flags</code></p>
	 */
	private parameters_info parameters[];	//parameters_count
	/**
	 * Factory method to generate a <code>MethodParameters_attribute</code> instance.
	 * 
	 * <p>The <code>MethodParameters_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>method_info</code> 
	 * structure. A <code>MethodParameters_attribute</code> records information about the formal parameters of a method, such as their names.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>MethodParameters_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>MethodParameters_attribute</code> format
	 */
	public static MethodParameters_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
 	{
 		int offset = 0;
 		MethodParameters_attribute res = new MethodParameters_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.parameters_count = info[offset++];
 		res.parameters = new parameters_info[res.parameters_count&0xFF];
 		for(int i=0;i<res.parameters_count;++i)
 		{
 			res.parameters[i] = parameters_info.getInstance(info,offset);
 			offset+=res.parameters[i].getSize();
 		}
 		return res;
 	}
	/**
	 * Accessor method to <code>parameters_count</code> field
	 * 
	 * <p>The value of the <code>parameters_count</code> item indicates the number of parameter descriptors in the method descriptor 
	 * referenced by the <code>descriptor_index</code> of the attribute's enclosing <code>method_info</code> structure.</p>
	 * @return value of <code>parameters_count</code> field
	 */
	public byte getParameters_count() { return parameters_count; }
	/**
	 * Accessor method to <code>parameters</code> field
	 * 
	 * <p>Each entry in the <code>parameters</code> array contains the following pair of items <code>name_index</code>, <code>access_flags</code></p>
	 * @return value of <code>parameters</code> field
	 */
	public parameters_info[] getParameters() { return parameters; }

	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" parameters_count: "+parameters_count+"\n";
		for(int i=0;i<parameters_count;++i)
		{
			res+=indentStr+" parameters["+i+"]: \n";
			res+=parameters[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
