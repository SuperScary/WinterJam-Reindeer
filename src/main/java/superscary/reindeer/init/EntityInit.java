package superscary.reindeer.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superscary.reindeer.ReindeerMod;
import superscary.reindeer.entity.ReindeerEntity;

public class EntityInit
{

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ReindeerMod.MODID);

    public static final RegistryObject<EntityType<ReindeerEntity>> REINDEER_ENTITY = ENTITIES.register("reindeer_entity",
            () -> EntityType.Builder.<ReindeerEntity>of(ReindeerEntity::new, MobCategory.CREATURE)
            .canSpawnFarFromPlayer()
            .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(ReindeerMod.MODID, "reindeer_entity").toString())
    );

}
