package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;

/**
 * Provides abstraction for <code>path_info</code> item
 * 
 * <p>The <code>path_info</code> is a fixed-length sub-element structure used in <code>type_path_info</code> 
 * item.</p>
 * <p>The <code>parameters_info</code> structure has the following format:</p>
 * <code>path_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 type_path_kind;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 type_argument_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class path_info 
{
	/**
	 * <p>The legal values for the <code>type_path_kind</code> item are listed in following table. </p>
	 * <table summary="Interpretation of <code>type_path_kind</code> values.">
	 * 	<thead>
	 * 		<tr><th>Value</th> <th>Interpretation</th></tr>
	 * 	</thead>
	 * 	<tbody>
	 * 		<tr><td>0</td> <td>Annotation is deeper in an array type</td></tr>
	 * 		<tr><td>1</td> <td>Annotation is deeper in a nested type</td></tr>
	 * 		<tr><td>2</td> <td>Annotation is on the bound of a wildcard type argument of a parameterized type</td></tr>
	 * 		<tr><td>3</td> <td>Annotation is on a type argument of a parameterized type</td></tr>
	 * 	</tbody>
	 * </table>
	 */
	private byte type_path_kind;
	/**
	 * <p>If the value of the <code>type_path_kind</code> item is 0, 1, or 2, then the value of the <code>type_argument_index</code> item is 0.</p>
	 * <p>If the value of the <code>type_path_kind</code> item is 3, then the value of the <code>type_argument_index</code> item specifies which 
	 * type argument of a parameterized type is annotated, where 0 indicates the first type argument of a parameterized type.</p>
	 */
	private byte type_argument_index;
	/**
	 * Factory method to generate a <code>path_info</code> instance.
	 * 
	 * <p>The <code>path_info</code> is a fixed-length sub-element structure used in <code>type_path_info</code> 
	 * item.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>path_info</code>
	 */
	public static path_info getInstance(byte[]classFileData, int offset)
	{
		path_info res = new path_info();
		res.type_path_kind = classFileData[offset++];
		res.type_argument_index = classFileData[offset];
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>path_info</code> entry components</p>
	 * @return size of <code>path_info</code> entry
	 */
	public int getSize() { return 2; }
	/**
	 * Accessor method to <code>type_path_kind</code> field
	 * 
	 * <p>The legal values for the <code>type_path_kind</code> item are listed in following table. </p>
	 * <table summary="Interpretation of <code>type_path_kind</code> values.">
	 * 	<thead>
	 * 		<tr><th>Value</th> <th>Interpretation</th></tr>
	 * 	</thead>
	 * 	<tbody>
	 * 		<tr><td>0</td> <td>Annotation is deeper in an array type</td></tr>
	 * 		<tr><td>1</td> <td>Annotation is deeper in a nested type</td></tr>
	 * 		<tr><td>2</td> <td>Annotation is on the bound of a wildcard type argument of a parameterized type</td></tr>
	 * 		<tr><td>3</td> <td>Annotation is on a type argument of a parameterized type</td></tr>
	 * 	</tbody>
	 * </table>
	 * @return value of <code>type_path_kind</code> field
	 */
	public byte getType_path_kind() { return type_path_kind; }
	/**
	 * Accessor method to <code>type_argument_index</code> field
	 * 
	 * <p>If the value of the <code>type_path_kind</code> item is 0, 1, or 2, then the value of the <code>type_argument_index</code> item is 0.</p>
	 * <p>If the value of the <code>type_path_kind</code> item is 3, then the value of the <code>type_argument_index</code> item specifies which 
	 * type argument of a parameterized type is annotated, where 0 indicates the first type argument of a parameterized type.</p>
	 * @return value of <code>type_argument_index</code> field
	 */
	public byte getType_argument_index() { return type_argument_index; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" type_path_kind: "+String.format("%02X", type_path_kind)+"\n";
		res+=indentStr+" type_argument_index: "+ String.format("%02X", type_argument_index)+"\n";
		return res;
	}
}
