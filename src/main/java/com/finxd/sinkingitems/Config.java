package com.finxd.sinkingitems;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(modid = SinkingItems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static boolean enableMod;
    public static boolean slowSinking;

    public static final ForgeConfigSpec.BooleanValue ENABLE_MOD = BUILDER
            .comment("Should the mod's Mixin apply changes?")
            .define("enableMod", true);

    public static final ForgeConfigSpec.BooleanValue SLOW_SINKING = BUILDER
            .comment("Should items sink slowly? (a mix of new and old behaviour)")
            .define("slowSinking", false);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    public static void onConstructModEvent(final FMLConstructModEvent event) {
        final ModLoadingContext context = ModLoadingContext.get();
        context.registerConfig(ModConfig.Type.COMMON, SPEC);
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enableMod = ENABLE_MOD.get();
        slowSinking = SLOW_SINKING.get();
    }
}
