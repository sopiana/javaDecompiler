package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;

public class bootstrap_methods_info {
	private short bootstrap_method_ref;
	private short num_bootstrap_arguments;
	private short bootstrap_arguments[];	//num_bootstrap_arguments
	public static bootstrap_methods_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		bootstrap_methods_info res = new bootstrap_methods_info();
		res.bootstrap_method_ref = Util.byte2Short(classFileData,offset); offset+=2;
		res.num_bootstrap_arguments = Util.byte2Short(classFileData,offset); offset+=2;
		res.bootstrap_arguments = new short [res.num_bootstrap_arguments];
		for(int i=0;i<res.num_bootstrap_arguments;++i)
		{
			res.bootstrap_arguments[i] = Util.byte2Short(classFileData,offset); offset+=2;
		}
		return res;
	}
	
	public int getSize() { return 4+num_bootstrap_arguments*2; }
}
