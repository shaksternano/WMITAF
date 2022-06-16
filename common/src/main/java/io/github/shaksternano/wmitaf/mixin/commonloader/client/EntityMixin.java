package io.github.shaksternano.wmitaf.mixin.commonloader.client;

import io.github.shaksternano.wmitaf.client.accessor.TextHolder;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Optional;

/**
 * For caching a {@link Text} name and a {@link Text} mod name related to an entity.
 */
@SuppressWarnings("unused")
@Mixin(Entity.class)
abstract class EntityMixin implements TextHolder {

    /**
     * The cached mod name of the entity.
     */
    @Unique
    @Nullable
    private Text wmitaf$textModName;

    @Unique
    @Override
    public Optional<Text> wmitaf$getTextModName() {
        return Optional.ofNullable(wmitaf$textModName);
    }

    @Unique
    @Override
    public void wmitaf$setTextModName(@Nullable Text textModName) {
        wmitaf$textModName = textModName;
    }
}
