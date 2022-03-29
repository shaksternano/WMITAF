package io.github.shaksternano.wmitaf.client.plugin.waila.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public enum ItemEntityComponent implements IEntityComponentProvider {

    INSTANCE;

    /**
     * Sets the mod name in the Waila tooltip for item entities
     * to be the name of the mod that adds the first enchantment
     * on the item if it's an enchanted book, or the name of the
     * mod that adds the first effect on the item if it's a potion.
     *
     * @param tooltip  The tooltip to change the mod name of.
     * @param accessor The accessor for the entity.
     * @param config   The current plugin configuration.
     */
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            ItemEntity itemEntity = accessor.getEntity();
            ItemStack stack = itemEntity.getStack();

            ModNameUtil.getActualModName(stack).ifPresent(modName -> ModNameUtil.setWailaTooltip(
                    tooltip,
                    itemEntity,
                    modName,
                    ModNameUtil.modNameNeedsToBeChanged(stack)
            ));
        }
    }
}
