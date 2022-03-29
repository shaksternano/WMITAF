package io.github.shaksternano.wmitaf.client.plugin.waila.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import mcp.mobius.waila.api.IEventListener;
import mcp.mobius.waila.api.IPluginConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public enum ItemStackEventListener implements IEventListener {

    INSTANCE;

    /**
     * Sets the mod name in the Waila tooltip for items to be the
     * name of the mod that adds the first enchantment on the item
     * if it's an enchanted book, or the name of the mod that adds
     * the first effect on the item if it's a potion.
     *
     * @param stack  The {@link ItemStack} to get the mod name from.
     * @param config The current plugin configuration.
     * @return The mod name of the item.
     */
    @Nullable
    @Override
    public String getHoveredItemModName(ItemStack stack, IPluginConfig config) {
        return ModNameUtil.getActualModName(stack).orElse(null);
    }
}
