package com.Ming.GuardHorn.config;

import com.Ming.GuardHorn.GuardHornMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = GuardHornMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue COOLDOWN_TICKS = BUILDER
            .comment("号角使用后的冷却时间（单位：游戏刻，20 ticks = 1秒）\n默认值：3600（3分钟）")
            .defineInRange("cooldown_ticks", 3600, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue GUARD_COUNT = BUILDER
            .comment("\n警卫召唤数量\n默认值：3")
            .defineInRange("guard_count", 3, 1,9);

    public static final ForgeConfigSpec.BooleanValue ENABLE_ZOMBIE_VS_ILLAGER = BUILDER
            .comment("\n启用僵尸与灾厄村民之间的敌对行为\n默认值：true")
            .define("enable_zombie_vs_illager", true);



    public static final ForgeConfigSpec SPEC = BUILDER.build();

    // 保存配置值的实际变量
    public static int cooldownTicks;
    public static int guardCount;
    public static boolean enableZombieVsIllager;

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event) {
        // 当配置加载或重载时，将配置值赋给静态变量
        cooldownTicks = COOLDOWN_TICKS.get();
        guardCount = GUARD_COUNT.get();
        enableZombieVsIllager = ENABLE_ZOMBIE_VS_ILLAGER.get();
    }
}