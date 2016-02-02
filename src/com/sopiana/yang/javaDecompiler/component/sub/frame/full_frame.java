package com.sopiana.yang.javaDecompiler.component.sub.frame;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.stack_map_frame;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class full_frame extends stack_map_frame
{
	private short offset_delta;
	private short number_of_locals;
	private verification_type_info locals[];	//number_of_locals
	private short number_of_stack_items;
	private verification_type_info stack[];		//number_of_stack_items
	
	public static full_frame getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		full_frame res = new full_frame();
		res.frame_type = classFileData[offset++];
		res.offset_delta = Util.byte2Short(classFileData,offset); offset+=2;
		res.number_of_locals = Util.byte2Short(classFileData,offset); offset+=2;
		res.locals = new verification_type_info[res.number_of_locals];
		for(int i=0; i<res.locals.length;++i)
		{
			res.locals[i] = verification_type_info.getInstance(classFileData, offset);
			offset += res.locals[i].getSize();
		}
		res.number_of_stack_items = Util.byte2Short(classFileData,offset); offset+=2;
		res.stack = new verification_type_info[res.number_of_stack_items];
		for(int i=0; i<res.stack.length;++i)
		{
			res.stack[i] = verification_type_info.getInstance(classFileData, offset);
			offset += res.stack[i].getSize();
		}
		return res;
	}

	public int getSize() {
		int res = 7;
		for(int i=0; i<locals.length;++i)
			res += locals[i].getSize();
		for(int i=0; i<stack.length;++i)
			res += stack[i].getSize();
		return res;
	}
}
