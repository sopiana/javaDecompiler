package com.sopiana.yang.javaDecompiler.component;

import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>fields</code> item in <code>ClassFile</code> structure
 * 
 * <p>Each <code>field</code> is described by a <code>field_info</code> structure.</p>
 * <p>No two fields in one class file may have the same name and descriptor. The structure has the following format:</p>
 * <code>field_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 access_flags;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 descriptor_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attributes_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;attribute_info attributes[attributes_count];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class field_info extends class_info
{
	/**
	 * <code>access_flags</code> shows that a field is declared <code>public</code>; may be accessed from outside its package.
	 */
	public static final short ACC_PUBLIC 	= 0x0001;
	/**
	 * <code>access_flags</code> shows that a field is declared <code>private</code>; usable only within the defining class.
	 */
	public static final short ACC_PRIVATE 	= 0x0002;
	/**
	 * <code>access_flags</code> shows that a field is declared <code>protected</code>; may be accessed within subclasses.
	 */
	public static final short ACC_PROTECTED = 0x0004;
	/**
	 * <code>access_flags</code> shows that a field is declared <code>static</code>.
	 */
	public static final short ACC_STATIC 	= 0x0008;
	/**
	 * <code>access_flags</code> shows that a field is declared <code>final</code>; never directly assigned to after object construction.
	 */
	public static final short ACC_FINAL 	= 0x0010;
	/**
	 * <code>access_flags</code> shows that a field is declared <code>volatile</code>; cannot be cached.
	 */
	public static final short ACC_VOLATILE 	= 0x0040;
	/**
	 * <code>access_flags</code> shows that a field is declared <code>transient</code>; not written or read by a persistent object manager.
	 */
	public static final short ACC_TRANSIENT = 0x0080;
	/**
	 * <code>access_flags</code> shows that a field is declared <code>synthetic</code>; not present in the source code.
	 */
	public static final short ACC_SYNTHETIC = 0x1000;
	/**
	 * <code>access_flags</code> shows that a field is declared as an element of an <code>enum</code>. 
	 */
	public static final short ACC_ENUM 		= 0x4000;
	/**
	 * The value of the <code>access_flags</code> item is a mask of flags used to denote access permission to and 
	 * properties of the field. The interpretation of each flag, when set, is specified by <code>ACC_xx</code> constants
	 */
	private short access_flags;
	/**
	 * The value of the <code>name_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure which 
	 * represents a valid unqualified name denoting a field.
	 */
	private short name_index;
	/**
	 * The value of the <code>descriptor_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure which 
	 * represents a valid field descriptor.
	 */
	private short descriptor_index;
	/**
	 * The value of the <code>attributes_count</code> item indicates the number of additional attributes of this field.
	 */
	private short attributes_count;
	/**
	 * Each value of the <code>attributes</code> table must be an <code>attribute_info</code> structure.<br>
	 * A field can have any number of optional attributes associated with it.
	 */
	private attribute_info attributes[];
	
	/**
	 * Factory method to generate a <code>fields</code> entry from given array of byte in specific offset.
	 * 
	 * <p>Each <code>fields</code> should begin with 2 bytes of <code>access_flags</code> describing access modifier 
	 * on a field, followed by 2 bytes of <code>name_index</code> describing field's name, 2 bytes of <code>descriptor_index</code> 
	 * field descriptor and variable length of <code>attribute_info</code> structures table.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @param constant_pool <code>constant_pool</code> entry of a class
	 * @return instance of <code>field_info</code>
	 * @throws decompilerException if supplied <code>classFileData</code> is not a Valid <code>field_info</code>
	 */
    public static field_info getInstance(byte[]classFileData, int offset,cp_info[] constant_pool) throws decompilerException
	{
    	field_info res = new field_info();
    	res.offset = offset;
    	res.access_flags = Util.byte2Short(classFileData,offset);offset+=2;
    	res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
    	res.descriptor_index = Util.byte2Short(classFileData,offset);offset+=2;
    	res.attributes_count = Util.byte2Short(classFileData,offset);offset+=2;
    	res.attributes = new attribute_info[res.attributes_count];
    	for(int i=0;i<res.attributes_count;++i)
    	{
    		res.attributes[i] = attribute_info.getInstance(classFileData, offset,constant_pool);
    		offset += res.attributes[i].getSize();
    	}
    	return res;
	}
    
    /**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Showing <code>fields</code> entry in 8-bit cells byte including size of <code>tag</code>, <code>access_flag</code>
	 * <code>descriptor_index</code> and <code>attributes</code> table.
	 * components</p>
	 * @return size of <code>fields</code> entry
	 */
    public int getSize()
	{
    	int len = 8;
    	for(int i=0;i<attributes_count;++i)
    		len+=attributes[i].getSize();
    	return len;
	}
    
    /**
     * Accessor method to <code>access_flags</code> field
     * 
	 * <p>The value of the <code>access_flags</code> item is a mask of flags used to denote access permission to and 
	 * properties of the field. The interpretation of each flag, when set, is specified by <code>ACC_xx</code> constants</p>
	 * @return value of <code>access_flags</code> field
	 */
    public short getAccess_flags() { return access_flags; }
    
    /**
     * Accessor method to <code>name_index</code> field
     * 
     * <p>The value of the <code>descriptor_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure which 
	 * represents a valid field descriptor.</p>
     * @return value of <code>name_index</code> field
     */
    public int getName_index() { return name_index&0xFFFF; }
    
    /**
     * Accessor method to <code>descriptor_index</code> field
     * 
     * <p>The value of the <code>descriptor_index</code> item must be a valid index into the <code>constant_pool</code> table. 
	 * The <code>constant_pool</code> entry at that index must be a <code>CONSTANT_Utf8_info</code> structure which 
	 * represents a valid field descriptor.</p>
     * @return value of <code>descriptor_index</code> field
     */
    public int getDescriptor_index() { return descriptor_index&0xFFFF; }
    
    /**
     * Accessor method to <code>attributes_count</code> field
     * 
     * <p>The value of the <code>attributes_count</code> item indicates the number of additional attributes of this field.</p>
     * @return value of <code>attributes_count</code> field
     */
    public int getAttributes_count() { return attributes_count;}
	
    /**
	 * Accessor method to <code>attributes</code> field
	 * 
	 * <p>Each value of the <code>attributes</code> table must be an <code>attribute_info</code> structure.<br>
	 * A field can have any number of optional attributes associated with it.</p>
	 * @return value of <code>attributes</code> table
	 */
    public attribute_info[] getAttributes() { return attributes; }
	
    /**
	 * Return string value of given <code>access_flag</code>
	 * 
	 * <p>Field access modifier is mapped in <code>access_flag</code> field. Each bit representing one Java access modifier.
	 * The <code>synthetic</code> modifier will not shown since it's not specify in Java Language Specification</p>
	 * @param access_flag field <code>access_flag</code> value
	 * @return string value of given <code>access_flag</code>
	 */
    public static String getAccessModifier(short access_flag)
	{
		String res="";
		if((access_flag & ACC_PUBLIC) == ACC_PUBLIC)
			res += "public ";
		if((access_flag & ACC_PRIVATE) == ACC_PRIVATE)
			res += "private ";
		if((access_flag & ACC_PROTECTED) == ACC_PROTECTED)
			res += "protected ";
		if((access_flag & ACC_STATIC) == ACC_STATIC)
			res += "static ";
		if((access_flag & ACC_FINAL) == ACC_FINAL)
			res += "final ";
		if((access_flag & ACC_VOLATILE) == ACC_VOLATILE)
			res += "volatile ";
		if((access_flag & ACC_TRANSIENT) == ACC_TRANSIENT)
			res += "transient ";
		if((access_flag & ACC_ENUM) == ACC_ENUM)
			res += "enum ";
		return res;
	}
}
