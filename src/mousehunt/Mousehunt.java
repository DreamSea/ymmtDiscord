package mousehunt;

import java.util.Map;
import java.util.TreeMap;

public class Mousehunt {

	private long lasthunt = 0;
	private String lasthunter = "";
	
	private long TIME_BETWEEN_HUNTS = 30000; // 30 seconds
	
	private Map<String, Hunter> hunters;
	
	private Location meadow;
	
	public Mousehunt() {
		meadow = new Location("Meadow");
		meadow.addMouse(new Mouse("White Mouse", 100, 70, 1.0), 10);
		meadow.addMouse(new Mouse("Brown Mouse", 150, 115, 0.75), 10);
		meadow.addMouse(new Mouse("Grey Mouse", 125, 90, 0.75), 10);
		meadow.addMouse(new Mouse("Spotted Mouse", 175, 175, 0.5), 10);
		
		hunters = new TreeMap<String, Hunter>();
	}
	
	public String hunt(Hunter hunter) {
		long currentTime = System.currentTimeMillis();
		
		long millisSinceLastHunt = currentTime - lasthunt;
		
		if (millisSinceLastHunt > TIME_BETWEEN_HUNTS) {
			lasthunt = currentTime;
			lasthunter = hunter.getName();
			return "```\n"+hunter.getName()+" began the hunt.\n"+doHunt()+"```";
		} else {
			return lasthunter+" started the last hunt "+millisSinceLastHunt/1000+" second(s) ago. "+
				"Time until the next hunt can begin: "+((TIME_BETWEEN_HUNTS-millisSinceLastHunt)/1000)+" second(s).";
		}
	}
	
	public String doHunt() {
		StringBuilder sb = new StringBuilder();
		for (Hunter h : hunters.values()) {
			Mouse m = meadow.getMouse();
			if (Math.random() < m.getCatchRate()) {
				sb.append(h.getName()+" caught a "+m.getName()+" worth "+m.getPoints()+" points and "+m.getGold()+" gold.\n");
				h.addGold(m.getGold());
				h.addPoints(m.getPoints());
			} else {
				sb.append("A "+m.getName()+" ate a piece of cheese without setting off "+h.getName()+"'s trap.\n");
			}
		}
		return sb.toString();
	}

	public String process(String name, String id, String content) {
		if (content.equals(".hunt")) {
			return hunt(getHunter(name, id));
		} else if (content.equals(".stats")) {
			return "```http\n"+getHunter(name, id).getStats()+"\n```";
		}
		return null;
	}
	
	private Hunter getHunter(String name, String id) {
		if (!hunters.containsKey(name+"."+id)) {
			hunters.put(name+"."+id, new Hunter(name, id));
		}
		return hunters.get(name+"."+id);
	}

	public void save() {
		for (Hunter h : hunters.values()) {
			System.out.println(h.getStats());
			System.out.println("====");
		}	
	}
}
