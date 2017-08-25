package cloud.configs.hazelcast.dynamictemplate.v34;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import cloud.configs.hazelcast.dynamictemplate.v34.schema.Hazelcast;
import cloud.configs.hazelcast.dynamictemplate.v34.schema.ManagementCenter;
import cloud.configs.hazelcast.dynamictemplate.v34.schema.ObjectFactory;


public class HazelCastConfigGenerator {
	
	public static void main(String[] args) {
		
		try {
		    
			JAXBContext jaxbContext=JAXBContext.newInstance("schema", Thread.currentThread().getContextClassLoader());
			
			Marshaller marshaller=jaxbContext.createMarshaller();
			
			ObjectFactory factory=new ObjectFactory(); 
			
			// parent 
			Hazelcast hzc = factory.createHazelcast();
			
			// management-center
			ManagementCenter mc = factory.createManagementCenter();
			mc.setEnabled(true);
			mc.setValue("http://localhost:8090/mancenter");
			
			marshaller.marshal(hzc, new FileOutputStream("c:\\tmp\\configs\\hzc.xml"));
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
