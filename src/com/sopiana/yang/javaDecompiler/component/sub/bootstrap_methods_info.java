package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>bootstrap_methods_info</code> item in <code>element_value</code> structure
 * 
 * <p>The <code>array_value_info</code> is a fixed-length sub-element structure used in <code>BootstrapMethods_attribute</code> item. Each 
 * entry in the <code>bootstrap_methods_info</code> table contains an index to a <code>CONSTANT_MethodHandle_info</code> structure which specifies 
 * a bootstrap method, and a sequence (perhaps empty) of indexes to static arguments for the bootstrap method.</p>
 * <p>The <code>bootstrap_methods_info</code> structure has the following format:</p>
 * <code>bootstrap_methods_info{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 bootstrap_method_ref;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 num_bootstrap_arguments;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 bootstrap_arguments[num_bootstrap_arguments];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class bootstrap_methods_info 
{
	/**
	 * <p>The value of the <code>bootstrap_method_ref</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_MethodHandle_info</code> structure.</p>
	 * <p><small>The form of the method handle is driven by the continuing resolution of the call site specifier in <i>invokedynamic</i>, where 
	 * execution of <code>invoke</code> in <code>java.lang.invoke.MethodHandle</code> requires that the bootstrap method handle be adjustable 
	 * to the actual arguments being passed, as if by a call to <code>java.lang.invoke.MethodHandle.asType</code>. Accordingly, the 
	 * <code>reference_kind</code> item of the <code>CONSTANT_MethodHandle_info</code> structure should have the value 6 or 8, and the 
	 * <code>reference_index</code> item should specify a static method or constructor that takes three arguments of type <code>java.lang.invoke.MethodHandles.Lookup</code>, 
	 * <code>String</code>, and <code>java.lang.invoke.MethodType</code>, in that order. Otherwise, invocation of the bootstrap method handle 
	 * during call site specifier resolution will complete abruptly</small></p>
	 */
	private short bootstrap_method_ref;
	/**
	 * <p>The value of the <code>num_bootstrap_arguments</code> item gives the number of items in the <code>bootstrap_arguments</code> array.</p>
	 */
	private short num_bootstrap_arguments;
	/**
	 * <p>Each entry in the <code>bootstrap_arguments</code> array must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_String_info</code>, <code>CONSTANT_Class_info</code>, <code>CONSTANT_Integer_info</code>, 
	 * <code>CONSTANT_Long_info</code>, <code>CONSTANT_Float_info</code>, <code>CONSTANT_Double_info</code>, <code>CONSTANT_MethodHandle_info</code>, 
	 * or <code>CONSTANT_MethodType_info</code> structure.</p>
	 */
	private short bootstrap_arguments[];	//num_bootstrap_arguments
	/**
	 * Factory method to generate a <code>bootstrap_methods_info</code> entry from given array of byte in specific offset.
	 * 
	 * <p>The <code>array_value_info</code> is a fixed-length sub-element structure used in <code>BootstrapMethods_attribute</code> item. Each 
	 * entry in the <code>bootstrap_methods_info</code> table contains an index to a <code>CONSTANT_MethodHandle_info</code> structure which specifies 
	 * a bootstrap method, and a sequence (perhaps empty) of indexes to static arguments for the bootstrap method.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>bootstrap_methods_info</code>
	 * @throws decompilerException if supplied <code>classFileData</code> is not a Valid <code>bootstrap_methods_info</code>
	 */
	public static bootstrap_methods_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		bootstrap_methods_info res = new bootstrap_methods_info();
		res.bootstrap_method_ref = Util.byte2Short(classFileData,offset); offset+=2;
		res.num_bootstrap_arguments = Util.byte2Short(classFileData,offset); offset+=2;
		res.bootstrap_arguments = new short [res.num_bootstrap_arguments];
		for(int i=0;i<res.num_bootstrap_arguments;++i)
		{
			res.bootstrap_arguments[i] = Util.byte2Short(classFileData,offset); offset+=2;
		}
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>bootstrap_methods_info</code> entry components</p>
	 * @return size of <code>bootstrap_methods_info</code> entry
	 */
	public int getSize() { return 4+num_bootstrap_arguments*2; }
	 /**
     * Accessor method to <code>bootstrap_method_ref</code> field
     * 
	 * <p>The value of the <code>bootstrap_method_ref</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_MethodHandle_info</code> structure.</p>
	 * <p><small>The form of the method handle is driven by the continuing resolution of the call site specifier in <i>invokedynamic</i>, where 
	 * execution of <code>invoke</code> in <code>java.lang.invoke.MethodHandle</code> requires that the bootstrap method handle be adjustable 
	 * to the actual arguments being passed, as if by a call to <code>java.lang.invoke.MethodHandle.asType</code>. Accordingly, the 
	 * <code>reference_kind</code> item of the <code>CONSTANT_MethodHandle_info</code> structure should have the value 6 or 8, and the 
	 * <code>reference_index</code> item should specify a static method or constructor that takes three arguments of type <code>java.lang.invoke.MethodHandles.Lookup</code>, 
	 * <code>String</code>, and <code>java.lang.invoke.MethodType</code>, in that order. Otherwise, invocation of the bootstrap method handle 
	 * during call site specifier resolution will complete abruptly</small></p>
	 * @return value of <code>bootstrap_method_ref</code> field
	 */
	public short getBootstrap_method_ref() { return bootstrap_method_ref; }
	 /**
     * Accessor method to <code>num_bootstrap_arguments</code> field
     * 
	 * <p>The value of the <code>num_bootstrap_arguments</code> item gives the number of items in the <code>bootstrap_arguments</code> array.</p>
	 * @return value of <code>num_bootstrap_arguments</code> field
	 */
	public short getNum_bootstrap_arguments() { return num_bootstrap_arguments; }
	 /**
     * Accessor method to <code>bootstrap_arguments</code> field
     * 
	 * <p>Each entry in the <code>bootstrap_arguments</code> array must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_String_info</code>, <code>CONSTANT_Class_info</code>, <code>CONSTANT_Integer_info</code>, 
	 * <code>CONSTANT_Long_info</code>, <code>CONSTANT_Float_info</code>, <code>CONSTANT_Double_info</code>, <code>CONSTANT_MethodHandle_info</code>, 
	 * or <code>CONSTANT_MethodType_info</code> structure.</p>
	 * @return value of <code>bootstrap_arguments</code> field
	 */
	public short[] getBootstrap_arguments() { return bootstrap_arguments; }
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" bootstrap_method_ref: \n";
		res+=constant_pool[bootstrap_method_ref].toString(indent+1, constant_pool);
		res+=indentStr+" num_bootstrap_arguments: "+num_bootstrap_arguments+"\n";
		for(int i=0;i<num_bootstrap_arguments;++i)
		{
			res+=indentStr+"bootstrap_arguments["+i+"]:"+String.format("%04x", bootstrap_arguments[i])+"\n";
		}
		return res;
	}
}
