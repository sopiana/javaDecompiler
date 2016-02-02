package com.sopiana.yang.javaDecompiler.component.sub.frame;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.stack_map_frame;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type_info;

public class same_locals_1_stack_item_frame extends stack_map_frame
{
	private verification_type_info stack;
	public static same_locals_1_stack_item_frame getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		same_locals_1_stack_item_frame res= new same_locals_1_stack_item_frame();
		res.frame_type = classFileData[offset++];
		res.stack = verification_type_info.getInstance(classFileData, offset);
		return res;
	}
	public int getSize() { return 1+stack.getSize(); }
}
