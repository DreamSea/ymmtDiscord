package plugin.mousehunt.mice;

import java.util.Collections;
import java.util.Map;

// power from https://sites.google.com/site/tehhowch/downloads/cre-modeling
public enum EIndigenousMice implements IMice {
	BIONIC("Bionic Mouse",		300, 	550,	680,	Collections.emptyMap(), Collections.emptyMap()),
	BROWN("Brown Mouse",		115, 	150,	3,		Collections.emptyMap(), Collections.emptyMap()),
	DIAMOND("Diamond Mouse",	1_200, 	600,	765,	Collections.emptyMap(), Collections.emptyMap()),
	DWARF("Dwarf Mouse",		225, 	450,	200,	Collections.emptyMap(), Collections.emptyMap()),
	GOLD("Gold Mouse",			600, 	1_200,	720,	Collections.emptyMap(), Collections.emptyMap()),
	GRANITE("Granic Mouse",		285, 	525,	635,	Collections.emptyMap(), Collections.emptyMap()),
	GREY("Grey Mouse",			90, 	125,	2,		Collections.emptyMap(), Collections.emptyMap()),
	STEEL("Steel Mouse",		270, 	500,	595,	Collections.emptyMap(), Collections.emptyMap()),
	WHITE("White Mouse",		70,		100,	1,		Collections.emptyMap(), Collections.emptyMap());

	private Mouse mouse;
	
	private EIndigenousMice(String name, long gold, long points, long power, 
			Map<String, Double> cheesePref, Map<String, Double> powerResist) {
		mouse = new Mouse(name, gold, points, power, cheesePref, powerResist);
	}
	
	@Override
	public Mouse getMouse() {
		return mouse;
	}
}
