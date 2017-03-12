package mousehunt;

public class Mouse {
	
	private String name;
	private long gold;
	private long points;
	private double catchRate;
	
	public Mouse(String name, long gold, long points, double catchRate) {
		this.name = name;
		this.gold = gold;
		this.points = points;
		this.catchRate = catchRate;
	}

	public String getName() {
		return name;
	}

	public long getGold() {
		return gold;
	}

	public long getPoints() {
		return points;
	}

	public double getCatchRate() {
		return catchRate;
	}
}
