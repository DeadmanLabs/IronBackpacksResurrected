package com.deadman.ironbackpacks.init;

import net.minecraft.world.item.Item;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.deadman.ironbackpacks.items.BasicBackpack;
import com.deadman.ironbackpacks.IronBackpacks;

public class ModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(IronBackpacks.MODID);
    public static final DeferredItem<BasicBackpack> BASIC_BACKPACK = REGISTRY.register(
        "basic_backpack_none",
        BasicBackpack::new
    );
}