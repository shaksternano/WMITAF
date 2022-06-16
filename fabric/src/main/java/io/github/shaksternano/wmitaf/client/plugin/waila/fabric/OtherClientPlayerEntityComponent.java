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
    private static final String REVOLT = "YOU SHOULD OPEN revolt.chat... NOW!";
    private static final String BALLS = "YOU SHOULD DOWNLOAD BALLS... NOW!";
    private static final String DEEZ = "deez squared";
    private static final String AMONG_US = "among us";
    private static final String SEGMENTATION_FAULT = "Segmentation fault (core dumped)";
    private static final String LIGHTSPEED = "YOU SHOULD OPEN lightspeed.tv... NOW!";

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
                .put("dbafc5f2-8dfc-43a9-9f2f-71c81e6bf6df", BALLS) // pircsi
                .put("605ea77d-26cf-4401-86e4-7c6049d61146", BALLS) // Sm9l
                .put("941b37c7-7cc7-40a6-9613-bb3ca43bf70e", DEEZ) // DiaperYiff
                .put("97dca97d-8ca1-4ddb-8b98-47e1922f37f1", AMONG_US) // _Wait_What
                .put("1896f801-366d-47bc-b1e7-4ff731122c1d", SEGMENTATION_FAULT) // FatalErrorCoded
                .put("ec99e171-40f1-47e5-a15c-bee4b846c932", LIGHTSPEED) // friendlyfredward
        ;
        return builder.buildOrThrow();
    }
}
