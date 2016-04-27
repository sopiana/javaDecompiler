package com.sopiana.yang.javaDecompiler.javaFile;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.method_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class javaMethod 
{
	private String methodName;
	private String methodModifier;
	private String methodDescriptor;
	private String returnType;
	public static javaMethod getInstance(ClassFile classObj, method_info methodObj) throws decompilerException
	{
		javaMethod res = new javaMethod();
		res.methodName = cp_info.getName(methodObj.getName_index(), classObj.getConstant_pool());
		res.methodModifier = method_info.getAccessModifier(methodObj.getAccess_flags());
		res.methodDescriptor = cp_info.getName(methodObj.getDescriptor_index(),classObj.getConstant_pool());
		res.returnType = Util.getFieldDescriptor(res.methodDescriptor.substring(res.methodDescriptor.lastIndexOf(")")));
		System.out.println(res.methodModifier+res.returnType+" "+res.methodName+" "+res.methodDescriptor+";");
		return res;
	}
}
