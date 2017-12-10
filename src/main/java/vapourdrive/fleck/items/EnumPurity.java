package vapourdrive.fleck.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;

/**
 * Created by CBos on 11/28/2017.
 */
public enum EnumPurity {
    CRUDE(TextFormatting.WHITE, "Crude"),
    ROUGH(TextFormatting.YELLOW, "Rough"),
    FAIR(TextFormatting.GREEN, "Fair"),
    PURE(TextFormatting.AQUA, "Pure"),
    PRISTINE(TextFormatting.LIGHT_PURPLE, "Pristine");

    public final TextFormatting textColour;
    /** Rarity name. */
    public final String purityName;

    private EnumPurity (TextFormatting colour, String name) {
        this.purityName = name;
        this.textColour = colour;
    }

    public String getPurityName() {
        return this.purityName;
    }

    public String getLocalizedName() {
        return (I18n.format("chunk.purity." + this.purityName.toLowerCase()));
    }
}
