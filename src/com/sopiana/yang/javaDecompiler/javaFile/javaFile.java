package com.sopiana.yang.javaDecompiler.javaFile;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.field_info;
import com.sopiana.yang.javaDecompiler.component.method_info;

public class javaFile {
	private ClassFile classObj;
	private String packageName;
	private String className;
	private String classModifier;
	private String superClassName;
	private String[] interfaces;
	private javaField[] fields;
	private javaMethod[] methods;
	private javaFile(ClassFile classObj){
		this.classObj = classObj;
	}
	
	public static javaFile getInstance(ClassFile classObj)
	{	
		try {
			javaFile res = new javaFile(classObj);
			res.resolvePackageAndClassName();
			res.resolveClassModifier();
			res.resolveSuperClassName();
			res.resolveInterfaces();
			res.resolveFields();
			res.resolveMethods();
			return res;
		} catch (decompilerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void resolvePackageAndClassName() throws decompilerException
	{
		String packageName = this.classObj.getClassName();
		this.packageName = packageName.substring(0, packageName.lastIndexOf("/")).replace("/", ".");
		
		this.className = packageName.substring(packageName.lastIndexOf("/")+1);
		System.out.println("::packageName:"+this.packageName+" className:"+this.className);
	}
	
	private void resolveClassModifier()
	{
		this.classModifier = ClassFile.getAccessModifier(this.classObj.getAccess_flags());
		System.out.println("::classModifier:"+this.classModifier);
	}
	
	private void resolveSuperClassName() throws decompilerException
	{
		this.superClassName = this.classObj.getSuperClassName();
		System.out.println("::superClassName:"+(this.superClassName==null?"null":this.superClassName));
	}
	
	private void resolveInterfaces()throws decompilerException
	{
		this.interfaces = new String[this.classObj.getInterfaces_count()];
		short[]interfacesIndexes = this.classObj.getInterfaces();
		System.out.print("::Interfaces:");
		for(int i=0;i<this.interfaces.length;++i)
		{
			this.interfaces[i] = this.classObj.getInterfaceName(interfacesIndexes[i]);
			System.out.print(this.interfaces[i]+" ");
		}
		System.out.println();
	}
	
	private void resolveFields() throws decompilerException
	{
		this.fields = new javaField[this.classObj.getFfields_count()];
		field_info[] fieldsObj = this.classObj.getFields();
		System.out.println("::fields:"+fieldsObj.length);
		for(int i=0;i<fieldsObj.length;++i)
		{
			this.fields[i] = javaField.getInstance(classObj, fieldsObj[i]);
		}
	}
	
	private void resolveMethods() throws decompilerException
	{
		this.methods = new javaMethod[this.classObj.getMethods_count()];
		method_info[] methodsObj = this.classObj.getMethods();
		System.out.println("::methods:"+methodsObj.length);
		for(int i=0;i<methodsObj.length;++i)
		{
			this.methods[i] = javaMethod.getInstance(classObj, methodsObj[i]);
		}
	}
}
