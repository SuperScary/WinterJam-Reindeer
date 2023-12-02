package superscary.reindeer.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superscary.reindeer.item.ModFoodProperties;

import static superscary.reindeer.ReindeerMod.MODID;

public class ItemInit
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<ForgeSpawnEggItem> REINDEER_SPAWN_EGG = ITEMS.register("reindeer_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.REINDEER_ENTITY, 0x9c866c, 0xe3dac9, new Item.Properties()));

    public static final RegistryObject<Item> RAW_VEAL = ITEMS.register("raw_veal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VEAL = ITEMS.register("veal",
            () -> new Item(new Item.Properties().food(ModFoodProperties.VEAL)));

    public static final RegistryObject<Item> ANTLER = ITEMS.register("antler",
            () -> new Item(new Item.Properties()));

}
