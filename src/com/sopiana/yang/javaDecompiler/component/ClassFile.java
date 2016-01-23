package com.sopiana.yang.javaDecompiler.component;

import java.util.ArrayList;

import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.SourceFile_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Class_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Utf8_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Void;
import com.sopiana.yang.javaDecompiler.util.Util;

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
    
	private String sourceFile;
	private String packageName;
	private String className;
	private String superClassName;
	private ArrayList<String> importedPackage;
	private ArrayList<String> implementedInterfaces;

	private ClassFile()
	{
		importedPackage = new ArrayList<String>();
		implementedInterfaces = new ArrayList<String>();
	}
	
	public static ClassFile getInstance(byte[] classFileData) throws decompilerException
    {
		int offset = 0;
		ClassFile instance = new ClassFile();
	
		instance.magic = Util.byte2Int(classFileData, offset); offset+=4;
		if(instance.magic!=MAGIC)
			throw new decompilerException("Invalid MAGIC number");
		instance.minor_version = Util.byte2Short(classFileData,offset);offset+=2;
		instance.major_version = Util.byte2Short(classFileData,offset);offset+=2;
		instance.constant_pool_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.constant_pool = new cp_info[instance.constant_pool_count];
		instance.constant_pool[0] = new CONSTANT_Void();
		for(int i=1;i<instance.constant_pool.length;++i)
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
		instance.parse();
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
	
	public void parse() throws  decompilerException
	{
		parseThis_Class();
		parseSuper_Class();
		parseInterfaces();
		fixAttributesType();
		fixFieldAttributesType();
		fixMethodAttributesType();
		sourceFile = getSourceFile();
		System.out.println(toString());
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
	
	private String getClassName(int index) throws decompilerException
	{
		int nameIndex=0;
		if(constant_pool[index] instanceof CONSTANT_Class_info)
		{
			nameIndex = ((CONSTANT_Class_info)constant_pool[index]).getName_index();
		
			if(constant_pool[nameIndex] instanceof CONSTANT_Utf8_info)
			{
				return ((CONSTANT_Utf8_info)constant_pool[nameIndex]).getString().replace("/", ".");
			}
			throw new decompilerException("constant_pool entry in specified name index is not CONSTANT_Utf8_info");
		}
		throw new decompilerException("constant_pool entry in specified argument is not CONSTANT_Class_info");
	}
	
	private String getName(int index) throws decompilerException
	{
		if(constant_pool[index] instanceof CONSTANT_Utf8_info)
		{
			return ((CONSTANT_Utf8_info)constant_pool[index]).getString().replace("/", ".");
		}
		throw new decompilerException("constant_pool entry in specified argument is not CONSTANT_Utf8_info");
	}
	
	private void parseThis_Class() throws decompilerException
	{
		packageName = getClassName(this_class);
		className = packageName.substring(packageName.lastIndexOf(".")+1);
		packageName = packageName.substring(0, packageName.lastIndexOf("."));
	}
	
	private void parseSuper_Class() throws decompilerException
	{
		superClassName = getClassName(super_class);
		if(superClassName.contains("."))
			addImportedPackage(superClassName.substring(0, superClassName.lastIndexOf(".")));
	}
	
	private void parseInterfaces() throws decompilerException
	{
		String interfaceName;
		for(int i=0;i<interfaces.length;++i)
		{
			interfaceName = getClassName(interfaces[i]);
			implementedInterfaces.add(interfaceName);
			if(interfaceName.contains("."))
				addImportedPackage(interfaceName.substring(0, interfaceName.lastIndexOf(".")));
		}
	}
	
	private void fixAttributesType() throws decompilerException
	{
		String attribInfo;
		for(int i=0;i<attributes.length;++i)
		{
			attribInfo = getName(attributes[i].getAttribute_name_index());
			attributes[i] = attributes[i].getAttribute(attribInfo);
		}
	}
	
	private void fixFieldAttributesType() throws decompilerException
	{
		String attribInfo;
		for(int i=0;i<fields.length;++i)
		{
			for(int j=0;j<fields[i].getAttributes_count();++j)
			{
				attribInfo = getName(fields[i].getAttributes()[j].getAttribute_name_index());
				fields[i].getAttributes()[j] = fields[i].getAttributes()[j].getAttribute(attribInfo);
			}
		}
	}
	
	private void fixMethodAttributesType() throws decompilerException
	{
		String attribInfo;
		for(int i=0;i<methods.length;++i)
		{
			for(int j=0;j<methods[i].getAttributes_count();++j)
			{
				attribInfo = getName(methods[i].getAttributes()[j].getAttribute_name_index());
				methods[i].getAttributes()[j] = methods[i].getAttributes()[j].getAttribute(attribInfo);
			}
		}
	}
	public String getSourceFile() throws decompilerException
	{
		for(attribute_info attrib:attributes)
		{
			if(attrib instanceof SourceFile_attribute)
			{
				return getName(((SourceFile_attribute)attrib).getSourcefile_index());
			}
		}
		return className;
	}
	
	public String toString()
	{
		String res="";
		try
		{
			System.out.println("==========================================");
			System.out.println("Source File:"+sourceFile);
			System.out.println("Package Name = "+packageName);
			System.out.println("Class Name = "+className);
			System.out.println("Super Class = "+superClassName);
			System.out.println("Imported Package");
			for(String s:importedPackage)
			{
				System.out.println(s);
			}
			
			System.out.println("Implemented interfaces");
			for(String s:implementedInterfaces)
			{
				System.out.println(s);
			}
			
			System.out.println("Fields");
			for(field_info f:fields)
			{
				System.out.println(field_info.getAccessModifier(f.getAccess_flags())+" "+
						getName(f.getName_index())+" "+getName(f.getDescriptor_index()));
				System.out.println("=>Attribute Length:"+f.getAttributes_count());
				for(attribute_info attrib:f.getAttributes())
				{
					System.out.println("==>"+attrib.getClass().getName());
				}
			}
			System.out.println("Methods");
			for(method_info m:methods)
			{
				System.out.println(method_info.getAccessModifier(m.getAccess_flags())+" "+
						getName(m.getName_index())+" "+getName(m.getDescriptor_index()));
				System.out.println("=>Attribute Length:"+m.getAttributes_count());
				for(attribute_info attrib:m.getAttributes())
				{
					System.out.println("==>"+attrib.getClass().getName());
				}
			}
			System.out.println("Attributes");
			for(attribute_info attrib:attributes)
			{
				System.out.println("==>"+attrib.getClass().getName());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

}
