package com.sopiana.yang.javaDecompile.component.sub.cp_info;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.sopiana.yang.javaDecompile.component.decompilerException;
import com.sopiana.yang.javaDecompile.component.cp_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class CONSTANT_Utf8_info extends cp_info{
	private short length;
	private byte bytes[];
	
	public static CONSTANT_Utf8_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_Utf8_info res = new CONSTANT_Utf8_info();
		res.tag = classFileData[offset++];
		res.length = Util.byte2Short(classFileData,offset); offset+=2;
		res.bytes = Arrays.copyOfRange(classFileData, offset, offset+res.length);
		return res;
    }
	public int getSize() { return 3+length;}
	public short getLength() { return length; }
	public String getString() throws decompilerException
	{
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new decompilerException("invalid CONSTANT_Utf8_info encoding format");
		}
	}
}
