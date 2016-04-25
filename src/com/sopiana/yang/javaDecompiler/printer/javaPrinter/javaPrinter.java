package com.sopiana.yang.javaDecompiler.printer.javaPrinter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.printer.decompilerPrinter;

public class javaPrinter implements decompilerPrinter
{
	private ArrayList<ClassFile> classes;
	private String outputPath;
	
	public javaPrinter(String outputPath) 
	{
		classes = new ArrayList<>();
		this.outputPath = outputPath;
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
		Dictionary<String, ArrayList<ClassFile>> sources = new Hashtable<>();
		classFileHandler handler;
		
		//populate javaFileName
		for(ClassFile classObj:classes)
		{
			String className = classObj.getClassName();
			String sourceFileName = className.substring(0, className.lastIndexOf("/")+1)+classObj.getSourceFile();
			ArrayList<ClassFile> cls = sources.get(sourceFileName);
			if(cls==null)
			{
				cls = new ArrayList<ClassFile>();
				sources.put(sourceFileName, cls);
			}
			cls.add(classObj);
		}
		
		Enumeration<String>sourceFiles = sources.keys();
		
		while(sourceFiles.hasMoreElements())
		{
			String sourceFile = sourceFiles.nextElement();
			File output = new File(outputPath+"/"+sourceFile.substring(0,sourceFile.lastIndexOf("/")));
			if(!output.exists())
				output.mkdirs();
			System.out.println("##sourceFile:"+sourceFile);
			
			output = new File(outputPath+"/"+sourceFile);
			try 
			{
				FileWriter fos = new FileWriter(output);
				ArrayList<ClassFile> cls = sources.get(sourceFile);
				for(ClassFile classObj:cls)
				{
					handler = classFileHandler.getInstance(classObj);
					String msg = classObj.toString();
					System.out.println(msg);
					
					fos.write(msg);
					fos.write("========================================");
				}
				fos.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
