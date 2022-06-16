package io.github.shaksternano.wmitaf.client.plugin.waila.fabric;

import com.google.common.collect.ImmutableMap;
import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;

import java.util.Map;

@Environment(EnvType.CLIENT)
public enum OtherClientPlayerEntityComponent implements IEntityComponentProvider {

    INSTANCE;

    private static final String THE_INEPT_BRITS = "The Inept Brits";
    private static final String FORTNITE = "fortnite battle pass";
    private static final String HAEMA = "YOU SHOULD DOWNLOAD HAEMA... NOW!";
    private static final String REVOLT = "rolt moment";

    /**
     * Player messages.
     */
    private static final Map<String, String> PLAYER_MESSAGES = createPlayerMessagesMap();

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
            String message = PLAYER_MESSAGES.get(entity.getUuidAsString());
            if (message != null) {
                ModNameUtil.setWailaTooltip(tooltip, entity, message, true);
            }
        }
    }

    private static Map<String, String> createPlayerMessagesMap() {
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
        builder
                .put("65972a6e-02b9-4701-96a7-0f76c08c2e5d", THE_INEPT_BRITS) // ShaksterNano
                .put("64e44de7-a634-4dff-86a5-0e607c7f1f19", THE_INEPT_BRITS) // DeMagnumKong
                .put("eea7537e-0219-46b4-90e1-fcaaa1221fe0", THE_INEPT_BRITS) // AtVeroAeneas
                .put("391cd817-d95b-4fa0-b044-513641feec3a", THE_INEPT_BRITS) // Cosmo_1709
                .put("9ecbd174-f1db-4c81-ab1f-05f49d3b9e76", THE_INEPT_BRITS) // Multiverse__
                .put("4ccc4e71-9259-44b5-9641-1941ad0bf37b", THE_INEPT_BRITS) // I5haq2003
                .put("0ebe52a9-7c23-4a15-ab31-aaa39c1bab2c", FORTNITE) // Foxkin
                .put("1f2ee0cc-3011-4261-bc5c-50382288cab2", FORTNITE) // Lutitious
                .put("4db72998-a62e-4be5-b6de-02ed1dd82847", FORTNITE) // Insertish
                .put("9b035372-0d8d-4513-8bd5-9808d7f4a9b3", HAEMA) // will_bl
                .put("438695b0-950e-4859-a119-49162ef58c25", REVOLT) // RevoltChat
        ;
        return builder.buildOrThrow();
    }
}
