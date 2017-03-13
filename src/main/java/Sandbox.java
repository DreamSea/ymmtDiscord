import org.junit.Test;

import plugin.mousehunt.Hunter;

public class Sandbox {

	@Test
	public void test() {
		Hunter hunter = new Hunter("Cat", "1234");
		System.out.println(hunter.getStats());
		hunter.addGold(500);
		hunter.addPoints(200);
		System.out.println(hunter.getStats());
	}

}
