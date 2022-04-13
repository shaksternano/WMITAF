package io.github.shaksternano.wmitaf.client.fabric;

import io.github.shaksternano.wmitaf.client.plugin.topplus.fabric.TopPlusEventHooks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public class WmitafFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isModLoaded("top_plus")) {
            TopPlusEventHooks.registerClientEventHooks();
        }
    }
}
