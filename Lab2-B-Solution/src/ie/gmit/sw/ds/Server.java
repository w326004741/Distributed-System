package ie.gmit.sw.ds;

import java.net.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import com.sun.jersey.api.json.JSONMarshaller;

import java.io.*;
import java.math.BigDecimal;

public class Server {
	private static final int SERVER_PORT = 9999;
	private ServerSocket server = null;
	private Socket clientRequest = null;
	private boolean blnKeepRunning;
	private Listener listener;
	private PurchaseOrder po;

	public Server(){

		init();
		blnKeepRunning = true;
		
		try {
			getOrderAsXML();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			server = new ServerSocket(SERVER_PORT);	
			listener = new Listener();
			listener.start();

			System.out.println("[INFO] Service started on port " + SERVER_PORT);
		}catch(Exception e){			
			e.printStackTrace();	
		}
		
	}

	private void init() {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date(System.nanoTime()));
		XMLGregorianCalendar date = null;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		ObjectFactory objFactory = new ObjectFactory();

		po = objFactory.createPurchaseOrder();
		po.setOrderNumber("55522-BABA");
		po.setOrderDate(date);

		Address shipTo = new Address();
		shipTo.setName("John Doe");
		shipTo.setStreet("123 Castle Road");
		shipTo.setCity("Oranmore");
		shipTo.setCounty("Galway");
		shipTo.setCountry(Country.IRELAND);
		po.setShipTo(shipTo);
		po.setBillTo(shipTo);

		Items items = new Items();
		po.setItems(items);
		List<Items.Item> col = items.getItem();
		Items.Item i1 = new Items.Item();
		i1.setPartNumber("123ABC");
		i1.setProductName("11ft Trout Fly Road");
		i1.setQuantity(1);
		i1.setPrice(new BigDecimal("250.00"));
		i1.setShipDate(date);
		col.add(i1);


		Items.Item i2 = new Items.Item();
		i2.setPartNumber("177AAA");
		i2.setProductName("14ft Salmon Fly Road");
		i2.setQuantity(1);
		i2.setPrice(new BigDecimal("450.00"));
		i2.setShipDate(date);
		col.add(i2);
	}

	private String getOrderAsXML() throws Exception{
		// Marshal the PurchaseOrder in XML
		JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds");
		StringWriter sw = new StringWriter();
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(po, sw);
		return sw.toString();
	}
	
	private String getOrderAsJSON() throws Exception{
		// Marshal the PurchaseOrder in JSON
		JSONJAXBContext ctx = new JSONJAXBContext(JSONConfiguration.natural().build(), po.getClass());
		JSONMarshaller jm = ctx.createJSONMarshaller();
		jm.setProperty(JSONMarshaller.FORMATTED, true);
		StringWriter sw = new StringWriter();
		jm.marshallToJSON(po, sw);		
		return sw.toString();
	}



	public static void main(String[] args) {
		new Server();
	}


	class Listener extends Thread{
		public void run(){
			try{
				while(blnKeepRunning){
					//Accept incoming socket request
					clientRequest = server.accept();

					//Deserialize the socket input stream into a String
					InputStream inputStream = clientRequest.getInputStream();
					ObjectInputStream oin = new ObjectInputStream(inputStream);

					OutputStream outStream = clientRequest.getOutputStream();
					ObjectOutputStream out = new ObjectOutputStream(outStream);

					String command = (String) oin.readObject();

					System.out.println("[INFO] Received " + command + " from " + clientRequest.getInetAddress());

					Object request = null;

					if(command.equals("xml")){ //An XML request
						request = getOrderAsXML();
					}
					else if (command.equals("json")) { //A JSON request
						request = getOrderAsJSON();
					}

					out.writeObject(request);
					out.close();
				}		
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
