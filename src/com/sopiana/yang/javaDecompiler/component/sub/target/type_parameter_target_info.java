package com.sopiana.yang.javaDecompiler.component.sub.target;
/**
 * The type_parameter_target item indicates that an annotation appears on the
declaration of the i'th type parameter of a generic class, generic interface, generic
method, or generic constructor.
type_parameter_target {
 u1 type_parameter_index;
}
 */
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;

public class type_parameter_target_info extends target_info
{
	/**
	 * The value of the type_parameter_index item specifies which type parameter
declaration is annotated. A type_parameter_index value of0 specifies the first
type parameter declaration.
	 */
	private byte type_parameter_index;
	public static type_parameter_target_info getInstance(byte[]classFileData, int offset)
	{
		type_parameter_target_info res = new type_parameter_target_info();
		res.type_parameter_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 1; }
	public byte getType_parameter_index() { return type_parameter_index; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
