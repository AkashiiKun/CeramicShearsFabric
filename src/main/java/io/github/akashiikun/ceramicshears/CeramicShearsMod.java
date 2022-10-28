package io.github.akashiikun.ceramicshears;

import io.github.akashiikun.ceramicshears.config.ServerConfig;
import io.github.akashiikun.ceramicshears.item.CeramicShearsItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CeramicShearsMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("ceramicshears");

	public static final Item CLAY_SHEARS_PART = Registry.register(Registry.ITEM, new Identifier("ceramicshears", "clay_shears_part"),
        new Item(new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item CERAMIC_SHEARS_PART = Registry.register(Registry.ITEM, new Identifier("ceramicshears", "ceramic_shears_part"),
			new Item(new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item CERAMIC_SHEARS = Registry.register(Registry.ITEM, new Identifier("ceramicshears", "ceramic_shears"),
			new CeramicShearsItem(ServerConfig.DEFAULT_DURABILITY));

	@Override
	public void onInitialize() {
		ModLoadingContext.registerConfig("ceramicshears", ModConfig.Type.COMMON, ServerConfig.SERVER_CONFIG);
	}
}
