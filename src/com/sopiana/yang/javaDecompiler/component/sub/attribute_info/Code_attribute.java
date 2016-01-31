package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import java.util.Arrays;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.exception_table_info;
import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * <p>The <code>Code attribute</code> is a variable-length attribute in the attributes table of a <code>method_info</code> structure. 
 * A <code>Code attribute</code> contains the Java Virtual Machine instructions and auxiliary information for a method, including an instance 
 * initialization method or a class or interface initialization method.</p>
 * <p>If the method is either <code>native</code> or <code>abstract</code>, its <code>method_info</code> structure must not have a <code>Code attribute</code> 
 * in its <code>attributes</code> table. Otherwise, its <code>method_info</code> structure must have exactly one Code attribute in its <code>attributes</code> table.</p>
 * <p>The <code>Code attribute</code> has the following format:</p>
 * <code>Code_attribute {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 max_stack;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 max_locals;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 code_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 code[code_length];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 exception_table_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;{<br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 start_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 end_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 handler_pc;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 catch_type;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} exception_table[exception_table_length];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attributes_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;attribute_info attributes[attributes_count];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class Code_attribute extends attribute_info
{
	/**
	 * <p>The value of the <code>max_stack</code> item gives the maximum depth of the operand stack of this method at any point during 
	 * execution of the method.</p>
	 */
	private short max_stack;
	/**
	 * <p>The value of the <code>max_locals</code> item gives the number of local variables in the local variable array allocated upon 
	 * invocation of this method, including the local variables used to pass parameters to the method on its invocation.</p>
	 * <p>The greatest local variable index for a value of type <code>long</code> or <code>double</code> is <code>max_locals - 2</code>. 
	 * The greatest local variable index for a value of any other type is <code>max_locals - 1</code>.<p>
	 */
	private short max_locals;
	/**
	 * <p>The value of the <code>code_length</code> item gives the number of <code>bytes</code> in the code array for this method.</p>
	 * <p>The value of <code>code_length</code> must be greater than zero (as the code array must not be empty) and less than 65536.</p>
	 */
	private int code_length;
	/**
	 * <p>The <code>code</code> array gives the actual bytes of Java Virtual Machine code that implement the method.</p>
	 * <p>When the <code>code</code> array is read into memory on a byte-addressable machine, if the first byte of the array is aligned on a 
	 * 4-byte boundary, the <code>tableswitch</code> and <code>lookupswitch</code> 32-bit offsets will be 4-byte aligned. 
	 * (Refer to the descriptions of those instructions for more information on the consequences of code array alignment.)</p>
	 */
	private byte code[];	//code_length
	/**
	 * <p>The value of the <code>exception_table_length</code> item gives the number of entries in the <code>exception_table</code> table.</p>
	 */
	private short exception_table_length;
	/**
	 * <p>Each entry in the <code>exception_table</code> array describes one exception handler in the code array. The order of the handlers in 
	 * the <code>exception_table</code> array is significant.</p>
	 */
	private exception_table_info exception_table[]; //exception_table_length
	/**
	 * <p>The value of the <code>attributes_count</code> item indicates the number of attributes of the Code attribute.</p>
	 */
 	private short attributes_count;
 	/**
 	 * <p>Each value of the  <code>attributes</code> table must be an <code>attribute_info</code> structure. A Code attribute can have any 
 	 * number of optional <code>attributes</code> associated with it.</p>
 	 */
 	private attribute_info attributes[];			//attributes_count
 	/**
	 * Factory method to generate a <code>Code_attribute</code> instance.
	 * 
	 * <p>The <code>Code_attribute</code> is a variable-length attribute in the <code>attributes</code> contains the Java Virtual Machine instructions and auxiliary information for a method, including an instance 
	 * initialization method or a class or interface initialization method.</p>
	 * @param attribute_name_index attribute_name_index value representing the name of the attribute
	 * @param attribute_length attribute_length value indicating the length of the subsequent information in bytes
	 * @param info byte array from the class file
	 * @param constant_pool <code>constant_pool</code> entry of a class
	 * @return instance of <code>Code_attribute</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>Code_attribute</code> format
	 */
 	public static Code_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info,cp_info[] constant_pool) throws decompilerException
 	{
 		int offset = 0;
 		Code_attribute res = new Code_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.max_stack = Util.byte2Short(info,offset); offset+=2;
 		res.max_locals = Util.byte2Short(info,offset); offset+=2;
 		res.code_length = Util.byte2Int(info,offset); offset+=4; 
 		res.code = Arrays.copyOfRange(info, offset, offset+res.code_length); offset+=res.code_length;
 		res.exception_table_length = Util.byte2Short(info,offset); offset+=2;
 		res.exception_table = new exception_table_info[res.exception_table_length];
 		for(int i=0;i<res.exception_table_length;++i)
 		{
 			res.exception_table[i] = exception_table_info.getInstance(info, offset);
 			offset += res.exception_table[i].getSize();
 		}
 		res.attributes_count = Util.byte2Short(info,offset); offset+=2;
 		res.attributes = new attribute_info[res.attributes_count];
 		for(int i=0;i<res.attributes_count;++i)
 		{
 			res.attributes[i] = attribute_info.getInstance(info, offset,constant_pool);
 			offset += res.attributes[i].getSize();
 		}
 		return res;
 	}
 	/**
	 * Accessor method to <code>max_stack</code> field
	 * 
	 * <p>The value of the <code>max_stack</code> item gives the maximum depth of the operand stack of this method at any point during 
	 * execution of the method.</p>
	 * @return value of <code>max_stack</code> field
	 */
 	public short getMax_stack() { return max_stack; }
 	/**
	 * Accessor method to <code>max_locals</code> field
	 * 
	 * <p>The value of the <code>max_locals</code> item gives the number of local variables in the local variable array allocated upon 
	 * invocation of this method, including the local variables used to pass parameters to the method on its invocation.</p>
	 * <p>The greatest local variable index for a value of type <code>long</code> or <code>double</code> is <code>max_locals - 2</code>. 
	 * The greatest local variable index for a value of any other type is <code>max_locals - 1</code>.<p>
	 * @return value of <code>max_locals</code> field
	 */
 	public short getMax_locals() { return max_locals; }
 	/**
	 * Accessor method to <code>code_length</code> field
	 * 
	 * <p>The value of the <code>code_length</code> item gives the number of <code>bytes</code> in the code array for this method.</p>
	 * <p>The value of <code>code_length</code> must be greater than zero (as the code array must not be empty) and less than 65536.</p>
	 * @return value of <code>code_length</code> field
	 */
 	public int getCode_length() { return code_length; }
 	/**
	 * Accessor method to <code>code</code> field
	 * 
	 * <p>The <code>code</code> array gives the actual bytes of Java Virtual Machine code that implement the method.</p>
	 * <p>When the <code>code</code> array is read into memory on a byte-addressable machine, if the first byte of the array is aligned on a 
	 * 4-byte boundary, the <code>tableswitch</code> and <code>lookupswitch</code> 32-bit offsets will be 4-byte aligned. 
	 * (Refer to the descriptions of those instructions for more information on the consequences of code array alignment.)</p>
	 * @return value of <code>code</code> field
	 */
 	public byte[] getCode() { return code; }
 	/**
	 * Accessor method to <code>exception_table_length</code> field
	 * 
	 * <p>The value of the <code>exception_table_length</code> item gives the number of entries in the <code>exception_table</code> table.</p>
	 * @return value of <code>exception_table_length</code> field
	 */
 	public short getException_table_length() { return exception_table_length; }
 	/**
	 * Accessor method to <code>exception_table</code> field
	 * 
	 * <p>Each entry in the <code>exception_table</code> array describes one exception handler in the code array. The order of the handlers in 
	 * the <code>exception_table</code> array is significant.</p>
	 * @return value of <code>exception_table</code> field
	 */
 	public exception_table_info[] getException_table() { return exception_table; }
 	/**
	 * Accessor method to <code>attributes_count</code> field
	 * 
	 * <p>The value of the <code>attributes_count</code> item indicates the number of attributes of the Code attribute.</p>
	 * @return value of <code>attributes_count</code> field
	 */
 	public short getAttributes_count() { return attributes_count; }
 	/**
	 * Accessor method to <code>attributes</code> field
	 * 
	 * <p>Each value of the  <code>attributes</code> table must be an <code>attribute_info</code> structure. A Code attribute can have any 
 	 * number of optional <code>attributes</code> associated with it.</p>
	 * @return value of <code>attributes</code> field
	 */
 	public attribute_info[] getAttributes() { return attributes; }

	public String toString(int indent, cp_info[] constant_pool) {
		String indentStr = getIndent(indent);
		String res=super.toString(indent, constant_pool);
		res+=indentStr+" max_stack: "+max_stack+"\n";
		res+=indentStr+" max_locals: "+max_locals+"\n";
		res+=indentStr+" code_length: "+code_length+"\n";
		res+=indentStr+"code:\n";
		res+=getCodeStr(indent+1,constant_pool);
		res+=indentStr+" exception_table_length: "+exception_table_length+"\n";
		for(int i=0;i<exception_table_length;++i)
		{
			res+=indentStr+"exception_table["+i+"]:\n";
			res+=exception_table[i].toString(indent+1, constant_pool);
		}
		res+=indentStr+" attributes_count: "+attributes_count+"\n";
		for(int i=0;i<attributes_count;++i)
		{
			res+=indentStr+"attributes["+i+"]:\n";
			res+=attributes[i].toString(indent+1, constant_pool);
		}
		return res;
	}
	
	public String getCodeStr(int indent, cp_info[] constant_pool)
    {
		String res="";
    	String indentStr = getIndent(indent);
		int offset=0;
		try 
		{
			while(offset<code.length)
			{
				instruction ins;
				
				ins = instruction.getByteCode(code, offset);
			
				res+=indentStr+ins.getMnemonic()+"\n";
				offset+=ins.getSize();
			} 
			
		}
		catch (Exception e) 
		{
			res+=indentStr+"??Unknown Instruction "+String.format("%02x ", code[offset])+"\n";
		}
		return res;
    }
}
