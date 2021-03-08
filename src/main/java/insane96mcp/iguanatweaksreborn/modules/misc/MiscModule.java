package insane96mcp.iguanatweaksreborn.modules.misc;

import insane96mcp.iguanatweaksreborn.base.ITModule;
import insane96mcp.iguanatweaksreborn.base.Label;
import insane96mcp.iguanatweaksreborn.modules.misc.feature.DebuffFeature;
import insane96mcp.iguanatweaksreborn.modules.misc.feature.ExplosionOverhaulFeature;
import insane96mcp.iguanatweaksreborn.modules.misc.feature.WeightFeature;
import insane96mcp.iguanatweaksreborn.setup.Config;

@Label(name = "Miscellaneous")
public class MiscModule extends ITModule {

	public ExplosionOverhaulFeature explosionOverhaulFeature;
	public DebuffFeature debuffFeature;
	public WeightFeature weightFeature;

	public MiscModule() {
		super();
		Config.builder.comment(this.getDescription()).push(this.getName());
		explosionOverhaulFeature = new ExplosionOverhaulFeature(this);
		debuffFeature = new DebuffFeature(this);
		weightFeature = new WeightFeature(this);
		Config.builder.pop();
	}

	@Override
	public void loadConfig() {
		super.loadConfig();
		explosionOverhaulFeature.loadConfig();
		debuffFeature.loadConfig();
		weightFeature.loadConfig();
	}

}
