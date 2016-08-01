package com.ted.db;

import java.io.File;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.ted.model.Customer;

public class XmlMarshalling {

	@Test
	public void customerMarshalling() {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("Sumeet");
		customer.setAge(22);

		try {
			// Marshalling
			File file = new File("D:\\customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	@Test
	public void customerUnmarshalling() {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Customer.class); //1
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Customer customer = (Customer)unmarshaller.unmarshal(new FileReader("D:\\customer.xml")); //2
			System.out.println("Customer: " + customer.getName()); //3
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

}
