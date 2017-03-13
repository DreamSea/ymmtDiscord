import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import plugin.mousehunt.Hunter;
import plugin.mousehunt.data.HunterData;
import plugin.mousehunt.data.ReaderWriter;

// not actual tests.
public class Sandbox {

//	@Test
	public void test() {
		Hunter hunter = new Hunter("Cat", "1234");
		System.out.println(hunter.getStats());
		hunter.addGold(500);
		hunter.addPoints(200);
		System.out.println(hunter.getStats());
	}
	
//	@Test
	public void testSave() throws IOException, JAXBException {
		HunterData data = new HunterData();
		data.setName("Cat");
		data.setId("1234");
		data.setGold(51400);
		data.setPoints(200);
		
		ReaderWriter readWriter = new ReaderWriter();
		readWriter.save(data);
	}
	
	@Test
	public void testLoad() throws IOException, JAXBException {
		ReaderWriter readWriter = new ReaderWriter();
		HunterData data = readWriter.load("CaCt", "1234"); // TODO : deal with file not found
		
		System.out.println(data.getName());
		System.out.println(data.getId());
		System.out.println(data.getGold());
		System.out.println(data.getPoints());
	}
}
