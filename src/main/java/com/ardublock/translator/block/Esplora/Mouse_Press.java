package com.ardublock.translator.block.Esplora;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
 * @author User
 */
public class Mouse_Press extends TranslatorBlock {

    /**
     *
     * @param blockId
     * @param translator
     * @param codePrefix
     * @param codeSuffix
     * @param label
     */
    public Mouse_Press (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	//@Override

    /**
     *
     * @return
     * @throws SocketNullException
     * @throws SubroutineNotDeclaredException
     */
			public String toCode() throws SocketNullException, SubroutineNotDeclaredException
			{
				String Click;
				TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
				Click = translatorBlock.toCode();
				
				translator.addSetupCommand("Mouse.begin();");
				String ret = "Mouse.press(MOUSE_"+Click+");\n";
				
				return ret;
					
			}
	
}
