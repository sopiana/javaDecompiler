package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
/**
 * The formal_parameter_target item indicates that an annotation appears on
the type in a formal parameter declaration of a method, constructor, or lambda
expression.
formal_parameter_target {
 u1 formal_parameter_index;
}
 * @author yang
 *
 */
public class formal_parameter_target_info extends target_info
{
	/**
	 * The value of the formal_parameter_index item specifies which formal
parameter declaration has an annotated type. A formal_parameter_index value
of 0 specifies the first formal parameter declaration.
<small>The formal_parameter_target item records that a formal parameter's type
is annotated, but does not record the type itself. The type may be found by
inspecting the method descriptor (§4.3.3) of the method_info structure enclosing the
RuntimeVisibleTypeAnnotations attribute. A formal_parameter_index value
of 0 indicates the first parameter descriptor in the method descriptor.</small>
	 */
	private byte formal_parameter_index;
	public static formal_parameter_target_info getInstance(byte[]classFileData, int offset)
	{
		formal_parameter_target_info res = new formal_parameter_target_info();
		res.formal_parameter_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 1; }
	public byte getFormal_parameter_index() { return formal_parameter_index; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
