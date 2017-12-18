package vapourdrive.fleck.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vapourdrive.fleck.items.FleckItems;

/**
 * Created by CBos on 11/27/2017.
 */
public class FleckCreativeTab extends CreativeTabs {
    public static int timeSinceChance = 250;
    public static ItemStack stack;

    public FleckCreativeTab(int id, String name) {
        super(id, name);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getTabLabel()
    {
        return "Fleck";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
        return "Fleck";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
        return new ItemStack(FleckItems.ItemDebris);
    }


    // TODO: 11/27/2017 make iterate properly 
//    @Override
//    @SideOnly(Side.CLIENT)
//    public ItemStack getIconItemStack()
//    {
//        if (timeSinceChance >= 250)
//        {
//            timeSinceChance = 0;
//            ItemStack stack = new ItemStack(FleckItems.ItemDebris);
//            stack.setItemDamage(0);
//        }
//        timeSinceChance++;
//        return stack;
//    }
}
