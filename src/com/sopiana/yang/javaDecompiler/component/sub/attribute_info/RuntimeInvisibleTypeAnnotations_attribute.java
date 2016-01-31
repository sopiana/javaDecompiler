package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.type_annotation_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>RuntimeInvisibleTypeAnnotations_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>RuntimeInvisibleTypeAnnotations_attribute</code> is an variable-length attribute in the <code>attributes</code> table of a 
 * <code>ClassFile</code>, <code>field_info</code>, or <code>method_info</code> structure, or <code>Code_attribute</code>. 
 * The <code>RuntimeInvisibleTypeAnnotations_attribute</code> records run-time invisible annotations on types used in the corresponding 
 * declaration of a class, field, or method, or in an expression in the corresponding method body. The <code>RuntimeInvisibleTypeAnnotations_attribute</code> 
 * also records annotations on type parameter declarations of generic classes, interfaces, methods, and constructors.</p>
 * <p>There may be at most one <code>RuntimeInvisibleTypeAnnotations_attribute</code> in the <code>attributes</code> table of a <code>ClassFile</code>, 
 * <code>field_info</code>, or <code>method_info</code> structure, or <code>Code_attribute</code>.</p>
 * <p>An <code>attributes</code> table contains a <code>RuntimeInvisibleTypeAnnotations_attribute</code> only if types are annotated in kinds 
 * of declaration or expression that correspond to the parent structure or attribute of the attributes table.</p>
 * <p>The <code>RuntimeInvisibleTypeAnnotations_attribute</code> has the following format:</p>
 * <code>RuntimeInvisibleTypeAnnotations_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_annotations;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;type_annotation annotations[num_annotations];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class RuntimeInvisibleTypeAnnotations_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>num_annotations</code> item gives the number of run-time invisible type <code>annotations</code> represented by 
	 * the structure.</p>
	 */
	private short num_annotations;
	/**
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time invisible annotation on a type used in a declaration 
	 * or expression.</p>
	 */
	private type_annotation_info annotations[];	//num_annotations
	/**
	 * Factory method to generate a <code>RuntimeInvisibleTypeAnnotations_attribute</code> instance.
	 * 
	 * <p>The <code>RuntimeInvisibleTypeAnnotations_attribute</code> is an variable-length attribute in the <code>attributes</code> table of a 
	 * <code>ClassFile</code>, <code>field_info</code>, or <code>method_info</code> structure, or <code>Code_attribute</code>. 
	 * The <code>RuntimeInvisibleTypeAnnotations_attribute</code> records run-time invisible annotations on types used in the corresponding 
	 * declaration of a class, field, or method, or in an expression in the corresponding method body. The <code>RuntimeInvisibleTypeAnnotations_attribute</code> 
	 * also records annotations on type parameter declarations of generic classes, interfaces, methods, and constructors.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>RuntimeInvisibleTypeAnnotations_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>RuntimeInvisibleTypeAnnotations_attribute</code> format
	 */
	public static RuntimeInvisibleTypeAnnotations_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException 
	{
		int offset = 0;
		RuntimeInvisibleTypeAnnotations_attribute res = new RuntimeInvisibleTypeAnnotations_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.num_annotations = Util.byte2Short(info); offset+=2;
		res.annotations = new type_annotation_info[res.num_annotations];
		for(int i=0;i<res.num_annotations;++i)
		{
			res.annotations[i] = type_annotation_info.getInstance(info, offset);
			offset+=res.annotations[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>num_annotations</code> field
	 * 
	 * <p>The value of the <code>num_annotations</code> item gives the number of run-time invisible type <code>annotations</code> represented by 
	 * the structure.</p>
	 * @return value of <code>num_annotations</code> field
	 */
	public short getNum_annotations() { return num_annotations; }
	/**
	 * Accessor method to <code>annotations</code> field
	 * 
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time invisible annotation on a type used in a declaration 
	 * or expression.</p>
	 * @return value of <code>annotations</code> field
	 */
	public type_annotation_info[] getAnnotations() { return annotations; }	

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
