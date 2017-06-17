package com.eztouch.typingtools.proxy

import net.minecraftforge.fml.common.event.*

abstract class CommonProxy : IProxy {

    override fun onPreInit(event: FMLPreInitializationEvent) {
    }

    override fun onInit(event: FMLInitializationEvent) {
    }

    override fun onPostInit(event: FMLPostInitializationEvent) {
    }

    override fun onServerStarting(event: FMLServerStartingEvent) {
    }

    override fun onServerStopping(event: FMLServerStoppingEvent) {
    }

    fun registerEventHandlers() {
    }
}