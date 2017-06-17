package com.eztouch.typingtools.proxy

import net.minecraftforge.fml.common.event.*

interface IProxy {

    fun onPreInit(event: FMLPreInitializationEvent)

    fun onInit(event: FMLInitializationEvent)

    fun onPostInit(event: FMLPostInitializationEvent)

    fun onServerStarting(event: FMLServerStartingEvent)

    fun onServerStopping(event: FMLServerStoppingEvent)

    fun getClientProxy(): ClientProxy? {
        return null
    }
}