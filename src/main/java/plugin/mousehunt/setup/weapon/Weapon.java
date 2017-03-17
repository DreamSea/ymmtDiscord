package plugin.mousehunt.setup.weapon;

import plugin.mousehunt.setup.CommonTrapProperties;
import plugin.mousehunt.setup.EFreshness;
import plugin.mousehunt.setup.EPowerType;

public class Weapon extends CommonTrapProperties {
	
	private EPowerType powerType;
	
	public Weapon(String name, EPowerType powerType, int power, double powerBonus, int luck, double attractionBonus,
			EFreshness freshness, int pointReq, int cost) {
		super(name, power, powerBonus, luck, attractionBonus, freshness, pointReq, cost);
		this.powerType = powerType;
	}

	public EPowerType getPowerType() {
		return powerType;
	}

}
