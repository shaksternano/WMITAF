package io.github.shaksternano.wmitaf.client.accessor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

/**
 * For caching a {@link Text} name and a {@link Text} mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
public interface TextHolder {

    @Nullable
    Text wmitaf$getTextName();

    void wmitaf$setTextName(@Nullable Text textName);

    @Nullable
    Text wmitaf$getTextModName();

    void wmitaf$setTextModName(@Nullable Text textModName);
}
