package io.github.shaksternano.wmitaf.client.plugin.rei.forge;

import io.github.shaksternano.wmitaf.client.accessor.ModNameHolder;
import io.github.shaksternano.wmitaf.client.plugin.rei.WmitafReiClientPlugin;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
import me.shedaniel.rei.forge.REIPlugin;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
@REIPlugin
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
     * Gets the mod ID of an {@link ItemStack}. If the mod ID
     * is not cached, it will be cached in the ItemStack.
     *
     * @param stack The ItemStack to get the mod ID of.
     * @return The mod ID of the ItemStack.
     */
    @SuppressWarnings("ConstantConditions")
    public static Optional<String> getActualModId(ItemStack stack) {
        ModNameHolder modNameHolder = (ModNameHolder) (Object) stack;
        Optional<String> modIdOptional = modNameHolder.wmitaf$getModId();
        modIdOptional.ifPresent(modNameHolder::wmitaf$setModId);
        return modIdOptional.isPresent() ? modIdOptional : Optional.ofNullable(stack.getItem().getCreatorModId(stack));
    }
}
