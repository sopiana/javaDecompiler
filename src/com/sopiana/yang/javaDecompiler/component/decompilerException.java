package com.sopiana.yang.javaDecompiler.component;

public class decompilerException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reason;
	public decompilerException(String reason)
	{
		this.reason = reason;
	}
	public String getReason() { return reason; }
}
