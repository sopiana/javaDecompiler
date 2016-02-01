package com.sopiana.yang.javaDecompiler.component.sub;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.target.catch_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.empty_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.formal_parameter_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.localvar_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.offset_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.supertype_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.throws_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.type_argument_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.type_parameter_bound_target_info;
import com.sopiana.yang.javaDecompiler.component.sub.target.type_parameter_target_info;
/**
 * Provides abstraction for <code>target_info</code> item
 * <p>The value of the <code>target_info</code> item denotes precisely which type in a declaration or expression is annotated.</p>
 * @author yang.sopiana
 *
 */
public abstract class target_info 
{
	/**
	 * <p>Return <code>target_info</code> according to it's type as following table</p>
	 * <table summary="Interpretation of target_type values">
	 * 		<thead>
	 * 			<tr><th>Value</th><th>Kind of target</th> <th><code>target_info</code> item</th></tr>
	 * 		</thead>
	 * 		<tbody>
	 * 			<tr>
	 * 				<td>0x00</td> 
	 * 				<td>type parameter declaration of generic class or interface</td>
	 * 				<td>type_parameter_target</td>
	 * 			</tr>
	 * 			<tr>
	 * 				<td>0x01</td> 
	 * 				<td>type parameter declaration of generic method or constructor</td>
	 * 				<td>type_parameter_target</td>
	 * 			</tr>
	 * 			<tr>
	 * 				<td>0x10</td> 
	 * 				<td>type in extends or implements clause of class declaration (including the direct superclass or direct superinterface of an anonymous class declaration), or in extends clause of interface declaration</td> 
	 * 				<td>supertype_target</td>
	 * 			</tr>
	 *			<tr>
	 *				<td>0x11</td> 
	 *				<td>type in bound of type parameter declaration of generic class or interface</td>
	 *				<td>type_parameter_bound_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x12</td> 
	 *				<td>type in bound of type parameter declaration of generic method or constructor</td>
	 *				<td>type_parameter_bound_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x13</td> 
	 *				<td>type in field declaration</td> 
	 *				<td>empty_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x14</td> 
	 *				<td>return type of method, or type of newly constructed object</td>
	 *				<td>empty_target</td>
	 *			</tr>	
	 *			<tr>
	 *				<td>0x15</td> 
	 *				<td>receiver type of method or constructor</td> 
	 *				<td>empty_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x16</td> 
	 *				<td>type in formal parameter declaration of method, constructor, or lambda expression</td>
	 *				<td>formal_parameter_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x17<td> 
	 *				<td>type in throws clause of method or constructor</td>
	 *				<td>throws_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x40</td> 
	 *				<td>type in local variable declaration</td> 
	 *				<td>localvar_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x41</td> 
	 *				<td>type in resource variable declaration</td> 
	 *				<td>localvar_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x42</td> 
	 *				<td>type in exception parameter declaration</td> 
	 *				<td>catch_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x43</td> 
	 *				<td>type in <i>instanceof</i> expression</td> 
	 *				<td>offset_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x44</td> 
	 *				<td>type in <i>new</i> expression</td> 
	 *				<td>offset_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x45</td> 
	 *				<td>type in method reference expression using <i>:: new</i></td> 
	 *				<td>offset_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x46</td> 
	 *				<td>type in method reference expression using <i>:: Identifier</i></td>
	 *				<td>offset_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x47</td> 
	 *				<td>type in cast expression</td> 
	 *				<td>type_argument_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x48</td> 
	 *				<td>type argument for generic constructor in <i>new</i> expression or explicit constructor invocation statement</td>
	 *				<td>type_argument_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x49</td> 
	 *				<td>type argument for generic method in method invocation expression</td>
	 *				<td>type_argument_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x4A</td> 
	 *				<td>type argument for generic constructor in method reference expression using <i>:: new</i></td>
	 *				<td>type_argument_target</td>
	 *			</tr>
	 *			<tr>
	 *				<td>0x4B</td> 
	 *				<td>type argument for generic method in method reference expression using <i>:: Identifier</i></td>
	 *				<td>type_argument_target</td>
	 *			</tr>
	 *		</tbody>
	 *	</table>
	 * @param targetType type of a target
	 * @param classFileData byte array from the class file
	 * @param offset starting index to <code>classFileData</code>
	 * @return <code>target_info</code> instance based on <code>targetType</code>
	 * @throws decompilerException if <code>targetType</code> is not a valid type <code>classFileData</code> data is not <code>target_info</code> structure
	 */
	public static target_info getInstance(byte targetType, byte[]classFileData, int offset) throws decompilerException
	{
		switch(targetType)
		{
			case 0x00:
			case 0x01:
				return type_parameter_target_info.getInstance(classFileData,offset);
			case 0x10:
				return supertype_target_info.getInstance(classFileData,offset);
			case 0x11:
			case 0x12:
				return type_parameter_bound_target_info.getInstance(classFileData,offset);
			case 0x13:
			case 0x14:
			case 0x15:
				return empty_target_info.getInstance(classFileData,offset);
			case 0x16:
				return formal_parameter_target_info.getInstance(classFileData,offset);
			case 0x17:
				return throws_target_info.getInstance(classFileData,offset);
			case 0x40:
			case 0x41:
				return localvar_target_info.getInstance(classFileData,offset);
			case 0x42:
				return catch_target_info.getInstance(classFileData,offset);
			case 0x43:
			case 0x44:
			case 0x45:
			case 0x46:
				return offset_target_info.getInstance(classFileData,offset);
			case 0x47:
			case 0x48:
			case 0x49:
			case 0x4A:
			case 0x4B:
				return type_argument_target_info.getInstance(classFileData,offset);
			default:
				throw new decompilerException("target_type is not a valid target_info item");
		}
	}
	/**
	 * Accessor method to <code>size</code> field
	 * 
	 * <p>Return size of <code>target_info</code> entry components</p>
	 * @return size of <code>target_info</code> entry
	 */
	public abstract int getSize();
	public abstract String toString(int indent, cp_info[] constant_pool);
}
