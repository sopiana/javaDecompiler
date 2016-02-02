package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;

/**
 * Provides abstraction for <code>type_path_info</code> item
 * 
 * <p>Wherever a type is used in a declaration or expression, the <code>type_path_info</code> structure identifies which part of the type is 
 * annotated. An annotation may appear on the type itself, but if the type is a reference type, then there are additional locations where an 
 * annotation may appear:</p>
 * <ul>
 * <li>If an array type <code>T[]</code>  is used in a declaration or expression, then an annotation may appear on any component type of the 
 * array type, including the element type.</li>
 * <li>If a nested type <code>T1</code>. <code>T2</code> is used in a declaration or expression, then an annotation may appear on the name of 
 * the top level type or any member type.</li>
 * <li>If a parameterized type <code>T&lt;A&gt;</code>or <code>T&lt;? extends A&gt;</code> or <code>T&lt;? super A&gt;</code> is used in a 
 * declaration or expression, then an annotation may appear on any type argument or on the bound of any wildcard type argument.</li>
 * </ul>
 * <p>The <code>type_path_info</code> structure has the following format:</p>
 * <code>type_path_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 path_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;path_info path;<br>
 * }</code>
 * 
 * @author yang.sopiana
 *
 */
public class type_path_info 
{
	/**
	 * <p>The value of the <code>path_length</code> item gives the number of entries in the path array:</p>
	 * <ul>
	 * <li>If the value of <code>path_length</code> is 0, then the annotation appears directly on the type itself.</li>
	 * <li>If the value of <code>path_length</code> is non-zero, then each entry in the path array represents an iterative, left-to-right step 
	 * towards the precise location of the annotation in an array type, nested type, or parameterized type. (In an array type, the iteration 
	 * visits the array type itself, then its component type, then the component type of that component type, and so on, until the element type 
	 * is reached.) </li>
	 * </ul>
	 */
	private byte path_length;
	/**
	 * <p>Annotation type path array, identifies which part of the type is annotated</p>
	 */
	private path_info path[];	//path_length
	/**
	 * Factory method to generate a <code>type_path_info</code> instance.
	 * 
	 * <p>The <code>type_path_info</code> structure identifies which part of the type is 
	 * annotated. An annotation may appear on the type itself, but if the type is a reference type, then there are additional locations where an 
	 * annotation may appear.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>type_path_info</code>
	 */
	public static type_path_info getInstance(byte[]classFileData, int offset)
	{
		type_path_info res = new type_path_info();
		res.path_length = classFileData[offset++];
		res.path = new path_info[res.path_length&0xFF];
		for(int i=0; i<res.path.length;++i)
		{
			res.path[i] = path_info.getInstance(classFileData,offset);
			offset = res.path[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>type_path_info</code> entry components</p>
	 * @return size of <code>type_path_info</code> entry
	 */
	public int getSize() 
	{
		int res = 1;
		for(int i=0;i<path.length;++i)
		{
			res+=path[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>path_length</code> field
	 * 
	 * <p>The value of the <code>path_length</code> item gives the number of entries in the path array:</p>
	 * <ul>
	 * <li>If the value of <code>path_length</code> is 0, then the annotation appears directly on the type itself.</li>
	 * <li>If the value of <code>path_length</code> is non-zero, then each entry in the path array represents an iterative, left-to-right step 
	 * towards the precise location of the annotation in an array type, nested type, or parameterized type. (In an array type, the iteration 
	 * visits the array type itself, then its component type, then the component type of that component type, and so on, until the element type 
	 * is reached.) </li>
	 * </ul>
	 * @return value of <code>path_length</code> field
	 */
	public byte getPath_length() { return path_length; }
	/**
	 * Accessor method to <code>path</code> field
	 * 
	 * <p>Annotation type path array, identifies which part of the type is annotated</p>
	 * @return value of <code>path</code> field
	 */
	public path_info[] getPath() { return path; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" path_length: "+ path_length+"\n";
		for(int i=0;i<path_length;++i)
		{
			res+=indentStr+" path["+i+"]:\n ";
			res+=path[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
