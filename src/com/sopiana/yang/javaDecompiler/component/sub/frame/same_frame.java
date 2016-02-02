package com.sopiana.yang.javaDecompiler.component.sub.frame;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.stack_map_frame;

public class same_frame extends stack_map_frame
{
	public static same_frame getInstance(byte[] classFileData, int offset)
	{
		same_frame res= new same_frame();
		res.tag = classFileData[offset];
		return res;
	}
	public int getSize() { return 1; }
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}

}
