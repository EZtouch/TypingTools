package fonter.common;

import fonter.handler.GuiAnalyzer;
import fonter.handler.KeyInputEventHandler;
import fonter.handler.MessageAnalyzer;
import fonter.reference.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Mod(modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION/*,
         guiFactory = Reference.GUI_FACTORY_CLASS*/,
        acceptedMinecraftVersions = "[1.8.9]"
)
public class Fonter
{
    @SidedProxy(
            clientSide = "fonter.client.ClientProxy",
            serverSide = "fonter.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Instance(Reference.MOD_ID)
    public static Fonter instance;

    public static Map<Character, String> characterMap = Collections.synchronizedMap(new HashMap<Character, String>());


    public void populateCharacterMap()
    {
        characterMap.put('a', "\ud800\udc35");
    }

    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
        proxy.registerHandlers();
        MinecraftForge.EVENT_BUS.register(instance);
        FMLCommonHandler.instance().bus().register(instance);

        MinecraftForge.EVENT_BUS.register(new MessageAnalyzer());
        MinecraftForge.EVENT_BUS.register(new GuiAnalyzer());
        MinecraftForge.EVENT_BUS.register(new KeyInputEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
        proxy.registerKeyBindings();
    }
}
