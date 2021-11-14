package io.github.shaksternano.wmitef.client.plugin.waila;

import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;

@Environment(EnvType.CLIENT)
public enum EnchantedBookItemEntityOverride implements IEntityComponentProvider {

    INSTANCE;

    // Sets the mod name in the tooltip of an enchanted book item entity to be the mod name of it's first enchantment.
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            ItemStack stack = accessor.<ItemEntity>getEntity().getStack();
            String modName = TooltipUtil.replaceEnchantmentModName(stack);
            if (modName != null) {
                tooltip.set(WailaConstants.MOD_NAME_TAG, new LiteralText(IWailaConfig.get().getFormatting().formatModName(modName)));
            }
        }
    }
}
