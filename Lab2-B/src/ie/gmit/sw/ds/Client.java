package ie.gmit.sw.ds;

import java.io.*;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;

public class Client {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String getOrderAsXML = "xml";
		String getOrderAsJSON = "json";

		try {
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds");
			PurchaseOrder po = null;
			Object response = getResponse(getOrderAsXML);
			String responseString = (String) response;
			StringReader sr = new StringReader(responseString);

			// Unmarshal the XML into a PurchaseOrder Object
			Unmarshaller um = jc.createUnmarshaller();
			po = (PurchaseOrder) JAXBIntrospector.getValue(um.unmarshal(sr));
			System.out.println("\n\n######## XML Unmarshalling #######\n" + po.getOrderNumber());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Object getResponse(String request) throws Exception {
		Socket s = new Socket("127.0.0.1", 9999);
		ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
		output.writeObject(request);
		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
		Object response = in.readObject();
		s.close();
		return response;
	}
}
