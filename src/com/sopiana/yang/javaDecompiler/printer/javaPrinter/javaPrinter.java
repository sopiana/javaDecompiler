package com.sopiana.yang.javaDecompiler.printer.javaPrinter;

import java.util.ArrayList;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.printer.decompilerPrinter;

public class javaPrinter implements decompilerPrinter
{
	private ArrayList<ClassFile> classes;
	private String outputPath;
	
	public javaPrinter() 
	{
		classes = new ArrayList<>();
	}
	
	public javaPrinter(ArrayList<ClassFile>classes, String outputPath) 
	{
		this.classes = classes;
		this.outputPath = outputPath;
	}
	
	public void addClass(ClassFile classfile)
	{
		this.classes.add(classfile);
	}
	
	public void setOuputPath(String path) 
	{
		this.outputPath = path;
	}

	public void generateOuputFile() throws decompilerException 
	{
		classFileHandler handler;
		for(ClassFile classObj:classes)
		{
			handler = classFileHandler.getInstance(classObj);
			System.out.println(handler.getSourceFile());
			System.out.println(handler.getPackageName());
			System.out.println(handler.getClassName());
			System.out.println(handler.getSuperClassName());
			
			ArrayList<String>strs = handler.getImplementedInterfaces();
			for(String str:strs)
			{
				System.out.println(">"+str);
			}
			strs = handler.getImportedPackage();
			for(String str:strs)
			{
				System.out.println(">>"+str);
			}
			System.out.println("=================================================================");
		}
		
	}

}
