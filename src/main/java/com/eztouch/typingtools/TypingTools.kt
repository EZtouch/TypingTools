package com.eztouch.typingtools

import com.eztouch.typingtools.common.CommonProxy
import com.eztouch.typingtools.handler.GuiAnalyzer
import com.eztouch.typingtools.handler.KeyInputEventHandler
import com.eztouch.typingtools.handler.MessageAnalyzer
import com.eztouch.typingtools.reference.Reference
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.network.NetworkRegistry

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
class TypingTools {

    @Mod.Instance(Reference.MOD_ID)
    var instance: TypingTools? = null

    @EventHandler
    fun preInit(event: FMLInitializationEvent) {
        Companion.proxy!!.registerHandlers()
        MinecraftForge.EVENT_BUS.register(instance)

        MinecraftForge.EVENT_BUS.register(MessageAnalyzer())
        MinecraftForge.EVENT_BUS.register(GuiAnalyzer())
        MinecraftForge.EVENT_BUS.register(KeyInputEventHandler())
    }

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, Companion.proxy)
        Companion.proxy!!.registerKeyBindings()
    }

    companion object {
        @SidedProxy(clientSide = "com.eztouch.typingtools.client.ClientProxy", serverSide = "com.eztouch.typingtools.common.CommonProxy")
        var proxy: CommonProxy? = null
    }
}