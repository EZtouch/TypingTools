package fonter.handler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by EZtouch on 21/08/15.
 */
public class GuiAnalyzer
{
    @SubscribeEvent
    public void onGuiLaunched(GuiOpenEvent event)
    {
        //LogHelper.info("WORKS!");
        if (Minecraft.getMinecraft().currentScreen != null && Minecraft.getMinecraft().thePlayer != null /*&& Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen() == true*/)
        {
            //LogHelper.info("EVENT IS " + event.getPhase());
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("EVENT IS " + event.getPhase()));
            //LogHelper.info("CURRENT GUI IS " + Minecraft.getMinecraft().currentScreen);
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("CURRENT GUI IS " + Minecraft.getMinecraft().currentScreen));
            //LogHelper.info("CHAT IS " + Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen());
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("CHAT IS " + Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()));
            //LogHelper.info("THE CHAT IS OPENED!");
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Time is " + new java.util.Date()));
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(""));
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(""));
        }
    }
}