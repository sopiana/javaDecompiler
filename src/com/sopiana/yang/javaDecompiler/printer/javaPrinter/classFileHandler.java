package com.sopiana.yang.javaDecompiler.printer.javaPrinter;

import java.util.ArrayList;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.InnerClass_info;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.InnerClasses_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.SourceFile_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Class_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Utf8_info;

public class classFileHandler 
{
	private String sourceFile;
	private String packageName;
	private String className;
	private String superClassName;
	private ArrayList<String> importedPackage;
	private ArrayList<String> implementedInterfaces;
	
	ClassFile classObj;
	
	public static classFileHandler getInstance(ClassFile classObj) throws decompilerException
	{
		classFileHandler res = new classFileHandler();
		res.classObj= classObj;
		
		res.importedPackage = new ArrayList<>();
		res.implementedInterfaces = new ArrayList<>();
		res.parseThis_Class();
		res.parseSuper_Class();
		res.parseInterfaces();
		res.parseAttributes();
		return res;
	}
	
	private void parseAttributes() throws decompilerException 
	{
		for(attribute_info attrib:classObj.getAttributes())
		{
			if(attrib instanceof SourceFile_attribute)
			{
				sourceFile = cp_info.getName(((SourceFile_attribute)attrib).getSourcefile_index(),classObj.getConstant_pool());
			}
			if(attrib instanceof InnerClasses_attribute)
			{
				InnerClasses_attribute innerClass = (InnerClasses_attribute)attrib;
				System.out.println("==>"+innerClass.getNumber_of_classes());
				InnerClass_info innerClasses[] = innerClass.getClasses();
				for(InnerClass_info cla:innerClasses)
				{
					if(cla.getInner_name_index()!=0)
						System.out.println("===>"+cp_info.getName(cla.getInner_name_index(),classObj.getConstant_pool()));
				}
			}
		}
	}
	
	private String getClassName(int index) throws decompilerException
	{
		int nameIndex=0;
		cp_info constant_pool[] = classObj.getConstant_pool();
		if(constant_pool[index] instanceof CONSTANT_Class_info)
		{
			nameIndex = ((CONSTANT_Class_info)constant_pool[index]).getName_index();
		
			if(constant_pool[nameIndex] instanceof CONSTANT_Utf8_info)
			{
				return ((CONSTANT_Utf8_info)constant_pool[nameIndex]).getString();
			}
			throw new decompilerException("constant_pool entry in specified name index is not CONSTANT_Utf8_info");
		}
		throw new decompilerException("constant_pool entry in specified argument is not CONSTANT_Class_info");
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
	private void parseThis_Class() throws decompilerException
	{
		packageName = getClassName(classObj.getThis_class());
		className = packageName.substring(packageName.lastIndexOf("/")+1);
		System.out.println(className);
		packageName = packageName.substring(0, packageName.lastIndexOf("/"));
	}
	
	private void parseSuper_Class() throws decompilerException
	{
		superClassName = getClassName(classObj.getSuper_class());
		if(superClassName.contains("/"))
			addImportedPackage(superClassName.substring(0, superClassName.lastIndexOf("/")));
	}
	
	private void parseInterfaces() throws decompilerException
	{
		String interfaceName;
		short[] interfaces = classObj.getInterfaces();
		for(int i=0;i<interfaces.length;++i)
		{
			interfaceName = getClassName(interfaces[i]);
			implementedInterfaces.add(interfaceName);
			if(interfaceName.contains("/"))
				addImportedPackage(interfaceName.substring(0, interfaceName.lastIndexOf("/")));
		}
	}
	public String getSourceFile() { return sourceFile; }
	public String getPackageName(){ return packageName; }
	public String getClassName() { return className; }
	public String getSuperClassName() { return superClassName;}
	public ArrayList<String> getImportedPackage() { return importedPackage; }
	public ArrayList<String> getImplementedInterfaces() { return implementedInterfaces; }
}
