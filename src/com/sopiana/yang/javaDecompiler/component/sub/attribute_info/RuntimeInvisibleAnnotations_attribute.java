package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.annotation_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>RuntimeInvisibleAnnotations_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>RuntimeInvisibleAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure. The <code>RuntimeInvisibleAnnotations_attribute</code> records run-time 
 * invisible annotations on the declaration of the corresponding class, method, or field.</p>
 * <p>There may be at most one <code>RuntimeInvisibleAnnotations_attribute</code> in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure.</p>
 * <p><small>The <code>RuntimeInvisibleAnnotations_attribute</code> is similar to the <code>RuntimeVisibleAnnotations_attribute</code>, except that 
 * the annotations represented by a <code>RuntimeInvisibleAnnotations_attribute</code> must not be made available for return 
 * by reflective APIs, unless the Java Virtual Machine has been instructed to retain these annotations via some implementation-specific 
 * mechanism such as a command line flag. In the absence of such instructions, the Java Virtual Machine ignores this attribute.</small></p>
 * <p>The <code>RuntimeInvisibleAnnotations_attribute</code> has the following format:</p>
 * <code>RuntimeInvisibleAnnotations_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_annotations;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;annotation annotations[num_annotations];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class RuntimeInvisibleAnnotations_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>num_annotations</code> item gives the number of run-time invisible <code>annotations</code> represented by 
	 * the structure.</p>
	 */
	private short num_annotations;
	/**
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time invisible annotation on a declaration. The annotation 
	 * structure is specified in <code>annotation_info</code> structure.</p>
	 */
	private annotation_info annotations[];	//num_annotations
	/**
	 * Factory method to generate a <code>RuntimeInvisibleAnnotations_attribute</code> instance.
	 * 
	 * <p>The <code>RuntimeInvisibleAnnotations_attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>ClassFile</code>, 
	 * <code>field_info</code>, or <code>method_info</code> structure. The <code>RuntimeInvisibleAnnotations_attribute</code> records run-time 
	 * invisible annotations on the declaration of the corresponding class, method, or field.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>RuntimeInvisibleAnnotations_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>RuntimeInvisibleAnnotations_attribute</code> format
	 */
	public static RuntimeInvisibleAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeInvisibleAnnotations_attribute res = new RuntimeInvisibleAnnotations_attribute();
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
	 * <p>The value of the <code>num_annotations</code> item gives the number of run-time invisible <code>annotations</code> represented by 
	 * the structure.</p>
	 * @return value of <code>num_annotations</code> field
	 */
	public short getNum_annotations() { return num_annotations; }
	/**
	 * Accessor method to <code>annotations</code> field
	 * 
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time invisible annotation on a declaration. The annotation 
	 * structure is specified in <code>annotation_info</code> structure.</p>
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
