package com.jaxb.main;

import java.io.File;
import javax.xml.bind.*;

import com.jaxb.pojo.Address;
import com.jaxb.pojo.Employee;

public class ConversionMain {

	public static String pathName = "C:/Users/dharshna.mala/Desktop/AU_Training/Week3-ppt/Assignments/EmployeeXml.xml";

	private void marshalingExample(Employee e) {
		try {

			File file = new File(pathName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(e, file);
			jaxbMarshaller.marshal(e, System.out);

		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

	private void unMarshalingExample() {
		try {

			File file = new File(pathName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Employee emp = (Employee) jaxbUnmarshaller.unmarshal(file);
			System.out.println(emp);

		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Address ad = new Address("Vellore", "TN", 612321);
		Employee emp = new Employee(3610, "Sivagami", "Sankar", ad);
		ConversionMain cm = new ConversionMain();
		cm.marshalingExample(emp);
		cm.unMarshalingExample();
	}

}
