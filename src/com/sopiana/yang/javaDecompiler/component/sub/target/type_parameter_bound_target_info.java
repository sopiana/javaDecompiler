package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
/**
 * The type_parameter_bound_target item indicates that an annotation appears
on the i'th bound of the j'th type parameter declaration of a generic class,
interface, method, or constructor.
type_parameter_bound_target {
 u1 type_parameter_index;
 u1 bound_index;
}
 * @author yang
 *
 */
public class type_parameter_bound_target_info extends target_info
{
	/**
	 * The value of the oftype_parameter_index item specifies which type parameter
declaration has an annotated bound. A type_parameter_index value of 0
specifies the first type parameter declaration.
	 */
	private byte type_parameter_index;
	/**
	 * The value of the bound_index item specifies which bound of the type parameter
declaration indicated by type_parameter_index is annotated. A bound_index
value of 0 specifies the first bound of a type parameter declaration.
<small>The type_parameter_bound_target item records that a bound is annotated, but does
not record the type which constitutes the bound. The type may be found by inspecting
the class signature or method signature stored in the appropriate Signature attribute.</small>
	 */
	private byte bound_index;
	public static type_parameter_bound_target_info getInstance(byte[]classFileData, int offset)
	{
		type_parameter_bound_target_info res = new type_parameter_bound_target_info();
		res.type_parameter_index = classFileData[offset++];
		res.bound_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 2; }
	public byte getType_parameter_index() { return type_parameter_index; }
	public byte getBound_index() { return bound_index; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
