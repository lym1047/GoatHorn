package com.ming.guardhorn.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ModCommonConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue COOLDOWN_TICKS = BUILDER
            .comment("号角使用后的冷却时间（单位：游戏刻，20 ticks = 1秒）\n默认值：3600（3分钟）")
            .defineInRange("cooldown_ticks", 3600, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue GUARD_COUNT = BUILDER
            .comment("\n警卫召唤数量\n默认值：3")
            .defineInRange("guard_count", 3, 1,9);

    public static final ModConfigSpec.BooleanValue ENABLE_ZOMBIE_VS_ILLAGER = BUILDER
            .comment("\n启用僵尸与灾厄村民之间的敌对行为\n默认值：true")
            .define("enable_zombie_vs_illager", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static int cooldownTicks;
    public static int guardCount;
    public static boolean enableZombieVsIllager;

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event) {

        cooldownTicks = COOLDOWN_TICKS.get();
        guardCount = GUARD_COUNT.get();
        enableZombieVsIllager = ENABLE_ZOMBIE_VS_ILLAGER.get();
    }
}
