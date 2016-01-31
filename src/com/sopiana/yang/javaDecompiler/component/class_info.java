package com.sopiana.yang.javaDecompiler.component;
/**
 * The abstract class for <code>ClassFile</code>'s component
 * 
 * <p>It is needed to make debugging and comparing with class file easier, by providing
 * the offset where each <code>ClassFile</code>'s component found.</p>
 * @author yang.sopiana
 *
 */
public abstract class class_info 
{
	/**
	 * offset from class file data where specific component is found
	 */
	protected int offset;
	
	/**
	 * return the offset from class file data where specific component is found
	 * 
	 * <p>The <code>offset</code> will give you the position of component in class file</p>
	 * 
	 * @return offset from class file data where specific component is found
	 */
	public int getOffset() { return offset; }
	
	protected String getIndent(int indent)
	{
		String indentStr="";
		
		while(indent-->0)
			indentStr+="  ";
		return indentStr;
	}
	
	public abstract String toString(int indent,cp_info[]constant_pool);
}