package io.github.shaksternano.wmitaf.client.accessor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * For caching a Mod ID and Mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
public interface ModNameHolder {

    /**
     * Gets the cached mod ID of the {@link ItemStack}.
     *
     * @return An {@link Optional} describing the cached mod ID
     * of the ItemStack.
     */
    Optional<String> wmitaf$getModId();

    /**
     * Sets the cached mod ID of the {@link ItemStack}.
     *
     * @param modId The mod ID to cache.
     */
    void wmitaf$setModId(@Nullable String modId);

    /**
     * Gets the cached mod name of the {@link ItemStack}.
     *
     * @return An {@link Optional} describing the cached mod name
     * of the ItemStack.
     */
    Optional<String> wmitaf$getModName();

    /**
     * Sets the cached mod name of the {@link ItemStack}.
     *
     * @param modName The mod name to cache.
     */
    void wmitaf$setModName(@Nullable String modName);
}
