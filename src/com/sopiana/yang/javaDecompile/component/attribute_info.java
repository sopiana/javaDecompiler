package com.sopiana.yang.javaDecompile.component;

import java.util.Arrays;

import com.sopiana.yang.javaDecompile.component.sub.attribute_info.Code_attribute;
import com.sopiana.yang.javaDecompile.component.sub.attribute_info.ConstantValue_attribute;
import com.sopiana.yang.javaDecompile.component.sub.attribute_info.StackMapTable_attribute;
import com.sopiana.yang.javaDecompile.util.Util;

public class attribute_info extends class_info
{
	public static final String ATTRIB_CONSTANT_VALUE = "ConstantValue";
	public static final String ATTRIB_CODE = "Code";
	public static final String ATTRIB_STACKMAP_TABLE = "StackMapTable";
	public static final String ATTRIB_EXCEPTIONS = "Exceptions";
	public static final String ATTRIB_BOOTSTRAP_METHODS = "BootstrapMethods";
	public static final String ATTRIB_INNERCLASSES = "InnerClasses";
	public static final String ATTRIB_ENCLOSING_METHOD = "EnclosingMethod";
	public static final String ATTRIB_SYNTHETIC = "Synthetic";
	public static final String ATTRIB_SIGNATURE = "Signature";
	public static final String ATTRIB_RUNTIME_VISIBLE_ANNOTATIONs = "RuntimeVisibleAnnotations";
	public static final String ATTRIB_RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
	public static final String ATTRIB_RUNTIME_VISIBLE_PARAM_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
	public static final String ATTRIB_RUNTIME_INVISIBLE_PARAM_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
	public static final String ATTRIB_RUNTIME_VISIBLE_TYPE_ANNOTATIONS = "RuntimeVisibleTypeAnnotations";
	public static final String ATTRIB_RUNTIME_INVISIBLE_TYPE_ANNOTATIONS = "RuntimeInvisibleTypeAnnotations";
	public static final String ATTRIB_ANNOTATION_DEFAULT = "AnnotationDefault";
	public static final String ATTRIB_METHOD_PARAMETERS = "MethodParameters";
	public static final String ATTRIB_SOURCE_FILE = "SourceFile";
	public static final String ATTRIB_SOURCEDEBUG_EXTENSION = "SourceDebugExtension";
	public static final String ATTRIB_LINE_NUMBER_TABLE = "LineNumberTable";
	public static final String ATTRIB_LOCAL_VAR_TABLE = "LocalVariableTable";
	public static final String ATTRIB_LOCAL_VAR_TYPE_TABLE = "LocalVariableTypeTable";
	public static final String ATTRIB_DEPRECATED = "Deprecated";

	protected short attribute_name_index;
	protected int attribute_length;
    private byte info[];	//attribute_length
    
	public static attribute_info getInstance(byte[]classFileData, int offset)
	{
		attribute_info res = new attribute_info();
		res.offset = offset;
		res.attribute_name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.attribute_length = Util.byte2Int(classFileData,offset);offset+=4;
		res.info = Arrays.copyOfRange(classFileData, offset, offset+res.attribute_length);
		return res;
	}
	
	public int getSize()
	{
		return 6+attribute_length;
	}
	
	public short getAttribute_name_index() { return attribute_name_index; }
	public int getAttribute_length() { return attribute_length; }
	public byte[] getInfo() { return Arrays.copyOf(info, info.length); }
	
	public attribute_info getAttribute(String attributeInfo) throws decompilerException
	{
		if(attributeInfo.equals(ATTRIB_CONSTANT_VALUE))
			return ConstantValue_attribute.getInstance(attribute_name_index, attribute_length, info);
		if(attributeInfo.equals(ATTRIB_CODE))
			return Code_attribute.getInstance(attribute_name_index, attribute_length, info);
		if(attributeInfo.equals(ATTRIB_STACKMAP_TABLE))
			return StackMapTable_attribute.getInstance(attribute_name_index, attribute_length, info);
		return this;
	}
	
}
