package io.github.shaksternano.wmitaf.client.plugin.rei.forge;

import io.github.shaksternano.wmitaf.client.accessor.ModNameHolder;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import me.shedaniel.rei.forge.REIPlugin;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;

import java.util.Optional;

@SuppressWarnings("unused")
@OnlyIn(Dist.CLIENT)
@REIPlugin
public class WmitafReiClientPluginForge implements REIClientPlugin {

    /**
     * Registers the REI plugins.
     *
     * @param registry The entry settings adapters registry
     */
    @SuppressWarnings({"deprecation", "UnstableApiUsage"})
    @Override
    public void registerEntrySettingsAdapters(EntrySettingsAdapterRegistry registry) {
        registry.register(VanillaEntryTypes.ITEM, EntryStack.Settings.CONTAINING_NS, (entry, settings, value) -> {
            String modId = getOrCacheModId(entry.getValue());
            return modId == null ? value : (stack, namespace) -> modId;
        });
    }

    /**
     * Gets the mod ID of an {@link ItemStack}. If the mod ID
     * is not cached, it will be cached in the ItemStack.
     *
     * @param stack The ItemStack to get the mod ID of.
     * @return The mod ID of the ItemStack.
     */
    @SuppressWarnings("ConstantConditions")
    private static String getOrCacheModId(ItemStack stack) {
        ModNameHolder modNameHolder = (ModNameHolder) (Object) stack;
        Optional<String> modIdOptional = modNameHolder.wmitaf$getModId();
        modIdOptional.ifPresent(modNameHolder::wmitaf$setModId);
        return modIdOptional.orElse(ForgeHooks.getDefaultCreatorModId(stack));
    }
}
