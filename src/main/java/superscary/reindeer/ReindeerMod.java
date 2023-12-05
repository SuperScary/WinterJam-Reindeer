package superscary.reindeer;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import superscary.reindeer.init.EntityInit;
import superscary.reindeer.init.ItemInit;
import superscary.reindeer.sound.ModSounds;

@Mod(ReindeerMod.MODID)
public class ReindeerMod
{
    public static final String MODID = "reindeer";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ReindeerMod ()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModdedCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        ItemInit.ITEMS.register(modEventBus);
        EntityInit.ENTITIES.register(modEventBus);
        ModSounds.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative (BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS)
        {
            event.accept(ItemInit.REINDEER_SPAWN_EGG);
        }

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ItemInit.RAW_VEAL);
            event.accept(ItemInit.VEAL);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ItemInit.ANTLER);
            event.accept(ItemInit.REINDEER_DROPPINGS);
        }

    }

}
