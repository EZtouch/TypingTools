package fonter.common;

import fonter.handler.KeyInputEventHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
    public void registerHandlers()
    {
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    public World getClientWorld()
    {
        return null;
    }

    public void registerKeyBindings()
    {
    }

    public boolean isShiftKeyDown()
    {
        return false;
    }

    public KeyInputEventHandler getKeyBindings()
    {
        return null;
    }

    public void registerDisplayInformationPreInit()
    {
    }
}
