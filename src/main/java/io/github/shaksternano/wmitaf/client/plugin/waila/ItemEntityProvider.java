package io.github.shaksternano.wmitaf.client.plugin.waila;

import io.github.shaksternano.wmitaf.client.util.TooltipUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public enum ItemEntityProvider implements IEntityComponentProvider {

    // This is an enum.
    INSTANCE;

    // Sets the mod name in the Waila tooltip for item entities to be the name of the mod that adds the first enchantment on the item if it's an enchanted book, or the name of the mod that adds the first effect on the item if it's a potion.
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            ItemStack stack = accessor.<ItemEntity>getEntity().getStack();
            String modName = TooltipUtil.replaceModName(stack);
            if (modName != null) {
                tooltip.set(WailaConstants.MOD_NAME_TAG, Text.of(IWailaConfig.get().getFormatting().formatModName(modName)));
            }
        }
    }
}
