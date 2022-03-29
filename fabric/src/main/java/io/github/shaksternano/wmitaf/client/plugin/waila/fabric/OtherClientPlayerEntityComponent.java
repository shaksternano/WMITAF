package io.github.shaksternano.wmitaf.client.plugin.waila.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public enum OtherClientPlayerEntityComponent implements IEntityComponentProvider {

    INSTANCE;

    /**
     * Give dev custom Waila mod name.
     *
     * @param tooltip  The tooltip to modify.
     * @param accessor The accessor for the entity.
     * @param config   The current plugin configuration.
     */
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            Entity entity = accessor.getEntity();

            // ShaksterNano
            if (entity.getUuidAsString().equals("65972a6e-02b9-4701-96a7-0f76c08c2e5d")) {
                ModNameUtil.setWailaTooltip(tooltip, entity, "WMITAF Developer", true);
            }
        }
    }
}
