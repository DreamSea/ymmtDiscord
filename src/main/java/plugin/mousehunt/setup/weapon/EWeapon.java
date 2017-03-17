package plugin.mousehunt.setup.weapon;

import plugin.mousehunt.setup.EFreshness;
import plugin.mousehunt.setup.EPowerType;

public enum EWeapon implements IWeapon {
	MOUSE_HOT_TUB("Mouse Hot Tub", EPowerType.PHYSICAL, 70, 0.03, 2, 0.35, EFreshness.NEUTRAL, 0, 600),
	HIGH_TENSION_SPRING("High Tension Spring", EPowerType.PHYSICAL, 75, 0.05, 2, 0.20, EFreshness.NEUTRAL, 0, 600);
	
	private Weapon weapon;
	
	private EWeapon(String name, EPowerType powerType, 
			int power, double powerBonus, int luck, double attractionBonus,
			EFreshness freshness, int pointReq, int cost) {
		weapon = new Weapon(name, powerType, power, powerBonus, luck, attractionBonus, freshness, pointReq, cost);;
	}

	@Override
	public Weapon getWeapon() {
		return weapon;
	}
}
