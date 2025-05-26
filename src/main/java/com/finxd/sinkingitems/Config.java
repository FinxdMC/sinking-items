package com.finxd.sinkingitems;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = SinkingItems.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static boolean enableMod;
    public static boolean slowSinking;

    public static final ModConfigSpec.BooleanValue ENABLE_MOD = BUILDER
            .comment("Should the mod's Mixin apply changes?")
            .define("enableMod", true);

    public static final ModConfigSpec.BooleanValue SLOW_SINKING = BUILDER
            .comment("Should items sink slowly? (a mix of new and old behaviour)")
            .define("slowSinking", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enableMod = ENABLE_MOD.get();
        slowSinking = SLOW_SINKING.get();
    }
}
