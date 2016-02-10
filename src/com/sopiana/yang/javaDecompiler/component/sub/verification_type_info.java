package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Double_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Float_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Integer_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Long_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Null_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Object_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Top_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.UninitializedThis_variable_info;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type.Uninitialized_variable_info;
/**
 * Provides abstraction for <code>verification_type_info</code> item
 * 
 * <p>A verification type specifies the type of either one or two locations, where a location is either a single local variable or a single 
 * operand stack entry. A verification type is represented by a discriminated union, <code>verification_type_info</code>, that consists of a 
 * one-byte <code>tag</code>, indicating which item of the union is in use, followed by zero or more bytes, giving more information about the 
 * tag.</p>
 * <p>The <code>verification_type_info</code> structure has the following format:</p>
 * <code>union verification_type_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Top_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Integer_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Float_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Long_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Double_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Null_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;UninitializedThis_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Object_variable_info;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Uninitialized_variable_info;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public abstract class verification_type_info 
{
	/**
	 * <code>tag</code> value indicating that the item is an <code>Top_variable_info</code>
	 */
	public static final byte ITEM_Top = 0;
	/**
	 * <code>tag</code> value indicating that the item is an <code>Integer_variable_info</code>
	 */
	public static final byte ITEM_Integer = 1;
	/**
	 * <code>tag</code> value indicating that the item is an <code>Float_variable_info</code>
	 */
	public static final byte ITEM_Float = 2;
	/**
	 * <code>tag</code> value indicating that the item is an <code>Double_variable_info</code>
	 */
	public static final byte ITEM_Double = 3;
	/**
	 * <code>tag</code> value indicating that the item is an <code>Long_variable_info</code>
	 */
	public static final byte ITEM_Long = 4;
	/**
	 * <code>tag</code> value indicating that the item is an <code>Null_variable_info</code>
	 */
	public static final byte ITEM_Null = 5;
	/**
	 * <code>tag</code> value indicating that the item is an <code>UninitializedThis_variable_info</code>
	 */
	public static final byte ITEM_UninitializedThis = 6;
	/**
	 * <code>tag</code> value indicating that the item is an <code>Object_variable_info</code>
	 */
	public static final byte ITEM_Object = 7;
	/**
	 * <code>tag</code> value indicating that the item is an <code>Uninitialized_variable_info</code>
	 */
	public static final byte ITEM_Uninitialized = 8;
	/**
	 * one-byte <code>tag</code>, indicating which item of the union is in use
	 */
	protected byte tag;
	/**
	 * Factory method to generate a <code>verification_type_info</code> instance based on its tag.
	 * 
	 * <p>A verification type specifies the type of either one or two locations, where a location is either a single local variable or a single 
	 * operand stack entry. A verification type is represented by a discriminated union, <code>verification_type_info</code>, that consists of a 
	 * one-byte <code>tag</code>, indicating which item of the union is in use, followed by zero or more bytes, giving more information about the 
	 * tag.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>verification_type_info</code>
	 * @throws decompilerException if supplied <code>classFileData</code> is not a Valid <code>verification_type_info</code>
	 */
	public static verification_type_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		switch(classFileData[offset])
		{
			case ITEM_Top:
				return Top_variable_info.getInstance(classFileData,offset);
			case ITEM_Integer:
				return Integer_variable_info.getInstance(classFileData, offset);
			case ITEM_Double:
				return Double_variable_info.getInstance(classFileData, offset);
			case ITEM_Float:
				return Float_variable_info.getInstance(classFileData, offset);
			case ITEM_Long:
				return Long_variable_info.getInstance(classFileData, offset);
			case ITEM_Null:
				return Null_variable_info.getInstance(classFileData, offset);
			case ITEM_UninitializedThis:
				return UninitializedThis_variable_info.getInstance(classFileData, offset);
			case ITEM_Object:
				return Object_variable_info.getInstance(classFileData, offset);
			case ITEM_Uninitialized:
				return Uninitialized_variable_info.getInstance(classFileData, offset);
			default:
				throw new decompilerException("Arguments passed is not type of verification_type_info");
		}
	}
	/**
	 * Accessor method to <code>tag</code> field
     * 
	 * <p>one-byte <code>tag</code>, indicating which item of the union is in use.</p>
	 * @return value of <code>tag</code> field
	 */
	public byte getTag() { return tag; }
	public abstract int getSize();
	public abstract String toString();
}
