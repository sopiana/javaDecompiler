package com.sopiana.yang.javaDecompiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.decompilerException;

public class classParser 
{
	public static void main(String[]args)
	{
		try
		{
			String fileName = "D:\\Ayah\\javacard\\CardAnalyzer\\javaDecompiler\\test\\CONSTANT_Classref_info.class";;
			//String fileName = "D:\\Ayah\\javacard\\CardAnalyzer\\javaDecompiler\\test\\jsoup-1.8.3.jar";
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
