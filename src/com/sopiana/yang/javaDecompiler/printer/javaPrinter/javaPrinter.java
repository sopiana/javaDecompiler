package com.sopiana.yang.javaDecompiler.printer.javaPrinter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
		File output = new File("output");
		if(!output.exists())
			output.mkdirs();
		for(ClassFile classObj:classes)
		{
			handler = classFileHandler.getInstance(classObj);
			/*
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
			}*/
			try 
			{
				output = new File("output\\"+handler.getClassName().replace("/", ".")+".java");
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(output));
				String msg = classObj.toString();
				System.out.println(msg);
				
				fos.write(msg.getBytes());
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("=================================================================");
		}
		
	}

}
