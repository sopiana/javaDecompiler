package com.sopiana.yang.javaDecompiler.component;

import com.sopiana.yang.javaDecompiler.component.sub.attribute_info.SourceFile_attribute;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Class_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Utf8_info;
import com.sopiana.yang.javaDecompiler.component.sub.cp_info.CONSTANT_Void;
import com.sopiana.yang.javaDecompiler.util.Util;

/**
 * <code>ClassFile</code> represents Java Virtual Machine class file structure 
 * 
 * <p>A class file consists of a stream of 8-bit bytes. All 16-bit, 32-bit, and 64-bit quantities are constructed by 
 * reading in two, four, and eight consecutive 8-bit bytes, respectively. </p>
 * <p>A <code>class</code> file consists of a single <code>ClassFile</code> structure:</p>
 * <code>
 * ClassFile {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u4 magic;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 minor_version;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 major_version;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 constant_pool_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;cp_info constant_pool[constant_pool_count-1];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 access_flags;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 this_class;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 super_class;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 interfaces_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 interfaces[interfaces_count];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 fields_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;field_info fields[fields_count];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 methods_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;method_info methods[methods_count];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u2 attributes_count;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;attribute_info attributes[attributes_count];<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class ClassFile
{
	/**
	 * Class is declared <code>public</code>; may be accessed from outside its package.
	 */
	public static final short ACC_PUBLIC = 0x0001;
	/**
	 * Class is declared <code>final</code>; no subclasses allowed.
	 */
	public static final short ACC_FINAL = 0x0010;
	/**
	 * Treat superclass methods specially when invoked by the <code>invokespecial</code> instruction.
	 */
	public static final short ACC_SUPER = 0x0020;	
	/**
	 * <code>ClassFile</code> is an <code>interface</code>, not a <code>class</code>.
	 */
	public static final short ACC_INTERFACE = 0x0200;
	/**
	 * Class is declared <code>abstract</code>; must not be instantiated.
	 */
	public static final short ACC_ABSTRACT = 0x0400;
	/**
	 * Class is declared <code>synthetic</code>; not present in the source code.
	 */
	public static final short ACC_SYNTHETIC = 0x1000;
	/**
	 * Class is declared as an annotation type.
	 */
	public static final short ACC_ANNOTATION = 0x2000;
	/**
	 * Class is declared as an <code>enum</code> type.
	 */
	public static final short ACC_ENUM = 0x4000;
	/**
	 * The specification value for magic number
	 */
	public static final int MAGIC = 0xCAFEBABE;
	
	/**
	 * The magic item supplies the magic number identifying the class file format; it has the value 0xCAFEBABE.
	 */
	private int magic;
	/**
	 * minor version numbers of the class file. 
	 */
	private short minor_version;
	/**
	 * major version numbers of the class file. 
	 */
	private short major_version;
	/**
	 * The value of the constant_pool_count item is equal to the number of entries in the constant_pool table plus one. 
	 */
	private short constant_pool_count;
	/**
	 * The constant_pool is a table of structures (§4.4) representing various string constants, class and interface names, 
	 * field names, and other constants that are referred to within the <code>ClassFile</code> structure and its substructures. 
	 */
	private cp_info constant_pool[];	//constant_pool_count-1
	/**
	 * The value of the access_flags item is a mask of flags used to denote access permissions to and properties of 
	 * class or interface. 
	 */
	private short access_flags;
	/**
	 * The value of the <code>this_class</code> item must be a valid index into the <code>constant_pool</code> table.
	 */
	private short this_class;
	/**
	 * The value of the <code>super_class</code> item either must be zero or must be a valid index into the 
	 * <code>constant_pool</code> table. 
	 */
	private short super_class;
	/**
	 * The value of the <code>interfaces_count</code> item gives the number of direct superinterfaces of this class or 
	 * interface type.
	 */
	private short interfaces_count;
	/**
	 * Each value in the <code>interfaces</code> array must be a valid index into the <code>constant_pool</code> table. 
	 */
	private short interfaces[];			//interfaces_count
	/**
	 * The value of the <code>fields_count</code> item gives the number of <code>field_info</code> structures in the fields table. 
	 */
	private short fields_count;
	/**
	 * Each value in the <code>fields</code> table must be a <code>field_info</code> structure (§4.5) giving a complete description 
	 * of a field in this class or interface. 
	 */
	private field_info fields[] ;		//fields_count
	/**
	 * The value of the <code>methods_count</code> item gives the number of <code>method_info</code> structures in the methods table.
	 */
	private short methods_count;
	/**
	 * Each value in the <code>methods</code> table must be a <code>method_info</code> structure (§4.6) giving a complete 
	 * description of a method in this class or interface.
	 */
	private method_info methods[];		//methods_count
	/**
	 * The value of the <code>attributes_count</code> item gives the number of attributes in the <code>attributes</code> table of 
	 * this class.
	 */
	private short attributes_count;
	/**
	 * Each value of the <code>attributes</code> table must be an <code>attribute_info</code> structure (§4.7).
	 */
	private attribute_info attributes[];//attributes_count

	/**
	 * Factory method for generating instance of <code>ClassFile</code>
	 * 
	 * <p>The <code>classFileData</code> parameter contains class file in raw byte array. The method will get the first 8 bytes and 
	 * check the magic number, then the method will parse each byte of data to java virtual machine class structure.</p>
	 * @param classFileData array of byte contains data in class file
	 * @return <code>ClassFile</code> instance, contains the <code>classFileData</code> in java virtual machine class structures
	 * @throws decompilerException if <code>classFileData</code> is not in valid class structures
	 */
	public static ClassFile getInstance(byte[] classFileData) throws decompilerException
    {
		int offset = 0;
		ClassFile instance = new ClassFile();
	
		instance.magic = Util.byte2Int(classFileData, offset); offset+=4;
		if(instance.magic!=MAGIC)
			throw new decompilerException("Invalid MAGIC number");
		instance.minor_version = Util.byte2Short(classFileData,offset);offset+=2;
		instance.major_version = Util.byte2Short(classFileData,offset);offset+=2;
		instance.constant_pool_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.constant_pool = new cp_info[instance.constant_pool_count&0xFFFF];
		instance.constant_pool[0] = new CONSTANT_Void();
		for(int i=1;i<instance.constant_pool.length;++i)
		{
			instance.constant_pool[i] = cp_info.getInstance(classFileData, offset);
			offset += instance.constant_pool[i].getSize();
		}
		instance.access_flags = Util.byte2Short(classFileData,offset);offset+=2;
		instance.this_class = Util.byte2Short(classFileData,offset);offset+=2;
		instance.super_class = Util.byte2Short(classFileData,offset);offset+=2;
		instance.interfaces_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.interfaces = new short[instance.interfaces_count&0xFFFF];
		for(int i=0;i<instance.interfaces.length;++i)
		{
			instance.interfaces[i] = Util.byte2Short(classFileData,offset);offset+=2;
		}
		instance.fields_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.fields = new field_info[instance.fields_count&0xFFFF];
		for(int i=0;i<instance.fields.length;++i)
		{
			instance.fields[i] = field_info.getInstance(classFileData, offset, instance.constant_pool);
			offset += instance.fields[i].getSize();
		}
		instance.methods_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.methods = new method_info[instance.methods_count&0xFFFF];
		for(int i=0;i<instance.methods.length;++i)
		{
			instance.methods[i] = method_info.getInstance(classFileData, offset, instance.constant_pool);
			offset += instance.methods[i].getSize();
		}
		instance.attributes_count = Util.byte2Short(classFileData,offset);offset+=2;
		instance.attributes = new attribute_info[instance.attributes_count&0xFFFF];
		for(int i=0;i<instance.attributes.length;++i)
		{
			instance.attributes[i] = attribute_info.getInstance(classFileData, offset, instance.constant_pool);
			offset += instance.attributes[i].getSize();
		}
		//instance.parse();
		return instance;
    }
	
	/**
	 * Accessor method to <code>magic</code> field
	 * 
	 * <p>The magic item supplies the magic number identifying the class file format; it has the value 0xCAFEBABE.</p>
	 * @return return <code>magic</code> field
	 */
	public int getMagic() { return magic; }
	
	/**
	 * Accessor method to <code>minor_version</code> field
	 * 
	 * <p>minor version numbers of the class file.</p>
	 * @return <code>minor_version</code> field 
	 */
	public short minor_version() { return minor_version; }
	
	/**
	 * Accessor method to <code>major_version</code> field 
	 * 
	 * <p>major version numbers of the class file.</p>
	 * @return <code>major_version</code> field 
	 */
	public short major_version() { return major_version; }
	
	/**
	 * Accessor method to <code>constant_pool_count</code> field 
	 * 
	 * <p>The value of the constant_pool_count item is equal to the number of entries in the <code>constant_pool</code> table plus one.</p>
	 * @return <code>constant_pool_count</code> field 
	 */
	public int getConstant_pool_count() { return constant_pool_count&0xFFFF; }
	
	/**
	 * Accessor method to <code>constant_pool</code> field
	 * 
	 * <p>The <code>constant_pool</code> is a table of structures (§4.4) representing various string constants, class and interface names, 
	 * field names, and other constants that are referred to within the <code>ClassFile</code> structure and its substructures.</p>
	 * @return <code>constant_pool</code> field 
	 */
	
	public cp_info[] getConstant_pool() { return constant_pool; }
	
	/**
	 * Accessor method to <code>access_flags</code> field 
	 * 
	 * <p>The value of the <code>access_flags</code> item is a mask of flags used to denote access permissions to and properties of 
	 * class or interface. </p>
	 * @return <code>access_flags</code> field 
	 */
	public short getAccess_flags() { return access_flags; }
	
	/**
	 * Accessor method to <code>this_class</code> field
	 * <p>The value of the <code>this_class</code> item must be a valid index into the <code>constant_pool</code> table.</p>
	 * @return <code>this_class</code> field
	 */
	public int getThis_class() { return this_class&0xFFFF; }
	
	/**
	 * Accessor method to <code>super_class</code> field
	 * <p>The value of the <code>super_class</code> item either must be zero or must be a valid index into the 
	 * <code>constant_pool</code> table.</p> 
	 * @return <code>super_class</code> field
	 */
	public int getSuper_class() { return super_class&0xFFFF; }
	
	/**
	 * Accessor method to <code>interfaces_count</code> field
	 * The value of the <code>interfaces_count</code> item gives the number of direct superinterfaces of this class or 
	 * interface type.
	 * @return <code>interfaces_count</code> field
	 */
	public int getInterfaces_count() { return interfaces_count&0xFFFF; }
	
	/**
	 * Accessor method to <code>interfaces</code> field
	 * 
	 * <p>Each value in the <code>interfaces</code> array must be a valid index into the <code>constant_pool</code> table.</p>
	 * @return <code>interfaces</code> field
	 */
	public short[] getInterfaces() { return interfaces; }
	
	/**
	 * Accessor method to <code>fields_count</code> field 
	 * 
	 * <p>The value of the <code>fields_count</code> item gives the number of <code>field_info</code> structures in the fields table.</p>
	 * @return <code>fields_count</code> field 
	 */
	public int getFfields_count() { return fields_count&0xFFFF; }
	
	/**
	 * Accessor method to <code>fields</code> field 
	 * 
	 * <p>Each value in the <code>fields</code> table must be a <code>field_info</code> structure (§4.5) giving a complete description 
	 * of a field in this class or interface. </p>
	 * @return <code>fields</code> field 
	 */
	public field_info[] getFields() { return fields; }
	
	/**
	 * Accessor method to <code>methods_count</code> field 
	 * 
	 * <p>The value of the <code>methods_count</code> item gives the number of <code>method_info</code> structures in the methods table.</p>
	 * @return <code>methods_count</code> field 
	 */
	public int getMethods_count() { return methods_count&0xFFFF; }
	
	/**
	 * Accessor method to <code>methods</code> field
	 * 
	 * <p>Each value in the <code>methods</code> table must be a <code>method_info</code> structure (§4.6) giving a complete 
	 * description of a method in this class or interface.</p>
	 * @return <code>methods</code> field
	 */
	public method_info[] getMethods() { return methods; }
	
	/**
	 * Accessor method to <code>attributes_count</code> field
	 * 
	 * <p>The value of the <code>attributes_count</code> item gives the number of attributes in the <code>attributes</code> table of 
	 * this class.</p>
	 * @return <code>attributes_count</code> field
	 */
	public int attributes_count() { return attributes_count&0xFFFF; }
	
	/**
	 * Accessor method to <code>attributes</code> field
	 * <p>Each value of the <code>attributes</code> table must be an <code>attribute_info</code> structure (§4.7).</p>
	 * @return <code>attributes</code> field
	 */
	public attribute_info[] getAttributes() { return attributes; }
	
	public static String getAccessModifier(short access_flag)
	{
		String res="";
		if((access_flag & ACC_PUBLIC) == ACC_PUBLIC)
			res += "public ";
		if((access_flag & ACC_FINAL) == ACC_FINAL)
			res += "final ";
		if((access_flag & ACC_ABSTRACT) == ACC_ABSTRACT)
			res += "abstract ";
		if((access_flag & ACC_INTERFACE) == ACC_INTERFACE)
			res += "interface ";
		else if((access_flag & ACC_ENUM) == ACC_ENUM)
			res += "enum ";
		else
			res += "class ";
		return res;
	}
	
	public String getSourceFile() throws decompilerException
	{
		for(attribute_info attrib:attributes)
		{
			if(attrib instanceof SourceFile_attribute)
				return cp_info.getName(((SourceFile_attribute)attrib).getSourcefile_index(), constant_pool);
		}
		return null;
	}
	
	public String getClassName() throws decompilerException
	{
		int nameIndex=0;

		if(constant_pool[this_class] instanceof CONSTANT_Class_info)
		{
			nameIndex = ((CONSTANT_Class_info)constant_pool[this_class]).getName_index();
		
			if(constant_pool[nameIndex] instanceof CONSTANT_Utf8_info)
			{
				return ((CONSTANT_Utf8_info)constant_pool[nameIndex]).getString();
			}
			throw new decompilerException("constant_pool entry in specified name index is not CONSTANT_Utf8_info");
		}
		throw new decompilerException("constant_pool entry in specified argument is not CONSTANT_Class_info");
	}
	
	public String toString()
	{
		String res="";
		res+=String.format("Magic: 0x%08X\n", magic);
		res+="Version: "+major_version+"."+minor_version+"\n";
		res+="Constant Pool Count: "+constant_pool_count+"\n";
		for(int i=0;i<constant_pool_count;++i)
		{
			res+=" constant_pool["+i+"]\n";
			res+=constant_pool[i].toString(1, constant_pool);
		}
		res+="access_flags: "+getAccessModifier(access_flags)+"\n";
		res+="this_class: @"+this_class;
		try
		{
			res+=" "+cp_info.getName(((CONSTANT_Class_info)constant_pool[this_class]).getName_index(),constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=" error cannot find this_class description \n";
		}
		res+="super_class: @"+super_class;
		try
		{
			res+=" "+cp_info.getName(((CONSTANT_Class_info)constant_pool[super_class]).getName_index(),constant_pool)+"\n";
		}
		catch(decompilerException e)
		{
			res+=" error cannot find super_class description \n";
		}
		res+="interfaces_count : "+interfaces_count+"\n";
		for(int i=0;i<interfaces_count;++i)
		{
			try
			{
				res+="   @"+interfaces[i]+" "+cp_info.getName(((CONSTANT_Class_info)constant_pool[interfaces[i]]).getName_index(),constant_pool)+"\n";
			}
			catch(decompilerException e)
			{
				res+="   error cannot find interfaces description @"+interfaces[i];
			}
		}
		res+="fields_count: "+fields_count+"\n";
		for(int i=0;i<fields_count;++i)
		{
			res+=" field["+i+"]\n";
			res+=fields[i].toString(1,constant_pool);
		}
		res+="methods_count: "+methods_count+"\n";
		for(int i=0;i<methods_count;++i)
		{
			res+=" methods["+i+"]\n";
			res+=methods[i].toString(1,constant_pool);
		}
		res+="attributes_count: "+attributes_count+"\n";
		for(int i=0;i<attributes_count;++i)
		{
			res+=" attributes["+i+"]\n";
			res+=attributes[i].toString(1,constant_pool);
		}
		return res;
	}
}
