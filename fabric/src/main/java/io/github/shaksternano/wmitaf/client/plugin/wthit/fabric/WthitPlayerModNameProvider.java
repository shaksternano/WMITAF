package io.github.shaksternano.wmitaf.client.plugin.wthit.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.PlayerMessages;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public enum WthitPlayerModNameProvider implements IEntityComponentProvider {

    INSTANCE;

    /**
     * Give some players a custom WTHIT mod name.
     *
     * @param tooltip  The tooltip to modify.
     * @param accessor The accessor for the entity.
     * @param config   The current plugin configuration.
     */
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            Entity player = accessor.getEntity();
            PlayerMessages.getMessage(player.getUuidAsString()).ifPresent(
                    message -> tooltip.setLine(WailaConstants.MOD_NAME_TAG, IWailaConfig.get().getFormatter().modName(message))
            );
        }
    }
}
