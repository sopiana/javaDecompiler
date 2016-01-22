package com.sopiana.yang.javaDecompile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.sopiana.yang.javaDecompile.component.ClassFile;
import com.sopiana.yang.javaDecompile.component.decompilerException;

public class classParser 
{
	public static void main(String[]args)
	{
		try
		{
			//String fileName = "D:\\Ayah\\javacard\\CardAnalyzer\\javaDecompiler\\test\\CONSTANT_Classref_info.class";;
			String fileName = "D:\\Ayah\\javacard\\CardAnalyzer\\javaDecompiler\\test\\jsoup-1.8.3.jar";
			ClassFile classObj;
			File fClass = new File(fileName);
			int size;
			if(!fClass.exists())
			{
				System.out.println("No File Found");
				return;
			}
			
			if(fileName.lastIndexOf(".jar")==fileName.length()-4)
			{	
				ZipFile zipJar = new ZipFile(fClass); 
				Enumeration<? extends ZipEntry> entries = zipJar.entries();
				while(entries.hasMoreElements())
				{
					ZipEntry zipEntry = entries.nextElement();
					String entryName = zipEntry.getName();
					InputStream fis = zipJar.getInputStream(zipEntry);
					size = (int)zipEntry.getSize();
					
					if(size<=0 || entryName.length()<6 || entryName.lastIndexOf(".class")!=entryName.length()-6)
						continue;
					System.out.println(entryName);
					classObj = getClassObject(fis, size);

				}
				zipJar.close();
			}
			else if(fileName.lastIndexOf(".class")==fileName.length()-6)
			{
				size = (int)fClass.length();
				if(size<0)
					throw new decompilerException("Size is too big to handle");
				InputStream fis = new FileInputStream(fClass);
				classObj = getClassObject(fis, size);
			}
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
			/*int line=0;
			System.out.format("fileSize %d ", fileSize);
			for(int i=0;i<data.length;++i)
			{
				if(i%16==0)
				{
					System.out.format("\n%04x ", line);
					++line;
				}
				System.out.format("%02x ", data[i]);
			}*/
			classObj = ClassFile.getInstance(data);
			classObj.parse();
			return classObj;
		} 
		catch (IOException | decompilerException e) 
		{
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
}
