package ie.gmit.sw.ds;

import java.net.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import com.sun.jersey.api.json.JSONUnmarshaller;

import java.io.*;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String getOrderAsXML = "xml";
		String getOrderAsJSON = "json";

		try{

			PurchaseOrder po = null;

			// request the PurchaseOrder object from the server as XML
			Object responseXML = getResponse(getOrderAsXML);
			String responseXMLString = (String) responseXML;
			StringReader sr = new StringReader(responseXMLString);

			//Unmarshal the XML into a PurchaseOrder Object
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds");
			Unmarshaller um = jc.createUnmarshaller();
			po = (PurchaseOrder) JAXBIntrospector.getValue(um.unmarshal(sr));
			System.out.println("\n\n######### XML Unmarshalling #########\n" + po.getOrderNumber());

			// request the PurchaseOrder object from the server as JSON
			Object responseJSON = getResponse(getOrderAsJSON);
			String responseJSONString = (String) responseJSON;
			sr = new StringReader(responseJSONString);			
					
			//Unmarshal the JSON into a PurchaseOrder Object
			JSONJAXBContext ctx = new JSONJAXBContext(JSONConfiguration.natural().build(), po.getClass());
			JSONUnmarshaller jum = ctx.createJSONUnmarshaller();
			po = (PurchaseOrder) jum.unmarshalFromJSON(sr, po.getClass());
	 	   	System.out.println("\n\n######### JSON Unmarshalling #########\n" + po.getOrderNumber());


		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static Object getResponse(String request) throws Exception{
		Socket s = new Socket("127.0.0.1", 9999);
		ObjectOutputStream output= new ObjectOutputStream(s.getOutputStream());
		output.writeObject(request);
		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
		Object response =  in.readObject();		
		s.close();
		return response;
	}

}
