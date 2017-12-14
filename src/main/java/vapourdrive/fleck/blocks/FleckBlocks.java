package vapourdrive.fleck.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import vapourdrive.fleck.Reference;
import vapourdrive.fleck.machines.finesmelter.BlockFineSmelter;

/**
 * Created by CBos on 12/11/2017.
 */

public class FleckBlocks {

    @GameRegistry.ObjectHolder(Reference.ResourcePath + "blockfinesmelter")
    public static BlockFineSmelter FineSmelter;

    public static void preInit() {
        FineSmelter = new BlockFineSmelter();
    }

    public static void init() {
    }

    public static void initModels() {
        FineSmelter.initModel();
    }
}
