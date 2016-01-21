package com.sopiana.yang.javaDecompile.component;

public class compilerException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reason;
	public compilerException(String reason)
	{
		this.reason = reason;
	}
	public String getReason() { return reason; }
}
