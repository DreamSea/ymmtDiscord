package plugin.mousehunt;

import java.util.Map;
import java.util.TreeMap;

import plugin.mousehunt.data.HunterData;
import plugin.mousehunt.data.ReaderWriter;
import plugin.mousehunt.mice.EIndigenousMice;
import plugin.mousehunt.mice.Mouse;

public class Mousehunt {

	private long lasthunt = 0;
	private String lasthunter = "";
	
	private long TIME_BETWEEN_HUNTS = 30000; // 30 seconds
	
	private Map<String, Hunter> hunters;
	
	private Location meadow;
	
	private ReaderWriter readerWriter;
	
	public Mousehunt(ReaderWriter readerWriter) {
		this.readerWriter = readerWriter;
		
		meadow = new Location("Meadow");
		meadow.addMouse(EIndigenousMice.WHITE, 2);
		meadow.addMouse(EIndigenousMice.BROWN, 2);
		meadow.addMouse(EIndigenousMice.GREY, 2);
		meadow.addMouse(EIndigenousMice.DWARF, 1);
		
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
			if (Math.random() < m.getCatchRate(105, 2)) {
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
			HunterData data = readerWriter.load(name, id);
			hunters.put(name+"."+id, new Hunter(data));
		}
		return hunters.get(name+"."+id);
	}

	public void save() {
		for (Hunter h : hunters.values()) {
			System.out.println(h.getStats());
			System.out.println("====");
			h.save(readerWriter);
		}	
	}
}
