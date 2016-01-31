package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.annotation_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>RuntimeVisibleAnnotations_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>RuntimeVisibleAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure. The <code>RuntimeVisibleAnnotations_attribute</code> records run-time visible 
 * annotations on the declaration of the corresponding class, field, or method. The Java Virtual Machine must make these annotations available so 
 * they can be returned by the appropriate reflective APIs.</p>
 * <p>There may be at most one <code>RuntimeVisibleAnnotations_attribute</code> in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure.</p>
 * <p>The <code>RuntimeVisibleAnnotations_attribute</code> has the following format:</p>
 * <code>RuntimeVisibleAnnotations_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_annotations;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;annotation annotations[num_annotations];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class RuntimeVisibleAnnotations_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>num_annotations</code> item gives the number of run-time visible <code>annotations</code> represented 
	 * by the structure.</p>
	 */
	private short num_annotations;
	/**
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time visible annotation on a declaration.</p>
	 */
	private annotation_info annotations[];	//num_annotations
	/**
	 * Factory method to generate a <code>RuntimeVisibleAnnotations_attribute</code> instance.
	 * 
	 * <p>The <code>RuntimeVisibleAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
	 * <code>field_info</code>, or <code>method_info</code> structure. The <code>RuntimeVisibleAnnotations_attribute</code> records run-time visible 
	 * annotations on the declaration of the corresponding class, field, or method. The Java Virtual Machine must make these annotations available so 
	 * they can be returned by the appropriate reflective APIs.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>RuntimeVisibleAnnotations_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>RuntimeVisibleAnnotations_attribute</code> format
	 */
	public static RuntimeVisibleAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeVisibleAnnotations_attribute res = new RuntimeVisibleAnnotations_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.num_annotations = Util.byte2Short(info);offset+=2;
		res.annotations = new annotation_info[res.num_annotations];
		for(int i=0;i<res.num_annotations;++i)
		{
			res.annotations[i] = annotation_info.getInstance(info, offset);
			offset += res.annotations[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>num_annotations</code> field
	 * 
	 * <p>The value of the <code>num_annotations</code> item gives the number of run-time visible <code>annotations</code> represented 
	 * by the structure.</p>
	 * @return value of <code>num_annotations</code> field
	 */
	public short num_annotations() { return num_annotations; }
	/**
	 * Accessor method to <code>annotations</code> field
	 * 
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time visible annotation on a declaration.</p>
	 * @return value of <code>annotations</code> field
	 */
	public annotation_info[] getAnnotations() { return annotations; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" num_annotations: "+num_annotations+"\n";
		for(int i=0;i<num_annotations;++i)
		{
			res+=indentStr+" annotations["+i+"]: \n";
			res+=annotations[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
