package com.eztouch.typingtools.client.handler

import com.eztouch.typingtools.client.gui.CustomGuiChat
import com.eztouch.typingtools.client.settings.Keybindings
import com.eztouch.typingtools.reference.Key
import com.eztouch.typingtools.reference.Key.FANCYCHAT
import com.eztouch.typingtools.reference.Key.UNKNOWN
import net.minecraft.client.Minecraft
import net.minecraftforge.fml.client.FMLClientHandler
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly


@SideOnly(Side.CLIENT)
class KeyInputEventHandler {

    private fun getPressedKeybinding(): Key {
        if (Keybindings.FANCYCHAT.isPressed) {
            return FANCYCHAT
        }
        return UNKNOWN
    }

    @SubscribeEvent
    fun handleKeyInputEvent(event: InputEvent.KeyInputEvent) {

        if (getPressedKeybinding() === UNKNOWN) {
            return
        }

        if (FMLClientHandler.instance().client.inGameHasFocus && FMLClientHandler.instance().clientPlayerEntity != null) {

            val entityPlayer = FMLClientHandler.instance().clientPlayerEntity

            if (entityPlayer.entityWorld.isRemote) Minecraft.getMinecraft().displayGuiScreen(CustomGuiChat())
        }
    }

}