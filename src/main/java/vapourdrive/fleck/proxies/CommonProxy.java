package vapourdrive.fleck.proxies;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vapourdrive.fleck.creativetabs.FleckCreativeTab;
import vapourdrive.fleck.events.EventHandler;
import vapourdrive.fleck.items.FleckItems;
import vapourdrive.fleck.items.ItemChunk;

import java.io.File;

/**
 * Created by CBos on 11/24/2017.
 */
@Mod.EventBusSubscriber
public class CommonProxy {

    public static CreativeTabs FleckTab;
    public static File ConfigPath;

    public void preInit (FMLPreInitializationEvent event){
        ConfigPath = event.getModConfigurationDirectory();
        FleckTab = new FleckCreativeTab(CreativeTabs.getNextID(), "FleckTab");
        FleckItems.preInit();

    }

    public void init (FMLInitializationEvent event){
        FleckItems.init();

        EventHandler.init();
    }

    public void postInit (FMLPostInitializationEvent event){
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemChunk());
    }

}
