package com.sopiana.yang.javaDecompiler.component.sub.frame;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.stack_map_frame;
import com.sopiana.yang.javaDecompiler.util.Util;

public class same_frame_extended extends stack_map_frame
{
	private short offset_delta;
	public static same_frame_extended getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		same_frame_extended res= new same_frame_extended();
		res.frame_type = classFileData[offset++];
		res.offset_delta = Util.byte2Short(classFileData,offset);
		return res;
	}
	
	public int getSize() { return 3; }
	public short getOffset_delta() { return offset_delta; }
}
