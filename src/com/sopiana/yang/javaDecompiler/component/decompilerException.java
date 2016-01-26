package com.sopiana.yang.javaDecompiler.component;
/**
 * Exception object showing that there's one or more process is failed during decompilation process
 * 
 * <p>User can get the reason of why the decompilation process is failed by invoking <code>getReason()</code>
 * method</p>
 * @author yang.sopiana
 *
 */
public class decompilerException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String reason;
	/**
	 * <code>decompilerException</code>'s Constructor 
	 * 
	 * @param reason reason of why the decompilation process is failed
	 */
	public decompilerException(String reason)
	{
		this.reason = reason;
	}
	/**
	 * Return description about cause of failed decompilation process 
	 * @return reason of why the decompilation process is failed
	 */
	public String getReason() { return reason; }
}
