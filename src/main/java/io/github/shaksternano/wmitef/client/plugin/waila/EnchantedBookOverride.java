package io.github.shaksternano.wmitef.client.plugin.waila;

import io.github.shaksternano.wmitef.client.util.TooltipUtil;
import mcp.mobius.waila.api.IEventListener;
import mcp.mobius.waila.api.IPluginConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public enum EnchantedBookOverride implements IEventListener {

    INSTANCE;

    // Sets the mod name in the Waila tooltip of an enchanted book to be the mod name of it's first enchantment.
    @Nullable
    @Override
    public String getHoveredItemModName(ItemStack stack, IPluginConfig config) {
        return TooltipUtil.replaceEnchantmentModName(stack);
    }
}
