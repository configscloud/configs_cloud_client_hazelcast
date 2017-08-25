package cloud.configs.hazelcast.configtemplate;

public class CLIMain {
	
	private static String api_endpoint;
	private static String api_key;
	private static String template_file_name;
	private static String target_file_name;
	private static String envSname;
	private static Integer datasetId;
	
	// CLI Commands 
	private static final Object HELP = "-help";

	public static void main(String[] args) throws Exception {
		
		// Collect arguments with CLI
		processArgs(args);
		
		// Initiate generation of XML file
		HazelCastConfigGenerator hccg = new HazelCastConfigGenerator(api_endpoint, api_key, datasetId, envSname, template_file_name, target_file_name);
		hccg.generateConfiguration();
	}

	
	// Process Incoming arguments.
	private static void processArgs(String[] args) throws Exception {
		if (args == null){
			throw new Exception("No Arguments Found. Execute - HazelCastConfigGenerator -help for Usage");
		} else {
			if (args.length <= 5) {
				Usage();
				throw new Exception ("Insufficient number of Arguments. Refer Console output for Usage.");
			}
			for (int i=0; i< args.length;i++){
				switch (i){ 
					case 0:
						if (args[0].equals(HELP)) {
							// WARNING : Assuming that HELP will only be called via command line
							// change this if thats not the case, otherwise your JVM will exit
							// and return unforeseen consequences
							Usage();
							System.exit(1);
						} else {
							api_endpoint = args[i];
						}
						break;
					case 1:
						api_key = args[i];
						break;
					case 2:
						datasetId = Integer.parseInt(args[i]);
						break;
					case 3:
						envSname = args[i];
						break;
					case 4:
						template_file_name = args[i];
						break;
					case 5:
						target_file_name = args[i];
						break;
					
				}
			} //end for 
		}
	}


	private static void Usage() {
		System.out.println("  ... ");
		System.out.println("  ... Call as: ");
		System.out.println("  ... HazelCastConfigGenerator [-help] [server_url] [api_key] [dataset_id] [env_shortname] [template_file_name] [target_file_name]");
		System.out.println("  ... ");
		System.out.println("  ... -help : To view this Help text");
		System.out.println("  ... ");
		System.out.println("  ... server_url : URL of the hosted Configs.Cloud app. For e.g. http://app.configs.cloud");
		System.out.println("  ... api_key    : API Key for your username from Configs.Cloud app For e.g. ZXYrc2tsMk8wYm9jMFRGZ2RyRWoy");
		System.out.println("  ... dataset_id : Dataset id to read configs from. Is an integer for e.g. 24");
		System.out.println("  ... env_shortname  : Environment short name in the dataset for e.g. all, test, dev etc.");
		System.out.println("  ... template_file_name : Complete path (including file name) of the template file to be used");
		System.out.println("  ... target_file_name : Complete path (including file name) of the generated file");
		System.out.println("  ... ");
		System.out.println("  NOTE: Except file names and server URL, all other values to be obtained from Configs.Cloud hosted instance. ");
		System.out.println("  ... ");
		
	}
}
