package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.parameter_annotations_info;
/**
 * Provides abstraction for <code>RuntimeVisibleParameterAnnotations_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>RuntimeVisibleParameterAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of the 
 * <code>method_info</code> structure. The <code>RuntimeVisibleParameterAnnotations_attribute</code> records run-time visible annotations on the 
 * declarations of formal parameters of the corresponding method.</p>
 * <p>The Java Virtual Machine must make these annotations available so they can be returned by the appropriate reflective APIs.</p>
 * <p>There may be at most one <code>RuntimeVisibleParameterAnnotations_attribute</code> in the <code>attributes</code> table of a <code>method_info</code> 
 * structure.</p>
 * <p>The <code>RuntimeVisibleParameterAnnotations_attribute</code> has the following format:</p>
 * <code>RuntimeVisibleParameterAnnotations_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 num_parameters;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 num_annotations;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;annotation annotations[num_annotations];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} parameter_annotations[num_parameters];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class RuntimeVisibleParameterAnnotations_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>num_parameters</code> item gives the number of formal parameters of the method represented by the <code>method_info</code> 
	 * structure on which the annotation occurs.</p>
	 */
	private byte num_parameters;
	/**
	 * <p>Each entry in the <code>parameter_annotations</code> table represents all of the runtime visible annotations on the declaration of a 
	 * single formal parameter. The <i>i</i>'th entry in the table corresponds to the <i>i</i>'th formal parameter in the method descriptor.</p> 
	 */
	private parameter_annotations_info parameter_annotations[];	//num_parameters
	/**
	 * Factory method to generate a <code>RuntimeVisibleParameterAnnotations_attribute</code> instance.
	 * 
	 * <p>The <code>RuntimeVisibleParameterAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of the 
	 * <code>method_info</code> structure. The <code>RuntimeVisibleParameterAnnotations_attribute</code> records run-time visible annotations on the 
	 * declarations of formal parameters of the corresponding method.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>RuntimeVisibleParameterAnnotations_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>RuntimeVisibleParameterAnnotations_attribute</code> format
	 */
	public static RuntimeVisibleParameterAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeVisibleParameterAnnotations_attribute res = new RuntimeVisibleParameterAnnotations_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.num_parameters = info[offset++];
		res.parameter_annotations = new parameter_annotations_info[res.num_parameters];
		for(int i=0;i<res.num_parameters;++i)
		{
			res.parameter_annotations[i] = parameter_annotations_info.getInstance(info, offset);
			offset += res.parameter_annotations[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>num_parameters</code> field
	 * 
	 * <p>The value of the <code>num_parameters</code> item gives the number of formal parameters of the method represented by the <code>method_info</code> 
	 * structure on which the annotation occurs.</p>
	 * @return value of <code>num_parameters</code> field
	 */
	public byte getNum_parameters() { return num_parameters; }
	/**
	 * Accessor method to <code>parameter_annotations</code> field
	 * 
	 * <p>Each entry in the <code>parameter_annotations</code> table represents all of the runtime visible annotations on the declaration of a 
	 * single formal parameter. The <i>i</i>'th entry in the table corresponds to the <i>i</i>'th formal parameter in the method descriptor.</p> 
	 * @return value of <code>parameter_annotations</code> field
	 */
	public parameter_annotations_info[] getParameter_annotations() { return parameter_annotations; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" num_parameters: "+num_parameters+"\n";
		for(int i=0;i<num_parameters;++i)
		{
			res+=indentStr+" parameter_annotations["+i+"]: \n";
			res+=parameter_annotations[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
