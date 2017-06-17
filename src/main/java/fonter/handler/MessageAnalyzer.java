package fonter.handler;

import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by EZtouch on 20/08/15.
 */
public class MessageAnalyzer
{
    public static String chatMsg;

    @SubscribeEvent
    public void onMessageReceived(ServerChatEvent event)
    {
        //chatMsg = event.getComponent().getUnformattedText();
        //event.setComponent(new ChatComponentText("Your message has been deleted"));
    }
}

