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
/**
 * <code>attribute_info</code> class contains abstraction of Java Virtual Machine <i>Attributes</i> elements.
 * 
 * <p><i>Attributes</i> are used in the <code>ClassFile</code>, <code>field_info</code>, <code>method_info</code>, and
 * <code>Code_attribute</code> structures of the class file format (§4.1, §4.5, §4.6, §4.7.3).</p>
 * <p>All attributes have the following general format:</p>
 * <code>attribute_info {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attribute_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 attribute_length;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 info[attribute_length];<br>
 * }</code>
 * 
 * @author yang.sopiana
 * @see <p>The Java® Virtual Machine Specification Java SE 8 Edition section 4.7 Attributes</p>
 */
public class attribute_info extends class_info
{
	/**
	 * <code>ConstantValue</code> attribute name
	 */
	public static final String ATTRIB_CONSTANT_VALUE = "ConstantValue";
	/**
	 * <code>Code</code> attribute name
	 */
	public static final String ATTRIB_CODE = "Code";
	/**
	 * <code>StackMapTable</code> attribute name
	 */
	public static final String ATTRIB_STACKMAP_TABLE = "StackMapTable";
	/**
	 * <code>Exceptions</code> attribute name
	 */
	public static final String ATTRIB_EXCEPTIONS = "Exceptions";
	/**
	 * <code>BootstrapMethods</code> attribute name
	 */
	public static final String ATTRIB_BOOTSTRAP_METHODS = "BootstrapMethods";
	/**
	 * <code>InnerClasses</code> attribute name
	 */
	public static final String ATTRIB_INNERCLASSES = "InnerClasses";
	/**
	 * <code>EnclosingMethod</code> attribute name
	 */
	public static final String ATTRIB_ENCLOSING_METHOD = "EnclosingMethod";
	/**
	 * <code>Synthetic</code> attribute name
	 */
	public static final String ATTRIB_SYNTHETIC = "Synthetic";
	/**
	 * <code>Signature</code> attribute name
	 */
	public static final String ATTRIB_SIGNATURE = "Signature";
	/**
	 * <code>RuntimeVisibleAnnotations</code> attribute name
	 */
	public static final String ATTRIB_RUNTIME_VISIBLE_ANNOTATIONs = "RuntimeVisibleAnnotations";
	/**
	 * <code>RuntimeInvisibleAnnotations</code> attribute name
	 */
	public static final String ATTRIB_RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
	/**
	 * <code>RuntimeVisibleParameterAnnotations</code> attribute name
	 */
	public static final String ATTRIB_RUNTIME_VISIBLE_PARAM_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
	/**
	 * <code>RuntimeInvisibleParameterAnnotations</code> attribute name
	 */
	public static final String ATTRIB_RUNTIME_INVISIBLE_PARAM_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
	/**
	 * <code>RuntimeVisibleTypeAnnotations</code> attribute name
	 */
	public static final String ATTRIB_RUNTIME_VISIBLE_TYPE_ANNOTATIONS = "RuntimeVisibleTypeAnnotations";
	/**
	 * <code>RuntimeInvisibleTypeAnnotations</code> attribute name
	 */
	public static final String ATTRIB_RUNTIME_INVISIBLE_TYPE_ANNOTATIONS = "RuntimeInvisibleTypeAnnotations";
	/**
	 * <code>AnnotationDefault</code> attribute name
	 */
	public static final String ATTRIB_ANNOTATION_DEFAULT = "AnnotationDefault";
	/**
	 * <code>MethodParameters</code> attribute name
	 */
	public static final String ATTRIB_METHOD_PARAMETERS = "MethodParameters";
	/**
	 * <code>SourceFile</code> attribute name
	 */
	public static final String ATTRIB_SOURCE_FILE = "SourceFile";
	/**
	 * <code>SourceDebugExtension</code> attribute name
	 */
	public static final String ATTRIB_SOURCEDEBUG_EXTENSION = "SourceDebugExtension";
	/**
	 * <code>LineNumberTable</code> attribute name
	 */
	public static final String ATTRIB_LINE_NUMBER_TABLE = "LineNumberTable";
	/**
	 * <code>LocalVariableTable</code> attribute name
	 */
	public static final String ATTRIB_LOCAL_VAR_TABLE = "LocalVariableTable";
	/**
	 * <code>LocalVariableTypeTable</code> attribute name
	 */
	public static final String ATTRIB_LOCAL_VAR_TYPE_TABLE = "LocalVariableTypeTable";
	/**
	 * <code>Deprecated</code> attribute name
	 */
	public static final String ATTRIB_DEPRECATED = "Deprecated";
	/**
	 * For all attributes, the <code>attribute_name_index</code> must be a valid unsigned 16-bit index into the 
	 * <code>constant pool</code> of the class. The <code>constant_pool</code> entry at <code>attribute_name_index</code> must 
	 * be a <code>CONSTANT_Utf8_info</code> structure (§4.4.7) representing the name of the attribute. 
	 */
	protected short attribute_name_index;
	/**
	 * The value of the <code>attribute_length</code> item indicates the length of the subsequent information in bytes. 
	 */
	protected int attribute_length;
	/**
	 * Main information contained for each attribute. Different attribute type will have different <code>info</code> structure.
	 */
    private byte info[];	//attribute_length
    
