package net.sefalonzophry.voidascension.setup.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;

public class InjectorModel <T extends InjectorEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer injector;
    private final ModelRenderer body;
    private final ModelRenderer back_left_leg;
    private final ModelRenderer cube_r1;
    private final ModelRenderer back_right_leg;
    private final ModelRenderer cube_r2;
    private final ModelRenderer front_left_leg;
    private final ModelRenderer front_right_leg;

    public InjectorModel() {
        texWidth = 32;
        texHeight = 32;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 24.0F, 0.0F);
        head.texOffs(9, 9).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
        head.texOffs(20, 7).addBox(-2.0F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        head.texOffs(7, 20).addBox(1.0F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

        injector = new ModelRenderer(this);
        injector.setPos(0.0F, 24.0F, 0.0F);
        injector.texOffs(0, 10).addBox(-1.0F, -5.75F, -2.75F, 2.0F, 1.0F, 1.0F, 0.0F, true);
        injector.texOffs(12, 13).addBox(-0.5F, -5.25F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        injector.texOffs(13, 6).addBox(-0.5F, -5.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        injector.texOffs(9, 12).addBox(-0.5F, -4.75F, -4.75F, 1.0F, 1.0F, 1.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        body.texOffs(0, 0).addBox(-2.0F, -6.0F, -1.0F, 4.0F, 2.0F, 4.0F, 0.0F, true);
        body.texOffs(7, 6).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, true);
        body.texOffs(0, 6).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);
        body.texOffs(0, 0).addBox(-1.0F, -6.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

        back_left_leg = new ModelRenderer(this);
        back_left_leg.setPos(1.95F, 19.125F, 1.525F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(-1.95F, 4.875F, -1.525F);
        back_left_leg.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
        cube_r1.texOffs(19, 1).addBox(4.5F, -3.75F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(0, 12).addBox(5.75F, -2.0F, -7.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(10, 19).addBox(5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(19, 3).addBox(4.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(0, 19).addBox(3.5F, -4.5F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(17, 18).addBox(3.0F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(18, 11).addBox(2.5F, -5.5F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(7, 18).addBox(2.0F, -6.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(3, 18).addBox(1.5F, -5.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r1.texOffs(17, 16).addBox(1.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

        back_right_leg = new ModelRenderer(this);
        back_right_leg.setPos(-1.95F, 19.375F, 1.525F);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(1.95F, 4.625F, -1.525F);
        back_right_leg.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
        cube_r2.texOffs(0, 0).addBox(-6.75F, -2.0F, -7.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(16, 0).addBox(-6.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(14, 15).addBox(-5.5F, -3.75F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(10, 15).addBox(-5.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(15, 2).addBox(-4.5F, -4.5F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(0, 15).addBox(-4.0F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(14, 11).addBox(-3.5F, -5.5F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(14, 8).addBox(-2.5F, -5.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(7, 14).addBox(-2.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(3, 14).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

        front_left_leg = new ModelRenderer(this);
        front_left_leg.setPos(2.0F, 19.5F, -0.5F);
        front_left_leg.texOffs(12, 0).addBox(4.75F, 2.5F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(21, 9).addBox(4.0F, 1.5F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(0, 21).addBox(3.0F, 0.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(20, 19).addBox(3.5F, 0.75F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(20, 17).addBox(2.5F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(17, 20).addBox(2.0F, -0.5F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(20, 5).addBox(1.5F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(3, 20).addBox(1.0F, -1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(19, 14).addBox(0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_left_leg.texOffs(14, 19).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);

        front_right_leg = new ModelRenderer(this);
        front_right_leg.setPos(-2.0F, 19.5F, -0.5F);
        front_right_leg.texOffs(5, 11).addBox(-5.75F, 2.5F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(14, 17).addBox(-5.0F, 1.5F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(10, 17).addBox(-4.5F, 0.75F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(17, 9).addBox(-4.0F, 0.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(17, 6).addBox(-3.5F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(0, 17).addBox(-3.0F, -0.5F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(16, 13).addBox(-2.5F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(7, 16).addBox(-1.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(16, 4).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        front_right_leg.texOffs(3, 16).addBox(-2.0F, -1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        this.front_left_leg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.front_right_leg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.back_left_leg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.back_right_leg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        injector.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        back_left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        back_right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        front_left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        front_right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public static void register() {}
}