package io.github.shaksternano.wmitef.client.plugin.waila;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.ItemEntity;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public final class WmitefWailaPlugin implements IWailaPlugin {

    // Registers the overrides.
    @Override
    public void register(IRegistrar registrar) {
        registrar.addEventListener(EnchantedBookOverride.INSTANCE);
        registrar.addComponent(EnchantedBookItemEntityOverride.INSTANCE, TooltipPosition.TAIL, ItemEntity.class);
    }
}
