package com.eztouch.typingtools.handler

import com.eztouch.typingtools.client.gui.CustomGuiChat
import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.client.FMLClientHandler
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class KeyInputEventHandler {

    var keyM = KeyBinding("Open Fancy Chat Menu", 50, "key.categories.misc")

    init {
        ClientRegistry.registerKeyBinding(this.keyM)
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    fun playerTick(event: PlayerTickEvent) {
        if (event.side != Side.SERVER && event.phase == Phase.START && this.keyM.isKeyDown && FMLClientHandler.instance().client.inGameHasFocus) {
            Minecraft.getMinecraft().displayGuiScreen(CustomGuiChat())
        }

    }
}