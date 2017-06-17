package fonter.handler;

import fonter.client.gui.CustomGuiChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by EZtouch on 21/08/15.
 */
public class GuiHandler implements IGuiHandler
{

    public void registerKeyBindings()
    {
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == CustomGuiChat.GUI_ID)
            return new CustomGuiChat();

        return null;
    }
}