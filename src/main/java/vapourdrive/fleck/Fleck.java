package vapourdrive.fleck;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vapourdrive.fleck.proxies.CommonProxy;

@Mod(modid = Reference.ModID, version = Reference.Version, name = Reference.Name)
public class Fleck
{
    @Mod.Instance(Reference.ModID)
    public static Fleck Instance;

    @SidedProxy(clientSide = "vapourdrive.fleck.proxies.ClientProxy", serverSide = "vapourdrive.fleck.proxies.CommonProxy")
    public static CommonProxy proxy;
    public static final Logger Log = LogManager.getLogger(Reference.ModID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
