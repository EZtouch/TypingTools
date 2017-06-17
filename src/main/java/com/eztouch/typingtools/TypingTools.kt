package com.eztouch.typingtools

import com.eztouch.typingtools.proxy.IProxy
import com.eztouch.typingtools.reference.Messages
import com.eztouch.typingtools.reference.Reference
import com.eztouch.typingtools.util.LogHelper
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.*


@Mod(modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        certificateFingerprint = TypingTools.FINGERPRINT,
        version = Reference.VERSION)
class TypingTools {

    @EventHandler
    fun preInit(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(instance)
    }

    @EventHandler
    fun invalidFingerprint(event: FMLFingerprintViolationEvent) {
        if (FINGERPRINT == "@FINGERPRINT@") {
            LogHelper.info(Messages.NO_FINGERPRINT_MESSAGE)
        } else {
            LogHelper.warn(Messages.INVALID_FINGERPRINT_MESSAGE)
        }
    }

    @Mod.EventHandler
    fun onServerStarting(event: FMLServerStartingEvent) {
        proxy!!.onServerStarting(event)
    }

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        proxy!!.onPreInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        proxy!!.onInit(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy!!.onPostInit(event)
    }

    @Mod.EventHandler
    fun onServerStopping(event: FMLServerStoppingEvent) {
        proxy!!.onServerStopping(event)
    }

    companion object {
        @Mod.Instance(Reference.MOD_ID)
        var instance: TypingTools? = null

        @SidedProxy(clientSide = "com.eztouch.typingtools.proxy.ClientProxy", serverSide = "com.eztouch.typingtools.proxy.ServerProxy")
        var proxy: IProxy? = null

        const val FINGERPRINT = "@FINGERPRINT@"
    }
}