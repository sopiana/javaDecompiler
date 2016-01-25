package com.sopiana.yang.javaDecompiler.instruction;

import com.sopiana.yang.javaDecompiler.instruction.byteCodes.*;

public abstract class instruction 
{
	protected byte opcode;
	protected int offset;
	public byte getOpcode() { return opcode; }
	public int getOffset() { return offset; }
	public abstract byte[] getData();
	public abstract int getSize();
	public abstract String getMnemonic();
	
	public static instruction getByteCode(byte[]codes, int offset) throws instructionException
	{
		try
		{
			int opcode = codes[offset]&0xFF;
			switch(opcodeTable.values()[opcode])
			{
				case _nop:
					return nop.getInstance(codes, offset);
				case _aconst_null:
					return aconst_null.getInstance(codes, offset);
				case _iconst_m1:
					return iconst_m1.getInstance(codes, offset);
				case _iconst_0:
					return iconst_0.getInstance(codes, offset);
				case _iconst_1:
					return iconst_1.getInstance(codes, offset);
				case _iconst_2:
					return iconst_2.getInstance(codes, offset);
				case _iconst_3:
					return iconst_3.getInstance(codes, offset);
				case _iconst_4:
					return iconst_4.getInstance(codes, offset);
				case _iconst_5:
					return iconst_5.getInstance(codes, offset);
				case _lconst_0:
					return lconst_0.getInstance(codes, offset);
				case _lconst_1:
					return lconst_1.getInstance(codes, offset);
				case _fconst_0:
					return fconst_0.getInstance(codes, offset);
				case _fconst_1:
					return fconst_1.getInstance(codes, offset);
				case _fconst_2:
					return fconst_2.getInstance(codes, offset);
				case _dconst_0:
					return dconst_0.getInstance(codes, offset);
				case _dconst_1:
					return dconst_1.getInstance(codes, offset);
				case _bipush:
					return bipush.getInstance(codes, offset);
				case _sipush:
					return sipush.getInstance(codes, offset);
				case _ldc:
					return ldc.getInstance(codes, offset);
				case _ldc_w:
					return ldc_w.getInstance(codes, offset);
				case _ldc2_w:
					return ldc2_w.getInstance(codes, offset);
				case _iload:
					return iload.getInstance(codes, offset);
				case _lload:
					return lload.getInstance(codes, offset);
				case _fload:
					return fload.getInstance(codes, offset);
				case _dload:
					return dload.getInstance(codes, offset);
				case _aload:
					return aload.getInstance(codes, offset);
				case _iload_0:
					return iload_0.getInstance(codes, offset);
				case _iload_1:
					return iload_1.getInstance(codes, offset);
				case _iload_2:
					return iload_2.getInstance(codes, offset);
				case _iload_3:
					return iload_3.getInstance(codes, offset);
				case _lload_0:
					return lload_0.getInstance(codes, offset);
				case _lload_1:
					return lload_1.getInstance(codes, offset);
				case _lload_2:
					return lload_2.getInstance(codes, offset);
				case _lload_3:
					return lload_3.getInstance(codes, offset);
				case _fload_0:
					return fload_0.getInstance(codes, offset);
				case _fload_1:
					return fload_1.getInstance(codes, offset);
				case _fload_2:
					return fload_2.getInstance(codes, offset);
				case _fload_3:
					return fload_3.getInstance(codes, offset);
				case _dload_0:
					return dload_0.getInstance(codes, offset);
				case _dload_1:
					return dload_1.getInstance(codes, offset);
				case _dload_2:
					return dload_2.getInstance(codes, offset);
				case _dload_3:
					return dload_3.getInstance(codes, offset);
				case _aload_0:
					return aload_0.getInstance(codes, offset);
				case _aload_1:
					return aload_1.getInstance(codes, offset);
				case _aload_2:
					return aload_2.getInstance(codes, offset);
				case _aload_3:
					return aload_3.getInstance(codes, offset);
				case _iaload:
					return iaload.getInstance(codes, offset);
				case _laload:
					return laload.getInstance(codes, offset);
				case _faload:
					return faload.getInstance(codes, offset);
				case _daload:
					return daload.getInstance(codes, offset);
				case _aaload:
					return aaload.getInstance(codes, offset);
				case _baload:
					return baload.getInstance(codes, offset);
				case _caload:
					return caload.getInstance(codes, offset);
				case _saload:
					return saload.getInstance(codes, offset);
				case _istore:
					return istore.getInstance(codes, offset);
				case _lstore:
					return lstore.getInstance(codes, offset);
				case _fstore:
					return fstore.getInstance(codes, offset);
				case _dstore:
					return dstore.getInstance(codes, offset);
				case _astore:
					return astore.getInstance(codes, offset);
				case _istore_0:
					return istore_0.getInstance(codes, offset);
				case _istore_1:
					return istore_1.getInstance(codes, offset);
				case _istore_2:
					return istore_2.getInstance(codes, offset);
				case _istore_3:
					return istore_3.getInstance(codes, offset);
				case _lstore_0:
					return lstore_0.getInstance(codes, offset);
				case _lstore_1:
					return lstore_1.getInstance(codes, offset);
				case _lstore_2:
					return lstore_2.getInstance(codes, offset);
				case _lstore_3:
					return lstore_3.getInstance(codes, offset);
				case _fstore_0:
					return fstore_0.getInstance(codes, offset);
				case _fstore_1:
					return fstore_1.getInstance(codes, offset);
				case _fstore_2:
					return fstore_2.getInstance(codes, offset);
				case _fstore_3:
					return fstore_3.getInstance(codes, offset);
				case _dstore_0:
					return dstore_0.getInstance(codes, offset);
				case _dstore_1:
					return dstore_1.getInstance(codes, offset);
				case _dstore_2:
					return dstore_2.getInstance(codes, offset);
				case _dstore_3:
					return dstore_3.getInstance(codes, offset);
				case _astore_0:
					return astore_0.getInstance(codes, offset);
				case _astore_1:
					return astore_1.getInstance(codes, offset);
				case _astore_2:
					return astore_2.getInstance(codes, offset);
				case _astore_3:
					return astore_3.getInstance(codes, offset);
				case _iastore:
					return iastore.getInstance(codes, offset);
				case _lastore:
					return lastore.getInstance(codes, offset);
				case _fastore:
					return fastore.getInstance(codes, offset);
				case _dastore:
					return dastore.getInstance(codes, offset);
				case _aastore:
					return aastore.getInstance(codes, offset);
				case _bastore:
					return bastore.getInstance(codes, offset);
				case _castore:
					return castore.getInstance(codes, offset);
				case _sastore:
					return sastore.getInstance(codes, offset);
				case _pop:
					return pop.getInstance(codes, offset);
				case _pop2:
					return pop2.getInstance(codes, offset);
				case _dup:
					return dup.getInstance(codes, offset);
				case _dup_x1:
					return dup_x1.getInstance(codes, offset);
				case _dup_x2:
					return dup_x2.getInstance(codes, offset);
				case _dup2:
					return dup2.getInstance(codes, offset);
				case _dup2_x1:
					return dup2_x1.getInstance(codes, offset);
				case _dup2_x2:
					return dup2_x2.getInstance(codes, offset);
				case _swap:
					return swap.getInstance(codes, offset);
				case _iadd:
					return iadd.getInstance(codes, offset);
				case _ladd:
					return ladd.getInstance(codes, offset);
				case _fadd:
					return fadd.getInstance(codes, offset);
				case _dadd:
					return dadd.getInstance(codes, offset);
				case _isub:
					return isub.getInstance(codes, offset);
				case _lsub:
					return lsub.getInstance(codes, offset);
				case _fsub:
					return fsub.getInstance(codes, offset);
				case _dsub:
					return dsub.getInstance(codes, offset);
				case _imul:
					return imul.getInstance(codes, offset);
				case _lmul:
					return lmul.getInstance(codes, offset);
				case _fmul:
					return fmul.getInstance(codes, offset);
				case _dmul:
					return dmul.getInstance(codes, offset);
				case _idiv:
					return idiv.getInstance(codes, offset);
				case _ldiv:
					return ldiv.getInstance(codes, offset);
				case _fdiv:
					return fdiv.getInstance(codes, offset);
				case _ddiv:
					return ddiv.getInstance(codes, offset);
				case _irem:
					return irem.getInstance(codes, offset);
				case _lrem:
					return lrem.getInstance(codes, offset);
				case _frem:
					return frem.getInstance(codes, offset);
				case _drem:
					return drem.getInstance(codes, offset);
				case _ineg:
					return ineg.getInstance(codes, offset);
				case _lneg:
					return lneg.getInstance(codes, offset);
				case _fneg:
					return fneg.getInstance(codes, offset);
				case _dneg:
					return dneg.getInstance(codes, offset);
				case _ishl:
					return ishl.getInstance(codes, offset);
				case _lshl:
					return lshl.getInstance(codes, offset);
				case _ishr:
					return ishr.getInstance(codes, offset);
				case _lshr:
					return lshr.getInstance(codes, offset);
				case _iushr:
					return iushr.getInstance(codes, offset);
				case _lushr:
					return lushr.getInstance(codes, offset);
				case _iand:
					return iand.getInstance(codes, offset);
				case _land:
					return land.getInstance(codes, offset);
				case _ior:
					return ior.getInstance(codes, offset);
				case _lor:
					return lor.getInstance(codes, offset);
				case _ixor:
					return ixor.getInstance(codes, offset);
				case _lxor:
					return lxor.getInstance(codes, offset);
				case _iinc:
					return iinc.getInstance(codes, offset);
				case _i2l:
					return i2l.getInstance(codes, offset);
				case _i2f:
					return i2f.getInstance(codes, offset);
				case _i2d:
					return i2d.getInstance(codes, offset);
				case _l2i:
					return l2i.getInstance(codes, offset);
				case _l2f:
					return l2f.getInstance(codes, offset);
				case _l2d:
					return l2d.getInstance(codes, offset);
				case _f2i:
					return f2i.getInstance(codes, offset);
				case _f2l:
					return f2l.getInstance(codes, offset);
				case _f2d:
					return f2d.getInstance(codes, offset);
				case _d2i:
					return d2i.getInstance(codes, offset);
				case _d2l:
					return d2l.getInstance(codes, offset);
				case _d2f:
					return d2f.getInstance(codes, offset);
				case _i2b:
					return i2b.getInstance(codes, offset);
				case _i2c:
					return i2c.getInstance(codes, offset);
				case _i2s:
					return i2s.getInstance(codes, offset);
				case _lcmp:
					return lcmp.getInstance(codes, offset);
				case _fcmpl:
					return fcmpl.getInstance(codes, offset);
				case _fcmpg:
					return fcmpg.getInstance(codes, offset);
				case _dcmpl:
					return dcmpl.getInstance(codes, offset);
				case _dcmpg:
					return dcmpg.getInstance(codes, offset);
				case _ifeq:
					return ifeq.getInstance(codes, offset);
				case _ifne:
					return ifne.getInstance(codes, offset);
				case _iflt:
					return iflt.getInstance(codes, offset);
				case _ifge:
					return ifge.getInstance(codes, offset);
				case _ifgt:
					return ifgt.getInstance(codes, offset);
				case _ifle:
					return ifle.getInstance(codes, offset);
				case _if_icmpeq:
					return if_icmpeq.getInstance(codes, offset);
				case _if_icmpne:
					return if_icmpne.getInstance(codes, offset);
				case _if_icmplt:
					return if_icmplt.getInstance(codes, offset);
				case _if_icmpge:
					return if_icmpge.getInstance(codes, offset);
				case _if_icmpgt:
					return if_icmpgt.getInstance(codes, offset);
				case _if_icmple:
					return if_icmple.getInstance(codes, offset);
				case _if_acmpeq:
					return if_acmpeq.getInstance(codes, offset);
				case _if_acmpne:
					return if_acmpne.getInstance(codes, offset);
				case _goto:
					return goto_.getInstance(codes, offset);
				case _jsr:
					return jsr.getInstance(codes, offset);
				case _ret:
					return ret.getInstance(codes, offset);
				case _tableswitch:
					return tableswitch.getInstance(codes, offset);
				case _lookupswitch:
					return lookupswitch.getInstance(codes, offset);
				case _ireturn:
					return ireturn.getInstance(codes, offset);
				case _lreturn:
					return lreturn.getInstance(codes, offset);
				case _freturn:
					return freturn.getInstance(codes, offset);
				case _dreturn:
					return dreturn.getInstance(codes, offset);
				case _areturn:
					return areturn.getInstance(codes, offset);
				case _return:
					return return_.getInstance(codes, offset);
				case _getstatic:
					return getstatic.getInstance(codes, offset);
				case _putstatic:
					return putstatic.getInstance(codes, offset);
				case _getfield:
					return getfield.getInstance(codes, offset);
				case _putfield:
					return putfield.getInstance(codes, offset);
				case _invokevirtual:
					return invokevirtual.getInstance(codes, offset);
				case _invokespecial:
					return invokespecial.getInstance(codes, offset);
				case _invokestatic:
					return invokestatic.getInstance(codes, offset);
				case _invokeinterface:
					return invokeinterface.getInstance(codes, offset);
				case _invokedynamic:
					return invokedynamic.getInstance(codes, offset);
				case _new:
					return new_.getInstance(codes, offset);
				case _newarray:
					return newarray.getInstance(codes, offset);
				case _anewarray:
					return anewarray.getInstance(codes, offset);
				case _arraylength:
					return arraylength.getInstance(codes, offset);
				case _athrow:
					return athrow.getInstance(codes, offset);
				case _checkcast:
					return checkcast.getInstance(codes, offset);
				case _instanceof:
					return instanceof_.getInstance(codes, offset);
				case _monitorenter:
					return monitorenter.getInstance(codes, offset);
				case _monitorexit:
					return monitorexit.getInstance(codes, offset);
				case _wide:
					return wide.getInstance(codes, offset);
				case _multianewarray:
					return multianewarray.getInstance(codes, offset);
				case _ifnull:
					return ifnull.getInstance(codes, offset);
				case _ifnonnull:
					return ifnonnull.getInstance(codes, offset);
				case _goto_w:
					return goto_w.getInstance(codes, offset);
				case _jsr_w:	
					return jsr_w.getInstance(codes, offset);
				default:
					throw new instructionException("unknown bytecode was supplied");
				/*case _breakpoint
				case _impdep1
				case _impdep2*/
			}
		}
		catch(Exception e)
		{
			throw new instructionException("unknown bytecode was supplied");
		}
	}
}
