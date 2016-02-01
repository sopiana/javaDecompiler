package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.local_variable_type_table_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>LocalVariableTypeTable_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>LocalVariableTypeTable_attribute</code> is an optional variable-length attribute in the <code>attributes</code> table of a 
 * <code>Code_attribute</code>. It may be used by debuggers to determine the value of a given local variable during the execution of a method.</p>
 * <p>If multiple <code>LocalVariableTypeTable_attributes</code> are present in the <code>attributes</code> table of a given <code>Code_attribute</code>, 
 * then they may appear in any order.</p>
 * <p>There may be no more than one <code>LocalVariableTypeTable_attribute</code> per local variable in the <code>attributes</code> table of a 
 * <code>Code_attribute</code>.</p>
 * <p><small>The <code>LocalVariableTypeTable_attribute</code> differs from the <code>LocalVariableTable_attribute</code> in that it provides 
 * signature information rather than descriptor information. This difference is only significant for variables whose type uses a type variable 
 * or parameterized type. Such variables will appear in both tables, while variables of other types will appear only in <code>LocalVariableTable</code>.</small></p>
 * <p>The <code>LocalVariableTypeTable_attribute</code> has the following format:</p>
 * <code>LocalVariableTypeTable_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 local_variable_type_table_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 start_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 signature_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} local_variable_type_table[local_variable_type_table_length];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class LocalVariableTypeTable_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>local_variable_type_table_length</code> item indicates the number of entries in the 
	 * <code>local_variable_type_table</code> array.</p>
	 */
	private short local_variable_type_table_length;
	/**
	 * <p>Each entry in the <code>local_variable_type_table</code> array indicates a range of code array offsets within which a local variable 
	 * has a value. It also indicates the index into the local variable array of the current frame at which that local variable can be found.</p>
	 */
	private local_variable_type_table_info local_variable_type_table[];	//local_variable_type_table_length
	/**
	 * Factory method to generate a <code>LocalVariableTypeTable_attribute</code> instance.
	 * 
	 * <p>The <code>LocalVariableTypeTable_attribute</code> is an optional variable-length attribute in the <code>attributes</code> table of a 
	 * <code>Code_attribute</code>. It may be used by debuggers to determine the value of a given local variable during the execution of a method.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>LocalVariableTypeTable_attribute</code>
	 */
	public static LocalVariableTypeTable_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) 
	{
		int offset = 0;
		LocalVariableTypeTable_attribute res = new LocalVariableTypeTable_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.local_variable_type_table_length = Util.byte2Short(info);offset+=2;
		res.local_variable_type_table = new local_variable_type_table_info[res.local_variable_type_table_length];
		for(int i=0;i<res.local_variable_type_table_length;++i)
		{
			res.local_variable_type_table[i] = local_variable_type_table_info.getInstance(info, offset);
			offset += res.local_variable_type_table[i].getSize();
		}
		return res;
	}
	/**
	 * Accessor method to <code>local_variable_type_table_length</code> field
	 * 
	 * <p>The value of the <code>local_variable_type_table_length</code> item indicates the number of entries in the 
	 * <code>local_variable_type_table</code> array.</p>
	 * @return value of <code>local_variable_type_table_length</code> field
	 */
	public short getLocal_variable_type_table_length() { return local_variable_type_table_length; }
	/**
	 * Accessor method to <code>local_variable_type_table</code> field
	 * 
	 * <p>Each entry in the <code>local_variable_type_table</code> array indicates a range of code array offsets within which a local variable 
	 * has a value. It also indicates the index into the local variable array of the current frame at which that local variable can be found.</p>
	 * @return value of <code>local_variable_type_table</code> field
	 */
	public local_variable_type_table_info[] getLocal_variable_type_table() { return local_variable_type_table; }
	
	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" local_variable_type_table_length: "+local_variable_type_table_length+"\n";
		for(int i=0;i<local_variable_type_table_length;++i)
		{
			res+=indentStr+" local_variable_type_table["+i+"]: \n";
			res+=local_variable_type_table[i].toString(indent+1, constant_pool);
		}
		return res;
	}
}
