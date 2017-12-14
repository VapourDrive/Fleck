package vapourdrive.fleck.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vapourdrive.fleck.materials.Ores.Chunk;
import vapourdrive.fleck.materials.Ores.ChunkComponent;
import vapourdrive.fleck.materials.Ores.Ore;
import vapourdrive.fleck.Reference;
import vapourdrive.fleck.Utils.RandomUtils;
import vapourdrive.fleck.items.models.ChunkModel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by CBos on 11/24/2017.
 */
public class FleckItems {

    public static ArrayList<Ore> Ores = new ArrayList<>();
    public static ArrayList<Chunk> Chunks = new ArrayList<>();


    @GameRegistry.ObjectHolder(Reference.ResourcePath + "itemchunk")
    public static Item ItemChunk;


    public static void preInit() {
        setupOreList();
    }

    public static void initModels() {
        ChunkModel.init();
    }

    public static void init() {
        setupChunkList();
    }

    private static void setupOreList() {
        addOre("Iron", "ironOre", "oreIron", "chunkiron");
        addOre("Gold", "goldOre", "oreGold", "chunkgold");
        addOre("Lapis", "lapisOre", "oreLapis", "chunklapis");
        addOre("Diamond", "diamondOre", "oreDiamond", "chunkdiamond");
        addOre("Redstone", "redstoneOre", "oreRedstone", "chunkredstone");
        addOre("Emerald", "emeraldOre", "oreEmerald", "chunkemerald");
        addOre("Quartz", "quartzOre", "oreQuartz", null);
        addOre("Coal", "coalOre", "oreCoal", "chunkcoal");

        addOre("Tin", "tinOre", "oreTin", "chunktin");
        addOre("Nickel", "nickelOre", "oreNickel", "chunknickel");
        addOre("Platinum", "platinumOre", "orePlatinum", "chunkplatinum");
        addOre("Lead", "leadOre", "oreLead", "chunklead");
        addOre("Aluminum", "aluminumOre", "oreAluminum", "chunkaluminum");
        addOre("Silver", "silverOre", "oreSilver", "chunksilver");
        addOre("Mithril", "mithrilOre", "oreMithril", "chunkmithril");
        addOre("Copper", "copperOre", "oreCopper", "chunkcopper");
    }

    private static void setupChunkList() {
        addChunk("Iron", "oreIron", "chunkiron", new ChunkComponent(6, 60, new ItemStack(Items.IRON_NUGGET)));
        addChunk("Gold", "oreGold", "chunkgold", new ChunkComponent(6, 60, new ItemStack(Items.GOLD_NUGGET)));
        addChunk("Lapis", "oreLapis", "chunklapis", new ChunkComponent(5, 60, new ItemStack(Items.DYE, 1, 4)));
        addChunk("Diamond", "oreDiamond", "chunkdiamond", new ChunkComponent(6, 60, RandomUtils.getStackFromOreDict("nuggetDiamond")));
        addChunk("Redstone", "oreRedstone", "chunkredstone", new ChunkComponent(2, 10, new ItemStack(Items.REDSTONE)));
        addChunk("Emerald", "oreEmerald", "chunkemerald", new ChunkComponent(6, 60, RandomUtils.getStackFromOreDict("nuggetEmerald")));
        addChunk("Quartz", "quartzOre", "oreQuartz", new ChunkComponent(1, 4, RandomUtils.getStackFromOreDict("nuggetEmerald")));
        addChunk("Coal", "oreCoal", "chunkcoal", new ChunkComponent(1, 4, new ItemStack(Items.COAL)), new ChunkComponent(1, 2, 0.2f, RandomUtils.getStackFromOreDict("dustCoal")));

        addChunk("Tin", "oreTin", "chunktin", new ChunkComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetTin")));
        addChunk("Nickel", "oreNickel", "chunknickel", new ChunkComponent(8, 80, RandomUtils.getStackFromOreDict("nuggetNickel")), new ChunkComponent(1, 10, 0.1f, 1.2f, EnumPurity.ROUGH, RandomUtils.getStackFromOreDict("nuggetPlatinum"), 5));
        addChunk("Platinum", "orePlatinum", "chunkplatinum", new ChunkComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetPlatinum")), new ChunkComponent(1, 10, 0.05f, 0f, EnumPurity.PURE, RandomUtils.getStackFromOreDict("nuggetMithril"), 15));
        addChunk("Lead", "oreLead", "chunklead", new ChunkComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetLead")), new ChunkComponent(1, 10, 0.1f, 1.2f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetSilver"), 10));
        addChunk("Aluminum", "oreAluminum", "chunkaluminum", new ChunkComponent(6, 80, RandomUtils.getStackFromOreDict("nuggetAluminum")), new ChunkComponent(1, 10, 0.1f, 1.5f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetTin"), 10));
        addChunk("Silver", "oreSilver", "chunksilver", new ChunkComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetSilver")), new ChunkComponent(4, 10, 0.1f, 1.5f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetLead"), 10));
        addChunk("Mithril", "oreMithril", "chunkmithril", new ChunkComponent(6, 80, RandomUtils.getStackFromOreDict("nuggetMithril")), new ChunkComponent(2, 16, 0.1f, 1.5f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetDiamond"), 10));
        addChunk("Copper", "oreCopper", "chunkcopper", new ChunkComponent(6, 80, RandomUtils.getStackFromOreDict("nuggetCopper")), new ChunkComponent(1, 10, 0.1f, 1.5f, EnumPurity.FAIR, new ItemStack(Items.GOLD_NUGGET), 10));
    }

    private static void addOre(String material, String name, String oreDict, String chunkName) {
        Ores.add(new Ore(name, oreDict, chunkName, material));
    }

    private static void addChunk(String material, String oreDict, String chunkName, ChunkComponent... materials) {
        ArrayList<ChunkComponent> components = new ArrayList<>();
        Collections.addAll(components, materials);
        Chunks.add(new Chunk(oreDict, chunkName, material, components));
    }
}
