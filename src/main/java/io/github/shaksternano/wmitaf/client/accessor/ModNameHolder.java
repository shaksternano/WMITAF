package io.github.shaksternano.wmitaf.client.accessor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.Nullable;

/**
 * For caching a Mod ID and Mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
public interface ModNameHolder {

    @Nullable
    String wmitaf$getModId();

    void wmitaf$setModId(@Nullable String modId);

    @Nullable
    String wmitaf$getModName();

    void wmitaf$setModName(@Nullable String modName);
}
