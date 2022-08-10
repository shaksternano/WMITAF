package io.github.shaksternano.wmitaf.client.plugin.jade.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import snownee.jade.api.callback.JadeItemModNameCallback;

@Environment(EnvType.CLIENT)
public enum JadeItemModNameProvider implements JadeItemModNameCallback {

    INSTANCE;

    /**
     * Gets the name of the mod that actually adds an item.
     *
     * @param stack The item stack.
     * @return The name of the mod that actually adds the item.
     */
    @Nullable
    @Override
    public String gatherItemModName(ItemStack stack) {
        return ModNameUtil.getActualModName(stack).orElse(null);
    }
}
