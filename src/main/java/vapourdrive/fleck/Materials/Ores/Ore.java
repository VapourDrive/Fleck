package vapourdrive.fleck.Materials.Ores;

import vapourdrive.fleck.items.EnumPurity;

import java.util.ArrayList;

/**
 * Created by CBos on 11/25/2017.
 */
public class Ore {
    private final String name;
    private final String oreDict;
    private final String chunkName;
    private final String material;

    public Ore(String name, String oreDict, String material) {
        this.name = name;
        this.oreDict = oreDict;
        this.chunkName = "";
        this.material = material;
    }
    public Ore(String name, String oreDict, String chunkName, String material) {
        this.name = name;
        this.oreDict = oreDict;
        this.chunkName = chunkName;
        this.material = material;
    }

    public String getName() {
        return this.name;
    }

    public String getOreDict() {
        return this.oreDict;
    }

    public boolean getHasChunk() {
        if (chunkName != null) {
            return true;
        }
        return false;
    }

    public String getChunkName() {
        return this.chunkName;
    }


    public String getMaterial() {
        return this.material;
    }
}
