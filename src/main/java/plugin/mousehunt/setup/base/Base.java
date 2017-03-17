package plugin.mousehunt.setup.base;

import plugin.mousehunt.setup.CommonTrapProperties;
import plugin.mousehunt.setup.EFreshness;

public class Base extends CommonTrapProperties {
	
	public Base(String name, int power, double powerBonus, int luck, double attractionBonus,
			EFreshness freshness, int pointReq, int cost) {
		super(name, power, powerBonus, luck, attractionBonus, freshness, pointReq, cost);
	}

}
