package plugin.mousehunt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import plugin.mousehunt.mice.IMice;
import plugin.mousehunt.mice.Mouse;

public class Location {
	
	private Random r;
	private String name;
	private List<Mouse> population;
	
	public Location(String name) {
		this.name = name;
		r = new Random();
		population = new ArrayList<Mouse>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addMouse(IMice m, int count) {
		for (int i = 0; i < count; i++) {
			population.add(m.getMouse());
		}
	}
	
	public Mouse getMouse() {
		return population.get(r.nextInt(population.size()));
	}

}
