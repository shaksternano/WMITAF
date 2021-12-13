package io.github.shaksternano.wmitaf.mixin.client;

import io.github.shaksternano.wmitaf.client.accessor.TextHolder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/**
 * For caching a {@link Text} name and a {@link Text} mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
@Mixin(Entity.class)
abstract class EntityMixin implements TextHolder {

    @Nullable
    @Unique
    private Text textName;

    @Nullable
    @Unique
    private Text textModName;

    @Nullable
    @Override
    public Text wmitaf$getTextName() {
        return textName;
    }

    @Override
    public void wmitaf$setTextName(@Nullable Text textName) {
        if (this.textName == null) {
            this.textName = textName;
        }
    }

    @Nullable
    @Override
    public Text wmitaf$getTextModName() {
        return textModName;
    }

    @Override
    public void wmitaf$setTextModName(@Nullable Text textModName) {
        if (this.textModName == null) {
            this.textModName = textModName;
        }
    }
}
