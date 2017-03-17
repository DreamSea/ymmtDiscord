package plugin.mousehunt.setup.base;

import plugin.mousehunt.setup.EFreshness;

public enum EBase implements IBase {
	WOODEN_BASE("Wooden Base", 35, 0, 0, 0, EFreshness.VERY_FRESH, 0, 300);
	
	private Base base;

	private EBase(String name, int power, double powerBonus, int luck, double attractionBonus,
			EFreshness freshness, int pointReq, int cost) {
		base = new Base(name, power, powerBonus, luck, attractionBonus, freshness, pointReq, cost);
	}
	
	@Override
	public Base getValue() {
		return base;
	}

}
