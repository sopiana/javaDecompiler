package com.sopiana.yang.javaDecompiler.component.sub.target;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.sub.target_info;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * The localvar_target item indicates that an annotation appears on the type in
a local variable declaration, including a variable declared as a resource in a trywith-resources statement.
localvar_target {
 u2 table_length;
 { u2 start_pc;
 u2 length;
 u2 index;
 } table[table_length];
}
 * @author yang
 *
 */
public class localvar_target_info extends target_info
{
	/**
	 * The value of the table_length item gives the number of entries in the table
array.
	 */
	private short table_length;
	/**
	 * Each entry indicates a range of code array offsets within which a local
variable has a value. It also indicates the index into the local variable array of
the current frame at which that local variable can be found.
	 */
	private table_info table[];	//table_length
	public static localvar_target_info getInstance(byte[]classFileData, int offset)
	{
		localvar_target_info res = new localvar_target_info();
		res.table_length =  Util.byte2Short(classFileData,offset); offset += 2;
		res.table = new table_info[res.table_length];
		for(int i=0;i<res.table_length;++i)
		{
			res.table[i] = table_info.getInstance(classFileData, offset);
			offset+= res.table[i].getSize();
		}
		return res;
	}

	public int getSize() {
		int res = 2;
		for(int i=0;i<table_length;++i)
		{
			res += table[i].getSize();
		}
		return res;
	}
	
	public short getTable_length() { return table_length; }

	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
