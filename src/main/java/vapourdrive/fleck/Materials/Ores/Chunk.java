package vapourdrive.fleck.Materials.Ores;

import java.util.ArrayList;

/**
 * Created by CBos on 12/4/2017.
 */
public class Chunk {

    private final String oreDict;
    private final String chunkName;
    private final String material;
    private final ArrayList<ChunkComponent> ChunkComponents;

    public Chunk(String oreDict, String material, ArrayList<ChunkComponent> ChunkComponents) {
        this.oreDict = oreDict;
        this.chunkName = "";
        this.material = material;
        this.ChunkComponents = ChunkComponents;
    }
    public Chunk(String oreDict, String chunkName, String material, ArrayList<ChunkComponent> ChunkComponents) {
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

    public ArrayList<ChunkComponent> getComponents() {
        return this.ChunkComponents;
    }
}
