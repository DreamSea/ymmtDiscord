package mousehunt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public void addMouse(Mouse m, int count) {
		for (int i = 0; i < count; i++) {
			population.add(m);
		}
	}
	
	public Mouse getMouse() {
		return population.get(r.nextInt(population.size()));
	}

}
