package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
/**
 * Provides abstraction for <code>catch_target_info</code> item
 * 
 * <p>The <code>empty_target_info</code> item indicates that an annotation appears on either the type in a field declaration, the return 
 * type of a method, the type of a newly constructed object, or the receiver type of a method or constructor.</p>
 * <p>The <code>empty_target_info</code> structure has the following format:</p>
 * <code>empty_target_info {<br>
 * }</code>
 * <p><small>Only one type appears in each of these locations, so there is no per-type information to represent in the <code>target_info</code> union.</small></p>
 * @author yang
 *
 */
public class empty_target_info extends target_info
{
	/**
	 * Factory method to generate a <code>empty_target_info</code> instance.
	 * 
	 * <p>The <code>empty_target_info</code> item indicates that an annotation appears on either the type in a field declaration, the return 
	 * type of a method, the type of a newly constructed object, or the receiver type of a method or constructor.</p> 
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>empty_target_info</code>
	 */
	public static empty_target_info getInstance(byte[]classFileData, int offset)
	{
		return new empty_target_info();
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>empty_target_info</code> entry components</p>
	 * @return size of <code>empty_target_info</code> entry
	 */
	public int getSize() { return 0; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		return "";
	}
}
