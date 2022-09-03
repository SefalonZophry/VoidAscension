package net.beyondredemption2122.voidascension.setup.customblocks.tileentities.tileentityrenderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.beyondredemption2122.voidascension.setup.customblocks.tileentities.PedestalTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PedestalTileEntityRenderer extends TileEntityRenderer<PedestalTileEntity> {

    private Minecraft mc = Minecraft.getInstance();

    public PedestalTileEntityRenderer(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void render(PedestalTileEntity te, float pPartialTicks, MatrixStack pMatrixStack,
                       IRenderTypeBuffer pBuffer, int pCombinedLight, int pCombinedOverlay) {
        if (te.getItem().equals(ItemStack.EMPTY))
            return;

        ClientPlayerEntity player = mc.player;
    }

//    private int getLightLevel(World world, BlockPos)
}
