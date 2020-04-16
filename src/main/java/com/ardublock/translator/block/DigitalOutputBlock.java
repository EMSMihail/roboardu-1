package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
 * @author User
 */
public class DigitalOutputBlock extends TranslatorBlock
{

    /**
     *
     */
    public static final String ARDUBLOCK_DIGITAL_WRITE_DEFINE = "void __ardublockDigitalWrite(int pinNumber, boolean status)\n{\npinMode(pinNumber, OUTPUT);\ndigitalWrite(pinNumber, status);\n}\n";
	
    /**
     *
     * @param blockId
     * @param translator
     * @param codePrefix
     * @param codeSuffix
     * @param label
     */
    public DigitalOutputBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		// Should it ever not use ARDUBLOCK_DIGITAL_WRITE_DEFINE? Cannot think why.
		// What is special about NumberBlocks?
		// Should check for "is a simple number" not "instanceof NumberBlock" now that pinLists constants exist
			translator.addDefinitionCommand(ARDUBLOCK_DIGITAL_WRITE_DEFINE);
			String ret = "__ardublockDigitalWrite(";
			
			ret = ret + translatorBlock.toCode();
			ret = ret + ", ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
			ret = ret + translatorBlock.toCode();
			ret = ret + ");\n";
			return ret;

	}

}
