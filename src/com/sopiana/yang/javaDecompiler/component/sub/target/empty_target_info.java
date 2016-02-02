package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
/**
 * The empty_target item indicates that an annotation appears on either the type
in a field declaration, the return type of a method, the type of a newly constructed
object, or the receiver type of a method or constructor.
empty_target {
}
<small>Only one type appears in each of these locations, so there is no per-type information to
represent in the target_info union.</small>
 * @author yang
 *
 */
public class empty_target_info extends target_info{
	public static empty_target_info getInstance(byte[]classFileData, int offset)
	{
		return new empty_target_info();
	}
	public int getSize() { return 0; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
