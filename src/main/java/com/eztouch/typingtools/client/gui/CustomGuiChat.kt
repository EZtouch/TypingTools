package com.eztouch.typingtools.client.gui

import net.minecraft.client.gui.GuiChat
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.gui.GuiTextField
import net.minecraft.util.TabCompleter
import org.apache.commons.lang3.StringUtils
import org.lwjgl.input.Keyboard
import java.io.IOException
import java.util.*

class CustomGuiChat : GuiChat //GuiScreen
() {
    private var tabCompleter: TabCompleter? = null
    private var sentHistoryCursor = -1
    private val defaultInputFieldText = ""

    override fun initGui() {
        Keyboard.enableRepeatEvents(true)
        this.sentHistoryCursor = this.mc.ingameGUI.chatGUI.sentMessages.size
        this.inputField = GuiTextField(0, this.fontRendererObj, 4, this.height - 12, this.width - 4, 12)
        this.inputField.maxStringLength = 256
        this.inputField.enableBackgroundDrawing = false
        this.inputField.isFocused = true
        this.inputField.text = this.defaultInputFieldText
        this.inputField.setCanLoseFocus(false)
        this.tabCompleter = ChatTabCompleter(this.inputField)
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    @Throws(IOException::class)
    override fun keyTyped(typedChar: Char, keyCode: Int) {
        this.tabCompleter!!.resetRequested()
        if (keyCode == 15) {
            this.tabCompleter!!.complete()
        } else {
            this.tabCompleter!!.resetDidComplete()
        }

        if (keyCode == 1) {
            this.mc.displayGuiScreen(null as GuiScreen?)
        } else if (keyCode != 28 && keyCode != 156) {
            if (keyCode == 200) {
                this.getSentHistory(-1)
            } else if (keyCode == 208) {
                this.getSentHistory(1)
            } else if (keyCode == 201) {
                this.mc.ingameGUI.chatGUI.scroll(this.mc.ingameGUI.chatGUI.lineCount - 1)
            } else if (keyCode == 209) {
                this.mc.ingameGUI.chatGUI.scroll(-this.mc.ingameGUI.chatGUI.lineCount + 1)
            } else {
                this.inputField.textboxKeyTyped(typedChar, keyCode)
            }
        } else {
            var s = this.inputField.text.trim { it <= ' ' }

            if (s.length > 0) {

                if (characterMap.isEmpty()) {
                    populateMap()
                }

                for ((key, value) in characterMap) {
                    run { s = StringUtils.replace(s, key, value) }
                }
                if (!s.isEmpty()) {
                    this.sendChatMessage(s)
                }
            }

            this.mc.displayGuiScreen(null as GuiScreen?)
        }
    }

    fun populateMap() {
        val FULL_WIDTH_CHARS = "﻿ＡａＢｂＣｃＤｄＥｅＦｆＧｇＨｈＩｉＪｊ" + "ＫｋＬｌＭｍＮｎＯｏＰｐＱｑＲｒＳｓＴｔＵｕＶｖＷｗＸｘＹｙＺｚ"
        val NORMAL_CHARS = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz"

        characterMap.clear()
        characterMap.put("A", "Ａ")
        characterMap.put("a", "ａ")
        characterMap.put("B", "Ｂ")
        characterMap.put("b", "ｂ")
        characterMap.put("C", "Ｃ")
        characterMap.put("c", "ｃ")
        characterMap.put("D", "Ｄ")
        characterMap.put("d", "ｄ")
        characterMap.put("E", "Ｅ")
        characterMap.put("e", "ｅ")
        characterMap.put("F", "Ｆ")
        characterMap.put("f", "ｆ")
        characterMap.put("G", "Ｇ")
        characterMap.put("g", "ｇ")
        characterMap.put("H", "Ｈ")
        characterMap.put("h", "ｈ")
        characterMap.put("I", "Ｉ")
        characterMap.put("i", "ｉ")
        characterMap.put("J", "Ｊ")
        characterMap.put("j", "ｊ")
        characterMap.put("K", "Ｋ")
        characterMap.put("k", "ｋ")
        characterMap.put("L", "Ｌ")
        characterMap.put("l", "ｌ")
        characterMap.put("M", "Ｍ")
        characterMap.put("m", "ｍ")
        characterMap.put("N", "Ｎ")
        characterMap.put("n", "ｎ")
        characterMap.put("O", "Ｏ")
        characterMap.put("o", "ｏ")
        characterMap.put("P", "Ｐ")
        characterMap.put("p", "ｐ")
        characterMap.put("Q", "Ｑ")
        characterMap.put("q", "ｑ")
        characterMap.put("R", "Ｒ")
        characterMap.put("r", "ｒ")
        characterMap.put("S", "Ｓ")
        characterMap.put("s", "ｓ")
        characterMap.put("T", "Ｔ")
        characterMap.put("t", "ｔ")
        characterMap.put("U", "Ｕ")
        characterMap.put("u", "ｕ")
        characterMap.put("V", "Ｖ")
        characterMap.put("v", "ｖ")
        characterMap.put("W", "Ｗ")
        characterMap.put("w", "ｗ")
        characterMap.put("X", "Ｘ")
        characterMap.put("x", "ｘ")
        characterMap.put("Y", "Ｙ")
        characterMap.put("y", "ｙ")
        characterMap.put("Z", "Ｚ")
        characterMap.put("z", "ｚ")

        characterMap.put("`", "`")
        characterMap.put("1", "１")
        characterMap.put("2", "２")
        characterMap.put("3", "３")
        characterMap.put("4", "４")
        characterMap.put("5", "５")
        characterMap.put("6", "６")
        characterMap.put("7", "７")
        characterMap.put("8", "８")
        characterMap.put("9", "９")
        characterMap.put("0", "０")
        characterMap.put("-", "－")
        characterMap.put("=", "＝")

        characterMap.put("\"", "＼")
        characterMap.put("<", "＜")
        characterMap.put(">", "＞")
        characterMap.put("?", "？")
        characterMap.put(",", "，")
        characterMap.put(".", "．")
        characterMap.put("/", "／")

        characterMap.put(";", "；")
        characterMap.put("'", "＇")
        characterMap.put("\\", "＼")
        characterMap.put(":", "：")
        characterMap.put("\"", "＂")

        characterMap.put("~", "～")
        characterMap.put("!", "！")
        characterMap.put("@", "＠")
        characterMap.put("#", "＃")
        characterMap.put("$", "＄")
        characterMap.put("%", "％")
        characterMap.put("^", "＾")
        characterMap.put("&", "＆")
        characterMap.put("*", "＊")
        characterMap.put("_", "＿")
        characterMap.put("+", "＋")
    }

    companion object {
        val GUI_ID = 1
        private val characterMap = Collections.synchronizedMap(HashMap<String, String>())
    }
}