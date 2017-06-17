package fonter.client.gui;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EZtouch on 21/08/15.
 */
public class CustomGuiChat extends GuiChat //GuiScreen
{
    public static final int GUI_ID = 1;
    private static Map<String, String> characterMap = Collections.synchronizedMap(new HashMap<String, String>());
    private boolean playerNamesFound;
    private boolean waitingOnAutocomplete;

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        this.waitingOnAutocomplete = false;

        if (keyCode == 15)
        {
            this.autocompletePlayerNames();
        } else
        {
            this.playerNamesFound = false;
        }

        if (keyCode == 1)
        {
            this.mc.displayGuiScreen((GuiScreen) null);
        } else if (keyCode != 28 && keyCode != 156)
        {
            if (keyCode == 200)
            {
                this.getSentHistory(-1);
            } else if (keyCode == 208)
            {
                this.getSentHistory(1);
            } else if (keyCode == 201)
            {
                this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
            } else if (keyCode == 209)
            {
                this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
            } else
            {
                this.inputField.textboxKeyTyped(typedChar, keyCode);
            }
        } else
        {
            String s = this.inputField.getText().trim();

            if (s.length() > 0)
            {

                if (characterMap.isEmpty())
                {
                    populateMap();
                }

                for (Map.Entry<String, String> entry : characterMap.entrySet())
                {
                    {
                        s = StringUtils.replace(s, entry.getKey(), entry.getValue());
                    }
                }
                /*hm.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));

                //s = StringUtils.replace(s, "a", String.valueOf(Character.toChars(0x2080 + 5)));
                //s = StringUtils.replace(s, "a", String.valueOf(Character.toChars(0x2080 + 5)));
                final String FULL_WIDTH_CHARS = "﻿ＡａＢｂＣｃＤｄＥｅＦｆＧｇＨｈＩｉＪｊ"
                        + "ＫｋＬｌＭｍＮｎＯｏＰｐＱｑＲｒＳｓＴｔＵｕＶｖＷｗＸｘＹｙＺｚ";
                final String NORMAL_CHARS = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
                for(int i = 0; i < FULL_WIDTH_CHARS.length(); i++) {

                }*/
                this.sendChatMessage(s);
            }

            this.mc.displayGuiScreen((GuiScreen) null);
        }
    }

    /*GuiTextField chatField;

    @Override
    public void initGui()
    {
        //fancyChatField = new GUITextBox;
        chatField = new GuiTextField(width / 2, fontRendererObj, width * 3 / 10, height / 2 + 40, width * 3 / 10 - 4, 12);
        chatField.setEnableBackgroundDrawing(false);
        chatField.setMaxStringLength(101);
        updateText();
        chatField.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }

    public void updateScreen()
    {
        super.updateScreen();
        chatField.updateCursorCounter();
    }

    protected void keyTyped(char par1, int par2)
    {
        try
        {
            super.keyTyped(par1, par2);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        chatField.textboxKeyTyped(par1, par2);
    }

    private void drawField(GuiTextField field, String label)
    {
        GL11.glEnable(GL11.GL_BLEND);
        drawString(fontRendererObj, label, field.xPosition, field.yPosition - 12, 0xAAFFFFFF);
        drawRect(field.xPosition - 3, field.yPosition - 3, field.xPosition + field.width + 3, field.yPosition + field.height - 1, 0x22000000);
        drawRect(field.xPosition - 2, field.yPosition - 2, field.xPosition + field.width + 2, field.yPosition + field.height - 2, 0x66000000);

        GL11.glEnable(GL11.GL_BLEND);
        if (field.getText().isEmpty())
            drawString(fontRendererObj, "<blank>", field.xPosition, field.yPosition, 0x22FFFFFF);

        field.drawTextBox();
    }

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
        //drawDefaultBackground();
        super.drawScreen(par1, par2, par3);
        drawField(chatField, "Fancy Chat:");
        GL11.glDisable(GL11.GL_BLEND);
        chatField.drawTextBox();
    }

    private void updateText()
    {
        chatField.setText("");
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3)
    {
        try
        {
            super.mouseClicked(par1, par2, par3);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        chatField.mouseClicked(par1, par2, par3);
    }

    @Override
    public void onGuiClosed()
    {
        chatField.setFocused(false);
        Keyboard.enableRepeatEvents(false);
    }*/


    public void populateMap()
    {
        final String FULL_WIDTH_CHARS = "﻿ＡａＢｂＣｃＤｄＥｅＦｆＧｇＨｈＩｉＪｊ"
                + "ＫｋＬｌＭｍＮｎＯｏＰｐＱｑＲｒＳｓＴｔＵｕＶｖＷｗＸｘＹｙＺｚ";
        final String NORMAL_CHARS = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

        characterMap.clear();
        characterMap.put("A", "Ａ");
        characterMap.put("a", "ａ");
        characterMap.put("B", "Ｂ");
        characterMap.put("b", "ｂ");
        characterMap.put("C", "Ｃ");
        characterMap.put("c", "ｃ");
        characterMap.put("D", "Ｄ");
        characterMap.put("d", "ｄ");
        characterMap.put("E", "Ｅ");
        characterMap.put("e", "ｅ");
        characterMap.put("F", "Ｆ");
        characterMap.put("f", "ｆ");
        characterMap.put("G", "Ｇ");
        characterMap.put("g", "ｇ");
        characterMap.put("H", "Ｈ");
        characterMap.put("h", "ｈ");
        characterMap.put("I", "Ｉ");
        characterMap.put("i", "ｉ");
        characterMap.put("J", "Ｊ");
        characterMap.put("j", "ｊ");
        characterMap.put("K", "Ｋ");
        characterMap.put("k", "ｋ");
        characterMap.put("L", "Ｌ");
        characterMap.put("l", "ｌ");
        characterMap.put("M", "Ｍ");
        characterMap.put("m", "ｍ");
        characterMap.put("N", "Ｎ");
        characterMap.put("n", "ｎ");
        characterMap.put("O", "Ｏ");
        characterMap.put("o", "ｏ");
        characterMap.put("P", "Ｐ");
        characterMap.put("p", "ｐ");
        characterMap.put("Q", "Ｑ");
        characterMap.put("q", "ｑ");
        characterMap.put("R", "Ｒ");
        characterMap.put("r", "ｒ");
        characterMap.put("S", "Ｓ");
        characterMap.put("s", "ｓ");
        characterMap.put("T", "Ｔ");
        characterMap.put("t", "ｔ");
        characterMap.put("U", "Ｕ");
        characterMap.put("u", "ｕ");
        characterMap.put("V", "Ｖ");
        characterMap.put("v", "ｖ");
        characterMap.put("W", "Ｗ");
        characterMap.put("w", "ｗ");
        characterMap.put("X", "Ｘ");
        characterMap.put("x", "ｘ");
        characterMap.put("Y", "Ｙ");
        characterMap.put("y", "ｙ");
        characterMap.put("Z", "Ｚ");
        characterMap.put("z", "ｚ");

        characterMap.put("`", "`");
        characterMap.put("1", "１");
        characterMap.put("2", "２");
        characterMap.put("3", "３");
        characterMap.put("4", "４");
        characterMap.put("5", "５");
        characterMap.put("6", "６");
        characterMap.put("7", "７");
        characterMap.put("8", "８");
        characterMap.put("9", "９");
        characterMap.put("0", "０");
        characterMap.put("-", "－");
        characterMap.put("=", "＝");

        characterMap.put("\"", "＼");
        characterMap.put("<", "＜");
        characterMap.put(">", "＞");
        characterMap.put("?", "？");
        characterMap.put(",", "，");
        characterMap.put(".", "．");
        characterMap.put("/", "／");

        characterMap.put(";", "；");
        characterMap.put("'", "＇");
        characterMap.put("\\", "＼");
        characterMap.put(":", "：");
        characterMap.put("\"", "＂");

        characterMap.put("~", "～");
        characterMap.put("!", "！");
        characterMap.put("@", "＠");
        characterMap.put("#", "＃");
        characterMap.put("$", "＄");
        characterMap.put("%", "％");
        characterMap.put("^", "＾");
        characterMap.put("&", "＆");
        characterMap.put("*", "＊");
        characterMap.put("_", "＿");
        characterMap.put("+", "＋");
    }
}