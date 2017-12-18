package vapourdrive.fleck.machines.finesmelter;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import vapourdrive.fleck.blocks.FleckBlocks;
import vapourdrive.fleck.items.FleckItems;

/**
 * Created by CBos on 12/13/2017.
 */
public class FineSmelterTESR extends TileEntitySpecialRenderer<TileEntityFineSmelter>{

    @Override
    public void render(TileEntityFineSmelter te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();

        // Translate to the location of our tile entity
        GlStateManager.translate(x, y, z);
        GlStateManager.disableRescaleNormal();

        // Render our item
        renderItem(te);

        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    private void renderItem(TileEntityFineSmelter te) {
        ItemStack stack = new ItemStack(Items.EGG);
        if (!stack.isEmpty()) {
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.pushMatrix();
            // Translate to the center of the block and .9 points higher
            EntityDragon chicken = new EntityDragon(Minecraft.getMinecraft().world);
            GlStateManager.scale(0.05f, 0.05f, 0.05f);

            Minecraft.getMinecraft().getRenderManager().renderEntity(chicken, 10.0D, 20.0D, 7.0D, 0.2f, 0.0f, false);
            GlStateManager.translate(.3, .85, .7);
            GlStateManager.scale(1f, 1f, 1f);
            GlStateManager.rotate(90f, 1, 0f, 0f);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);
            //Minecraft.getMinecraft().getRenderManager().renderEntity(chicken, 0.25D, -0.5D, -0.5D, 0.2f, 0.0f, false);

            GlStateManager.popMatrix();
        }
        if (!stack.isEmpty()) {
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.pushMatrix();
            // Translate to the center of the block and .9 points higher
            GlStateManager.translate(.7, .85, .7);
            GlStateManager.scale(.5f, .5f, .5f);
            GlStateManager.rotate(90f, 1, 0f, 0f);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);

            GlStateManager.popMatrix();
        }
        if (!stack.isEmpty()) {
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.pushMatrix();
            // Translate to the center of the block and .9 points higher
            GlStateManager.translate(.7, .85, .3);
            GlStateManager.scale(.5f, .5f, .5f);
            GlStateManager.rotate(90f, 1, 0f, 0f);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);

            GlStateManager.popMatrix();
        }
        if (!stack.isEmpty()) {
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.pushMatrix();
            // Translate to the center of the block and .9 points higher
            GlStateManager.translate(.3, .85, .3);
            GlStateManager.scale(.5f, .5f, .5f);
            GlStateManager.rotate(90f, 1, 0f, 0f);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);

            GlStateManager.popMatrix();
        }
    }

}
