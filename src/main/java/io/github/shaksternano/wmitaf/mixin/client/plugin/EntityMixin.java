package io.github.shaksternano.wmitaf.mixin.client.plugin;

import io.github.shaksternano.wmitaf.client.accessor.TextHolder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

/**
 * For caching a {@link Text} name and a {@link Text} mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
@Mixin(Entity.class)
abstract class EntityMixin implements TextHolder {

    @Nullable
    private Text wmitaf$textName;

    @Nullable
    private Text wmitaf$textModName;

    @Nullable
    @Override
    public Text wmitaf$getTextName() {
        return wmitaf$textName;
    }

    @Override
    public void wmitaf$setTextName(@Nullable Text textName) {
        wmitaf$textName = textName;
    }

    @Nullable
    @Override
    public Text wmitaf$getTextModName() {
        return wmitaf$textModName;
    }

    @Override
    public void wmitaf$setTextModName(@Nullable Text textModName) {
        wmitaf$textModName = textModName;
    }
}
