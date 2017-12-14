package vapourdrive.fleck.machines.finesmelter;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import vapourdrive.fleck.Reference;
import vapourdrive.fleck.blocks.FleckBlocks;
import vapourdrive.fleck.creativetabs.FleckCreativeTab;
import vapourdrive.fleck.proxies.CommonProxy;

/**
 * Created by CBos on 12/11/2017.
 */
public class ItemFineSmelter extends ItemBlock {
    public ItemFineSmelter(Block block) {
        super(block);
        setRegistryName(FleckBlocks.FineSmelter.getRegistryName());
        setCreativeTab(CommonProxy.FleckTab);
    }
}
