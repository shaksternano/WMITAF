package io.github.shaksternano.wmitaf.client.plugin.waila;

import io.github.shaksternano.wmitaf.client.util.ModNameUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public enum ItemEntityComponent implements IEntityComponentProvider {

    // This is an enum.
    INSTANCE;

    // Sets the mod name in the Waila tooltip for item entities to be the name of the mod that adds the first enchantment on the item if it's an enchanted book, or the name of the mod that adds the first effect on the item if it's a potion.
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            ItemEntity itemEntity = accessor.getEntity();
            ItemStack stack = itemEntity.getStack();

            String modName = ModNameUtil.getActualModName(stack);

            if (modName != null) {
                ModNameUtil.setWailaTooltip(tooltip, itemEntity, modName, true, ModNameUtil.modNameNeedsToBeChanged(stack));
            }
        }
    }
}
