package com.sopiana.yang.javaDecompiler.instruction;

public class instructionException extends Exception
{
	private static final long serialVersionUID = 2L;
	private String reason;
	public instructionException(String reason)
	{
		this.reason = reason;
	}
	public String getReason() { return reason; }
}
