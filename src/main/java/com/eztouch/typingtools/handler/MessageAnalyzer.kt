package com.eztouch.typingtools.handler

import net.minecraftforge.event.ServerChatEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class MessageAnalyzer {

    @SubscribeEvent
    fun onMessageReceived(event: ServerChatEvent) {
        //chatMsg = event.getComponent().getUnformattedText();
        //event.setComponent(new ChatComponentText("Your message has been deleted"));
    }

    companion object {
        var chatMsg: String? = null
    }
}