package cloud.configs.hazelcast.configtemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import configs.cloud.client.CloudConfigClient;
import configs.cloud.client.entity.Config;
import configs.cloud.client.enums.CacheProvider;

/**
 * Client Class to Generate HazelCast XML from a simple available tokenized template 
 * 
 * WARNING:
 * Ensure that -help is called only from Command line, as after calling this command the system exits, 
 * which might cause unforeseen consequences.
 *  
 * @author Pushkar, D Kuruppath
 *
 */
public class HazelCastConfigGenerator {
	
	private String api_endpoint;
	private String api_key;
	private String template_file_name;
	private String target_file_name;
	private String envSname;
	private Integer datasetId;
	
	public HazelCastConfigGenerator(String api_endpoint, String api_key, Integer datasetId, String envSname, 
			String template_file_name, String target_file_name){
		super();
		this.api_endpoint = api_endpoint;
		this.api_key = api_key;
		this.envSname = envSname;
		this.template_file_name = template_file_name;
		this.target_file_name = target_file_name;
		this.datasetId = datasetId;
	}

	/**
	 * Method to Generate a HazelCast Configuration XML file
	 * 
	 * @throws Exception
	 */
	public void generateConfiguration() throws Exception {

		CloudConfigClient c = new CloudConfigClient(api_key, api_endpoint, true, datasetId, envSname, CacheProvider.HAZELCAST);
		List<Config> cd = c.getConfigs(datasetId, envSname);
		try {
			
			// Get template file
			File fXmlFile = getfile(template_file_name);
			FileReader fr = new FileReader(fXmlFile);
			BufferedReader br = new BufferedReader(fr);
			String s;
			String totalStr = "";
			
			// Read template file
			while ((s = br.readLine()) != null) {
				totalStr += s;
			}

			// replace tokens appropriately
			for (Config config : cd) {
				String keyToSearch = "$" + config.getKey();
				if (totalStr.contains(keyToSearch))
					totalStr = totalStr.replace(keyToSearch, config.getValue());
			}

			
			// Generate target file
			File hazleFile = getfile(target_file_name);
			FileWriter fw = new FileWriter(hazleFile);
			fw.write(totalStr);
			fw.flush();	
			fw.close();
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(hazleFile);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(hazleFile);
			transformer.transform(source, result);

			System.out.println("**  Hazelcast Configuration XML generation Complete ***. Check File: " + target_file_name);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			throw pce;
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
			throw tfe;
		} catch (Exception e){
			// Any other exception - file permission exceptions etc.
			throw e;
		}
	}


	
	private File getfile(String filename) {
		//ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(filename);
		return file;
	}
}
