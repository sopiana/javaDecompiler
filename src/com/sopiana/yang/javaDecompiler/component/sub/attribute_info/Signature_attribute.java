package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class Signature_attribute extends attribute_info
{
	private short signature_index;
	
	public static Signature_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		Signature_attribute res = new Signature_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.signature_index = Util.byte2Short(info);
		return res;
		
	}
	public static Signature_attribute getInstance(attribute_info attrib)
	{
		return getInstance(attrib.getAttribute_name_index(), attrib.getAttribute_length(), attrib.getInfo());
	}
	public short getSignature_index() { return this.signature_index; }
}
