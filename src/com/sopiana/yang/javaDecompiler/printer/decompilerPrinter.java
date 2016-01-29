package com.sopiana.yang.javaDecompiler.printer;

import com.sopiana.yang.javaDecompiler.component.decompilerException;

public interface decompilerPrinter {
	public void setOuputPath(String path);
	public void generateOuputFile()throws decompilerException ;
}
