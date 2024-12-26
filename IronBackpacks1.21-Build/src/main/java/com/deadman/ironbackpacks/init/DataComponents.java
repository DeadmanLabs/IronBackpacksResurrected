package com.deadman.ironbackpacks.init;

import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponentType.Builder;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.RegistryManager;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import com.mojang.serialization.Codec;

import com.deadman.ironbackpacks.IronBackpacks;
import com.deadman.ironbackpacks.items.data.Contents;

public class DataComponents {
    public static final DeferredRegister.DataComponents REGISTRY = DeferredRegister.createDataComponents(IronBackpacks.MODID);
    public static final Codec<Contents> CONTENTS_CODEC = RecordCodecBuilder.create(instance -> instance.group(
        UUIDUtil.CODEC.fieldOf("id").forGetter(Contents::id),
        UUIDUtil.CODEC.fieldOf("owner").forGetter(Contents::owner),
        ItemStack.CODEC.listOf().fieldOf("contents").forGetter(Contents::contents)
    ).apply(instance, Contents::new));
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Contents>> CONTENTS = REGISTRY.registerComponentType(
        "contents",
        builder -> builder.persistent(CONTENTS_CODEC)
    );
}