package com.sopiana.yang.javaDecompile.component;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.crypto.Mac;

import com.sopiana.yang.javaDecompile.subComponent.CONSTANT_Utf8_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class ClassFile
{
	public static final short ACC_PUBLIC = 0x0001;			//Declared public; may be accessed from outside its package.
	public static final short ACC_FINAL = 0x0010;			//Declared final; no subclasses allowed.
	public static final short ACC_SUPER = 0x0020;			//Treat superclass methods specially when invoked by the invokespecial instruction.
	public static final short ACC_INTERFACE = 0x0200;		//Is an interface, not a class.
	public static final short ACC_ABSTRACT = 0x0400;		//Declared abstract; must not be instantiated.
	public static final short ACC_SYNTHETIC = 0x1000;		//Declared synthetic; not present in the source code.
	public static final short ACC_ANNOTATION = 0x2000; 		//Declared as an annotation type.
	public static final short ACC_ENUM = 0x4000;			//Declared as an enum type.
	
	public static final int MAGIC = 0xCAFEBABE;
	private int magic;
	private short minor_version;
	private short major_version;
	private short constant_pool_count;
	private cp_info constant_pool[];	//constant_pool_count-1
	private short access_flags;
	private short this_class;
	private short super_class;
	private short interfaces_count;
	private short interfaces[];			//interfaces_count
	private short fields_count;
	private field_info fields[] ;		//fields_count
	private short methods_count;
	private method_info methods[];		//methods_count
	private short attributes_count;
	private attribute_info attributes[];//attributes_count
    
	private String packageName;
	private String className;
	private String superClassName;
	private ArrayList<String> importedPackage;
	
	public static ClassFile getInstance(byte[] classFileData) throws compilerException
    {
		int offset = 0;
		ClassFile instance = new ClassFile();
		instance.importedPackage = new ArrayList<String>();
		instance.magic = Util.byte2Int(classFileData, offset); offset+=4;
		if(instance.magic!=MAGIC)
			throw new compilerException("Invalid MAGIC number");
		instance.minor_version = Util.byte2Short(classFileData,offset);offset+=2;
		instance.major_version = Util.byte2Short(classFileData,offset);offset+=2;
		instance.constant_pool_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.constant_pool = new cp_info[instance.constant_pool_count - 1];
		for(int i=0;i<instance.constant_pool.length;++i)
		{
			instance.constant_pool[i] = cp_info.getInstance(classFileData, offset);
			offset += instance.constant_pool[i].getSize();
		}
		instance.access_flags = Util.byte2Short(classFileData,offset);offset+=2;
		instance.this_class = Util.byte2Short(classFileData,offset);offset+=2;
		instance.super_class = Util.byte2Short(classFileData,offset);offset+=2;
		instance.interfaces_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.interfaces = new short[instance.interfaces_count];
		for(int i=0;i<instance.interfaces_count;++i)
		{
			instance.interfaces[i] = Util.byte2Short(classFileData,offset);offset+=2;
		}
		instance.fields_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.fields = new field_info[instance.fields_count];
		for(int i=0;i<instance.fields_count;++i)
		{
			instance.fields[i] = field_info.getInstance(classFileData, offset);
			offset += instance.fields[i].getSize();
		}
		instance.methods_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.methods = new method_info[instance.methods_count];
		for(int i=0;i<instance.methods_count;++i)
		{
			instance.methods[i] = method_info.getInstance(classFileData, offset);
			offset += instance.methods[i].getSize();
		}
		instance.attributes_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.attributes = new attribute_info[instance.attributes_count];
		for(int i=0;i<instance.attributes_count;++i)
		{
			instance.attributes[i] = attribute_info.getInstance(classFileData, offset);
			offset += instance.attributes[i].getSize();
		}
		return instance;
    }
	
	public static String getAccessModifier(short access_flag)
	{
		String res="";
		if((access_flag & ACC_PUBLIC) == ACC_PUBLIC)
			res += "public ";
		if((access_flag & ACC_FINAL) == ACC_FINAL)
			res += "final ";
		if((access_flag & ACC_ABSTRACT) == ACC_ABSTRACT)
			res += "abstract ";
		if((access_flag & ACC_INTERFACE) == ACC_INTERFACE)
			res += "interface ";
		else if((access_flag & ACC_ENUM) == ACC_ENUM)
			res += "enum ";
		else
			res += "class ";
		return res;
	}
	
	public void parse() throws  compilerException
	{
		parseThis_Class();
		parseSuper_Class();
	}
	
	private void parseThis_Class() throws compilerException
	{
		if(constant_pool[this_class] instanceof CONSTANT_Utf8_info)
		{
			packageName = ((CONSTANT_Utf8_info)constant_pool[this_class]).getString().replace("/", ".");
			className = packageName.substring(packageName.lastIndexOf(".")+1);
			packageName = packageName.substring(0, packageName.lastIndexOf("."));
			return;
		}
		throw new compilerException("invalid this_class component");
	}
	
	private void addImportedPackage(String packageName)
	{
		if(this.packageName.compareTo(packageName)==0)
			return;
		for(String s:importedPackage)
		{
			if(s.compareTo(packageName)==0)
				return;
		}
		importedPackage.add(packageName);
	}
	
	private void parseSuper_Class() throws compilerException
	{
		if(constant_pool[super_class] instanceof CONSTANT_Utf8_info)
		{
			superClassName = ((CONSTANT_Utf8_info)constant_pool[super_class]).getString().replace("/", ".");
			addImportedPackage(superClassName.substring(0, superClassName.lastIndexOf(".")));
			return;
		}
		throw new compilerException("invalid super_class component");
	}
	
	public String toString()
	{
		String res="";
		try
		{
			System.out.println("Package Name = "+packageName);
			System.out.println("Class Name = "+className);
			System.out.println("Super Class = "+superClassName);
			System.out.println("Imported Package");
			for(String s:importedPackage)
			{
				System.out.println(s);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
}
