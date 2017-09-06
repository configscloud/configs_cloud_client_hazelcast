# configs_cloud_client_hazelcast
Client for Hazelcast Configuration Generator

## Functionality
This is a client codebase which uses Configs.Cloud Server to store all configuration data & relies on the Configs.Cloud Java client to retrieve its value and use it to generate a Hazelcast cache config XML file.  This codebase can be used in scenarios when there are multiple caches in a organization and needs to be managed from a single location.

## Implementations
The following two implementations are available:
1. Using a template based implementation
This is a simpler yet powerful implementation which allows enterprises to model a Cache configuration based on organizational standards (usually by a CoE) and then present as a XML template. The values in these XML template can be modified on Configs.Cache hosted service and the XML files generated. **NOTE:** Currently only this implementation is available. The JAXB based implementation (below) is under build.

2. Using JAXB based implementation. 
This is a more complex Implementation, which allows a user to add / modify the XML elements as they need and generate the Hazelcast config XML based on the choices added. 

## Step 1: Clone (or) Download
Clone this repo to a local directory to build the same using Maven (or) pull the pre-built jar file from central repo.
This client uses JDK 1.8

## Step 2: Build
If you have decided to clone the codebase, then execute a maven build in order to pull all the dependent jars from central Maven repositories

## Step 3: Configure 
The template based implementation is invokable via CLI only as of current release version. 
As the first step (after cloning) modify the batch file path - createHazelcastConfig.bat (or).sh directly under the repo  with paths as necessary. Follow comments in the file for more direction on paths.

## Step 4: Configure Hazelcast Template
Configure the templates under "templates" path in the downloaded repo as needed.

## Step 5: Configure properties in Configs.Cloud
Either clone an existing dataset with Hazelcast entries, or, create a new dataset and import the hazelcast entries into this dataset.
Configure values of configurations as needed.

## Step 6: Execute and Generate Hazelcast Configuration XML
Execute createHazelcastConfig.bat (or).sh file to generate the XML. 

Either contact via communities link (or) via github issues (or) via email to info@configs.cloud in case of any questions or issues. 




