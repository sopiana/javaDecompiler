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
 * 
 * Provides abstraction for <code>stack_map_frame</code> item
 * 
 * <p>A stack map frame specifies (either explicitly or implicitly) the bytecode offset at which it applies, and the verification types of 
 * local variables and operand stack entries for that offset.</p>
 * <p>
 * <p>Each stack map frame described in the entries table relies on the previous frame for some of its semantics. The first stack map frame 
 * of a method is implicit, and computed from the method descriptor by the type checker. The <code>stack_map_frame</code> structure at <code>entries[0]</code> 
 * therefore describes the second stack map frame of the method.</p>
 * <p>The bytecode offset at which a stack map frame applies is calculated by taking the value <code>offset_delta</code> specified in the frame 
 * (either explicitly or implicitly), and adding <code>offset_delta + 1</code> to the bytecode offset of the previous frame, unless the previous 
 * frame is the initial frame of the method. In that case, the bytecode offset at which the stack map frame applies is the value <code>offset_delta</code> 
 * specified in the frame.</p>
 * <p><small>By using an offset delta rather than storing the actual bytecode offset, we ensure, by definition, that stack map frames are in 
 * the correctly sorted order. Furthermore, by consistently using the formula <code>offset_delta + 1</code> for all explicit frames (as opposed 
 * to the implicit first frame), we guarantee the absence of duplicates.</small></p>
 * <p>An instruction in the bytecode has a corresponding stack map frame if the instruction starts at offset <i>i</i> in the code array of a 
 * <code>Code_attribute</code>, and the <code>Code_attribute</code> has a <code>StackMapTable_attribute</code> whose entries array contains a 
 * stack map frame that applies at bytecode offset <i>i</i>.</p>
 * <p>A stack map frame is represented by a discriminated union, <code>stack_map_frame</code>, which consists of a one-byte <code>tag</code>, 
 * indicating which item of the union is in use, followed by zero or more bytes, giving more information about the <code>tag</code>.</p>
 * <code>union stack_map_frame {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;same_frame;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;same_locals_1_stack_item_frame;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;same_locals_1_stack_item_frame_extended;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;chop_frame;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;same_frame_extended;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;append_frame;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;full_frame;<br>
 * }<br>
 * @author yang.sopiana
 *
 */
public abstract class stack_map_frame 
{
	/**
	 * <p> The value of <code>tag</code>, indicating which item of the union is in use</p>
	 */
	protected byte tag;
	/**
	 * Abstract factory method generating <code>stack_map_frame</code> instance based on it's tag
	 * 
	 * <p>Return <code>stack_map_frame</code> according to it's tag</p>
	 *  <table summary="stack_map_frame based on tag">
	 *  <thead>
	 *  	<tr><td>range</td><td>Type</td></tr>
	 *  </thead>
	 *  <tbody>
	 *  	<tr><td>[0-63]</td><td>same_frame</td></tr>
	 *   	<tr><td>[64, 127]</td><td>same_locals_1_stack_item_frame</td></tr>
	 *   	<tr><td>[128-246]</td><td>Reserve for Future Use</td></tr>
	 *   	<tr><td>247</td><td>same_locals_1_stack_item_frame_extended</td></tr>
	 *   	<tr><td>[248-250]</td><td>chop_frame</td></tr>
	 *   	<tr><td>251</td><td>same_frame_extended</td></tr>
	 *   	<tr><td>[252-254]</td><td>append_frame</td></tr>
	 *   	<tr><td>255</td><td>full_frame</td></tr>
	 *  </tbody>
	 * </table>  
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return <code>stack_map_frame</code> instance based on <code>tag</code>
	 * @throws decompilerException if <code>tag</code> is not a valid type <code>classFileData</code> data is not <code>stack_map_frame</code> structure
	 */
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
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>stack_map_frame</code> entry components</p>
	 * @return size of <code>stack_map_frame</code> entry
	 */
	public abstract int getSize();
	/**
	 * Accessor method to <code>tag</code> field
	 * 
	 * <p> The value of <code>tag</code>, indicating which item of the union is in use</p>
	 * @return value of <code>tag</code> field
	 */
	public byte getFrame_type() { return tag; }
	
	public abstract String toString(int indent, cp_info[] constant_pool);
}
