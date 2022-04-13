package io.github.shaksternano.wmitaf.mixin.commonloader.client;

import io.github.shaksternano.wmitaf.client.accessor.ModNameHolder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Optional;

/**
 * For caching a Mod ID and Mod name related to an entity.
 */
@SuppressWarnings("unused")
@Mixin(ItemStack.class)
abstract class ItemStackMixin implements ModNameHolder {

    /**
     * The cached mod ID of the ItemStack.
     */
    @Unique
    @Nullable
    private String wmitaf$modId;

    /**
     * The cached mod name of the ItemStack.
     */
    @Unique
    @Nullable
    private String wmitaf$modName;

    @Unique
    @Override
    public Optional<String> wmitaf$getModId() {
        return Optional.ofNullable(wmitaf$modId);
    }

    @Unique
    @Override
    public void wmitaf$setModId(@Nullable String modId) {
        wmitaf$modId = modId;
    }

    @Unique
    @Override
    public Optional<String> wmitaf$getModName() {
        return Optional.ofNullable(wmitaf$modName);
    }

    @Unique
    @Override
    public void wmitaf$setModName(@Nullable String modName) {
        wmitaf$modName = modName;
    }
}
