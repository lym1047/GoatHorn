package com.ming.guardhorn;

import com.ming.guardhorn.config.ModCommonConfig;
import com.ming.guardhorn.event.GuardHornEvent;
import com.ming.guardhorn.event.ZombieHitIllagers;
import com.ming.guardhorn.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(GuardHornMod.MOD_ID)
public class GuardHornMod {
    public static final String MOD_ID = "guardhorn";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GuardHornMod(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, ModCommonConfig.SPEC, "guardhorn-common.toml");
        ModItems.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(new GuardHornEvent());
        NeoForge.EVENT_BUS.register(new ZombieHitIllagers());

        modEventBus.register(ModCommonConfig.class);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Ming");
    }
}