    /**
     * Factory method to generate <code>attribute_info</code> instance
     * 
     * <p>This method generate the abstract <code>attribute_info</code> instance. To generate the specific attribute instance,
     * use <code>getAttribute</code> method after getting the instance.</p>
     * @param classFileData class file data in array of byte
     * @param offset start offset where the <code>attribute_info</code> structure starts
     * @return abstract <code>attribute_info</code> instance, to get specific attribute, use <code>getAttribute</code> method.
     */
	public static attribute_info getInstance(byte[]classFileData, int offset)
	{
		attribute_info res = new attribute_info();
		res.offset = offset;
		res.attribute_name_index = Util.byte2Short(classFileData,offset);offset+=2;
		res.attribute_length = Util.byte2Int(classFileData,offset);offset+=4;
		res.info = Arrays.copyOfRange(classFileData, offset, offset+res.attribute_length);
		return res;
	}
	/**
	 * Return size of an attribute.
	 * 
	 * <p>The size of the attribute will be total of 2 bytes of <code>attribute_name_index</code>, 4 bytes of <code>attribute_length</code>
	 * and <i>n</i> bytes of <code>info</code>. The <i>n</i> represents <code>attribute_length</code> value.</p>
	 * @return size of <code>attribute_info</code> instance
	 */
	public int getSize()
	{
		return 6+attribute_length;
	}
	
	/**
	 * Return <code>attribute_name_index</code> value.
	 * 
	 * <p>The <code>attribute_name_index</code> value should be positive integer. Since <code>attribute_name_index</code> type 
	 * is <code>short</code>, overflow will be possible. To avoid the overflow, perform <code>&amp;</code>(bitwise and) with <code>
	 * 0xFFFF</code> is needed.</p>
	 * @return <code>attribute_name_index</code> value
	 */
	public int getAttribute_name_index() { return attribute_name_index&0xFFFF; }
	
	/**
	 * Return <code>attribute_length</code> value
	 * 
	 * <p>The value of the <code>attribute_length</code> item indicates the length of the subsequent information in bytes.</p>
	 * @return <code>attribute_length</code> value
	 */
	public int getAttribute_length() { return attribute_length; }
	
	/**
	 * Return <code>info</code> field value
	 * 
	 * <p>The <code>info</code> field contains main information contained for each attribute. Different attribute type will 
	 * have different <code>info</code> structure.</p>
	 * @return <code>info</code> field value
	 */
	public byte[] getInfo() { return this.info; }
	
	/**
	 * Get actual attribute type instance according to attribute supplied attribute name 
	 * 
	 * <code>attributeName</code> should be one of 23 predefined attributes in Java Virtual Machine Specifications, otherwise
	 * the method will return the same object.
	 * @param attributeName attribute name string get from class <code>constant_pool</code> entry at <code>attribute_name_index</code>
	 * @return one of Java Virtual Machine predefined attribute object or same object if <code>attributeName</code> is not recognized
	 * @throws decompilerException if the <code>info</code> is not in valid format of specific attribute type
	 */
	public attribute_info getAttribute(String attributeName) throws decompilerException
	{
		if(attributeName.equals(ATTRIB_CONSTANT_VALUE))
			return ConstantValue_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_CODE))
			return Code_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_STACKMAP_TABLE))
			return StackMapTable_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_EXCEPTIONS))
			return Exceptions_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_INNERCLASSES))
			return InnerClasses_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_ENCLOSING_METHOD))
			return EnclosingMethod_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_SYNTHETIC))
			return Synthetic_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_SIGNATURE))
			return Signature_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_SOURCE_FILE))
			return SourceFile_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_SOURCEDEBUG_EXTENSION))
			return SourceDebugExtension_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_LINE_NUMBER_TABLE))
			return LineNumberTable_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_LOCAL_VAR_TABLE))
			return LocalVariableTable_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_LOCAL_VAR_TYPE_TABLE))
			return LocalVariableTypeTable_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_DEPRECATED))
			return Deprecated_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_RUNTIME_VISIBLE_ANNOTATIONs))
			return RuntimeVisibleAnnotations_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_RUNTIME_INVISIBLE_ANNOTATIONS))
			return RuntimeInvisibleAnnotations_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_RUNTIME_VISIBLE_PARAM_ANNOTATIONS))
			return RuntimeVisibleParameterAnnotations_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_RUNTIME_INVISIBLE_PARAM_ANNOTATIONS))
			return RuntimeInvisibleParameterAnnotations_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_RUNTIME_VISIBLE_TYPE_ANNOTATIONS))
			return RuntimeVisibleTypeAnnotations_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_RUNTIME_INVISIBLE_TYPE_ANNOTATIONS))
			return RuntimeInvisibleTypeAnnotations_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_ANNOTATION_DEFAULT))
			return AnnotationDefault_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_METHOD_PARAMETERS))
			return MethodParameters_attribute.getInstance(this);
		if(attributeName.equals(ATTRIB_BOOTSTRAP_METHODS))
			return BootstrapMethods_attribute.getInstance(this);
		return this;
	}
	
}
