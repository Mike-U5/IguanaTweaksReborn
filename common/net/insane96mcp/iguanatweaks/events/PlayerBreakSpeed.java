package net.insane96mcp.iguanatweaks.events;

import net.insane96mcp.iguanatweaks.IguanaTweaks;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IguanaTweaks.MOD_ID)
public class PlayerBreakSpeed {

	@SubscribeEvent
	public static void EventBreakSpeed(BreakSpeed event) {
		//ModuleHardness.ProcessHardness(event);
	}
}
