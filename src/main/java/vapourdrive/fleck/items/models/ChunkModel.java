package vapourdrive.fleck.items.models;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import org.apache.logging.log4j.Level;
import vapourdrive.fleck.Fleck;
import vapourdrive.fleck.Materials.OreHandler;
import vapourdrive.fleck.Materials.Ores.Ore;
import vapourdrive.fleck.Reference;
import vapourdrive.fleck.items.FleckItems;

import java.util.Iterator;

/**
 * Created by CBos on 11/24/2017.
 */
public class ChunkModel {
    public static void init() {
        ResourceLocation[] resourceLocations = new ResourceLocation[FleckItems.Ores.size()];
        Iterator<Ore> iterator = FleckItems.Ores.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Ore ore = (Ore) iterator.next();
            if (ore.getHasChunk()) {
                ResourceLocation location = new ModelResourceLocation(Reference.ResourcePath + ore.getChunkName());
                Fleck.Log.log(Level.INFO, location + " is the Resource Location");
                resourceLocations[i] = location;
            }
            else {
                ResourceLocation location = new ModelResourceLocation(Reference.ResourcePath + "chunkiron");
                Fleck.Log.log(Level.INFO, location + " is the Resource Location");
                resourceLocations[i] = location;
            }
            i++;
        }

        ModelBakery.registerItemVariants(FleckItems.ItemChunk, resourceLocations);

        ModelLoader.setCustomMeshDefinition(FleckItems.ItemChunk, new ItemMeshDefinition()
        {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                if(OreHandler.getOreFromStack(stack).getHasChunk()) {
                    return new ModelResourceLocation(Reference.ResourcePath + OreHandler.getOreFromStack(stack).getChunkName());
                }
                else {
                    return new ModelResourceLocation(Reference.ResourcePath + "chunkiron");
                }
            }

        });
    }
}
