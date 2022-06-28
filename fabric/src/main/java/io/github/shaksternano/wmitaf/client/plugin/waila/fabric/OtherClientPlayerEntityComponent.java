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

    /**
     * Creates a map mapping player UUIDs to custom messages.
     *
     * @return A map mapping player UUIDs to custom messages.
     */
    private static Map<String, String> createPlayerMessagesMap() {
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();

        addToBuilder(builder, "The Inept Brits",
                "65972a6e-02b9-4701-96a7-0f76c08c2e5d", // ShaksterNano
                "64e44de7-a634-4dff-86a5-0e607c7f1f19", // DeMagnumKong
                "eea7537e-0219-46b4-90e1-fcaaa1221fe0", // AtVeroAeneas
                "a0d4d6e5-a9f6-4e51-8005-30ff2ec88833", // Shepherd722
                "391cd817-d95b-4fa0-b044-513641feec3a", // Cosmo_1709
                "9ecbd174-f1db-4c81-ab1f-05f49d3b9e76", // Multiverse__
                "4ccc4e71-9259-44b5-9641-1941ad0bf37b" // I5haq2003
        );

        addToBuilder(builder, "fortnite battle pass",
                "0ebe52a9-7c23-4a15-ab31-aaa39c1bab2c", // Foxkin
                "1f2ee0cc-3011-4261-bc5c-50382288cab2", // Lutitious
                "4db72998-a62e-4be5-b6de-02ed1dd82847" // Insertish
        );

        addToBuilder(builder, "YOU SHOULD DOWNLOAD HAEMA... NOW!",
                "9b035372-0d8d-4513-8bd5-9808d7f4a9b3" // will_bl
        );

        addToBuilder(builder, "YOU SHOULD OPEN revolt.chat... NOW!",
                "438695b0-950e-4859-a119-49162ef58c25" // RevoltChat
        );

        addToBuilder(builder, "YOU SHOULD DOWNLOAD BALLS... NOW!",
                "dbafc5f2-8dfc-43a9-9f2f-71c81e6bf6df", // pircsi
                "605ea77d-26cf-4401-86e4-7c6049d61146" // Sm9l
        );

        addToBuilder(builder, "deez squared",
                "941b37c7-7cc7-40a6-9613-bb3ca43bf70e" // DiaperYiff
        );

        addToBuilder(builder, "among us",
                "97dca97d-8ca1-4ddb-8b98-47e1922f37f1" // _Wait_What
        );

        addToBuilder(builder, "Segmentation fault (core dumped)",
                "1896f801-366d-47bc-b1e7-4ff731122c1d" // FatalErrorCoded
        );

        addToBuilder(builder, "YOU SHOULD OPEN lightspeed.tv... NOW!",
                "ec99e171-40f1-47e5-a15c-bee4b846c932" // friendlyfredward
        );

        return builder.buildOrThrow();
    }

    /**
     * Associates multiple keys with a single value in a {@code ImmutableMap.Builder}.
     *
     * @param builder The builder to add to.
     * @param value   The value to add.
     * @param keys    The keys to add.
     * @param <K>     The key type.
     * @param <V>     The value type.
     * @throws IllegalArgumentException If no keys are provided.
     */
    @SafeVarargs
    private static <K, V> void addToBuilder(ImmutableMap.Builder<K, V> builder, V value, K... keys) {
        if (keys.length == 0) {
            throw new IllegalArgumentException("keys cannot be empty!");
        } else {
            for (K key : keys) {
                builder.put(key, value);
            }
        }
    }
}
