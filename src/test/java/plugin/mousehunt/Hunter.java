package plugin.mousehunt;

public class Hunter {
	
	private long lastActive = 0;
	private long lastRequest = 0;
	
	private long points = 0;
	private long gold = 0;
	
	private String name;
	private String id;
	
	public Hunter(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public boolean isActive() {
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public void addPoints(long points) {
		this.points += points;
	}
	
	public void addGold(long gold) {
		this.gold += gold;
	}
	
	public String getDisplayGold() {
		return String.valueOf(gold);
	}
	
	public String getDisplayPoints() {
		return String.valueOf(points);
	}
	
	public String getStats() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hunter: "+name+" (#"+id+")\n");
		sb.append("\n");
		sb.append("Points: "+getDisplayPoints()+"\n");
		sb.append("Gold: "+getDisplayGold()+"\n");
		sb.append("\n");
		sb.append("Location: Meadow\n");
		sb.append("Region: Gnawnia\n");
		sb.append("\n");
		sb.append("Weapon: Mouse Hot Tub\n");
		sb.append("Base: Wooden Base\n");
		return sb.toString();
	}
	
	
	
}
