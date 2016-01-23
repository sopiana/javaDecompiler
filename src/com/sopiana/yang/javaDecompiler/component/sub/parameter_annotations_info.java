package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;

public class parameter_annotations_info {
	private short num_annotations;
	private annotation_info annotations[];	//num_annotations
	public static parameter_annotations_info getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		parameter_annotations_info res = new parameter_annotations_info();
		res.num_annotations = Util.byte2Short(classFileData,offset); offset+=2;
		res.annotations = new annotation_info[res.num_annotations];
		for(int i=0;i<res.num_annotations;++i)
		{
			res.annotations[i] = annotation_info.getInstance(classFileData, offset);
			offset+=res.annotations[i].getSize();
		}
		return res;
	}
	public int getSize() 
	{ 
		int res = 2;
		for(int i=0;i<num_annotations;++i)
		{
			res+=annotations[i].getSize();
		}
		return res;
	}
}
