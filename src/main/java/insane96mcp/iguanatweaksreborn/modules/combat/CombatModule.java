package insane96mcp.iguanatweaksreborn.modules.combat;

import insane96mcp.iguanatweaksreborn.modules.combat.feature.NoKnockbackFeature;
import insane96mcp.iguanatweaksreborn.setup.Config;
import insane96mcp.insanelib.base.Label;
import insane96mcp.insanelib.base.Module;

@Label(name = "Combat")
public class CombatModule extends Module {

	public NoKnockbackFeature noItemNoKnockback;

	public CombatModule() {
		super(Config.builder);
		pushConfig(Config.builder);
		noItemNoKnockback = new NoKnockbackFeature(this);
		Config.builder.pop();
	}

	@Override
	public void loadConfig() {
		super.loadConfig();
		noItemNoKnockback.loadConfig();
	}

}
