package vapourdrive.fleck.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vapourdrive.fleck.materials.Ores.Debris;
import vapourdrive.fleck.materials.Ores.DebrisComponent;
import vapourdrive.fleck.materials.Ores.Ore;
import vapourdrive.fleck.Reference;
import vapourdrive.fleck.Utils.RandomUtils;
import vapourdrive.fleck.items.models.DebrisModel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by CBos on 11/24/2017.
 */
public class FleckItems {

    public static ArrayList<Ore> Ores = new ArrayList<>();
    public static ArrayList<Debris> Debris = new ArrayList<Debris>();


    @GameRegistry.ObjectHolder(Reference.ResourcePath + "itemdebris")
    public static Item ItemDebris;


    public static void preInit() {
        setupOreList();
    }

    public static void initModels() {
        DebrisModel.init();
    }

    public static void init() {
        setupDebrisList();
    }

    private static void setupOreList() {
        addOre("Iron", "ironOre", "oreIron", "debrisiron");
        addOre("Gold", "goldOre", "oreGold", "debrisgold");
        addOre("Lapis", "lapisOre", "oreLapis", "debrislapis");
        addOre("Diamond", "diamondOre", "oreDiamond", "debrisdiamond");
        addOre("Redstone", "redstoneOre", "oreRedstone", "debrisredstone");
        addOre("Emerald", "emeraldOre", "oreEmerald", "debrisemerald");
        addOre("Quartz", "quartzOre", "oreQuartz", null);
        addOre("Coal", "coalOre", "oreCoal", "debriscoal");

        addOre("Tin", "tinOre", "oreTin", "debristin");
        addOre("Nickel", "nickelOre", "oreNickel", "debrisnickel");
        addOre("Platinum", "platinumOre", "orePlatinum", "debrisplatinum");
        addOre("Lead", "leadOre", "oreLead", "debrislead");
        addOre("Aluminum", "aluminumOre", "oreAluminum", "debrisaluminum");
        addOre("Silver", "silverOre", "oreSilver", "debrissilver");
        addOre("Mithril", "mithrilOre", "oreMithril", "debrismithril");
        addOre("Copper", "copperOre", "oreCopper", "debriscopper");
    }

    private static void setupDebrisList() {
        addDebris("Iron", "oreIron", "debrisiron", new DebrisComponent(6, 60, new ItemStack(Items.IRON_NUGGET)));
        addDebris("Gold", "oreGold", "debrisgold", new DebrisComponent(6, 60, new ItemStack(Items.GOLD_NUGGET)));
        addDebris("Lapis", "oreLapis", "debrislapis", new DebrisComponent(5, 60, new ItemStack(Items.DYE, 1, 4)));
        addDebris("Diamond", "oreDiamond", "debrisdiamond", new DebrisComponent(6, 60, RandomUtils.getStackFromOreDict("nuggetDiamond")));
        addDebris("Redstone", "oreRedstone", "debrisredstone", new DebrisComponent(2, 10, new ItemStack(Items.REDSTONE)));
        addDebris("Emerald", "oreEmerald", "debrisemerald", new DebrisComponent(6, 60, RandomUtils.getStackFromOreDict("nuggetEmerald")));
        addDebris("Quartz", "quartzOre", "oreQuartz", new DebrisComponent(1, 4, RandomUtils.getStackFromOreDict("nuggetEmerald")));
        addDebris("Coal", "oreCoal", "debriscoal", new DebrisComponent(1, 4, new ItemStack(Items.COAL)), new DebrisComponent(1, 2, 0.2f, RandomUtils.getStackFromOreDict("dustCoal")));

        addDebris("Tin", "oreTin", "debristin", new DebrisComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetTin")));
        addDebris("Nickel", "oreNickel", "debrisnickel", new DebrisComponent(8, 80, RandomUtils.getStackFromOreDict("nuggetNickel")), new DebrisComponent(1, 10, 0.1f, 1.2f, EnumPurity.ROUGH, RandomUtils.getStackFromOreDict("nuggetPlatinum"), 5));
        addDebris("Platinum", "orePlatinum", "debrisplatinum", new DebrisComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetPlatinum")), new DebrisComponent(1, 10, 0.05f, 0f, EnumPurity.PURE, RandomUtils.getStackFromOreDict("nuggetMithril"), 15));
        addDebris("Lead", "oreLead", "debrislead", new DebrisComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetLead")), new DebrisComponent(1, 10, 0.1f, 1.2f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetSilver"), 10));
        addDebris("Aluminum", "oreAluminum", "debrisaluminum", new DebrisComponent(6, 80, RandomUtils.getStackFromOreDict("nuggetAluminum")), new DebrisComponent(1, 10, 0.1f, 1.5f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetTin"), 10));
        addDebris("Silver", "oreSilver", "debrissilver", new DebrisComponent(8, 60, RandomUtils.getStackFromOreDict("nuggetSilver")), new DebrisComponent(4, 10, 0.1f, 1.5f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetLead"), 10));
        addDebris("Mithril", "oreMithril", "debrismithril", new DebrisComponent(6, 80, RandomUtils.getStackFromOreDict("nuggetMithril")), new DebrisComponent(2, 16, 0.1f, 1.5f, EnumPurity.FAIR, RandomUtils.getStackFromOreDict("nuggetDiamond"), 10));
        addDebris("Copper", "oreCopper", "debriscopper", new DebrisComponent(6, 80, RandomUtils.getStackFromOreDict("nuggetCopper")), new DebrisComponent(1, 10, 0.1f, 1.5f, EnumPurity.FAIR, new ItemStack(Items.GOLD_NUGGET), 10));
    }

    private static void addOre(String material, String name, String oreDict, String debrisName) {
        Ores.add(new Ore(name, oreDict, debrisName, material));
    }

    private static void addDebris(String material, String oreDict, String debrisName, DebrisComponent... materials) {
        ArrayList<DebrisComponent> components = new ArrayList<>();
        Collections.addAll(components, materials);
        Debris.add(new Debris(oreDict, debrisName, material, components));
    }
}
