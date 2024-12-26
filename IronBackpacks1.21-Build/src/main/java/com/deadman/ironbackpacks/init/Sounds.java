package com.deadman.ironbackpacks.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import com.deadman.ironbackpacks.IronBackpacks;

public class Sounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, IronBackpacks.MODID);
    public static final DeferredHolder<SoundEvent, SoundEvent> OPEN_BACKPACK_SOUND = REGISTRY.register(
            "open_backpack_sound",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ironbackpacks", "open_backpack_sound"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> CLOSE_BACKPACK_SOUND = REGISTRY.register(
            "close_backpack_sound",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ironbackpacks", "close_backpack_sound"))
    );
}
