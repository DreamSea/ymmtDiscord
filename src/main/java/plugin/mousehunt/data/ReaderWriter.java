package plugin.mousehunt.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

// mixing Files and File errywhere =/
public class ReaderWriter {
	
	private static final String DATA_HUNTER_PATH = "/documents/ymmtDiscord/mousehunt/hunter";
	
	public void save(HunterData hunterData) {
		try {
			File hunterFile = getHunterFile(hunterData.getName(), hunterData.getId());
			if (Files.exists(hunterFile.toPath())) {
				File backup = new File(hunterFile.getPath()+".old");
				Files.copy(hunterFile.toPath(), backup.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			
			JAXBContext jc = JAXBContext.newInstance(HunterData.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.marshal(hunterData, hunterFile);
		} catch (IOException | JAXBException e) {
			System.out.println(hunterData.toString());
			e.printStackTrace();
		}
	}

	public HunterData load(String name, String id) {
		try {
			File hunterFile = getHunterFile(name, id);
			
			if (Files.notExists(hunterFile.toPath())) {
				HunterData hunterData = new HunterData();
				hunterData.setName(name);
				hunterData.setId(id);
				
				return hunterData;
			}
			
			JAXBContext jc = JAXBContext.newInstance(HunterData.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			HunterData hunterData = (HunterData) unmarshaller.unmarshal(hunterFile);
			return hunterData;
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private File getHunterFile(String name, String id) throws IOException {
		File ymmtDiscordDirectory = new File(System.getProperty("user.home")+DATA_HUNTER_PATH);
		Files.createDirectories(Paths.get(ymmtDiscordDirectory.getPath()));
		
		File hunterFile = new File(ymmtDiscordDirectory.getPath()+"/"+name+"."+id+".dat");
		return hunterFile;
	}
}
