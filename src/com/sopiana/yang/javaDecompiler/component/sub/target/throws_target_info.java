package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * The throws_target item indicates that an annotation appears on the i'th type in
the throws clause of a method or constructor declaration.
throws_target {
 u2 throws_type_index;
}
 * @author yang
 *
 */
public class throws_target_info extends target_info
{
	/**
	 * The value of the throws_type_index item is an index into the
exception_index_table array of the Exceptions attribute of the method_info
structure enclosing the RuntimeVisibleTypeAnnotations attribute.
	 */
	private short throws_type_index;
	public static throws_target_info getInstance(byte[]classFileData, int offset)
	{
		throws_target_info res = new throws_target_info();
		res.throws_type_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 2; }
	public short getThrows_type_index() { return throws_type_index; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
