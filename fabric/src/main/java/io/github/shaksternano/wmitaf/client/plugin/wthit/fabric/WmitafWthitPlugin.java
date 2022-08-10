package io.github.shaksternano.wmitaf.client.plugin.wthit.fabric;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class WmitafWthitPlugin implements IWailaPlugin {

    /**
     * Registers the WTHIT plugins.
     *
     * @param registrar The WTHIT registrar.
     */
    @Override
    public void register(IRegistrar registrar) {
        registrar.addEventListener(WthitItemModNameProvider.INSTANCE, 1500);
        registrar.addComponent(WthitItemModNameProvider.INSTANCE, TooltipPosition.TAIL, ItemEntity.class, 1500);
        registrar.addComponent(WthitPlayerModNameProvider.INSTANCE, TooltipPosition.TAIL, PlayerEntity.class, 1500);
    }
}
