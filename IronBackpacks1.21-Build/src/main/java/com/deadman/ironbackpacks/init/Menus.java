package com.deadman.ironbackpacks.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import com.deadman.ironbackpacks.IronBackpacks;
import com.deadman.ironbackpacks.world.inventory.BasicMenu;

public class Menus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, IronBackpacks.MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<BasicMenu>> BASIC_SCREEN = REGISTRY.register(
        "basic_screen",
        () -> IMenuTypeExtension.create(BasicMenu::new)
    );
}