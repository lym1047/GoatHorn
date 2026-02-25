package com.Ming.GuardHorn;

import com.Ming.GuardHorn.event.VillagerHornEvent;
import com.Ming.GuardHorn.event.ZombieHitIllagers;
import com.Ming.GuardHorn.item.ModItems;
import com.Ming.GuardHorn.config.ModCommonConfig;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GuardHornMod.MOD_ID)
public class GuardHornMod {
    public static final String MOD_ID = "guardhorn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GuardHornMod() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfig.SPEC, "guardhorn-common.toml");

        MinecraftForge.EVENT_BUS.register(new VillagerHornEvent());

        MinecraftForge.EVENT_BUS.register(new ZombieHitIllagers());

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
    }
}
