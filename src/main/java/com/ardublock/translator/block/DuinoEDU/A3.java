package com.ardublock.translator.block.Duinoedu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;

/**
 *
 * @author User
 */
public class A3 extends TranslatorBlock
{

    /**
     *
     * @param blockId
     * @param translator
     * @param codePrefix
     * @param codeSuffix
     * @param label
     */
    public A3(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

    /**
     *
     * @return
     * @throws SocketNullException
     */
    @Override
	public String toCode() throws SocketNullException {
		return codePrefix + "A3" + codeSuffix;
	}

}
