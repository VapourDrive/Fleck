package vapourdrive.fleck.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import vapourdrive.fleck.materials.Ores.Ore;
import vapourdrive.fleck.items.FleckItems;

/**
 * Created by CBos on 12/6/2017.
 */
public class RightClickEventHandler {

    @SubscribeEvent
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        EntityPlayer player = event.getEntityPlayer();
        ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
        if(event.getItemStack() == player.getHeldItem(EnumHand.MAIN_HAND) && player.getHeldItem(EnumHand.MAIN_HAND).getCount() >= 9) {
            if (event.getEntityPlayer().getHeldItem(EnumHand.OFF_HAND).getItem() == Item.getItemFromBlock(Blocks.ANVIL)) {
                String oreDict = OreDictionary.getOreName(OreDictionary.getOreIDs(stack)[0]);
                if (oreDict.contains("nugget")) {
                    oreDict = oreDict.replaceFirst("nugget", "");
                    for (Ore ore: FleckItems.Ores) {
                        if(ore.getMaterial().equals(oreDict)) {
                            oreDict = "ingot" + oreDict;

                            ItemStack ingot = OreDictionary.getOres(oreDict).get(0);
                            ingot.setCount(1);


                            if (!ingot.isEmpty()) {
                                player.getHeldItem(EnumHand.MAIN_HAND).shrink(9);
                                if (!(player.addItemStackToInventory(ingot))) {
                                    player.dropItem(ingot, true);
                                }
                                event.setResult(Event.Result.ALLOW);
                            }
                        }
                    }
                }
            }
        }
    }
}
