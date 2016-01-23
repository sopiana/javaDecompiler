package com.sopiana.yang.javaDecompiler.component;

import java.util.Arrays;

import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.AnnotationDefault_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.BootstrapMethods_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.Code_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.ConstantValue_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.Deprecated_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.EnclosingMethod_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.Exceptions_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.InnerClasses_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.LineNumberTable_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.LocalVariableTable_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.LocalVariableTypeTable_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.MethodParameters_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.RuntimeInvisibleAnnotations_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.RuntimeInvisibleParameterAnnotations_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.RuntimeInvisibleTypeAnnotations_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.RuntimeVisibleAnnotations_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.RuntimeVisibleParameterAnnotations_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.RuntimeVisibleTypeAnnotations_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.Signature_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.SourceDebugExtension_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.SourceFile_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.StackMapTable_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.Synthetic_attribute;
import com.sopiana.yang.javaDecompiler.util.Util;

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
	public byte[] getInfo() { return this.info; }
	
	public attribute_info getAttribute(String attributeInfo) throws decompilerException
	{
		if(attributeInfo.equals(ATTRIB_CONSTANT_VALUE))
			return ConstantValue_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_CODE))
			return Code_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_STACKMAP_TABLE))
			return StackMapTable_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_EXCEPTIONS))
			return Exceptions_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_INNERCLASSES))
			return InnerClasses_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_ENCLOSING_METHOD))
			return EnclosingMethod_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_SYNTHETIC))
			return Synthetic_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_SIGNATURE))
			return Signature_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_SOURCE_FILE))
			return SourceFile_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_SOURCEDEBUG_EXTENSION))
			return SourceDebugExtension_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_LINE_NUMBER_TABLE))
			return LineNumberTable_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_LOCAL_VAR_TABLE))
			return LocalVariableTable_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_LOCAL_VAR_TYPE_TABLE))
			return LocalVariableTypeTable_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_DEPRECATED))
			return Deprecated_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_RUNTIME_VISIBLE_ANNOTATIONs))
			return RuntimeVisibleAnnotations_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_RUNTIME_INVISIBLE_ANNOTATIONS))
			return RuntimeInvisibleAnnotations_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_RUNTIME_VISIBLE_PARAM_ANNOTATIONS))
			return RuntimeVisibleParameterAnnotations_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_RUNTIME_INVISIBLE_PARAM_ANNOTATIONS))
			return RuntimeInvisibleParameterAnnotations_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_RUNTIME_VISIBLE_TYPE_ANNOTATIONS))
			return RuntimeVisibleTypeAnnotations_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_RUNTIME_INVISIBLE_TYPE_ANNOTATIONS))
			return RuntimeInvisibleTypeAnnotations_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_ANNOTATION_DEFAULT))
			return AnnotationDefault_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_METHOD_PARAMETERS))
			return MethodParameters_attribute.getInstance(this);
		if(attributeInfo.equals(ATTRIB_BOOTSTRAP_METHODS))
			return BootstrapMethods_attribute.getInstance(this);
		return this;
	}
	
}
