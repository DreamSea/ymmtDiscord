package plugin.mousehunt.setup;

import plugin.mousehunt.data.HunterData;
import plugin.mousehunt.setup.base.Base;
import plugin.mousehunt.setup.weapon.Weapon;

public class Setup {
	
	private HunterData data;
	private Weapon weapon;
	private Base base;
	private ECheese cheese;
	
	public Setup(HunterData data) {
		this.data = data;
		weapon = data.getWeapon().getWeapon();
		base = data.getBase().getValue();
		cheese = ECheese.CHEDDAR;
	}
	
	public int getPower() {
		return weapon.getPower() + base.getPower();
	}
	
	public double getPowerBonus() {
		return 1 + weapon.getPowerBonus() + base.getPowerBonus();
	}
	
	public int getLuck() {
		return weapon.getLuck() + base.getLuck();
	}
	
	public double getTotalPower() {
		return getPower() * getPowerBonus();
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public Base getBase() {
		return base;
	}

	public ECheese getCheese() {
		return cheese;
	}
}
