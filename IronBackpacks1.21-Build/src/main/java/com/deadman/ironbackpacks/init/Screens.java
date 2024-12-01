package com.deadman.ironbackpacks.init;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import com.deadman.ironbackpacks.IronBackpacks;
import com.deadman.ironbackpacks.client.gui.BasicScreen;

@EventBusSubscriber(modid = IronBackpacks.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Screens {
    @SubscribeEvent
    public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
        event.register(
            Menus.BASIC_SCREEN.get(),
            BasicScreen::new
        );
    }
}