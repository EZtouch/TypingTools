package fonter.handler;

import fonter.client.gui.CustomGuiChat;
import fonter.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by EZtouch on 21/08/15.
 */
public class KeyInputEventHandler
{

    public KeyBinding keyM = new KeyBinding("Open Fancy Chat Menu", 50, "key.categories.misc");

    public KeyInputEventHandler()
    {
        ClientRegistry.registerKeyBinding(this.keyM);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void playerTick(PlayerTickEvent event)
    {
        if (event.side != Side.SERVER && event.phase == Phase.START && this.keyM.isKeyDown() && FMLClientHandler.instance().getClient().inGameHasFocus)
        {
            Minecraft.getMinecraft().displayGuiScreen(new CustomGuiChat());
        }

    }
}