package com.sopiana.yang.javaDecompiler.component;

import com.sopiana.yang.javaDecompiler.util.Util;

public class field_info extends class_info
{
	public static final short ACC_PUBLIC 	= 0x0001; 	//Declared public; may be accessed from outside its package.
	public static final short ACC_PRIVATE 	= 0x0002; 	//Declared private; usable only within the defining class.
	public static final short ACC_PROTECTED = 0x0004; 	//Declared protected; may be accessed within subclasses.
	public static final short ACC_STATIC 	= 0x0008; 	//Declared static.
	public static final short ACC_FINAL 	= 0x0010; 	//Declared final; never directly assigned to after object construction (JLS §17.5).
	public static final short ACC_VOLATILE 	= 0x0040; 	//Declared volatile; cannot be cached.
	public static final short ACC_TRANSIENT = 0x0080; 	//Declared transient; not written or read by a persistent object manager.
	public static final short ACC_SYNTHETIC = 0x1000; 	//Declared synthetic; not present in the source code.
	public static final short ACC_ENUM 		= 0x4000; 	//Declared as an element of an enum. 
	
	private short access_flags;
	private short name_index;
	private short descriptor_index;
	private short attributes_count;
	private attribute_info attributes[];		//attributes_count
	
    public static field_info getInstance(byte[]classFileData, int offset)
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
    		res.attributes[i] = attribute_info.getInstance(classFileData, offset);
    		offset += res.attributes[i].getSize();
    	}
    	return res;
	}
    
    public int getSize()
	{
    	int len = 8;
    	for(int i=0;i<attributes_count;++i)
    		len+=attributes[i].getSize();
    	return len;
	}
    public short getAccess_flags() { return access_flags; }
    public short getName_index() { return name_index; }
    public short getDescriptor_index() { return descriptor_index; }
    public int getAttributes_count() { return attributes_count;}
	public attribute_info[] getAttributes() { return attributes; }
	
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
