package com.deadman.ironbackpacks.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import com.deadman.ironbackpacks.IronBackpacks;
import com.deadman.ironbackpacks.world.inventory.BasicMenu;
import com.deadman.ironbackpacks.world.inventory.IronStorageMenu;
import com.deadman.ironbackpacks.world.inventory.GoldStorageMenu;
import com.deadman.ironbackpacks.world.inventory.DiamondStorageMenu;

public class Menus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, IronBackpacks.MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<BasicMenu>> BASIC_SCREEN = REGISTRY.register(
        "basic_screen",
        () -> IMenuTypeExtension.create(BasicMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<IronStorageMenu>> IRON_STORAGE_SCREEN = REGISTRY.register(
        "iron_storage_screen",
        () -> IMenuTypeExtension.create(IronStorageMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<GoldStorageMenu>> GOLD_STORAGE_SCREEN = REGISTRY.register(
        "gold_storage_screen",
        () -> IMenuTypeExtension.create(GoldStorageMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<DiamondStorageMenu>> DIAMOND_STORAGE_SCREEN = REGISTRY.register(
        "diamond_storage_screen",
        () -> IMenuTypeExtension.create(DiamondStorageMenu::new)
    );
}