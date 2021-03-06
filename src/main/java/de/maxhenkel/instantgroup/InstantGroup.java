package de.maxhenkel.instantgroup;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.instantgroup.command.InstantGroupCommands;
import de.maxhenkel.instantgroup.config.CommonConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

public class InstantGroup implements ModInitializer {

    public static final String MOD_ID = "instantgroup";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static CommonConfig CONFIG;

    @Override
    public void onInitialize() {
        CONFIG = ConfigBuilder.build(Paths.get(".", "config").resolve(MOD_ID).resolve("%s.properties".formatted(MOD_ID)), CommonConfig::new);
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> InstantGroupCommands.register(dispatcher));
    }
}
