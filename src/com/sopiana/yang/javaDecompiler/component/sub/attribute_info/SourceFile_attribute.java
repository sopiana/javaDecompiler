package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>SourceFile_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>SourceFile_attribute</code> is an optional fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
 * structure.</p>
 * <p>There may be at most one <code>SourceFile_attribute</code> in the <code>attributes</code> table of a <code>ClassFile</code> structure.</p>
 * <p>The <code>SourceFile_attribute</code> has the following format:</p>
 * <code>SourceFile_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 sourcefile_index;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class SourceFile_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>sourcefile_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a string.</p>
	 */
	private short sourcefile_index;
	/**
	 * Factory method to generate a <code>SourceFile_attribute</code> instance.
	 * 
	 * <p>The <code>SourceFile_attribute</code> is an optional fixed-length attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
	 * structure, represents the source file name of a <code>ClassFile</code> structure.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>SourceFile_attribute</code>
	 */
	public static SourceFile_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		SourceFile_attribute res = new SourceFile_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.sourcefile_index = Util.byte2Short(info);
		return res;
	}
	/**
	 * Accessor method to <code>sourcefile_index</code> field
	 * 
	 * <p>The value of the <code>sourcefile_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a string.</p>
	 * @return value of <code>sourcefile_index</code> field
	 */
	public short getSourcefile_index() { return this.sourcefile_index; }

	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		try 
		{
			res+=indentStr+" sourcefile_index: "+cp_info.getName(sourcefile_index, constant_pool)+"\n";
		} 
		catch (decompilerException e) 
		{
			e.printStackTrace();
			res+=indentStr+" sourcefile_index: @"+sourcefile_index+"\n";
		}
		return res;
	}
}
