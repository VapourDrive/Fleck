package vapourdrive.fleck.events;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by CBos on 12/4/2017.
 */

public class ToolTipHandler {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void itemToolTipAddition(ItemTooltipEvent event) {
        if (!(event.getFlags().isAdvanced())) {
            return;
        }

        ItemStack itemstack = event.getItemStack();

        int[] names = OreDictionary.getOreIDs(itemstack);
        for (int name : names) {
            event.getToolTip().add(OreDictionary.getOreName(name));
        }
    }

}
