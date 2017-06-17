package com.eztouch.typingtools.reference

import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.lwjgl.input.Keyboard

@SideOnly(Side.CLIENT)
object Keybindings {
    val fancygui = KeyBinding(Names.Keys.FANCYGUI, Keyboard.KEY_M, Names.Keys.CATEGORY)
}