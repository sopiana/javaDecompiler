package com.sopiana.yang.javaDecompiler.javaFile;

import com.sopiana.yang.javaDecompiler.component.ClassFile;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.field_info;

public class javaField 
{
	private String fieldName;
	private String fieldModifier;
	private String fieldDescriptor;
	public static javaField getInstance(ClassFile classObj, field_info fieldObj) throws decompilerException
	{
		javaField res = new javaField();
		res.fieldName = cp_info.getName(fieldObj.getName_index(), classObj.getConstant_pool());
		res.fieldModifier = field_info.getAccessModifier(fieldObj.getAccess_flags());
		res.fieldDescriptor = cp_info.getName(fieldObj.getDescriptor_index(),classObj.getConstant_pool());
		System.out.println(res.fieldModifier+" "+res.fieldDescriptor+" "+res.fieldName+";");
		return res;
	}
}
