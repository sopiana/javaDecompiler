package com.sopiana.yang.javaDecompile.component;

import com.sopiana.yang.javaDecompile.util.Util;

public class field_info {
	private short access_flags;
	private short name_index;
	private short descriptor_index;
	private short attributes_count;
	private attribute_info attributes[];		//attributes_count
    
    public static field_info getInstance(byte[]classFileData, int offset)
	{
    	field_info res = new field_info();
    	res.access_flags = Util.byte2Short(classFileData,offset);offset+=2;
    	res.name_index = Util.byte2Short(classFileData,offset);offset+=2;
    	res.descriptor_index = Util.byte2Short(classFileData,offset);offset+=2;
    	res.attributes_count = Util.byte2Short(classFileData,offset);offset+=2;
    	res.attributes = new attribute_info[res.attributes_count];
    	for(int i=0;i<res.attributes_count;++i)
    	{
    		res.attributes[i] = attribute_info.getInstance(classFileData, offset);
    		offset += res.attributes[i].getSize();
    	}
    	return res;
	}
    
    public int getSize()
	{
    	int len = 8;
    	for(int i=0;i<attributes_count;++i)
    		len+=attributes[i].getSize();
    	return len;
	}
}
