package com.eztouch.typingtools.common

import com.eztouch.typingtools.handler.KeyInputEventHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

open class CommonProxy : IGuiHandler {
    fun registerHandlers() {}

    override fun getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        return null
    }

    override fun getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        return null
    }

    val clientWorld: World?
        get() = null

    fun registerKeyBindings() {}

    val isShiftKeyDown: Boolean
        get() = false

    val keyBindings: KeyInputEventHandler?
        get() = null

    fun registerDisplayInformationPreInit() {}
}
