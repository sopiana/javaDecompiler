package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>catch_target_info</code> item
 * 
 * <p>The catch_target item indicates that an annotation appears on the <i>i</i>'th type in an exception parameter declaration.</p>
 * <p>The <code>catch_target_info</code> structure has the following format:</p>
 * <code>catch_target_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 exception_table_index;<br>
 * }</code>
 * @author yang
 *
 */
public class catch_target_info extends target_info
{
	/**
	 * <p>The value of the <code>exception_table_index</code> item is an index into the <code>exception_table</code> array of the Code attribute 
	 * enclosing the <code>RuntimeVisibleTypeAnnotations</code> attribute.</p>
	 * <p><small>The possibility of more than one type in an exception parameter declaration arises from the multi-catch clause of the try 
	 * statement, where the type of the exception parameter is a union of types (JLS §14.20). A compiler usually creates one <code>exception_table</code> 
	 * entry for each type in the union, which allows the catch_target item to distinguish them. This preserves the correspondence between 
	 * a type and its annotations.</small></p>
	 */
	private short exception_table_index;
	/**
	 * Factory method to generate a <code>catch_target_info</code> instance.
	 * 
	 * <p>The catch_target item indicates that an annotation appears on the <i>i</i>'th type in an exception parameter declaration.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>catch_target_info</code>
	 */
	public static catch_target_info getInstance(byte[]classFileData, int offset)
	{
		catch_target_info res = new catch_target_info();
		res.exception_table_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>catch_target_info</code> entry components</p>
	 * @return size of <code>catch_target_info</code> entry
	 */
	public int getSize() { return 2; }
	/**
	 * Accessor method to <code>exception_table_index</code> field
	 * 
	 * <p>The value of the <code>exception_table_index</code> item is an index into the <code>exception_table</code> array of the Code attribute 
	 * enclosing the <code>RuntimeVisibleTypeAnnotations</code> attribute.</p>
	 * <p><small>The possibility of more than one type in an exception parameter declaration arises from the multi-catch clause of the try 
	 * statement, where the type of the exception parameter is a union of types (JLS §14.20). A compiler usually creates one <code>exception_table</code> 
	 * entry for each type in the union, which allows the catch_target item to distinguish them. This preserves the correspondence between 
	 * a type and its annotations.</small></p>
	 * @return value of <code>exception_table_index</code> field
	 */
	public short getException_table_index() { return exception_table_index; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = class_info.getIndent(indent);
		String res= indentStr+" exception_table_index: "+exception_table_index+"\n";
		return res;
	}
}
