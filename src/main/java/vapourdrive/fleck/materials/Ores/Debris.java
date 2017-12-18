package vapourdrive.fleck.materials.Ores;

import java.util.ArrayList;

/**
 * Created by CBos on 12/4/2017.
 */
public class Debris {

    private final String oreDict;
    private final String chunkName;
    private final String material;
    private final ArrayList<DebrisComponent> ChunkComponents;

    public Debris(String oreDict, String material, ArrayList<DebrisComponent> ChunkComponents) {
        this.oreDict = oreDict;
        this.chunkName = "";
        this.material = material;
        this.ChunkComponents = ChunkComponents;
    }
    public Debris(String oreDict, String chunkName, String material, ArrayList<DebrisComponent> ChunkComponents) {
        this.oreDict = oreDict;
        this.chunkName = chunkName;
        this.material = material;
        this.ChunkComponents = ChunkComponents;
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

    public ArrayList<DebrisComponent> getComponents() {
        return this.ChunkComponents;
    }
}
