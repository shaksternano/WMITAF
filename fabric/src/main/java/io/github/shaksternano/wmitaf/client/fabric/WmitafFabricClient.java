package io.github.shaksternano.wmitaf.client.fabric;

import io.github.shaksternano.wmitaf.client.plugin.topplus.fabric.TopPlusEventHooks;
import net.fabricmc.api.ClientModInitializer;

public class WmitafFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        TopPlusEventHooks.registerClientEventHooks();
    }
}
