package configs.cloud.client;

import java.util.List;

import org.apache.log4j.Logger;

import configs.cloud.client.entity.Config;
import configs.cloud.client.enums.CacheProvider;

/**
 * Demo class showing use of library
 * 
 * @author Pushkar
 *
 */
public class Main {

	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	private static final String API_KEY = "ZXY4c2tsMk8wYm9jMFRGZ2RyRWoy";
	private static final String API_ENDPOINT = "http://localhost:8080";
	
	public static void main(String[] args) throws Exception {
		
		String s = "N";
		CloudConfigClient c = new CloudConfigClient(API_KEY, API_ENDPOINT, true,2,"all",CacheProvider.HAZELCAST);

		/*logger.debug("Calling : getDatasets");
		List<Dataset> datasets = c.getDatasets();
		logger.debug("Dataset size : " + datasets.size());
		
		logger.debug("Calling : getDataset");
		Dataset dataset = c.getDataset(datasets.get(0).getDatasetid());
		logger.debug("Dataset : " + dataset.getDatasetname());
		
		logger.debug("Calling : getEnvironments");		
		List<Env> envs = c.getEnvironments();
		logger.debug(" Env size : " + envs.size());
		*/
		logger.debug("Calling : getConfigs");
		List<Config> cd = c.getConfigs(2);
		logger.debug(" Config size : " + cd.size());
		
		logger.debug("Calling : getConfigs");
		 cd = c.getConfigs(2);
		logger.debug(" Config size : " + cd.size());
		
		logger.debug("Calling : getConfigValue");
		String configKey = c.getConfigValue("sonar.projectKey");
		logger.debug(" config key : " + configKey);
		
		logger.debug("Calling : getConfig(key)");
		Config config = c.getConfig("sonar.projectKey");
		logger.debug(" config : " + config);

		logger.debug("Calling : getConfig(env,key)");
		Config config1 = c.getConfig("all", "sonar.projectKey");
		logger.debug(" config : " + config1);
	
		logger.debug("Calling : getConfig(env)");
		List<Config> configs = c.getConfigs("all");
		logger.debug(" config size: " + configs.size());

		logger.debug("Calling : searchConfigs");
		List<Config> searchconfigs = c.searchConfigs("configid==2,key==log4j.*;ispassword==N");
		logger.debug(" search config size: " + searchconfigs.size());

		logger.debug("Calling : searchConfigs(query,iqk)");
		List<Config> searchconfigs1 = c.searchConfigs("configid==2,key==log4j.*;ispassword==N",true);
		logger.debug(" search config size: " + searchconfigs1.size());

		logger.debug("Calling : updateConfig");
		boolean result=c.updateConfig("sonar.projectKey", "update from sdk123");
		logger.debug(" update config: " + result);

		/*logger.debug("Calling : updateConfig(key,inenabled)");
		boolean result1=c.updateConfig("sonar.projectKey", s.charAt(0));
		logger.debug(" update config: " + result1);
*/
		/*logger.debug("Calling : getDatasets");
		List<Dataset> dset=c.getDatasets();
		logger.debug(" dataset size: " + dset.size());

		logger.debug("Calling : getDatasets(datasetid)");
		Dataset dset1=c.getDataset(2L);
		logger.debug(" dataset size: " + dset1);

		logger.debug("Calling : getEnvironments");
		List<Env> environments = c.getEnvironments();
		logger.debug(" environment size: " + environments.size());
		
		logger.debug("Calling : getEnvironment(envname)");
		Env env = c.getEnvironment("all");		
		logger.debug(" environment : " + env.getName());*/

	}
}