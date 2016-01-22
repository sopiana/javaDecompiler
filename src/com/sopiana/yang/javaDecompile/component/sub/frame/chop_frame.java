package com.sopiana.yang.javaDecompile.component.sub.frame;

import com.sopiana.yang.javaDecompile.component.decompilerException;
import com.sopiana.yang.javaDecompile.util.Util;

public class chop_frame extends stack_map_frame
{
	private short offset_delta;
	public static chop_frame getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		chop_frame res= new chop_frame();
		res.frame_type = classFileData[offset++];
		res.offset_delta = Util.byte2Short(classFileData,offset);
		return res;
	}
	
	public int getSize() { return 3; }
	public short getOffset_delta() { return offset_delta; }
}
