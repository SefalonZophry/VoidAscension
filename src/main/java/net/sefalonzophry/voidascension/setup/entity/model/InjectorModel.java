package net.sefalonzophry.voidascension.setup.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;
import org.joml.Math;

public class InjectorModel <T extends InjectorEntity> extends EntityModel<T> {
    public static final ModelLayerLocation INJECTOR = new ModelLayerLocation(new ResourceLocation("modid", "injector"), "main");
    private final ModelPart body;
    private final ModelPart injector;
    private final ModelPart spores;
    private final ModelPart right_back_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_front_leg;
    private final ModelPart left_back_leg;

    public InjectorModel(ModelPart root) {
        this.body = root.getChild("body");
        this.injector = root.getChild("injector");
        this.spores = root.getChild("spores");
        this.right_back_leg = root.getChild("right_back_leg");
        this.right_front_leg = root.getChild("right_front_leg");
        this.left_front_leg = root.getChild("left_front_leg");
        this.left_back_leg = root.getChild("left_back_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-0.275F, -4.15F, -4.45F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(7, 19).addBox(-0.275F, -4.9F, -2.825F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 19).addBox(-0.275F, -4.9F, -1.675F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 17).addBox(-0.275F, -4.9F, -0.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-0.275F, -4.9F, 0.725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition injector = partdefinition.addOrReplaceChild("injector", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = injector.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.35F, -9.1F, -3.925F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.2836F, -0.0175F, 0.0F));

        PartDefinition spores = partdefinition.addOrReplaceChild("spores", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -2.375F));

        PartDefinition cube_r2 = spores.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 3).addBox(-6.425F, -7.6F, -0.45F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-6.425F, -7.6F, -1.625F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 8).addBox(-6.425F, -7.6F, -2.85F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 17).addBox(-6.425F, -7.6F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 3.55F, 0.0F, 0.0F, 0.5672F));

        PartDefinition cube_r3 = spores.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 5).addBox(4.775F, -7.35F, -0.45F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(4.775F, -7.35F, -1.625F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(4.775F, -7.35F, -2.85F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 17).addBox(4.775F, -7.35F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 3.55F, 0.0F, 0.0F, -0.5672F));

        PartDefinition right_back_leg = partdefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 1.0F));

        PartDefinition cube_r4 = right_back_leg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(5, 12).addBox(-6.5238F, -4.6175F, 4.3663F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.2006F, 0.1404F, 1.5376F));

        PartDefinition cube_r5 = right_back_leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(7, 15).addBox(1.0513F, -8.1425F, 2.9913F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.0528F, -0.5083F, 0.3458F));

        PartDefinition cube_r6 = right_back_leg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 8).addBox(-0.6013F, -8.25F, 0.6887F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.0F, 0.6109F, 0.0F));

        PartDefinition right_front_leg = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -5.975F));

        PartDefinition cube_r7 = right_front_leg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(13, 8).addBox(-2.9225F, -8.4175F, 1.0162F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, -0.2731F, -0.4436F, 1.1803F));

        PartDefinition cube_r8 = right_front_leg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(15, 11).addBox(-0.0725F, -8.2925F, 1.9662F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.1304F, -0.2118F, 0.3468F));

        PartDefinition cube_r9 = right_front_leg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 0).addBox(-0.9575F, -8.25F, -3.9112F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 4.35F, 0.0F, -0.829F, 0.0F));

        PartDefinition left_front_leg = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.625F));

        PartDefinition cube_r10 = left_front_leg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 13).addBox(0.1975F, -8.0925F, 1.2162F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, -4.35F, -0.2731F, 0.4436F, -1.1803F));

        PartDefinition cube_r11 = left_front_leg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(15, 15).addBox(-2.5775F, -8.1425F, 2.0662F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, -4.35F, 0.1304F, 0.2118F, -0.3468F));

        PartDefinition cube_r12 = left_front_leg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 12).addBox(0.3075F, -8.25F, -3.6612F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.0F, 0.829F, 0.0F));

        PartDefinition left_back_leg = partdefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 1.0F));

        PartDefinition cube_r13 = left_back_leg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(9, 4).addBox(3.6737F, -4.0425F, 4.2163F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.2006F, -0.1404F, -1.5376F));

        PartDefinition cube_r14 = left_back_leg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(14, 0).addBox(-3.8512F, -8.1425F, 3.3663F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.0528F, 0.5083F, -0.3458F));

        PartDefinition cube_r15 = left_back_leg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(8, 8).addBox(0.0513F, -8.25F, 0.6887F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.0F, -0.6109F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        this.left_front_leg.xRot = Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.right_front_leg.xRot = Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.left_back_leg.xRot = Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.right_back_leg.xRot = Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        injector.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        body.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        spores.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        left_front_leg.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        right_back_leg.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        left_back_leg.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        right_front_leg.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
    }

    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public static void register() {
    }

}