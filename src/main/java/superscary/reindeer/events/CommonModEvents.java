package superscary.reindeer.events;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superscary.reindeer.init.EntityInit;
import superscary.reindeer.ReindeerMod;
import superscary.reindeer.entity.ReindeerEntity;

@Mod.EventBusSubscriber(modid = ReindeerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents
{

    @SubscribeEvent
    public static void entityAttributes (EntityAttributeCreationEvent event)
    {
        event.put(EntityInit.REINDEER_ENTITY.get(), ReindeerEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements (SpawnPlacementRegisterEvent event)
    {
        event.register(EntityInit.REINDEER_ENTITY.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                ReindeerEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR);
    }

}
