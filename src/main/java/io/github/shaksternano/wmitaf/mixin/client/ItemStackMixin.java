package io.github.shaksternano.wmitaf.mixin.client;

import io.github.shaksternano.wmitaf.client.accessor.ModNameHolder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/**
 * For caching a Mod ID and Mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
@Mixin(ItemStack.class)
abstract class ItemStackMixin implements ModNameHolder {

    @Nullable
    @Unique
    private String modId;

    @Nullable
    @Unique
    private String modName;

    @Nullable
    @Override
    public String wmitaf$getModId() {
        return modId;
    }

    @Override
    public void wmitaf$setModId(@Nullable String modId) {
        if (this.modId == null) {
            this.modId = modId;
        }
    }

    @Override
    @Nullable
    public String wmitaf$getModName() {
        return modName;
    }

    @Override
    public void wmitaf$setModName(@Nullable String modName) {
        if (this.modName == null) {
            this.modName = modName;
        }
    }
}
