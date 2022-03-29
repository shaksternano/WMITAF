package io.github.shaksternano.wmitaf.client.plugin.rei.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class WmitafReiClientPluginFabric implements REIClientPlugin {

    /**
     * Registers the REI plugins.
     *
     * @param registry The entry settings adapters registry
     */
    @SuppressWarnings({"deprecation", "UnstableApiUsage"})
    @Override
    public void registerEntrySettingsAdapters(EntrySettingsAdapterRegistry registry) {
        registry.register(VanillaEntryTypes.ITEM, EntryStack.Settings.CONTAINING_NS, (entry, settings, value) -> {
            Optional<String> modIdOptional = ModNameUtil.getActualModId(entry.getValue());
            return modIdOptional.isEmpty() ? value : (stack, namespace) -> modIdOptional.orElseThrow();
        });
    }
}
