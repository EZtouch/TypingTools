package com.eztouch.typingtools.client.settings

import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.lwjgl.input.Keyboard

@SideOnly(Side.CLIENT)
object Keybindings {

    private val CATEGORY = "key.categories.typingtools"

    val FANCYCHAT = KeyBinding("key.fancychat", Keyboard.KEY_M, CATEGORY)
}