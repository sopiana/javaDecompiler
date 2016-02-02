package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * The supertype_target item indicates that an annotation appears on a type in
the extends or implements clause of a class or interface declaration.
supertype_target {
 u2 supertype_index;
}
 * @author yang
 *
 */
public class supertype_target_info extends target_info
{
	/**
	 * A supertype_index value of 65535 specifies that the annotation appears on the
superclass in an extends clause of a class declaration.
Any other supertype_index value is an index into the interfaces array of
the enclosing ClassFile structure, and specifies that the annotation appears on
that superinterface in either the implements clause of a class declaration or the
extends clause of an interface declaration.
	 */
	private short supertype_index;
	public static supertype_target_info getInstance(byte[]classFileData, int offset)
	{
		supertype_target_info res = new supertype_target_info();
		res.supertype_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 2; }
	public short getSupertype_index() { return supertype_index; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
