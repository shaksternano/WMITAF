package io.github.shaksternano.wmitaf.client.plugin.waila.fabric;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.entity.ItemEntity;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class WmitafWailaPluginFabric implements IWailaPlugin {

    /**
     * Registers the Waila plugins.
     *
     * @param registrar The Waila registrar.
     */
    @Override
    public void register(IRegistrar registrar) {
        registrar.addEventListener(ItemStackEventListener.INSTANCE, 1500);
        registrar.addComponent(ItemEntityComponent.INSTANCE, TooltipPosition.TAIL, ItemEntity.class, 1500);
        registrar.addComponent(OtherClientPlayerEntityComponent.INSTANCE, TooltipPosition.TAIL, OtherClientPlayerEntity.class, 1500);
    }
}
