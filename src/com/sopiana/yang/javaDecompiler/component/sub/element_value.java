package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.class_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.util.Util;
/**
 * Provides abstraction for <code>element_value</code> item
 * 
 * <p>The <code>element_value</code> structure is a discriminated union representing the value of an element-value pair.</p>
 * <p>The <code>element_value</code> structure has the following format:</p>
 * <code>element_value {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;u1 tag;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;union {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 const_value_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{ <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 type_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 const_name_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;} enum_const_value;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 class_info_index;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;annotation annotation_value;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{ <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u2 num_values;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;element_value values[num_values];<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;} array_value;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} value;<br>
 * }</code>
 * @author yang.sopiana
 *
 */
public class element_value 
{
	/**
	 * <p>The <code>tag</code> item uses a single ASCII character to indicate the type of the value of the element-value pair. This determines 
	 * which item of the value union is in use. Following table shows the valid characters for the <code>tag</code> item, the type indicated 
	 * by each character, and the item used in the value union for each character. The table's fourth column is used in the description below 
	 * of one item of the value union.</p>
	 * <table>
	 * 	<tr>
	 * 		<th>tag Item</th><th>Type</th><th>value Item</th><th>Constant Type</th>
	 * 	</tr><tr>
	 * 		<td><code>B</code></td> <td><code>byte</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>C</code></td> <td><code>char</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>D</code></td> <td><code>double</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Double</code></td>
 	 * 	</tr><tr>
	 * 		<td><code>F</code></td> <td><code>float</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Float</code></td>
	 * 	</tr><tr>
	 * 		<td><code>I</code></td> <td><code>int</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>J</code></td> <td><code>long</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Long</code></td>
	 * 	</tr><tr>
	 * 		<td><code>S</code></td> <td><code>short</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>Z</code></td> <td><code>boolean</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>s</code></td> <td><code>String</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Utf8</code></td>
	 * 	</tr><tr>
	 * 		<td><code>e</code></td> <td><code>Enum</code> type</td> <td><code>enum_const_value</code></td> <td><i>Not applicable</i></td>
	 * 	</tr><tr>
	 * 		<td><code>c</code></td> <td><code>Class</code></td> <td><code>class_info_index</code></td> <td><i>Not applicable</i></td>
	 * 	</tr><tr>
	 * 		<td><code>@</code></td> <td><code>Annotation</code> type</td> <td><code>annotation_value</code></td> <td><i>Not applicable</i></td>
	 * 	</tr><tr>
	 * 		<td><code>[</code></td> <td><code>Array</code> type</td> <td><code>array_value</code></td> <td><i>Not applicable</i></td>
	 *  </tr>
	 * </table>
	 */
	private byte tag;
	//==>begin of union
	/**
	 * <p>The <code>const_value_index</code> item denotes either a primitive constant value or a String literal as the value of this element-
	 * value pair.</p>
	 * <p>The value of the <code>const_value_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>
	 * constant_pool</code> entry at that index must be of a type appropriate to the <code>tag</code> item.</p>
	 */
	private short const_value_index;
	/**
	 * <p>The <code>enum_const_value</code> item denotes an <code>enum</code> constant as the value of this element-value pair.</p>
	 */
	private enum_const_value_info enum_const_value;
	/**
	 * <p>The <code>class_info_index</code> item denotes a class literal as the value of this element value pair. </p>
	 * <p>The <code>class_info_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a return descriptor. The return descriptor gives 
	 * the type corresponding to the class literal represented by this element_value structure. Types correspond to class literals as follows:</p>
	 * <ul>
	 * <li>For a class literal <i>C</i>. class, where <i>C</i> is the name of a class, interface, or array type, the corresponding type is <i>C</i>. 
	 * The return descriptor in the <code>constant_pool</code> will be an <code>ObjectType</code> or <code>an ArrayType</code>.</li>
	 * <li>For a class literal <i>p</i>. class, where <i>p</i> is the name of a primitive type, the corresponding type is <i>p</i>. The return 
	 * descriptor in the <code>constant_pool</code> will be a <code>BaseType</code> character.</li>
	 * <li>For a class literal <code>void</code>. class, the corresponding type is <code>void</code>. The return descriptor in the <code>constant_pool</code> 
	 * will be <code>V</code>.</li>
	 * </ul>
	 */
	private short class_info_index;
	/**
	 * <p>The <code>annotation_value</code> item denotes a "nested" annotation as the value of this element-value pair.</p>
	 * <p>The value of the <code>annotation_value</code> item is an annotation structure that gives the annotation represented by 
	 * this <code>element_value</code> structure.</p>
	 */
	private annotation_info annotation_value;
	/**
	 * <p>The <code>array_value</code> item denotes an array as the value of this element-value pair.</p>
	 */
	private array_value_info array_value;
	//==>end of union
	/**
	 * Factory method to generate a <code>element_value</code> instance.
	 * 
	 * <p>The <code>element_value</code> structure is a discriminated union representing the value of an element-value pair.</p>
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return instance of <code>element_value</code>
	 * @throws decompilerException decompilerException if supplied <code>info</code> has invalid <code>element_value</code> format
	 */
	public static element_value getInstance(byte[]classFileData, int offset) throws decompilerException
	{
		element_value res = new element_value();
		res.tag = classFileData[offset++];
		switch((char)(res.tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				res.const_value_index = Util.byte2Short(classFileData,offset);
				break;
			case 'e':
				res.enum_const_value = enum_const_value_info.getInstance(classFileData, offset);
				break;
			case 'c':
				res.class_info_index = Util.byte2Short(classFileData,offset);
				break;
			case '@':
				res.annotation_value = annotation_info.getInstance(classFileData, offset);
				break;
			case '[':
				res.array_value = array_value_info.getInstance(classFileData, offset);
				break;
			default:
				throw new decompilerException("unsupported tag on element_value entry");
		}
		return res;
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>element_value</code> entry components</p>
	 * @return size of <code>element_value</code> entry
	 */
	public int getSize() 
	{
		int res=1;
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
			case 'c':
				res+=2;
				break;
			case 'e':
				res+=enum_const_value.getSize();
				break;
			case '@':
				res+=annotation_value.getSize();
				break;
			case '[':
			default:
				res+=array_value.getSize();
				break;
		}
		return res;
	}
	/**
	 * Accessor method to <code>tag</code> field
	 * 
	 * <p>The <code>tag</code> item uses a single ASCII character to indicate the type of the value of the element-value pair. This determines 
	 * which item of the value union is in use. Following table shows the valid characters for the <code>tag</code> item, the type indicated 
	 * by each character, and the item used in the value union for each character. The table's fourth column is used in the description below 
	 * of one item of the value union.</p>
	 * <table summary="Interpretation of tag values as types">
	 * <thead>
	 * 	<tr>
	 * 		<th>tag Item</th><th>Type</th><th>value Item</th><th>Constant Type</th>
	 * 	</tr>
	 * </thead>
	 * <tbody>
	 * <tr>
	 * 		<td><code>B</code></td> <td><code>byte</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>C</code></td> <td><code>char</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>D</code></td> <td><code>double</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Double</code></td>
 	 * 	</tr><tr>
	 * 		<td><code>F</code></td> <td><code>float</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Float</code></td>
	 * 	</tr><tr>
	 * 		<td><code>I</code></td> <td><code>int</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>J</code></td> <td><code>long</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Long</code></td>
	 * 	</tr><tr>
	 * 		<td><code>S</code></td> <td><code>short</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>Z</code></td> <td><code>boolean</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Integer</code></td>
	 * 	</tr><tr>
	 * 		<td><code>s</code></td> <td><code>String</code></td> <td><code>const_value_index</code></td> <td><code>CONSTANT_Utf8</code></td>
	 * 	</tr><tr>
	 * 		<td><code>e</code></td> <td><code>Enum</code> type</td> <td><code>enum_const_value</code></td> <td><i>Not applicable</i></td>
	 * 	</tr><tr>
	 * 		<td><code>c</code></td> <td><code>Class</code></td> <td><code>class_info_index</code></td> <td><i>Not applicable</i></td>
	 * 	</tr><tr>
	 * 		<td><code>@</code></td> <td><code>Annotation</code> type</td> <td><code>annotation_value</code></td> <td><i>Not applicable</i></td>
	 * 	</tr><tr>
	 * 		<td><code>[</code></td> <td><code>Array</code> type</td> <td><code>array_value</code></td> <td><i>Not applicable</i></td>
	 *  </tr>
	 * </tbody>
	 * </table>
	 * @return value of <code>tag</code> field
	 */
	public byte getTag() { return tag; }
	/**
	 * Accessor method to <code>const_value_index</code> field
	 * 
	 * <p>The <code>const_value_index</code> item denotes either a primitive constant value or a String literal as the value of this element-
	 * value pair.</p>
	 * <p>The value of the <code>const_value_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>
	 * constant_pool</code> entry at that index must be of a type appropriate to the <code>tag</code> item.</p>
	 * @return value of <code>const_value_index</code> field
	 * @throws decompilerException <code>tag</code> is not a primitive type
	 */
	public short getConst_value_index() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				return const_value_index;
			case 'e':
				throw new decompilerException("Not a const_value_index type, use getEnum_const_value() instead");
			case 'c':
				throw new decompilerException("Not a const_value_index type, use getClass_info_index() instead");
			case '@':
				throw new decompilerException("Not a const_value_index type, use getAnnotation_value() instead");
			case '[':
			default:
				throw new decompilerException("Not a const_value_index type, use getArray_value() instead");
		}
	}
	/**
	 * Accessor method to <code>enum_const_value</code> field
	 * 
	 * <p>The <code>enum_const_value</code> item denotes an <code>enum</code> constant as the value of this element-value pair.</p>
	 * @return value of <code>enum_const_value</code> field
	 * @throws decompilerException <code>tag</code> is not a enum type
	 */
	public enum_const_value_info getEnum_const_value() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a enum_const_value type, use getConst_value_index() instead");
			case 'e':
				return enum_const_value;
			case 'c':
				throw new decompilerException("Not a enum_const_value type, use getClass_info_index() instead");
			case '@':
				throw new decompilerException("Not a enum_const_value type, use getAnnotation_value() instead");
			case '[':
			default:
				throw new decompilerException("Not a enum_const_value type, use getArray_value() instead");
		}
	}
	/**
	 * Accessor method to <code>class_info_index</code> field
	 * 
	 * <p>The <code>class_info_index</code> item denotes a class literal as the value of this element value pair. </p>
	 * <p>The <code>class_info_index</code> item must be a valid index into the <code>constant_pool</code> table. The <code>constant_pool</code> 
	 * entry at that index must be a <code>CONSTANT_Utf8_info</code> structure representing a return descriptor. The return descriptor gives 
	 * the type corresponding to the class literal represented by this element_value structure. Types correspond to class literals as follows:</p>
	 * <ul>
	 * <li>For a class literal <i>C</i>. class, where <i>C</i> is the name of a class, interface, or array type, the corresponding type is <i>C</i>. 
	 * The return descriptor in the <code>constant_pool</code> will be an <code>ObjectType</code> or <code>an ArrayType</code>.</li>
	 * <li>For a class literal <i>p</i>. class, where <i>p</i> is the name of a primitive type, the corresponding type is <i>p</i>. The return 
	 * descriptor in the <code>constant_pool</code> will be a <code>BaseType</code> character.</li>
	 * <li>For a class literal <code>void</code>. class, the corresponding type is <code>void</code>. The return descriptor in the <code>constant_pool</code> 
	 * will be <code>V</code>.</li>
	 * </ul>
	 * @return value of <code>class_info_index</code> field
	 * @throws decompilerException <code>tag</code> is not a class type
	 */
	public short getClass_info_index() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a class_info_index type, use getConst_value_index() instead");
			case 'e':
				throw new decompilerException("Not a class_info_index type, use getClass_info_index() instead");
			case 'c':
				return class_info_index;
			case '@':
				throw new decompilerException("Not a class_info_index type, use getAnnotation_value() instead");
			case '[':
			default:
				throw new decompilerException("Not a class_info_index type, use getArray_value() instead");
		}
	}
	/**
	 * Accessor method to <code>annotation_value</code> field
	 * 
	 * <p>The <code>annotation_value</code> item denotes a "nested" annotation as the value of this element-value pair.</p>
	 * <p>The value of the <code>annotation_value</code> item is an annotation structure that gives the annotation represented by 
	 * this <code>element_value</code> structure.</p>
	 * @return value of <code>annotation_value</code> field
	 * @throws decompilerException <code>tag</code> is not a annotation type
	 */
	public annotation_info getAnnotation_value() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a annotation type, use getConst_value_index() instead");
			case 'e':
				throw new decompilerException("Not a annotation type, use getClass_info_index() instead");
			case 'c':
				throw new decompilerException("Not a annotation type, use getEnum_const_value() instead");
			case '@':
				return annotation_value;
			case '[':
			default:
				throw new decompilerException("Not a annotation type, use getArray_value() instead");
		}
	}
	/**
	 * Accessor method to <code>array_value</code> field
	 * 
	 * <p>The <code>array_value</code> item denotes an array as the value of this element-value pair.</p>
	 * @return value of <code>array_value</code> field
	 * @throws decompilerException <code>tag</code> is not a array type
	 */
	public array_value_info getArray_value() throws decompilerException
	{
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				throw new decompilerException("Not a array_value type, use getConst_value_index() instead");
			case 'e':
				throw new decompilerException("Not a array_value type, use getClass_info_index() instead");
			case 'c':
				throw new decompilerException("Not a array_value type, use getEnum_const_value() instead");
			case '[':
				return array_value;
			case '@':
			default:
				throw new decompilerException("Not a array_value type, use getAnnotation_value() instead");
		}
	}
	
	public String toString(int indent, cp_info[] constant_pool) 
	{	
		String indentStr = class_info.getIndent(indent);
		String res=indentStr+" tag: "+(char)(tag&0xFF);
		switch((char)(tag&0xFF))
		{
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'Z':
			case 's':
				res+=indentStr+" const_value_index: "+const_value_index+"\n";
				res+=constant_pool[const_value_index].toString(indent+1, constant_pool);
				break;
			case 'e':
				res+=indentStr+" enum_const_value: \n";
				res+=enum_const_value.toString(indent+1, constant_pool);
				break;
			case 'c':
				res+=indentStr+" class_info_index: "+class_info_index+"\n";
				res+=constant_pool[class_info_index].toString(indent+1, constant_pool);
				break;
			case '@':
				res+=indentStr+" annotation_value: \n";
				res+=annotation_value.toString(indent+1, constant_pool);
				break;
			case '[':
			default:
				res+=indentStr+" array_value: \n";
				res+=array_value.toString(indent+1, constant_pool);
				break;
		}
		return res;
	}
}
