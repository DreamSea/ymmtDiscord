import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import plugin.mousehunt.Hunter;
import plugin.mousehunt.data.HunterData;
import plugin.mousehunt.data.ReaderWriter;
import plugin.mousehunt.mice.EIndigenousMice;
import plugin.mousehunt.setup.ECheese;
import plugin.mousehunt.setup.Setup;
import plugin.mousehunt.setup.weapon.EWeapon;

// not actual tests.
public class Sandbox {

//	@Test
	public void test() {
		HunterData data = new HunterData();
		data.setName("Cat");
		data.setId("1234");
		Hunter hunter = new Hunter(data);
		System.out.println(hunter.getStats());
		hunter.addGold(500);
		hunter.addPoints(200);
		System.out.println(hunter.getStats());
	}
	
//	@Test
	public void testSave() {
		HunterData data = new HunterData();
		data.setName("Cat");
		data.setId("1234");
		data.setGold(51400);
		data.setPoints(200);
		
		ReaderWriter readWriter = new ReaderWriter();
		readWriter.save(data);
	}
	
//	@Test
	public void testLoad() {
		ReaderWriter readWriter = new ReaderWriter();
		HunterData data = readWriter.load("Cat", "1234");
		
		System.out.println(data.getName());
		System.out.println(data.getId());
		System.out.println(data.getGold());
		System.out.println(data.getPoints());
		
		System.out.println(data.getWeapon());
		
//		readWriter.save(data);
	}
	
//	@Test
	public void catchRates() {
		EIndigenousMice[] mice = EIndigenousMice.values();
		Arrays.sort(mice, new Comparator<EIndigenousMice>() {
			@Override
			public int compare(EIndigenousMice eMouse1, EIndigenousMice eMouse2) {
				return (int) (eMouse1.getMouse().getPower() -  eMouse2.getMouse().getPower());
			}
		});
		
		for (EIndigenousMice eMouse : mice) {
			System.out.println(eMouse.getMouse().getName()+" - "+eMouse.getMouse().getPower());
			System.out.println("2650/12: "+eMouse.getMouse().getCatchRate(2650, 12));
			System.out.println("400/1: "+eMouse.getMouse().getCatchRate(400, 1));
			System.out.println("105/2: "+eMouse.getMouse().getCatchRate(105, 2));
			System.out.println();
		}
	}
	
	@Test
	public void cheese() {

		System.out.println(ECheese.valueOf("CHEDDAR"));
		Setup setup = new Setup(new HunterData());
		
		System.out.println(setup.getTotalPower());
		System.out.println(setup.getLuck());
		
		Hunter hunter = new Hunter(new HunterData());
		hunter.addGold(1012314);
		System.out.println("~~~");
		System.out.println(hunter.getStats());
		System.out.println("~~~");
		System.out.println(hunter.getSetup());
	}
}
