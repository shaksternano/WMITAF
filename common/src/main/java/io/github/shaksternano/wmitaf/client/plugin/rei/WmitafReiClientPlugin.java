package io.github.shaksternano.wmitaf.client.plugin.rei;

import dev.architectury.injectables.annotations.ExpectPlatform;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class WmitafReiClientPlugin {

    /**
     * Registers the REI plugins.
     *
     * @param registry The entry settings adapters registry
     */
    @SuppressWarnings({"deprecation", "UnstableApiUsage"})
    public static void registerEntrySettingsAdapters(EntrySettingsAdapterRegistry registry) {
        registry.register(VanillaEntryTypes.ITEM, EntryStack.Settings.CONTAINING_NS, (entry, settings, value) -> {
            Optional<String> modIdOptional = getActualModId(entry.getValue());
            return modIdOptional.isPresent() ? (stack, namespace) -> modIdOptional.orElseThrow() : value;
        });
    }

    /**
     * Gets the mod ID of an {@link ItemStack}. If the mod ID
     * is not cached, it will be cached in the ItemStack.
     *
     * @param stack The ItemStack to get the mod ID of.
     * @return The mod ID of the ItemStack.
     */
    @SuppressWarnings("unused")
    @ExpectPlatform
    public static Optional<String> getActualModId(ItemStack stack) {
        throw new AssertionError();
    }
}
