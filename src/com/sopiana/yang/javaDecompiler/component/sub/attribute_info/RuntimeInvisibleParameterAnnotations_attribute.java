package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.parameter_annotations_info;

/**
 * Provides abstraction for <code>RuntimeInvisibleParameterAnnotations_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>RuntimeInvisibleParameterAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a 
 * <code>method_info</code> structure. The <code>RuntimeInvisibleParameterAnnotations_attribute</code> records run-time invisible annotations 
 * on the declarations of formal parameters of the corresponding method.</p>
 * <p>There may be at most one <code>RuntimeInvisibleParameterAnnotations_attribute</code> in the attributes table of a <code>method_info</code> 
 * structure.</p>
 * <p><small>The <code>RuntimeInvisibleParameterAnnotations_attribute</code> is similar to the <code>RuntimeVisibleParameterAnnotations_attribute</code>, 
 * except that the annotations represented by a <code>RuntimeInvisibleParameterAnnotations_attribute</code> must not be made available for 
 * return by reflective APIs, unless the Java Virtual Machine has specifically been instructed to retain these annotations via some implementation 
 * specific mechanism such as a command line flag. In the absence of such instructions, the Java Virtual Machine ignores this attribute.</small></p>
 * <p>The <code>RuntimeInvisibleParameterAnnotations_attribute</code> has the following format:</p>
 * <code>RuntimeInvisibleParameterAnnotations_attribute {<br>
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
public class RuntimeInvisibleParameterAnnotations_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>num_parameters</code> item gives the number of formal parameters of the method represented by the 
	 * <code>method_info</code> structure on which the annotation occurs.</p>
	 */
	private byte num_parameters;
	/**
	 * <p>Each entry in the <code>parameter_annotations</code> table represents all of the runtime invisible annotations on the declaration of 
	 * a single formal parameter.The <i>i</i>'th entry in the table corresponds to the <i>i</i>'th formal parameter in the method descriptor.</p>
	 */
	private parameter_annotations_info parameter_annotations[];	//num_parameters
	/**
	 * Factory method to generate a <code>RuntimeInvisibleParameterAnnotations_attribute</code> instance.
	 * 
	 * <p>The <code>RuntimeInvisibleParameterAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a 
	 * <code>method_info</code> structure. The <code>RuntimeInvisibleParameterAnnotations_attribute</code> records run-time invisible annotations 
	 * on the declarations of formal parameters of the corresponding method.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>RuntimeInvisibleParameterAnnotations_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>RuntimeInvisibleParameterAnnotations_attribute</code> format
	 */
	public static RuntimeInvisibleParameterAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeInvisibleParameterAnnotations_attribute res = new RuntimeInvisibleParameterAnnotations_attribute();
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
	 * <p>The value of the <code>num_parameters</code> item gives the number of formal parameters of the method represented by the 
	 * <code>method_info</code> structure on which the annotation occurs.</p>
	 * @return value of <code>num_parameters</code> field
	 */
	public byte num_parameters() { return num_parameters; }
	/**
	 * Accessor method to <code>parameter_annotations</code> field
	 * 
	 * <p>Each entry in the <code>parameter_annotations</code> table represents all of the runtime invisible annotations on the declaration of 
	 * a single formal parameter.The <i>i</i>'th entry in the table corresponds to the <i>i</i>'th formal parameter in the method descriptor.</p>
	 * @return value of <code>parameter_annotations</code> field
	 */
	public parameter_annotations_info[] parameter_annotations() { return parameter_annotations; }
	
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
