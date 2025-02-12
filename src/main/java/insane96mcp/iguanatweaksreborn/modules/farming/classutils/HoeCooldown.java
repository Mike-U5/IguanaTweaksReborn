package insane96mcp.iguanatweaksreborn.modules.farming.classutils;

import insane96mcp.iguanatweaksreborn.common.classutils.IdTagMatcher;
import insane96mcp.iguanatweaksreborn.utils.LogHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.math.NumberUtils;

import javax.annotation.Nullable;

public class HoeCooldown extends IdTagMatcher {
	public int cooldown;

	public HoeCooldown(@Nullable ResourceLocation item, @Nullable ResourceLocation tag, int cooldown) {
		super(item, tag);
		this.cooldown = cooldown;
	}

	@Nullable
	public static HoeCooldown parseLine(String line) {
		String[] split = line.split(",");
		if (split.length != 2) {
			LogHelper.warn("Invalid line \"%s\" for Hoe Cooldown", line);
			return null;
		}
		if (!NumberUtils.isParsable(split[1])) {
			LogHelper.warn(String.format("Invalid chance \"%s\" for Hoe Cooldown", line));
			return null;
		}
		int cooldown = Integer.parseInt(split[1]);
		if (split[0].startsWith("#")) {
			String replaced = split[0].replace("#", "");
			ResourceLocation tag = ResourceLocation.tryCreate(replaced);
			if (tag == null) {
				LogHelper.warn("%s tag for Hoe Cooldown is not valid", replaced);
				return null;
			}
			return new HoeCooldown(null, tag, cooldown);
		}
		else {
			ResourceLocation block = ResourceLocation.tryCreate(split[0]);
			if (block == null) {
				LogHelper.warn("%s item for Hoe Cooldown is not valid", split[0]);
				return null;
			}
			if (ForgeRegistries.ITEMS.containsKey(block)) {
				return new HoeCooldown(block, null, cooldown);
			}
			else {
				LogHelper.warn(String.format("%s item for Hoe Till Chance seems to not exist", split[0]));
				return null;
			}
		}
	}
}