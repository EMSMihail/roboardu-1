package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
 * @author User
 */
public class MapBlock extends TranslatorBlock
{

    /**
     *
     * @param blockId
     * @param translator
     * @param codePrefix
     * @param codeSuffix
     * @param label
     */
    public MapBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

    /**
     *
     * @return
     * @throws SocketNullException
     * @throws SubroutineNotDeclaredException
     */
    @Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String ret = "map ( ";
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		ret = ret + tb.toCode();
		ret = ret + " , ";
		tb = this.getRequiredTranslatorBlockAtSocket(1);
		ret = ret + tb.toCode();
		ret = ret + " , ";
		tb = this.getRequiredTranslatorBlockAtSocket(2);
		ret = ret + tb.toCode();
		ret = ret + " , ";
		tb = this.getRequiredTranslatorBlockAtSocket(3);
		ret = ret + tb.toCode();
		ret = ret + " , ";
		tb = this.getRequiredTranslatorBlockAtSocket(4);
		ret = ret + tb.toCode();
		ret = ret + " ) ";
		return codePrefix + ret + codeSuffix;
	}
	
}
