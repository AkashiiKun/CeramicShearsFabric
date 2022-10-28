package io.github.akashiikun.ceramicshears.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ServerConfig {

    public static ForgeConfigSpec SERVER_CONFIG;

    public static final int DEFAULT_DURABILITY = 179;

    public static final ForgeConfigSpec.IntValue DURABILITY;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Balance Options");

        DURABILITY = builder
                .comment("Defines the maximum durability of Ceramic Shears. (179 - default value, 0 - deactivates the durability)")
                .defineInRange("durability", DEFAULT_DURABILITY, 0, 10000);

        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }

}