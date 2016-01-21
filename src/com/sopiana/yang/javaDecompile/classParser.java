package com.sopiana.yang.javaDecompile;

import java.io.File;
import java.io.FileInputStream;

import com.sopiana.yang.javaDecompile.component.ClassFile;

public class classParser 
{
	public static final float a = 3.14f;
	public static void main(String[]args)
	{
		String fileName = "D:\\Ayah\\javacard\\CardAnalyzer\\javaDecompiler\\test\\CONSTANT_Classref_info.class";
		File fClass = new File(fileName);
		ClassFile classObj;
		if(!fClass.exists())
		{
			System.out.println("No File Found");
			return;
		}
		int fileSize = (int)fClass.length();
		if(fileSize>0)
		{
			try 
			{
				byte data[] = new byte[fileSize];			
				FileInputStream fis = new FileInputStream(fClass);
				fis.read(data);
				classObj = ClassFile.getInstance(data);
				classObj.parse();
				System.out.println(classObj.toString());
				fis.close();
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
