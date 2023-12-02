package superscary.reindeer.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import superscary.reindeer.ReindeerMod;
import superscary.reindeer.client.model.ReindeerModel;
import superscary.reindeer.entity.ReindeerEntity;

public class ReindeerRenderer extends MobRenderer<ReindeerEntity, ReindeerModel<ReindeerEntity>>
{

    private final ResourceLocation NORMAL = new ResourceLocation(ReindeerMod.MODID, "textures/entity/reindeer_entity.png");
    private final ResourceLocation SNOW = new ResourceLocation(ReindeerMod.MODID, "textures/entity/reindeer_entity_snow.png");
    private final ResourceLocation RUDOLPH = new ResourceLocation(ReindeerMod.MODID, "textures/entity/reindeer_entity_rudolph.png");

    public ReindeerRenderer (EntityRendererProvider.Context ctx)
    {
        super(ctx, new ReindeerModel<>(ctx.bakeLayer(ReindeerModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation (ReindeerEntity entity)
    {
        if ((entity.level().getBiome(entity.getOnPos()).is(Biomes.SNOWY_TAIGA) ||
                entity.level().getBiome(entity.getOnPos()).is(Biomes.SNOWY_BEACH) ||
                entity.level().getBiome(entity.getOnPos()).is(Biomes.SNOWY_PLAINS) ||
                entity.level().getBiome(entity.getOnPos()).is(Biomes.SNOWY_SLOPES)) &&
                entity.level().isRainingAt(entity.getOnPos())) return SNOW;
        return NORMAL;
    }
}
