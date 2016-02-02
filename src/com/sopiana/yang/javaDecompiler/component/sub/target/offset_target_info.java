package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * The offset_target item indicates that an annotation appears on either the type
in an instanceof expression or a new expression, or the type before the ::  in a
method reference expression.
offset_target {
 u2 offset;
}
 * @author yang
 *
 */
public class offset_target_info extends target_info
{
	/**
	 * The value of the offset item specifies the code array offset of either the
instanceof bytecode instruction corresponding to the instanceof expression, the
new bytecode instruction corresponding to the new expression, or the bytecode
instruction corresponding to the method reference expression.
	 */
	private short offset;
	public static offset_target_info getInstance(byte[]classFileData, int offset)
	{
		offset_target_info res = new offset_target_info();
		res.offset = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 2; }
	public short getOffset() { return offset; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
