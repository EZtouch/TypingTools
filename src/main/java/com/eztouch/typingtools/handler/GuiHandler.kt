package com.eztouch.typingtools.handler

import com.eztouch.typingtools.client.gui.CustomGuiChat
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

class GuiHandler : IGuiHandler {

    fun registerKeyBindings() {}

    override fun getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        return null
    }

    override fun getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        if (ID == CustomGuiChat.GUI_ID)
            return CustomGuiChat()

        return null
    }
}