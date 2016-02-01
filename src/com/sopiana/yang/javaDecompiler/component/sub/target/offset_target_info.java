package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class offset_target_info extends target_info
{
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
