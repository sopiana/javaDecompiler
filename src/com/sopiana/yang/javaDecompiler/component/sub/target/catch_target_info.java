package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * The catch_target item indicates that an annotation appears on the i'th type in
an exception parameter declaration.
catch_target {
 u2 exception_table_index;
}
 * @author yang
 *
 */
public class catch_target_info extends target_info
{
	/**
	 * The value of the exception_table_index item is an index into
the exception_table array of the Code attribute enclosing the
RuntimeVisibleTypeAnnotations attribute.
<small>The possibility of more than one type in an exception parameter declaration arises from
the multi-catch clause of the try statement, where the type of the exception parameter
is a union of types (JLS §14.20). A compiler usually creates one exception_table
entry for each type in the union, which allows the catch_target item to distinguish
them. This preserves the correspondence between a type and its annotations.</small>
	 */
	private short exception_table_index;
	public static catch_target_info getInstance(byte[]classFileData, int offset)
	{
		catch_target_info res = new catch_target_info();
		res.exception_table_index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 2; }
	public short getException_table_index() { return exception_table_index; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
