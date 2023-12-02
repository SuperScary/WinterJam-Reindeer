package superscary.reindeer.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superscary.reindeer.client.model.ReindeerModel;
import superscary.reindeer.init.EntityInit;
import superscary.reindeer.ReindeerMod;
import superscary.reindeer.client.renderer.ReindeerRenderer;

@Mod.EventBusSubscriber(modid = ReindeerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents
{

    @SubscribeEvent
    public static void registerRenderers (EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(EntityInit.REINDEER_ENTITY.get(), ReindeerRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions (EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ReindeerModel.LAYER_LOCATION, ReindeerModel::createBodyLayer);
    }

}
