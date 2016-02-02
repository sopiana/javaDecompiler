package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * The type_argument_target item indicates that an annotation appears either on
the i'th type in a cast expression, or on the i'th type argument in the explicit type
argument list for any of the following: a new expression, an explicit constructor
invocation statement, a method invocation expression, or a method reference
expression.
type_argument_target {
 u2 offset;
 u1 type_argument_index;
}
 * @author yang.sopiana
 *
 */
public class type_argument_target_info extends target_info
{
	/**
	 * The value of the offset item specifies the code array offset of either the
bytecode instruction corresponding to the cast expression, the new bytecode
instruction corresponding to the new expression, the bytecode instruction
corresponding to the explicit constructor invocation statement, the bytecode
instruction corresponding to the method invocation expression, or the bytecode
instruction corresponding to the method reference expression.
	 */
	private short offset;
	/**
	 * For a cast expression, the value of the type_argument_index item specifies
which type in the cast operator is annotated. A type_argument_index value of
0 specifies the first (or only) type in the cast operator.
<small>The possibility of more than one type in a cast expression arises from a cast to an
intersection type.</small>
For an explicit type argument list, the value of the type_argument_index item
specifies which type argument is annotated. A type_argument_index value of
0 specifies the first type argument.
	 */
	private byte type_argument_index;
	public static type_argument_target_info getInstance(byte[]classFileData, int offset)
	{
		type_argument_target_info res = new type_argument_target_info();
		res.offset = Util.byte2Short(classFileData,offset); offset +=2;
		res.type_argument_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 3; }
	public short getOffset() { return offset; }
	public byte getType_argument_index() { return type_argument_index; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
