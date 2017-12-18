package vapourdrive.fleck.events;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vapourdrive.fleck.items.ItemDebris;
import vapourdrive.fleck.materials.OreHandler;
import vapourdrive.fleck.Utils.RandomUtils;
import vapourdrive.fleck.items.FleckItems;

/**
 * Created by CBos on 11/28/2017.
 */
public class DropHandler {
    @SubscribeEvent
    public void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        if (player != null) {
            for (int i = 0; i < event.getDrops().size(); i++) {
                ItemStack drop = event.getDrops().get(i);
                if (drop != null) {
                    Block block = Block.getBlockFromItem(drop.getItem());

                    if (block != Blocks.AIR && OreHandler.doesChunkExistForBlock(block)) {
                        event.getDrops().remove(i);
                        ItemStack chunk = getDebris(player, event.getWorld(), player.getHeldItem(EnumHand.MAIN_HAND), event.getState(), block, event.getFortuneLevel());
                        event.getDrops().add(chunk);
                    }


                    block = event.getState().getBlock();
                    if (OreHandler.doesChunkExistForBlock(block)){
                        event.getDrops().remove(i);
                        ItemStack chunk = getDebris(player, event.getWorld(), player.getHeldItem(EnumHand.MAIN_HAND), event.getState(), block, event.getFortuneLevel());
                        event.getDrops().add(chunk);
                    }
                }
            }
        }
    }

    public ItemStack getDebris(EntityPlayer player, World world, ItemStack tool, IBlockState state, Block block, int fortune) {
        float expLevel = (float) player.experienceLevel;
        float expLevelMultiplier = expLevel/250.0f;
        float fortuneMultiplier = ((float) fortune)/5.5f;
        float miningLevelMultiplier = ((float) tool.getItem().getHarvestLevel(tool, "pickaxe", player, state))/20;
        float total = (miningLevelMultiplier + expLevelMultiplier + fortuneMultiplier)*100;
        int purity = (world.rand.nextInt((int)(total*0.5f)) + (int)(total*0.6f))/20;

        if (purity > 4) {
            purity = 4;
        }

        ItemStack debris = new ItemStack(FleckItems.ItemDebris, 1, OreHandler.getMetaFromChunkName(OreHandler.getChunkForBlock(block)));

        RandomUtils.getNBT(debris).setInteger(ItemDebris.PurityKey, purity);
        return debris;

    }
}
