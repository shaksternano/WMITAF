package io.github.shaksternano.wmitaf.mixin.client;

import io.github.shaksternano.wmitaf.client.accessor.ModNameHolder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

/**
 * For caching a Mod ID and Mod name related to an entity.
 */
@Environment(EnvType.CLIENT)
@Mixin(ItemStack.class)
abstract class ItemStackMixin implements ModNameHolder {

    @Nullable
    private String wmitaf$modId;

    @Nullable
    private String wmitaf$modName;

    @Nullable
    @Override
    public String wmitaf$getModId() {
        return wmitaf$modId;
    }

    @Override
    public void wmitaf$setModId(@Nullable String modId) {
        if (wmitaf$modId == null) {
            wmitaf$modId = modId;
        }
    }

    @Override
    @Nullable
    public String wmitaf$getModName() {
        return wmitaf$modName;
    }

    @Override
    public void wmitaf$setModName(@Nullable String modName) {
        if (wmitaf$modName == null) {
            wmitaf$modName = modName;
        }
    }
}
