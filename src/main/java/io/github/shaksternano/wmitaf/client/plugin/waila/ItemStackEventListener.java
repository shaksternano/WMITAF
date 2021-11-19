package io.github.shaksternano.wmitaf.client.plugin.waila;

import io.github.shaksternano.wmitaf.client.util.TooltipUtil;
import mcp.mobius.waila.api.IEventListener;
import mcp.mobius.waila.api.IPluginConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public enum ItemStackEventListener implements IEventListener {

    // This is an enum.
    INSTANCE;

    // Sets the mod name in the Waila tooltip for items to be the name of the mod that adds the first enchantment on the item if it's an enchanted book, or the name of the mod that adds the first effect on the item if it's a potion.
    @Nullable
    @Override
    public String getHoveredItemModName(ItemStack stack, IPluginConfig config) {
        return TooltipUtil.actualModName(stack);
    }
}
