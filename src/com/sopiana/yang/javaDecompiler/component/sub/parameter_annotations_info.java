package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>parameter_annotations_info</code> item
 * 
 * <p>The <code>parameter_annotations_info</code> is a fixed-length sub-element structure used in <code>parameter_annotations_info</code> 
 * item. Each entry in the <code>parameter_annotations</code> table represents all of the runtime visible annotations on the declaration 
 * of a single formal parameter. The <i>i</i>'th entry in the table corresponds to the <i>i</i>'th formal parameter in the method descriptor.</p>
 * <p>The <code>parameter_annotations_info</code> structure has the following format:</p>
 * <code>parameter_annotations_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_annotations;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;annotation_info annotations[];<br>
 * }</code>
 *  
 * @author yang.sopiana
 *
 */
public class parameter_annotations_info 
{
	/**
	 * <p>The value of the <code>num_annotations</code> item indicates the number of runtime visible annotations on the declaration of the 
	 * formal parameter corresponding to the <code>parameter_annotations</code> entry.</p>
	 */
	private short num_annotations;
	/**
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time visible annotation on the declaration of the formal 
	 * parameter corresponding to the <code>parameter_annotations</code> entry.
	 */
	private annotation_info annotations[];	//num_annotations
	/**
	 * Factory method to generate a <code>parameter_annotations_info</code> instance.
	 * 
	 * <p>The <code>parameter_annotations_info</code> is a fixed-length sub-element structure used in <code>parameter_annotations_info</code> 
	 * item. Each entry in the <code>parameter_annotations</code> table represents all of the runtime visible annotations on the declaration 
	 * of a single formal parameter. The <i>i</i>'th entry in the table corresponds to the <i>i</i>'th formal parameter in the method descriptor.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>parameter_annotations_info</code>
	 * @throws decompilerException if supplied <code>classFileData</code> is not a Valid <code>parameter_annotations_info</code>
	 */
	public static parameter_annotations_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		parameter_annotations_info res = new parameter_annotations_info();
		res.num_annotations = Util.byte2Short(classFileData,offset); offset+=2;
		res.annotations = new annotation_info[res.num_annotations];
		for(int i=0;i<res.num_annotations;++i)
		{
			res.annotations[i] = annotation_info.getInstance(classFileData, offset);
			offset+=res.annotations[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>parameter_annotations_info</code> entry components</p>
	 * @return size of <code>parameter_annotations_info</code> entry
	 */
	public int getSize() 
	{ 
		int res = 2;
		for(int i=0;i<num_annotations;++i)
		{
			res+=annotations[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>num_annotations</code> field
	 * 
	 * <p>The value of the <code>num_annotations</code> item indicates the number of runtime visible annotations on the declaration of the 
	 * formal parameter corresponding to the <code>parameter_annotations</code> entry.</p>
	 * @return value of <code>num_annotations</code> field
	 */
	public short getNum_annotations() { return num_annotations; }
	/**
	 * Accessor method to <code>annotations</code> field
	 * 
	 * <p>Each entry in the <code>annotations</code> table represents a single run-time visible annotation on the declaration of the formal 
	 * parameter corresponding to the <code>parameter_annotations</code> entry.</p>
	 * @return value of <code>annotations</code> field
	 */
	public annotation_info[] getAnnotations() { return annotations; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" num_annotations: "+num_annotations+"\n";
		for(int i=0;i<num_annotations;++i)
		{
			res+=indentStr+" annotations["+i+"]\n:";
			res+=annotations[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
