package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.frame.append_frame;
import com.sopiana.yang.javaDecompiler.component.sub.frame.chop_frame;
import com.sopiana.yang.javaDecompiler.component.sub.frame.full_frame;
import com.sopiana.yang.javaDecompiler.component.sub.frame.same_frame;
import com.sopiana.yang.javaDecompiler.component.sub.frame.same_frame_extended;
import com.sopiana.yang.javaDecompiler.component.sub.frame.same_locals_1_stack_item_frame;
import com.sopiana.yang.javaDecompiler.component.sub.frame.same_locals_1_stack_item_frame_extended;
/**
 * A stack map frame specifies (either explicitly or implicitly) the bytecode offset at
which it applies, and the verification types of local variables and operand stack
entries for that offset.
Each stack map frame described in the entries table relies on the previous frame
for some of its semantics. The first stack map frame of a method is implicit,
and computed from the method descriptor by the type checker (§4.10.1.6). The
stack_map_frame structure at entries[0]  therefore describes the second stack
map frame of the method.
The bytecode offset at which a stack map frame applies is calculated by taking the
value offset_delta specified in the frame (either explicitly or implicitly), and
adding offset_delta + 1 to the bytecode offset of the previous frame, unless
the previous frame is the initial frame of the method. In that case, the bytecode
offset at which the stack map frame applies is the value offset_delta specified
in the frame.
By using an offset delta rather than storing the actual bytecode offset, we ensure, by
definition, that stack map frames are in the correctly sorted order. Furthermore, by
consistently using the formula offset_delta + 1 for all explicit frames (as opposed to
the implicit first frame), we guarantee the absence of duplicates.
We say that an instruction in the bytecode has a corresponding stack map frame if
the instruction starts at offset i in the code array of a Code attribute, and the Code
attribute has a StackMapTable attribute whose entries array contains a stack map
frame that applies at bytecode offset i.
A stack map frame is represented by a discriminated union, stack_map_frame,
which consists of a one-byte tag, indicating which item of the union is in use,
followed by zero or more bytes, giving more information about the tag.
union stack_map_frame {
 same_frame;
 same_locals_1_stack_item_frame;
 same_locals_1_stack_item_frame_extended;
 chop_frame;
 same_frame_extended;
 append_frame;
 full_frame;
}
 * @author yang
 *
 */
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
	public byte getFrame_type() { return frame_type; }
	public abstract int getSize();
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		//TODO finish this method
		return null;
	}
}
