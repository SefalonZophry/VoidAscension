package net.sefalonzophry.voidascension.setup;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;

public class CustomDimensionRenders {

    public CustomDimensionRenders() {
    }

    public static void init() {
        DimensionRenderInfo.EFFECTS.put(CustomDimensionRenders.Void.ID, new Void());
    }

    public static class Void extends DimensionRenderInfo {
        public static final ResourceLocation ID = new ResourceLocation("voidascension", "dark_skies");

        public Void() {
            super(Float.NaN, true, FogType.NONE, false, true );
        }

        public Vector3d getBrightnessDependentFogColor(Vector3d p_230494_1_, float p_230494_2_) {
            return p_230494_1_;
        }

        public boolean isFoggyAt(int p_230493_1_, int p_230493_2_) {
            return false;
        }
    }
}
