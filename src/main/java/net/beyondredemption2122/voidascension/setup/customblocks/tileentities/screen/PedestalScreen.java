package net.beyondredemption2122.voidascension.setup.customblocks.tileentities.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.customblocks.tileentities.container.PedestalContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PedestalScreen extends ContainerScreen<PedestalContainer> {

    private static final ResourceLocation PEDESTAL_GUI = new ResourceLocation(VoidAscension.MOD_ID, "textures/gui/pedestal_screen.png");

    public PedestalScreen(PedestalContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);

        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight = 201;
    }

    @Override
    public void render(MatrixStack pMatrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        this.renderBackground(pMatrixStack);
        super.render(pMatrixStack, pMouseX, pMouseY, pPartialTicks);
        this.renderTooltip(pMatrixStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderLabels(MatrixStack pMatrixStack, int pX, int pY) {
        this.font.draw(pMatrixStack, this.inventory.getDisplayName(), (float) this.inventoryLabelX,
                (float) this.inventoryLabelY, 4210752);
    }

    @Override
    protected void renderBg(MatrixStack pMatrixStack, float pPartialTicks, int pX, int pY) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.textureManager.bind(PEDESTAL_GUI);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(pMatrixStack, x, y, 0, 0, this.imageWidth, this.imageHeight);

    }
}
