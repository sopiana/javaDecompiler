package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>InnerClass_info</code> item in <code>InnerClasses_attribute</code> table of a <code>ClassFile</code>
 * 
 * <p>The <code>InnerClass_info</code> entry describe the innerclasses hierarchy of a <code>ClassFile</code>.
 * Every <code>CONSTANT_Class_info</code> entry in the <code>constant_pool</code> table which represents a class or interface <i>C</i> 
 * that is not a package member must have exactly one corresponding entry in the classes array.</p>
 * <p><small>If a class or interface has members that are classes or interfaces, its <code>constant_pool</code> table (and hence its 
 * <code>InnerClasses_attribute</code>) must refer to each such member, even if that member is not otherwise mentioned by the class.</small></p>
 * <p><small>In addition, the <code>constant_pool</code> table of every nested class and nested interface must refer to its enclosing 
 * class, so altogether, every nested class and nested interface will have <code>InnerClasses</code> information for each enclosing class 
 * and for each of its own nested classes and interfaces.</small></p>
 * @author yang.sopiana
 *
 */
public class InnerClass_info 
{
	/**
	 * Marked or implicitly <code>public</code> in source.
	 */
	public static final short ACC_PUBLIC = 0x0001;
	/**
	 * Marked <code>private</code> in source.
	 */
	public static final short ACC_PRIVATE = 0x0002;
	/**
	 * Marked <code>protected</code> in source.
	 */
	public static final short ACC_PROTECTED = 0x0004;
	/**
	 * Marked or implicitly <code>static</code> in source.
	 */
	public static final short ACC_STATIC = 0x0008;
	/**
	 * Marked <code>final</code> in source.
	 */
	public static final short ACC_FINAL = 0x0010; 
	/**
	 * Was an <code>interface</code> in source.
	 */
	public static final short ACC_INTERFACE = 0x0200;
	/**
	 * Marked or implicitly <code>abstract</code> in source.
	 */
	public static final short ACC_ABSTRACT = 0x0400;
	/**
	 * Declared; <code>synthetic</code>; not present in the source code.
	 */
	public static final short ACC_SYNTHETIC = 0x1000; 
	/**
	 * Declared as an <code>annotation</code> type.
	 */
	public static final short ACC_ANNOTATION = 0x2000; 
	/**
	 * Declared as an <code>enum</code> type.
	 */
	public static final short ACC_ENUM = 0x4000; 		

