package superscary.reindeer;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superscary.reindeer.init.ItemInit;

import static superscary.reindeer.ReindeerMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModdedCreativeTabs
{

   public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

   public static final RegistryObject<CreativeModeTab> TAB = TABS.register("reindeertab",
           () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.SNOWBALL))
                   .title(Component.translatable("reindeertab.items"))
                   .displayItems((displayParameters, output) -> {
                       output.accept(ItemInit.REINDEER_SPAWN_EGG.get());
                       output.accept(ItemInit.RAW_VEAL.get());
                       output.accept(ItemInit.VEAL.get());
                       output.accept(ItemInit.ANTLER.get());
                       output.accept(ItemInit.REINDEER_DROPPINGS.get());
                   }).build());

   public static void register (IEventBus eventBus)
   {
       TABS.register(eventBus);
   }

}
