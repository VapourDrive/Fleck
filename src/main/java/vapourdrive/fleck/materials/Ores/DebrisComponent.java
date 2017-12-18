package vapourdrive.fleck.materials.Ores;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import vapourdrive.fleck.items.EnumPurity;

import java.util.Random;

/**
 * Created by CBos on 12/4/2017.
 */
public class DebrisComponent {
    private final int base;
    private final int max;
    private final float chance;
    private final float purityChanceModifyer;
    private final EnumPurity minPurity;
    private final ItemStack stack;
    private final int minLevel;

    public DebrisComponent(int base, int max, float chance, float purityChanceModifyer, EnumPurity minPurity, ItemStack stack, int minLevel)  {
        this.base = base;
        this.max = max;
        this.chance = chance;
        this.purityChanceModifyer = purityChanceModifyer;
        this.minPurity = minPurity;
        this.stack = stack;
        this.minLevel = minLevel;
    }

    public DebrisComponent(int base, int max, ItemStack stack) {
        this.base = base;
        this.max = max;
        this.chance = 1.0F;
        this.purityChanceModifyer = 1.0F;
        this.minPurity = EnumPurity.CRUDE;
        this.stack = stack;
        this.minLevel = 0;
    }

    public DebrisComponent(int base, int max, float chance, ItemStack stack) {
        this.base = base;
        this.max = max;
        this.chance = chance;
        this.purityChanceModifyer = 1.0F;
        this.minPurity = EnumPurity.CRUDE;
        this.stack = stack;
        this.minLevel = 0;
    }

    public ItemStack getStack(EntityPlayer playerIn, EnumPurity purityFromStack) {
        if (this.stack != null && !this.stack.isEmpty() && playerIn.experienceLevel >= this.minLevel && purityFromStack.ordinal() >= this.minPurity.ordinal()) {
            Random rand = new Random();

            if ((((purityFromStack.ordinal()+1) * this.purityChanceModifyer * this.chance)) > rand.nextFloat()) {
                int level = purityFromStack.ordinal();
                int number = (int)(((((float)this.max-(float)this.base)/5.0f)*(float)level) + (float)rand.nextInt(((this.max-this.base)/5) + this.base + 1) + this.base);

                ItemStack stack = this.stack.copy();

                stack.setCount(number);
                return stack;
            }
        }
        return null;
    }

    public String getName() {
        return this.stack.getDisplayName();
    }
}
