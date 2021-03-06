package com.ardublock.translator.block.storage;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
 * @author User
 */
public class EEPROMWriteIntBlock extends TranslatorBlock
{

    /**
     *
     * @param blockId
     * @param translator
     * @param codePrefix
     * @param codeSuffix
     * @param label
     */
    public EEPROMWriteIntBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
		setupEEPROMEnvironment(translator);

			String ret = "eepromWriteInt( ";
			
			TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
			
			ret += tb.toCode();
			tb = this.getRequiredTranslatorBlockAtSocket(1);
			ret = "\t"+ret + " , " + tb.toCode() + " ) ;\n";
			
		return codePrefix + ret + codeSuffix;
	}
	
	private static void setupEEPROMEnvironment(Translator t)
	{
		t.addHeaderFile("EEPROM.h");
		t.addDefinitionCommand(	"/*******************************************************************\n"+
								"A way to write an 'int' (2 Bytes) to EEPROM \n"					+
								"EEPROM library natively supports only bytes. \n"						+
								"Note it takes around 8ms to write an int to EEPROM \n"+
								"*******************************************************************/\n"+
								"void eepromWriteInt(int address, int value){\n"						+
								"	union u_tag {\n"													+
								"		byte b[2];        //assumes 2 bytes in an int\n"				+
								"		int INTtime;\n"													+
								"	} time;\n"															+
								"	time.INTtime=value;\n"												+
								"	\n"																	+
								"	EEPROM.write(address  , time.b[0]); \n"								+
								"	EEPROM.write(address+1, time.b[1]); \n"								+
								"}\n" );
	}

}
