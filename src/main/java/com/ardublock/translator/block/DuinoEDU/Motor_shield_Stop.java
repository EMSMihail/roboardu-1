package com.ardublock.translator.block.Duinoedu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
 * @author User
 */
public class Motor_shield_Stop  extends TranslatorBlock {

    /**
     *
     * @param blockId
     * @param translator
     * @param codePrefix
     * @param codeSuffix
     * @param label
     */
    public Motor_shield_Stop (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
			
			
			translator.addDefinitionCommand("//libraries at http://duinoedu.com/dl/lib/dupont/EDU_MotorShield_Dupont/");
			translator.addHeaderFile("MotorShieldDupont.h");
			translator.addDefinitionCommand("MotorShieldDupont monMotorShield;");
			translator.addSetupCommand("monMotorShield.brancher();");
						
			String ret =  "monMotorShield.stopper();";
			
			return ret ;	
		}
}
