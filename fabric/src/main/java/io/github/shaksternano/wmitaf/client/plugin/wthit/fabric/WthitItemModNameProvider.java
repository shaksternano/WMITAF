package io.github.shaksternano.wmitaf.client.plugin.wthit.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public enum WthitItemModNameProvider implements IEntityComponentProvider, IEventListener {

    INSTANCE;

    /**
     * Sets the mod name in the WTHIT tooltip for item entities
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
            ModNameUtil.getActualModName(stack).ifPresent(
                    modName -> tooltip.setLine(WailaConstants.MOD_NAME_TAG, IWailaConfig.get().getFormatter().modName(modName))
            );
        }
    }

    /**
     * Sets the mod name in the WTHIT tooltip for item stacks
     * to be the name of the mod that adds the first enchantment
     * on the item if it's an enchanted book, or the name of the
     * mod that adds the first effect on the item if it's a potion.
     *
     * @param stack  The item stack
     * @param config The current plugin configuration.
     */
    @Nullable
    @Override
    public String getHoveredItemModName(ItemStack stack, IPluginConfig config) {
        return ModNameUtil.getActualModName(stack).orElse(null);
    }
}
