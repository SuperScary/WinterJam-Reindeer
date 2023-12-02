package superscary.reindeer.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import superscary.reindeer.init.EntityInit;

public class ReindeerEntity extends Animal
{

    public final AnimationState idleAnimationState = new AnimationState();

    public ReindeerEntity (EntityType<ReindeerEntity> type, Level level)
    {
        super(type, level);
    }

    public ReindeerEntity (Level level, double x, double y, double z)
    {
        this (EntityInit.REINDEER_ENTITY.get(), level);
        setPos(x, y, z);
    }

    public ReindeerEntity (Level level, BlockPos pos)
    {
        this (level, pos.getX(), pos.getY(), pos.getZ());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring (ServerLevel level, AgeableMob parent)
    {
        return new ReindeerEntity(level, this.blockPosition());
    }

    @Override
    protected void registerGoals ()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        if (tickCount >= 24000) this.goalSelector.addGoal(9, new TemptGoal(this, 1.0, Ingredient.of(Items.WHEAT), false));
    }

    @Override
    public void tick ()
    {
        if (level().isClientSide)
        {
            this.idleAnimationState.animateWhen(!isInWaterOrBubble() && !this.walkAnimation.isMoving(), tickCount);
        }

        super.tick();
    }

    public static AttributeSupplier.Builder createAttributes ()
    {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.00)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0d);
    }

    public static boolean canSpawn (EntityType<ReindeerEntity> type, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource source)
    {
        return Animal.checkAnimalSpawnRules(type, level, spawnType, position, source);
    }

}