	/**
	 * <p>The value of the <code>inner_class_info_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing <i>C</i>. The 
	 * remaining items in the classes array entry give information about <i>C</i>.</p>
	 */
	private short inner_class_info_index;
	/**
	 * <p>If <i>C</i> is not a member of a class or an interface (that is, if <i>C</i> is a top-level class or interface or a local class 
	 * or an anonymous class, the value of the <code>outer_class_info_index</code> item must be zero.</p>
	 * <p>Otherwise, the value of the <code>outer_class_info_index</code> item must be a valid index into the <code>constant_pool</code> table, 
	 * and the entry at that index must be a <code>CONSTANT_Class_info</code> structure representing the class or interface of which <i>C</i> 
	 * is a member.</p>
	 */
	private short outer_class_info_index;
	/**
	 * <p>If <i>C</i> is anonymous, the value of the <code>inner_name_index</code> item must be zero.</p>
	 * <p>Otherwise, the value of the <code>inner_name_index</code> item must be a valid index into the <code>constant_pool</code> table, and 
	 * the entry at that index must be a <code>CONSTANT_Utf8_info</code> structure that represents the original simple name of <i>C</i>, as 
	 * given in the source code from which this class file was compiled.</p>
	 */
	private short inner_name_index;
	/**
	 * <p>The value of the <code>inner_class_access_flags</code> item is a mask of flags used to denote access permissions to and properties of 
	 * class or interface <i>C</i> as declared in the source code from which this class file was compiled. It is used by a compiler to recover the 
	 * original information when source code is not available. </p>
	 */
	private short inner_class_access_flags;
	/**
	 * Factory method to generate a <code>InnerClass_info</code> instance.
	 * 
	 * <p>The <code>InnerClass_info</code> entry describe the innerclasses hierarchy of a <code>ClassFile</code>.
	 * Every <code>CONSTANT_Class_info</code> entry in the <code>constant_pool</code> table which represents a class or interface <i>C</i> 
	 * that is not a package member must have exactly one corresponding entry in the classes array.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>InnerClass_info</code>
	 */
	public static InnerClass_info getInstance(byte[]classFileData, int offset)
	{
		InnerClass_info res = new InnerClass_info();
		res.inner_class_info_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.outer_class_info_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.inner_name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.inner_class_access_flags = Util.byte2Short(classFileData,offset);offset+=2;
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>InnerClass_info</code> entry components</p>
	 * @return size of <code>InnerClass_info</code> entry
	 */
	public int getSize() { return 8; }
	/**
	 * Accessor method to <code>inner_class_info_index</code> field
	 * 
	 * <p>The value of the <code>inner_class_info_index</code> item must be a valid index into the <code>constant_pool</code> table. The 
	 * <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Class_info</code> structure representing <i>C</i>. The 
	 * remaining items in the classes array entry give information about <i>C</i>.</p>
	 * @return value of <code>inner_class_info_index</code> field
	 */
	public short getInner_class_info_index() { return inner_class_info_index; }  
	/**
	 * Accessor method to <code>outer_class_info_index</code> field
	 * 
	 * <p>If <i>C</i> is not a member of a class or an interface (that is, if <i>C</i> is a top-level class or interface or a local class 
	 * or an anonymous class, the value of the <code>outer_class_info_index</code> item must be zero.</p>
	 * <p>Otherwise, the value of the <code>outer_class_info_index</code> item must be a valid index into the <code>constant_pool</code> table, 
	 * and the entry at that index must be a <code>CONSTANT_Class_info</code> structure representing the class or interface of which <i>C</i> 
	 * is a member.</p>
	 * @return value of <code>outer_class_info_index</code> field
	 */
	public short getOuter_class_info_index() { return outer_class_info_index; }
	/**
	 * Accessor method to <code>inner_name_index</code> field
	 * 
	 * <p>If <i>C</i> is anonymous, the value of the <code>inner_name_index</code> item must be zero.</p>
	 * <p>Otherwise, the value of the <code>inner_name_index</code> item must be a valid index into the <code>constant_pool</code> table, and 
	 * the entry at that index must be a <code>CONSTANT_Utf8_info</code> structure that represents the original simple name of <i>C</i>, as 
	 * given in the source code from which this class file was compiled.</p>
	 * @return value of <code>inner_name_index</code> field
	 */
	public int getInner_name_index() { return inner_name_index&0xFFFF; }
	/**
	 * Accessor method to <code>inner_class_access_flags</code> field
	 * 
	 * <p>The value of the <code>inner_class_access_flags</code> item is a mask of flags used to denote access permissions to and properties of 
	 * class or interface <i>C</i> as declared in the source code from which this class file was compiled. It is used by a compiler to recover the 
	 * original information when source code is not available. </p>
	 * @return value of <code>inner_class_access_flags</code> field
	 */
	public short getInner_class_access_flags() { return inner_class_access_flags; }
	
	public static String getAccessModifier(short access_flag)
	{
		String res="";
		if((access_flag & ACC_PUBLIC) == ACC_PUBLIC)
			res += "public ";
		if((access_flag & ACC_PROTECTED) == ACC_PROTECTED)
			res += "protected ";
		if((access_flag & ACC_PRIVATE) == ACC_PRIVATE)
			res += "private ";
		if((access_flag & ACC_STATIC) == ACC_STATIC)
			res += "static ";
		if((access_flag & ACC_FINAL) == ACC_FINAL)
			res += "final ";
		if((access_flag & ACC_ABSTRACT) == ACC_ABSTRACT)
			res += "abstract ";
		if((access_flag & ACC_INTERFACE) == ACC_INTERFACE)
			res += "interface ";
		else if((access_flag & ACC_ANNOTATION) == ACC_ANNOTATION)
			res += "Annotation ";
		else if((access_flag & ACC_ENUM) == ACC_ENUM)
			res += "enum ";
		else
			res += "class ";
		return res;
	}
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res="";
		res+=indentStr+" inner_class_info: \n";
		res+= constant_pool[inner_class_info_index].toString(indent+1, constant_pool)+"\n";
		res+=indentStr+" outer_class_info: \n";
		res+=constant_pool[outer_class_info_index].toString(indent+1, constant_pool)+"\n";
		try
		{
			res+=indentStr+" inner_name_index: "+cp_info.getName(inner_name_index, constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=indentStr+" inner_name_index: @"+ inner_name_index+"\n";
		}
		return res;
	}
}
