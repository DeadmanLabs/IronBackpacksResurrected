package com.deadman.ironbackpacks.items;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;

import io.netty.buffer.Unpooled;

import net.neoforged.neoforge.common.MutableDataComponentHolder;

import java.util.List;

import com.deadman.ironbackpacks.world.inventory.DiamondStorageMenu;

public class DiamondBackpack extends Item {
    public DiamondBackpack() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, player, hand);
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() { return Component.literal("Diamond Backpack"); }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                    packetBuffer.writeBlockPos(player.blockPosition());
                    packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                    return new DiamondStorageMenu(id, inventory, packetBuffer);
                }
            }, buf -> {
               buf.writeBlockPos(player.blockPosition());
               buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
            });
        }
        return ar;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
    }
}