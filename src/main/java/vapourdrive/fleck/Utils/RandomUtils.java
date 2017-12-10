package vapourdrive.fleck.Utils;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;
import vapourdrive.fleck.Fleck;
import vapourdrive.fleck.items.FleckItems;

import java.util.List;

/**
 * Created by CBos on 11/28/2017.
 */
public class RandomUtils {

    public static NBTTagCompound getNBT(ItemStack stack)
    {
        if (stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        return stack.getTagCompound();
    }

    public static ItemStack getStackFromOreDict(String material) {
        List<ItemStack> stacks = OreDictionary.getOres(material);
        if(!(stacks.isEmpty())) {
            Fleck.Log.log(Level.INFO, new ItemStack(stacks.get(0).getItem()).getDisplayName());
            return stacks.get(0).copy();
        }
        return null;
    }
}
