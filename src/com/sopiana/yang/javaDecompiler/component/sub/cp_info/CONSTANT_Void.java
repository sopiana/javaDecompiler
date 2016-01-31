package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
/**
 * Dummy <code>constant_pool</code> entry
 * 
 * <p>Since size of <code>constant_pool</code> table is <code>constant_pool_count-1</code>, it needed to add dummy <code>constant_pool</code> entry,
 * so that the size will be <code>constant_pool_count</code>.
 * @author yang.sopiana
 *
 */
public class CONSTANT_Void extends cp_info {
	/**
	 * Accessor method to <code>constant_pool</code> field
	 * 
	 * <p>The value of the <code>length</code> item gives the number of bytes in the <code>bytes</code> array (not the 
	 * length of the resulting string).</p>
	 * @return 0
	 */
	public int getSize() { return 0; }

	public String toString(int indent, cp_info[] constant_pool) 
	{
		String indentStr = getIndent(indent);
		String res="";
		res+=indentStr+" tag: CONSTANT_Void"+"\n";
		return res;
	}

}
