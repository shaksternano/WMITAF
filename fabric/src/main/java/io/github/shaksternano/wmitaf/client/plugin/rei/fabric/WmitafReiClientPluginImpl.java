package io.github.shaksternano.wmitaf.client.plugin.rei.fabric;

import io.github.shaksternano.wmitaf.client.plugin.rei.WmitafReiClientPlugin;
import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class WmitafReiClientPluginImpl implements REIClientPlugin {

    /**
     * Registers the REI plugins.
     *
     * @param registry The entry settings adapters registry
     */
    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void registerEntrySettingsAdapters(EntrySettingsAdapterRegistry registry) {
        WmitafReiClientPlugin.registerEntrySettingsAdapters(registry);
    }

    /**
     * Gets the mod ID of an {@link ItemStack}.
     *
     * @param stack The ItemStack to get the mod ID of.
     * @return The mod ID of the ItemStack.
     */
    public static Optional<String> getActualModId(ItemStack stack) {
        return ModNameUtil.getActualModId(stack);
    }
}
