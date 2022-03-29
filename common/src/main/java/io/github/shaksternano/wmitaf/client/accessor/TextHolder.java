package io.github.shaksternano.wmitaf.client.accessor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * For caching a {@link Text} name and a {@link Text} mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
public interface TextHolder {

    /**
     * Gets the cached mod name of the {@link Entity}.
     *
     * @return An {@link Optional} describing cached mod name
     * of the entity.
     */
    Optional<Text> wmitaf$getTextModName();

    /**
     * Sets the cached mod name of the {@link Entity}.
     *
     * @param textModName The mod name to cache.
     */
    void wmitaf$setTextModName(@Nullable Text textModName);
}
