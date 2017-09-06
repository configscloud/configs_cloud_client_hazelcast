package cloud.configs.hazelcast.dynamictemplate.v34;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import cloud.configs.hazelcast.dynamictemplate.v34.schema.Hazelcast;
import cloud.configs.hazelcast.dynamictemplate.v34.schema.ManagementCenter;
import cloud.configs.hazelcast.dynamictemplate.v34.schema.ObjectFactory;

public class HazelCastConfigGenerator {
	

	public static void main(String[] args) {
		
		try {
			ObjectFactory factory = new ObjectFactory(); 
			
			// management-center
			ManagementCenter mc = factory.createManagementCenter();
			mc.setEnabled(true);
			mc.setValue("http://localhost:8090/mancenter");
			mc.setClusterId("ClusterId");
			mc.setSecurityToken("SecurityToken");
			mc.setUpdateInterval(new BigInteger("1"));
			
			// give the class path of schema folder
			JAXBContext jaxbContext = JAXBContext.newInstance("cloud.configs.hazelcast.dynamictemplate.v34.schema", Thread.currentThread().getContextClassLoader());
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			// parent 
			Hazelcast hzc = factory.createHazelcast();			
			hzc.setId("HazelCastId");
			
			// add object to parent
			hzc.getImportOrGroupOrLicenseKey().add(mc);
			
			// output file paths
			marshaller.marshal(hzc, new FileOutputStream("E:\\hzc.xml"));
			
		} catch (JAXBException e) {			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
