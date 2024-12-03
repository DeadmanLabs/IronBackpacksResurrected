package com.deadman.ironbackpacks.init;

import net.minecraft.world.item.Item;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.deadman.ironbackpacks.items.BasicBackpack;
import com.deadman.ironbackpacks.items.IronBackpack;
import com.deadman.ironbackpacks.items.GoldBackpack;
import com.deadman.ironbackpacks.items.DiamondBackpack;
import com.deadman.ironbackpacks.IronBackpacks;

public class ModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(IronBackpacks.MODID);
    public static final DeferredItem<BasicBackpack> BASIC_BACKPACK = REGISTRY.register(
        "basic_backpack_none",
        BasicBackpack::new
    );
    public static final DeferredItem<IronBackpack> IRON_STORAGE_BACKPACK = REGISTRY.register(
        "iron_backpack_storage",
        IronBackpack::new
    );
    public static final DeferredItem<GoldBackpack> GOLD_STORAGE_BACKPACK = REGISTRY.register(
        "gold_backpack_storage",
        GoldBackpack::new
    );
    public static final DeferredItem<DiamondBackpack> DIAMOND_STORAGE_BACKPACK = REGISTRY.register(
        "diamond_backpack_storage",
        DiamondBackpack::new
    );
}