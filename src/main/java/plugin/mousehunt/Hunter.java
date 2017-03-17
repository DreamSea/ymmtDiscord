package plugin.mousehunt;

import java.text.NumberFormat;

import plugin.mousehunt.data.HunterData;
import plugin.mousehunt.data.ReaderWriter;
import plugin.mousehunt.setup.Setup;

public class Hunter {
	
	private NumberFormat numberFormat;
	
	private long lastActive = 0;
	private long lastRequest = 0;
	
	private HunterData data;
	
	private Setup setup;
	
	public Hunter(HunterData data) {
		this.data = data;
		setup = new Setup(data);
		numberFormat = NumberFormat.getIntegerInstance();
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
		return numberFormat.format(data.getGold());
	}
	
	public String getDisplayPoints() {
		return numberFormat.format(data.getPoints());
	}
	
	public String getStats() {
		StringBuilder sb = new StringBuilder();
		sb.append("  Hunter: "+getName()+" (#"+getId()+")\n");
		sb.append("\n");
		sb.append("  Points: "+getDisplayPoints()+"\n");
		sb.append("    Gold: "+getDisplayGold()+"\n");
		sb.append("\n");
		sb.append("Location: Meadow\n");
		sb.append("  Region: Gnawnia\n");
		return sb.toString();
	}
	
	public String getSetup() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cheese: "+setup.getCheese().getName()+"\n");
		sb.append("Weapon: "+setup.getWeapon().getName()+"\n");
		sb.append("  Base: "+setup.getBase().getName()+"\n");
		sb.append("\n");
		sb.append(" Power: "+numberFormat.format(setup.getTotalPower())+"\n");
		sb.append("  Luck: "+numberFormat.format(setup.getLuck())+"\n");
		sb.append("\n");
		return sb.toString();
	}
	
	public void save(ReaderWriter readerWriter) {
		readerWriter.save(data);
	}
	
	public double getTotalPower() {
		return setup.getTotalPower();
	}
	
	public int getLuck() {
		return setup.getLuck();
	}
}
