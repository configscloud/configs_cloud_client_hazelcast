@echo off
rem ==============================================
rem @Author : Kuruppath
rem
rem This batch file creates a Hazelcast XML file based on 
rem configurations from the Hazelcast Configurations on the 
rem configs.cloud server
rem
rem Uses Java Client. Assumes Maven is used for compilation.  
rem Assumes Code is compiled under %CLIENT_PATH% 
rem
rem ==============================================
rem Modify paths below as per your local settings
rem 
set CLIENT_PATH=C:\WorkArea\configs_cloud_github_repos\configs_cloud_client_hazelcast
set HZC_TEMPLATE=%CLIENT_PATH%\templates\hazelcast-template.xml
set REPO_PATH=%appdata%\..\..\.m2\repository\
rem ==============================================

SET CURRENT_PATH=%~dp0
if not exist "%CLIENT_PATH%\output" mkdir %CLIENT_PATH%\output

set CLASSPATH=%REPO_PATH%\cloud\configs\ConfigsCloudClient\1.1\ConfigsCloudClient-1.1.jar;%REPO_PATH%\com\sun\xml\bind\jaxb-impl\2.2.11\jaxb-impl-2.2.11.jar;%REPO_PATH%\com\sun\xml\bind\jaxb-core\2.2.11\jaxb-core-2.2.11.jar;.;%REPO_PATH%\javax\ws\rs\jsr311-api\1.1.1\jsr311-api-1.1.1.jar;%REPO_PATH%\com\sun\jersey\jersey-core\1.8\jersey-core-1.8.jar;%REPO_PATH%\com\sun\jersey\jersey-client\1.8\jersey-client-1.8.jar;%REPO_PATH%\com\sun\jersey\contribs\jersey-apache-client4\1.17.1\jersey-apache-client4-1.17.1.jar;%REPO_PATH%\org\apache\httpcomponents\httpclient\4.0-beta1\httpclient-4.0-beta1.jar;%REPO_PATH%\com\fasterxml\jackson\core\jackson-annotations\2.4.4\jackson-annotations-2.4.4.jar;%REPO_PATH%\com\fasterxml\jackson\core\jackson-core\2.4.4\jackson-core-2.4.4.jar;%REPO_PATH%\com\fasterxml\jackson\core\jackson-databind\2.4.4\jackson-databind-2.4.4.jar;%REPO_PATH%\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;%REPO_PATH%\org\slf4j\slf4j-log4j12\1.7.25\slf4j-log4j12-1.7.25.jar;%REPO_PATH%\net\sf\ehcache\ehcache\2.9.0\ehcache-2.9.0.jar;%REPO_PATH%\junit\junit\4.12\junit-4.12.jar;%REPO_PATH%\org\springframework\spring-test\4.3.2.RELEASE\spring-test-4.3.2.RELEASE.jar;%REPO_PATH%\org\hamcrest\hamcrest-library\1.3\hamcrest-library-1.3.jar;%REPO_PATH%\com\jayway\jsonpath\json-path\2.2.0\json-path-2.2.0.jar;%REPO_PATH%\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;%REPO_PATH%\com\hazelcast\hazelcast\3.2\hazelcast-3.2.jar;%REPO_PATH%\com\hazelcast\hazelcast-client\3.2\hazelcast-client-3.2.jar;%REPO_PATH%\log4j\log4j\1.2.12\log4j-1.2.12.jar;


rem Call CLI Client to generate output
rem Assumption : Code has been compiled (using Maven)
cd %CLIENT_PATH%\target\classes

rem java cloud.configs.hazelcast.configtemplate.CLIMain [server_url] [api_key] [dataset_id] [env_shortname] [template_file_name] [target_file_name]
java cloud.configs.hazelcast.configtemplate.CLIMain http://localhost:8080 NUFYUG0xOGNqUjhwMUxidEhpRloy 8 test  %HZC_TEMPLATE% %CLIENT_PATH%\output\hazelcastDemo.xml

cd %CURRENT_PATH%
