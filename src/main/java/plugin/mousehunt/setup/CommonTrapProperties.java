package plugin.mousehunt.setup;

public class CommonTrapProperties {

	private String name;
	private int power;
	private double powerBonus;
	private int luck;
	private double attractionBonus;
	private EFreshness freshness;
	private int pointReq;
	private int cost;
	
	public CommonTrapProperties(String name, int power, double powerBonus, int luck, double attractionBonus,
			EFreshness freshness, int pointReq, int cost) {
		this.name = name;
		this.power = power;
		this.powerBonus = powerBonus;
		this.luck = luck;
		this.attractionBonus = attractionBonus;
		this.freshness = freshness;
		this.pointReq = pointReq;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public double getPowerBonus() {
		return powerBonus;
	}

	public int getLuck() {
		return luck;
	}

	public double getAttractionBonus() {
		return attractionBonus;
	}

	public EFreshness getFreshness() {
		return freshness;
	}

	public int getPointReq() {
		return pointReq;
	}

	public int getCost() {
		return cost;
	}
}
