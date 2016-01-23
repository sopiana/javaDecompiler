package com.sopiana.yang.javaDecompiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
/**
 * Java Decompiler Main Class
 * 
 * <p>Provides user accessible <code>main</code> method. Contains entry point to java .jar and .class decompilation process</p>
 * 
 * @author yang.sopiana
 *
 */
public class javaDecompiler 
{
	/**
	 * javaDecompiler <code>main</code> method.
	 * 
	 * <p>The method provide to end user to run the application. To decompile the .jar or .class user should input
	 * valid application arguments to this method, otherwise the application will only show help display.</p>
	 * <p>Supported application arguments are:</p>
	 * <ul>
	 * <li><code>-input &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code>: followed by .jar or .class to be decompiled</li>
	 * <li><code>-outputpath </code>: followed by folder name which the output saved</li>
	 * <li><code>-version &nbsp;&nbsp;&nbsp;</code>: to show the Java Decompiler current version</li>
	 * <li><code>-help &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code>: to show Java Decompiler usage</li>
	 * </ul>
	 * @param args application arguments
	 */
	public static void main(String[]args)
	{
		System.out.println(Integer.MAX_VALUE);
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
	/**
	 * Method to retrieve a class file in java virtual machine .class file structure
	 * 
	 * <p>The method will return a <code>ClassFile</code> object, which represent the .class file
	 * in java virtual machine class file structure. The method will read the inputstream, store the data in array and 
	 * do pass the data to <code>ClassFile.getInstance</code> method.</p>
	 * <i>Note: Since the inputstream will be stored in array of byte, the maximum size can handled is 2,147,483,647 bytes</i> 
	 * @param fis class file input stream
	 * @param fileSize the size of file
	 * @return <code>ClassFile</code> object, representing the inputed inputstream in Java Virtual Machine class file structure
	 */
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
	
	/**
	 * Method to parse and decompile .class file
	 * 
	 * <p>The <code>processClassFile</code> method is specially use for parsing and decompiling .class file.
	 * Inputed File parameter will processed as input stream and passed to <code>getClassObject</code> method to get the 
	 * <code>ClassFile</code> object in Java Virtual Machine structure. The <code>ClassFile</code> object then will be
	 * processed to get .java file.</p>
	 * @param classFile <code>File</code> object which handle the .class File
	 * @throws FileNotFoundException if File is not exist
	 * @throws decompilerException if the .class File has invalid Java Virtual Machine .class format
	 */
	public static void processClassFile(File classFile) throws FileNotFoundException, decompilerException
	{
		ClassFile classObj;
		int size = (int)classFile.length();
		if(size<0)
			throw new decompilerException("Size is too big to handle");
		InputStream fis = new FileInputStream(classFile);
		classObj = getClassObject(fis, size);
		//TODO: generate .java file
	}
	
	/**
	 * Method to parse and decompile .jar file
	 * 
	 * <p>The .jar file is a compressed file containing one or more .class file and zero or more description file.
	 * <code>processJarFile</code> will extract the .jar file and passed each entry to <code>getClassObject</code> method 
	 * to get the <code>ClassFile</code> object in Java Virtual Machine structure. The <code>ClassFile</code> object then 
	 * will be processed to get .java file.</p>
	 * 
	 * @param jarFile <code>File</code> object which handle the .jar File
	 * @throws ZipException if .jar file is not in valid deflated (.zip) format
	 * @throws IOException if .jar file can't be read, due to access conditions.
	 * @throws decompilerException if the .class File has invalid Java Virtual Machine .class format
	 */
	public static void processJarFile(File jarFile) throws ZipException, IOException, decompilerException
	{
		ArrayList<ClassFile>classesObj = new ArrayList<ClassFile>();
		int size = 0;
		
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
			classesObj.add(getClassObject(fis, size));
			//TODO: generate .java and manifest file
		}
		zipJar.close();
	}
}
