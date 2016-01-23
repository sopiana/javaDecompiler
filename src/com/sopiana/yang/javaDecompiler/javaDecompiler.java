package com.sopiana.yang.javaDecompiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
/**
 * Application main class
 * 
 * @author yang.sopiana
 *
 */
public class javaDecompiler 
{
	public static void main(String[]args)
	{
		appOption options = new appOption(args);
		if(options.isShowHelp())
		{
			options.printUsage();
			System.exit(1);
		}
		
		if(options.isShowVersion())
		{
			System.out.println("Java Decompiler ver "+ version.APP_VERSION + " by yang.sopiana");
			System.exit(1);
		}
		
		if(options.getInputFileName()==null)
		{
			options.printUsage();
			System.exit(1);
		}
		
		try
		{
			String fileName = options.getInputFileName();
			File inputFile = new File(fileName);
			if(!inputFile.exists())
			{
				System.out.println("No File Found");
				return;
			}
			
			if(fileName.lastIndexOf(".jar")==fileName.length()-4)
				processJarFile(inputFile);
			else if(fileName.lastIndexOf(".class")==fileName.length()-6)
				processClassFile(inputFile);
			else
				System.out.println("Unknown java file extension");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ClassFile getClassObject(InputStream fis,int fileSize)
	{
		try 
		{
			ClassFile classObj=null;
			byte data[] = new byte[fileSize];			
			fis.read(data);
			classObj = ClassFile.getInstance(data);
			return classObj;
		} 
		catch (IOException | decompilerException e) 
		{
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
	
	public static void processClassFile(File classFile) throws FileNotFoundException, decompilerException
	{
		ClassFile classObj;
		int size = (int)classFile.length();
		if(size<0)
			throw new decompilerException("Size is too big to handle");
		InputStream fis = new FileInputStream(classFile);
		classObj = getClassObject(fis, size);
	}
	
	public static void processJarFile(File jarFile) throws ZipException, IOException, decompilerException
	{
		ClassFile classObj;
		int size = 0;
		if(size<0)
			throw new decompilerException("Size is too big to handle");
		ZipFile zipJar = new ZipFile(jarFile); 
		Enumeration<? extends ZipEntry> entries = zipJar.entries();
		while(entries.hasMoreElements())
		{
			ZipEntry zipEntry = entries.nextElement();
			String entryName = zipEntry.getName();
			InputStream fis = zipJar.getInputStream(zipEntry);
			size = (int)zipEntry.getSize();
			
			if(size<=0 || entryName.length()<6 || entryName.lastIndexOf(".class")!=entryName.length()-6)
				continue;
			classObj = getClassObject(fis, size);
		}
		zipJar.close();
	}
}
