package plugin.mousehunt.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ReaderWriter {
	
	private static final String DATA_HUNTER_PATH = "/documents/ymmtDiscord/mousehunt/hunter";
	
	public void save(HunterData hunterData) throws IOException, JAXBException {
		File hunterFile = getHunterFile(hunterData.getName(), hunterData.getId());
		
		JAXBContext jc = JAXBContext.newInstance(HunterData.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.marshal(hunterData, hunterFile);
	}

	public HunterData load(String name, String id) throws IOException, JAXBException {

		File hunterFile = getHunterFile(name, id);
		
		JAXBContext jc = JAXBContext.newInstance(HunterData.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		
		HunterData hunterData = (HunterData) unmarshaller.unmarshal(hunterFile);
		
		return hunterData;
	}
	
	private File getHunterFile(String name, String id) throws IOException {
		File ymmtDiscordDirectory = new File(System.getProperty("user.home")+DATA_HUNTER_PATH);

		System.out.println(ymmtDiscordDirectory.getPath());
		Files.createDirectories(Paths.get(ymmtDiscordDirectory.getPath()));
		
		File hunterFile = new File(ymmtDiscordDirectory.getPath()+"/"+name+"."+id+".dat");
		
		return hunterFile;
	}
}
