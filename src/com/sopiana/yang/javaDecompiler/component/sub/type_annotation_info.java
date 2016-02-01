package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.target_info.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>type_annotation_info</code> item
 * 
 * <p>The <code>type_annotation_info</code> is a variable-length sub-element structure used in <code>RuntimeVisibleTypeAnnotations</code> and
 * <code>RuntimeInvisibleTypeAnnotations</code> item. Each entry in the <code>annotations</code> table represents a single run-time 
 * visible annotation on a type used in a declaration or expression.</p>
 * <p>The <code>type_annotation_info</code> structure has the following format:</p>
 * <code>type_annotation {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 target_type;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;union {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type_parameter_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;supertype_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type_parameter_bound_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;empty_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;method_formal_parameter_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;throws_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;localvar_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;catch_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;offset_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type_argument_target;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} target_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;type_path target_path;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 type_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_element_value_pairs;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 element_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;element_value value;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} element_value_pairs[num_element_value_pairs];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class type_annotation_info 
{
	/**
	 * <p>The value of the <code>target_type</code> item denotes the kind of target on which the annotation appears. The various kinds of 
	 * target correspond to the type contexts of the Java programming language where types are used in declarations and expressions.</p>
	 */
	private byte target_type;
	/**
	 * <p>The value of the <code>target_info</code> item denotes precisely which type in a declaration or expression is annotated.</p>
	 */
	private target_info target;
	/**
	 * <p>The value of the <code>target_path</code> item denotes precisely which part of the type indicated by <code>target_info</code> 
	 * is annotated.</p>
	 */
	private type_path_info target_path;
	/**
	 * <p>The value of the <code>type_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a field descriptor. The field descriptor denotes 
	 * the type of the annotation represented by this annotation structure.</p>
	 */
	private short type_index;
	/**
	 * <p>The value of the <code>num_element_value_pairs</code> item gives the number of element-value pairs of the annotation represented 
	 * by this annotation structure.
	 */
	private short num_element_value_pairs;
	/**
	 * <p>Each value of the <code>element_value_pairs</code> table represents a single element value pair in the annotation represented by 
	 * this annotation structure. </p>
	 */
	private element_value_pairs_info element_value_pairs[];	//num_element_value_pairs
	/**
	 * Factory method to generate a <code>type_annotation_info</code> entry from given array of byte in specific offset.
	 * 
	 * <p>The <code>type_annotation_info</code> is a variable-length sub-element structure used in <code>RuntimeVisibleTypeAnnotations</code> and
	 * <code>RuntimeInvisibleTypeAnnotations</code> item. Each entry in the <code>annotations</code> table represents a single run-time 
	 * visible annotation on a type used in a declaration or expression.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>type_annotation_info</code>
	 * @throws decompilerException if supplied <code>classFileData</code> is not a Valid <code>type_annotation_info</code>
	 */
	public static type_annotation_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		type_annotation_info res = new type_annotation_info();
		res.target_type = classFileData[offset++];
		res.target = target_info.getInstance(res.target_type,classFileData, offset);
		offset+=res.target.getSize();
		res.target_path = type_path_info.getInstance(classFileData, offset);
		offset += res.target_path.getSize();
		res.type_index = Util.byte2Short(classFileData,offset); offset+=2;
		res.num_element_value_pairs = Util.byte2Short(classFileData,offset); offset+=2;
		res.element_value_pairs = new element_value_pairs_info[res.num_element_value_pairs];
		for(int i=0;i<res.num_element_value_pairs;++i)
		{
			res.element_value_pairs[i] = element_value_pairs_info.getInstance(classFileData, offset);
			offset+=res.element_value_pairs[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>type_annotation_info</code> entry components</p>
	 * @return size of <code>type_annotation_info</code> entry
	 */
	public int getSize()
	{
		int res = 5;
		res+=target.getSize();
		res+=target_path.getSize();
		for(int i=0;i<num_element_value_pairs;++i)
		{
			res+=element_value_pairs[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>target_type</code> field
     * 
	 * <p>The value of the <code>target_type</code> item denotes the kind of target on which the annotation appears. The various kinds of 
	 * target correspond to the type contexts of the Java programming language where types are used in declarations and expressions.</p>
	 * @return value of <code>target_type</code> field
	 */
	public byte getTarget_type() { return target_type; }
	/**
	 * Accessor method to <code>target</code> field
     * 
	 * <p>The value of the <code>target_info</code> item denotes precisely which type in a declaration or expression is annotated.</p>
	 * @return value of <code>target</code> field
	 */
	public target_info getTarget() { return target; }
	/**
	 * Accessor method to <code>target_path</code> field
     * 
	 * <p>The value of the <code>target_path</code> item denotes precisely which part of the type indicated by <code>target_info</code> 
	 * is annotated.</p>
	 * @return value of <code>target_path</code> field
	 */
	public type_path_info getTarget_path() { return target_path; }
	/**
	 * Accessor method to <code>type_index</code> field
     * 
	 * <p>The value of the <code>type_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a field descriptor. The field descriptor denotes 
	 * the type of the annotation represented by this annotation structure.</p>
	 * @return value of <code>type_index</code> field
	 */
	public short getType_index() { return type_index; }
	/**
	 * Accessor method to <code>num_element_value_pairs</code> field
     * 
	 * <p>The value of the <code>num_element_value_pairs</code> item gives the number of element-value pairs of the annotation represented 
	 * by this annotation structure.</p>
	 * @return value of <code>num_element_value_pairs</code> field
	 */
	public short getNum_element_value_pairs() { return num_element_value_pairs; }
	/**
	 * Accessor method to <code>element_value_pairs</code> field
     * 
	 * <p>Each value of the <code>element_value_pairs</code> table represents a single element value pair in the annotation represented by 
	 * this annotation structure. </p>
	 * @return value of <code>element_value_pairs</code> field
	 */
	public element_value_pairs_info[] getElement_value_pairs() { return element_value_pairs; }
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" target_type: "+String.format("%02x", target_type)+"\n";
		res+=indentStr+" target: \n";
		res+=target.toString(indent+1, constant_pool);
		res+=indentStr+" target_path: \n";
		res+=target_path.toString(indent+1, constant_pool);
		try
		{
			res+=indentStr+" type: "+cp_info.getName(type_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" type_index: @"+ type_index+"\n";
		}
		res+=indentStr+" num_element_value_pairs: "+num_element_value_pairs+"\n";
		for(int i=0;i<num_element_value_pairs;++i)
		{
			res+=indentStr+" element_value_pairs["+i+"]: \n";
			res+=element_value_pairs[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
