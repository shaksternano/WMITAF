package io.github.shaksternano.wmitaf.client.plugin.rei;

import io.github.shaksternano.wmitaf.client.util.ModNameUtil;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class WmitafReiClientPlugin implements REIClientPlugin {

    @SuppressWarnings({"deprecation", "UnstableApiUsage"})
    @Override
    public void registerEntrySettingsAdapters(EntrySettingsAdapterRegistry registry) {
        registry.register(VanillaEntryTypes.ITEM, EntryStack.Settings.CONTAINING_NS, (entry, settings, value) -> {
            String modId = ModNameUtil.getActualModId(entry.getValue());
            return modId == null ? value : (stack, namespace) -> modId;
        });
    }
}
