package com.cloud.configs.hazelcastconfiggenerator;

import java.util.List;
import configs.cloud.client.CloudConfigClient;
import configs.cloud.client.entity.Config;
import configs.cloud.client.enums.CacheProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class HazleCast {
	
	private static final String API_KEY = "ZXY4c2tsMk8wYm9jMFRGZ2RyRWoy";
	private static final String API_ENDPOINT = "http://localhost:8080";

	public static void main(String[] args) throws Exception {

		CloudConfigClient c = new CloudConfigClient(API_KEY, API_ENDPOINT, true, 2, "test", CacheProvider.HAZELCAST);
		List<Config> cd = c.getConfigs(2, "test");
		try {
			HazleCast obj = new HazleCast();
			
			File fXmlFile = obj.getfile("hazelcast-template.xml");
			FileReader fr = new FileReader(fXmlFile);
			BufferedReader br = new BufferedReader(fr);
			String s;
			String totalStr = "";
			while ((s = br.readLine()) != null) {
				totalStr += s;
			}

			for (Config config : cd) {
				if (totalStr.contains("$" + config.getKey()))
					totalStr = totalStr.replace("$" + config.getKey(), config.getValue());
			}

			File hazleFile = obj.getfile("hazelcast.xml");
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

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	
	private File getfile(String filename) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());
		return file;
	}
}
