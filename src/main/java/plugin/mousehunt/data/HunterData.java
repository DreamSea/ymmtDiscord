package plugin.mousehunt.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import plugin.mousehunt.setup.base.EBase;
import plugin.mousehunt.setup.weapon.EWeapon;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HunterData {
	
	private long points = 0;
	private long gold = 0;
	
	private String name;
	private String id;

	private EWeapon weapon = EWeapon.MOUSE_HOT_TUB;
	private EBase base = EBase.WOODEN_BASE;
	
	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public long getGold() {
		return gold;
	}

	public void setGold(long gold) {
		this.gold = gold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EWeapon getWeapon() {
		return weapon;
	}

	public void setWeapon(EWeapon weapon) {
		this.weapon = weapon;
	}

	public EBase getBase() {
		return base;
	}

	public void setBase(EBase base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "HunterData [points=" + points + ", gold=" + gold + ", name=" + name + ", id=" + id + "]";
	}
}
