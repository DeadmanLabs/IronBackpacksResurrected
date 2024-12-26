package com.deadman.ironbackpacks.items.data;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.UUID;

public record Contents (UUID id, UUID owner, List<ItemStack> contents) {}