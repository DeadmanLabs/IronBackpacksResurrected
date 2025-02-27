package com.deadman.ironbackpacks.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import com.deadman.ironbackpacks.world.inventory.GoldStorageMenu;
import com.deadman.ironbackpacks.init.Sounds;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GoldStorageScreen extends AbstractContainerScreen<GoldStorageMenu> {
    private final static HashMap<String, Object> guistate = GoldStorageMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;

    public GoldStorageScreen(GoldStorageMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 182;
    }

    private static final ResourceLocation texture = ResourceLocation.parse("ironbackpacks:textures/gui/hardcodes/gold_storage.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            this.minecraft.player.playSound(Sounds.OPEN_BACKPACK_SOUND.get(), 1.0F, 1.0F);
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Component.literal("Gold Backpack"), 6, 6, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        this.minecraft.player.playSound(Sounds.OPEN_BACKPACK_SOUND.get(), 1.0F, 1.0F);
    }
}