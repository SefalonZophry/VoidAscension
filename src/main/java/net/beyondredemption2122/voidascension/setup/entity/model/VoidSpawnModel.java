package net.beyondredemption2122.voidascension.setup.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.beyondredemption2122.voidascension.setup.entity.custom.VoidSpawnEntity;

public class VoidSpawnModel<T extends VoidSpawnEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_leg;

    public VoidSpawnModel() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(1.0F, 0.0F, 0.0F);
        head.texOffs(0, 0).addBox(-5.5F, -8.25F, -4.25F, 9.0F, 8.0F, 8.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.5F, 24.0F, 0.0F);
        body.texOffs(0, 16).addBox(-5.0F, -25.0F, -3.0F, 9.0F, 12.0F, 5.0F, 0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setPos(-4.0F, 0.0F, -0.5F);
        left_arm.texOffs(38, 34).addBox(-4.0F, -1.0F, -2.5F, 4.0F, 12.0F, 5.0F, 0.0F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setPos(4.0F, 0.0F, 0.0F);
        right_arm.texOffs(20, 34).addBox(0.0F, -1.0F, -3.0F, 4.0F, 12.0F, 5.0F, 0.0F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setPos(-3.0F, 11.0F, -0.5F);
        left_leg.texOffs(0, 33).addBox(-1.5F, 0.0F, -2.5F, 5.0F, 13.0F, 5.0F, 0.0F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setPos(2.0F, 11.0F, -0.5F);
        right_leg.texOffs(28, 16).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 13.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.right_arm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.left_arm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.right_leg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.left_leg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public static void register() {}
}