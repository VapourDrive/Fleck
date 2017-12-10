package vapourdrive.fleck.events;

import net.minecraftforge.common.MinecraftForge;

/**
 * Created by CBos on 11/28/2017.
 */
public class EventHandler {
    public static void init(){
        MinecraftForge.EVENT_BUS.register(new DropHandler());
        MinecraftForge.EVENT_BUS.register(new ToolTipHandler());
        MinecraftForge.EVENT_BUS.register(new RightClickEventHandler());
    }
}
