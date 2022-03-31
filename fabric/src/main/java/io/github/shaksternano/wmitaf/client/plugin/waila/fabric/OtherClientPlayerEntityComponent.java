package io.github.shaksternano.wmitaf.client.plugin.waila.fabric;

import com.google.common.collect.ImmutableSet;
import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public enum OtherClientPlayerEntityComponent implements IEntityComponentProvider {

    INSTANCE;

    /**
     * The player UUID strings.
     */
    private static final ImmutableSet<String> PLAYER_UUIDS = ImmutableSet.of(
            "65972a6e-02b9-4701-96a7-0f76c08c2e5d", // ShaksterNano
            "64e44de7-a634-4dff-86a5-0e607c7f1f19", // DeMagnumKong
            "eea7537e-0219-46b4-90e1-fcaaa1221fe0", // AtVeroAeneas
            "391cd817-d95b-4fa0-b044-513641feec3a", // Cosmo_1709
            "9ecbd174-f1db-4c81-ab1f-05f49d3b9e76", // Multiverse__
            "4ccc4e71-9259-44b5-9641-1941ad0bf37b" // I5haq2003
    );

    /**
     * Give some players a custom Waila mod name.
     *
     * @param tooltip  The tooltip to modify.
     * @param accessor The accessor for the entity.
     * @param config   The current plugin configuration.
     */
    @Override
    public void appendTail(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            Entity entity = accessor.getEntity();

            if (PLAYER_UUIDS.contains(entity.getUuidAsString())) {
                ModNameUtil.setWailaTooltip(tooltip, entity, "The Inept Brits", true);
            }
        }
    }
}
