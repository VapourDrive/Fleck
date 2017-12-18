package vapourdrive.fleck.materials;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vapourdrive.fleck.materials.Ores.DebrisComponent;
import vapourdrive.fleck.materials.Ores.Ore;
import vapourdrive.fleck.items.FleckItems;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by CBos on 11/25/2017.
 */
public class OreHandler {

    public static Ore getOreFromStack(ItemStack stack) {
        if (stack.getItem() == FleckItems.ItemDebris) {
            return FleckItems.Ores.get(stack.getItemDamage());
        }
        return null;
    }

    public static boolean doesOreExistFromString(String oreDict) {
        if (OreDictionary.doesOreNameExist(oreDict)){
            return true;
        }
        return false;
    }

    public static boolean doesChunkExistForBlock(Block block) {
        if(getChunkForBlock(block) != null) {
            return true;
        }
        return false;
    }

    public static String getChunkForBlock(Block block) {
        int[] names = OreDictionary.getOreIDs(new ItemStack(block));
        for (int name : names) {
            for (Ore ore : FleckItems.Ores) {
                if (ore.getHasDebris() && ore.getOreDict().equals(OreDictionary.getOreName(name))) {
                    return ore.getDebrisName();
                }
            }
        }
        return null;
    }

    public static int getMetaFromChunkName(String chunk){
        int i = 0;
        for(Ore ore : FleckItems.Ores) {
            if(ore.getHasDebris()) {
                if(ore.getDebrisName().equals(chunk)) {
                    return i;
                }
            }
            i++;
        }
        return 0;
    }

    public static ItemStack getNuggetFromChunk(ItemStack stack) {
        String material = FleckItems.Ores.get(stack.getItemDamage()).getMaterial();
        List<ItemStack> nuggets = OreDictionary.getOres("nugget" + material);
        if(!(nuggets.isEmpty())) {
            return nuggets.get(0).copy();
        }
        return null;
    }

    public static ArrayList<DebrisComponent> getComponentsFromChunk(ItemStack stack) {
        ArrayList<DebrisComponent> components = FleckItems.Debris.get(stack.getItemDamage()).getComponents();

        return components;
    }
}
