package com.sopiana.yang.javaDecompiler.component.sub.frame;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.stack_map_frame;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class append_frame extends stack_map_frame
{
	private short  offset_delta;
	private verification_type_info locals[];	//frame_type - 251
	
	public static append_frame getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		append_frame res= new append_frame();
		res.tag = classFileData[offset++];
		res.offset_delta = Util.byte2Short(classFileData,offset); offset+=2;
		res.locals = new verification_type_info[res.tag-251];
		for(int i=0;i<res.locals.length;++i)
		{
			res.locals[i] = verification_type_info.getInstance(classFileData, offset);
			offset+=res.locals[i].getSize();
		}
		return res;
	}
	
	public int getSize() 
	{ 
		int res = 3;
		for(int i=0;i<locals.length;++i)
			res+=locals[i].getSize();
		return res; 
	}
	public short getOffset_delta() { return offset_delta; }

	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
