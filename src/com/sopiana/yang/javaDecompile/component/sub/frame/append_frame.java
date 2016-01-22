package com.sopiana.yang.javaDecompile.component.sub.frame;

import com.sopiana.yang.javaDecompile.component.decompilerException;
import com.sopiana.yang.javaDecompile.component.sub.verification_type.verification_type_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class append_frame extends stack_map_frame
{
	private short  offset_delta;
	private verification_type_info locals[];	//frame_type - 251
	
	public static append_frame getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		append_frame res= new append_frame();
		res.frame_type = classFileData[offset++];
		res.offset_delta = Util.byte2Short(classFileData,offset); offset+=2;
		res.locals = new verification_type_info[res.frame_type-251];
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
}
