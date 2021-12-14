package io.github.shaksternano.wmitaf.client.plugin.waila;

import io.github.shaksternano.wmitaf.client.util.ModNameUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.OtherClientPlayerEntity;

@Environment(EnvType.CLIENT)
public enum OtherClientPlayerEntityComponent implements IEntityComponentProvider {

    // This is an enum.
    INSTANCE;

    // Give dev custom Waila mod name.
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            OtherClientPlayerEntity player = accessor.getEntity();

            // ShaksterNano
            if (player.getUuidAsString().equals("65972a6e-02b9-4701-96a7-0f76c08c2e5d")) {
                ModNameUtil.setWailaTooltip(tooltip, player, "WMITAF Developer", true, true);
            }
        }
    }
}
