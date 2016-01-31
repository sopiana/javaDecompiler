package com.sopiana.yang.javaDecompiler.component.sub.frame;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;

public abstract class stack_map_frame 
{
	protected byte frame_type;
	
	public static stack_map_frame getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		short frameType = (short)(classFileData[offset]&0xFF);
		if(frameType>=0 && frameType<=63)
			return same_frame.getInstance(classFileData, offset);
		if(frameType>=64 && frameType<=127)
			return same_locals_1_stack_item_frame.getInstance(classFileData, offset);
		if(frameType==247)
			return same_locals_1_stack_item_frame_extended.getInstance(classFileData, offset);
		if(frameType>=248 && frameType<=250)
			return chop_frame.getInstance(classFileData, offset);
		if(frameType==251)
			return same_frame_extended.getInstance(classFileData, offset);
		if(frameType>=252 && frameType<=254)
			return append_frame.getInstance(classFileData, offset);
		if(frameType==255)
			return full_frame.getInstance(classFileData, offset);
		throw new decompilerException("Arguments passed is invalid tag of stack_map_frame");
	}
	
	public abstract int getSize();
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		//TODO finish this method
		return null;
	}
}
