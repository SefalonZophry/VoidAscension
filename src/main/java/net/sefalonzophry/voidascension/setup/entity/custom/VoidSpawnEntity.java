package net.sefalonzophry.voidascension.setup.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class VoidSpawnEntity extends MonsterEntity {
    public VoidSpawnEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttribute() {
        return MonsterEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30F)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ATTACK_SPEED, 0.25F)
                .add(Attributes.FOLLOW_RANGE, 8.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0F, false));
        this.goalSelector.addGoal(3, new LookAtGoal (this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected int getExperienceReward(PlayerEntity p_70693_1_) {
        return 3 + this.level.random.nextInt(5);
    }

    public static void register() {}
}
