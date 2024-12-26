package com.deadman.ironbackpacks.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import com.deadman.ironbackpacks.IronBackpacks;

public class Tabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronBackpacks.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IRON_BACKPACKS = REGISTRY.register(
        "ironbackpacks",
        () -> CreativeModeTab.builder()
            .title(Component.literal("Iron Backpacks"))
            .icon(() -> new ItemStack(ModItems.BASIC_BACKPACK.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.BASIC_BACKPACK.get());
                output.accept(ModItems.IRON_STORAGE_BACKPACK.get());
                output.accept(ModItems.GOLD_STORAGE_BACKPACK.get());
                output.accept(ModItems.DIAMOND_STORAGE_BACKPACK.get());
            })
            .withSearchBar()
            .build()
    );
}