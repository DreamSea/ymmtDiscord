package plugin.mousehunt.mice;

import java.util.Collections;
import java.util.Map;

public class Mouse {
	
	private final String name;
	private final long gold;
	private final long points;
	private final long power;
	private final Map<String, Double> cheesePref;
	private final Map<String, Double> powerResist;
	
	public Mouse(String name, long gold, long points, long power, 
			Map<String, Double> cheesePref, Map<String, Double> powerResist) {
		this.name = name;
		this.gold = gold;
		this.points = points;
		this.power = power;
		this.cheesePref = Collections.unmodifiableMap(cheesePref);
		this.powerResist = Collections.unmodifiableMap(powerResist);
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

	public long getPower() {
		return power;
	}

	public Map<String, Double> getCheesePref() {
		return cheesePref;
	}

	public Map<String, Double> getPowerResist() {
		return powerResist;
	}
	
	public double getCatchRate(long trapPower, long luck) {
		// 3-eff
		double powerFactor = (trapPower*1.0);
		double luckFactor = (3 - 1.0) * (1.0 * luck) * (1.0 * luck);
		double denom = (trapPower*1.0 + power);
		
		double rate = (powerFactor + luckFactor) / denom;
		
		return Math.min(rate, 1.0);
	}
}
