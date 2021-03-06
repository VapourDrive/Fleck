package vapourdrive.fleck.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vapourdrive.fleck.materials.OreHandler;
import vapourdrive.fleck.materials.Ores.DebrisComponent;
import vapourdrive.fleck.materials.Ores.Ore;
import vapourdrive.fleck.Reference;
import vapourdrive.fleck.Utils.RandomUtils;
import vapourdrive.fleck.proxies.CommonProxy;

import java.util.ArrayList;

/**
 * Created by CBos on 11/25/2017.
 */
public class ItemDebris extends Item {
    public static final String PurityKey = "Fleck.Debris.Purity";

    public ItemDebris() {
        this.setRegistryName("itemdebris");
        this.setUnlocalizedName(Reference.ModID + "itemdebris");
        this.hasSubtypes = true;
        this.setCreativeTab(CommonProxy.FleckTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab.equals(CommonProxy.FleckTab)) {
            for (int i = 0; i < FleckItems.Ores.size(); i++) {
                Ore ore = FleckItems.Ores.get(i);
                if (ore.getHasDebris() && OreHandler.doesOreExistFromString(ore.getOreDict())) {
                    ItemStack stack = new ItemStack(this);
                    ItemStack pristineChunk = new ItemStack(this);
                    stack.setItemDamage(i);
                    pristineChunk.setItemDamage(i);
                    RandomUtils.getNBT(stack).setInteger(ItemDebris.PurityKey, 0);
                    items.add(stack);
                    RandomUtils.getNBT(pristineChunk).setInteger(ItemDebris.PurityKey, 4);
                    items.add(pristineChunk);
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getItemStackDisplayName(ItemStack stack) {
        Ore ore = OreHandler.getOreFromStack(stack);
        if (ore != null && ore.getHasDebris()) {
            EnumPurity purity = getPurityFromStack(stack);
            return (purity.textColour + purity.getLocalizedName() + " " + I18n.format("item.fleck." + ore.getDebrisName() + ".name"));
        }
        return (I18n.format("item.fleck.uhoh"));
    }

    public EnumPurity getPurityFromStack(ItemStack stack) {
        switch (RandomUtils.getNBT(stack).getInteger(PurityKey)) {
            case 0:
                return EnumPurity.CRUDE;
            case 1:
                return EnumPurity.ROUGH;
            case 2:
                return EnumPurity.FAIR;
            case 3:
                return EnumPurity.PURE;
            case 4:
                return EnumPurity.PRISTINE;
            default:
                return EnumPurity.CRUDE;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return getPurityFromStack(stack).equals(EnumPurity.PRISTINE) ? true : false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(playerIn.isSneaking()) {

        }

        ArrayList<DebrisComponent> components = OreHandler.getComponentsFromChunk(playerIn.getHeldItem(handIn));
        for (DebrisComponent component : components) {
            ItemStack stack = component.getStack(playerIn, getPurityFromStack(playerIn.getHeldItem(handIn)));
            if(stack != null && !stack.isEmpty()) {
                playerIn.getHeldItem(handIn).shrink(1);
                if (!(playerIn.addItemStackToInventory(stack))) {
                    playerIn.dropItem(stack, true);
                }
            }
        }

    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

//    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        if (worldIn.isRemote) {
//            Fleck.Log.log(Level.INFO, "########### Ore Drop for 1000 ###########");
//            Fleck.Log.log(Level.INFO, worldIn.getBlockState(pos).getBlock().getLocalizedName());
//            Fleck.Log.log(Level.INFO, "100 blocks, no fortune: " + gethundredDropCount(worldIn, pos, 0));
//            Fleck.Log.log(Level.INFO, "100 blocks, fortune 1: " + gethundredDropCount(worldIn, pos, 1) + ", Percent increase: " + getPercentIncrease(gethundredDropCount(worldIn, pos, 1), gethundredDropCount(worldIn, pos, 0)));
//            Fleck.Log.log(Level.INFO, "100 blocks, fortune 2: " + gethundredDropCount(worldIn, pos, 2) + ", Percent increase: " + getPercentIncrease(gethundredDropCount(worldIn, pos, 2), gethundredDropCount(worldIn, pos, 0)));
//            Fleck.Log.log(Level.INFO, "100 blocks, fortune 3: " + gethundredDropCount(worldIn, pos, 3) + ", Percent increase: " + getPercentIncrease(gethundredDropCount(worldIn, pos, 3), gethundredDropCount(worldIn, pos, 0)));
//            Fleck.Log.log(Level.INFO, "100 blocks, fortune 4: " + gethundredDropCount(worldIn, pos, 4) + ", Percent increase: " + getPercentIncrease(gethundredDropCount(worldIn, pos, 4), gethundredDropCount(worldIn, pos, 0)));
//
//            Fleck.Log.log(Level.INFO, "");
//        }
//
//
//        return EnumActionResult.SUCCESS;
//    }

    private float getPercentIncrease(int larger, int smaller) {
        return ((float)((larger)) / (float)smaller);
    }

    public int gethundredDropCount(World world, BlockPos pos, int fortune) {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            count += world.getBlockState(pos).getBlock().quantityDropped(world.getBlockState(pos), fortune, world.rand);
        }
        return count;
    }
}
