package com.eztouch.typingtools.proxy

import com.eztouch.typingtools.TypingTools
import com.eztouch.typingtools.client.handler.KeyInputEventHandler
import com.eztouch.typingtools.client.settings.Keybindings
import com.eztouch.typingtools.handler.GuiHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.client.registry.ClientRegistry.registerKeyBinding
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.network.NetworkRegistry


class ClientProxy : CommonProxy() {

    override fun getClientProxy(): ClientProxy {
        return this
    }

    override fun onPreInit(event: FMLPreInitializationEvent) {

        super.onPreInit(event)

        // Register keybindings
        registerKeyBinding(Keybindings.FANCYCHAT)
    }

    override fun onInit(event: FMLInitializationEvent) {

        super.onInit(event)

        // Register the GUI Handler
        NetworkRegistry.INSTANCE.registerGuiHandler(TypingTools.instance, GuiHandler())

        // Register client specific event handlers
        MinecraftForge.EVENT_BUS.register(KeyInputEventHandler())
    }
}