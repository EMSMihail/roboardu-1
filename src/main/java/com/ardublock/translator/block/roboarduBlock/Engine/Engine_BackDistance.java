package com.ardublock.translator.block.roboarduBlock.Engine;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
import java.util.ResourceBundle;

/**
 *
 * @author User
 */
public class Engine_BackDistance extends TranslatorBlock {

    
    private static ResourceBundle uiMessageBundle = ResourceBundle.getBundle("com/ardublock/block/ardublock");
    /**
     *
     * @param blockId
     * @param translator
     * @param codePrefix
     * @param codeSuffix
     * @param label
     */
    public Engine_BackDistance(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    /**
     *
     * @return
     * @throws SocketNullException
     * @throws SubroutineNotDeclaredException
     */
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        translator.CheckClassName(this);

        translator.addSetupCommand("InitEnc();");
        translator.addSetupCommand("InitMotors();");
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String val = translatorBlock.toCode();
        if (Double.parseDouble(val) > 255 || Double.parseDouble(val) < -255) {
            throw new BlockException(translatorBlock.getBlockID(), uiMessageBundle.getString("ardublock.error_msg.out_of_range").replace("?", -255 +"; "+255));
        };
        String ret = "MoveBackByEncoder(" + translatorBlock.toCode() + ", ";
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        val = translatorBlock.toCode();
        try {
            Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new BlockException(translatorBlock.getBlockID(), uiMessageBundle.getString("ardublock.error_msg.must_be_int"));
        }

        ret = ret + translatorBlock.toCode() + ");";
        return codePrefix + ret + codeSuffix;
    }
}
