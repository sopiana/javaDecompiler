package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Each entry indicates a range of code array offsets within which a local
variable has a value. It also indicates the index into the local variable array of
the current frame at which that local variable can be found.
 * @author yang
 *
 */
public class table_info 
{
	/**
	 * The given local variable has a value at indices into the code array in
the interval [start_pc, start_pc + length), that is, between start_pc
inclusive and start_pc + length exclusive.
	 */
	private short start_pc;
	/**
	 * The given local variable has a value at indices into the code array in
the interval [start_pc, start_pc + length), that is, between start_pc
inclusive and start_pc + length exclusive.
	 */
	private short length;
	/**
	 * The given local variable must be at index in the local variable array of the
current frame.
If the local variable at index is of type double or long, it occupies both
index and index + 1.
<small>A table is needed to fully specify the local variable whose type is annotated, because
a single local variable may be represented with different local variable indices over
multiple live ranges. The start_pc, length, and index items in each table entry
specify the same information as a LocalVariableTable attribute.</small>
<small>The localvar_target item records that a local variable's type is annotated, but
does not record the type itself. The type may be found by inspecting the appropriate
LocalVariableTable attribute.</small>
	 */
	private short index;
	public static table_info getInstance(byte[]classFileData, int offset)
	{
		table_info res = new table_info();
		res.start_pc = Util.byte2Short(classFileData,offset); offset+=2;
		res.length = Util.byte2Short(classFileData,offset); offset+=2;
		res.index = Util.byte2Short(classFileData,offset);
		return res;
	}
	public int getSize() { return 6; }
	public short getStart_pc() { return start_pc; }
	public short getLength() { return length; }
	public short getIndex() { return index; }
}
