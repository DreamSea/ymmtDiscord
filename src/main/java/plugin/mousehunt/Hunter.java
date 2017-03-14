package plugin.mousehunt;

import plugin.mousehunt.data.HunterData;
import plugin.mousehunt.data.ReaderWriter;

public class Hunter {
	
	private long lastActive = 0;
	private long lastRequest = 0;
	
	private HunterData data;
	
	public Hunter(HunterData data) {
		this.data = data;
	}
	
	public boolean isActive() {
		return true;
	}
	
	public String getName() {
		return data.getName();
	}
	
	public String getId() {
		return data.getId();
	}
	
	public void addPoints(long points) {
		data.setPoints(data.getPoints() + points);
	}
	
	public void addGold(long gold) {
		data.setGold(data.getGold() + gold);
	}
	
	public String getDisplayGold() {
		return String.valueOf(data.getGold());
	}
	
	public String getDisplayPoints() {
		return String.valueOf(data.getPoints());
	}
	
	public String getStats() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hunter: "+getName()+" (#"+getId()+")\n");
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
	
	public void save(ReaderWriter readerWriter) {
		readerWriter.save(data);
	}
}
