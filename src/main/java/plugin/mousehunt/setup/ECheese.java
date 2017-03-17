package plugin.mousehunt.setup;

public enum ECheese {
	CHEDDAR("Cheddar Cheese", 10),
	MARBLE("Marble Cheese", 50),
	SWISS("Swiss Cheese", 100),
	BRIE("Brie Cheese", 200);
	
	private String name;
	private int cost;
	
	private ECheese(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}
}
