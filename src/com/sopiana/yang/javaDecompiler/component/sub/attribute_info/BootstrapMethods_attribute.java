package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.bootstrap_methods_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>BootstrapMethods_attribute</code> item in <code>attributes</code> table
 * 
 * <p>The <code>BootstrapMethods attribute</code> is a variable-length attribute in the <code>attributes</code> table of a <code>ClassFile</code> structure. 
 * The <code>BootstrapMethods</code> attribute records bootstrap method specifiers referenced by <i>invokedynamic</i> instructions.</p>
 * <p>There must be exactly one <code>BootstrapMethods</code> attribute in the <code>attributes</code> table of a <code>ClassFile</code> 
 * structure if the <code>constant_pool</code> table of the <code>ClassFile</code> structure has at least one <code>CONSTANT_InvokeDynamic_info</code> entry.</p>
 * <p>There may be at most one <code>BootstrapMethods</code> attribute in the <code>attributes</code> table of a ClassFile structure.</p>
 * <p>The <code>BootstrapMethods</code> attribute has the following format:</p>
 * <code>BootstrapMethods_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_bootstrap_methods;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{ 
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 bootstrap_method_ref;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 num_bootstrap_arguments;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 bootstrap_arguments[num_bootstrap_arguments];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} bootstrap_methods[num_bootstrap_methods];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class BootstrapMethods_attribute extends attribute_info
{
	/**
	 * The value of the <code>num_bootstrap_methods</code> item determines the number of bootstrap method specifiers in the <code>bootstrap_methods</code> 
	 * array.
	 */
	private short num_bootstrap_methods;
	/**
	 * Each entry in the <code>bootstrap_methods table</code> contains an index to a <code>CONSTANT_MethodHandle_info</code> structure which 
	 * specifies a bootstrap method, and a sequence (perhaps empty) of indexes to <i>static arguments</i> for the bootstrap method.
	 */
	private bootstrap_methods_info bootstrap_methods[];	//num_bootstrap_methods
	/**
	 * Factory method to generate a <code>BootstrapMethods_attribute</code> instance.
	 * 
	 * <p>The <code>BootstrapMethods_attribute </code> is a variable-length attribute in the <code>attributes</code> table records bootstrap method 
	 * specifiers referenced by <i>invokedynamic</i> instructions.. It started with 2 bytes of <code>name_index</code>, 
	 * 2 bytes of <code>attribute_length</code>, 2 bytes of <code>num_bootstrap_methods</code> and variable-length <code>bootstrap_methods</code> table</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @return instance of <code>BootstrapMethods_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>BootstrapMethods_attribute</code> format
	 */
	public static BootstrapMethods_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
 	{
 		int offset = 0;
 		BootstrapMethods_attribute res = new BootstrapMethods_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.num_bootstrap_methods = Util.byte2Short(info,offset); offset+=2;
 		res.bootstrap_methods = new bootstrap_methods_info[res.num_bootstrap_methods];
 		for(int i=0;i<res.num_bootstrap_methods;++i)
 		{
 			res.bootstrap_methods[i] = bootstrap_methods_info.getInstance(info,offset);
 			offset+=res.bootstrap_methods[i].getSize();
 		}
 		return res;
 	}
	/**
	 * Accessor method to <code>num_bootstrap_methods</code> field
	 * 
	 * <p>The value of the <code>num_bootstrap_methods</code> item determines the number of bootstrap method specifiers in the <code>bootstrap_methods</code> 
	 * array.</p>
	 * @return value of <code>num_bootstrap_methods</code> field
	 */
	public short getNum_bootstrap_methods() { return num_bootstrap_methods; }
	/**
	 * Accessor method to <code>bootstrap_methods</code> field
	 * 
	 * <p>Each entry in the <code>bootstrap_methods table</code> contains an index to a <code>CONSTANT_MethodHandle_info</code> structure which 
	 * specifies a bootstrap method, and a sequence (perhaps empty) of indexes to <i>static arguments</i> for the bootstrap method.</p>
	 * @return value of <code>bootstrap_methods_info</code> field
	 */
	public bootstrap_methods_info[] getBootstrap_methods() { return bootstrap_methods; }
	
	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" num_bootstrap_methods: "+num_bootstrap_methods+"\n";
		for(int i=0;i<num_bootstrap_methods;++i)
		{
			res+=indentStr+" bootstrap_methods["+i+"]: \n";
			res+=bootstrap_methods[i].toString(indent, constant_pool);
		}
		return res;
	}
}
