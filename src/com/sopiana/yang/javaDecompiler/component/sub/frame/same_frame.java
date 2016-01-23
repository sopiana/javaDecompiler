package com.sopiana.yang.javaDecompiler.component.sub.frame;

public class same_frame extends stack_map_frame
{
	public static same_frame getInstance(byte[] classFileData, int offset)
	{
		same_frame res= new same_frame();
		res.frame_type = classFileData[offset];
		return res;
	}
	public int getSize() { return 1; }

}
