package vapourdrive.fleck.materials.Ores;

/**
 * Created by CBos on 11/25/2017.
 */
public class Ore {
    private final String name;
    private final String oreDict;
    private final String debrisName;
    private final String material;

    public Ore(String name, String oreDict, String material) {
        this.name = name;
        this.oreDict = oreDict;
        this.debrisName = "";
        this.material = material;
    }
    public Ore(String name, String oreDict, String debrisName, String material) {
        this.name = name;
        this.oreDict = oreDict;
        this.debrisName = debrisName;
        this.material = material;
    }

    public String getName() {
        return this.name;
    }

    public String getOreDict() {
        return this.oreDict;
    }

    public boolean getHasDebris() {
        if (debrisName != null) {
            return true;
        }
        return false;
    }

    public String getDebrisName() {
        return this.debrisName;
    }


    public String getMaterial() {
        return this.material;
    }
}
