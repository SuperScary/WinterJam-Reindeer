package superscary.reindeer.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superscary.reindeer.ReindeerMod;

public class ModSounds
{

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ReindeerMod.MODID);

    public static final RegistryObject<SoundEvent> REINDEER_IDLE1 = registerSoundEvent("reindeer_idle1");
    public static final RegistryObject<SoundEvent> REINDEER_IDLE2 = registerSoundEvent("reindeer_idle2");
    public static final RegistryObject<SoundEvent> REINDEER_IDLE3 = registerSoundEvent("reindeer_idle3");

    public static final RegistryObject<SoundEvent> REINDEER_HURT = registerSoundEvent("reindeer_hurt");
    public static final RegistryObject<SoundEvent> REINDEER_DEATH = registerSoundEvent("reindeer_death");

    private static RegistryObject<SoundEvent> registerSoundEvent (String name)
    {
        ResourceLocation id = new ResourceLocation(ReindeerMod.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register (IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }

}
