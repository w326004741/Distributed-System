import java.io.*;
import java.util.*;
import java.math.*;
import javax.xml.bind.*;
import javax.xml.datatype.*;
import com.sun.jersey.api.json.*;
import ie.gmit.sw.ds.*;

public class JAXBPOExample {
	public static void main(String[] args) throws Exception{
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date(System.nanoTime()));
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		
		JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds");
		ObjectFactory objFactory = new ObjectFactory();
		
		PurchaseOrder po = objFactory.createPurchaseOrder();
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
		
		// Marshal the PurchaseOrder in XML
		System.out.println("\n\n######### XML Format #########");
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(po, new FileWriter("order.xml"));
		//StringWritter sw = new StringWritter();
		//m.marshal(po, sw);
		//send sw.ToString() over socket
		m.marshal(po, System.out);
		
		
		// Marshal the PurchaseOrder in JSON
		System.out.println("\n\n######### JSON Format #########");
		JSONJAXBContext ctx = new JSONJAXBContext(JSONConfiguration.natural().build(), po.getClass());
		JSONMarshaller jm = ctx.createJSONMarshaller();
		jm.setProperty(JSONMarshaller.FORMATTED, true);
		jm.marshallToJSON(po, new FileWriter("order.json"));
		jm.marshallToJSON(po, System.out);
		

		//Unmarshal the XML into a PurchaseOrder Object
		Unmarshaller um = jc.createUnmarshaller();
		//
		po = (PurchaseOrder) JAXBIntrospector.getValue(um.unmarshal(new File("order.xml")));
		System.out.println("\n\n######### XML Unmarshalling #########\n" + po.getOrderNumber());


		//Unmarshal the JSON into a PurchaseOrder Object
		JSONUnmarshaller jum = ctx.createJSONUnmarshaller();
		po = (PurchaseOrder) jum.unmarshalFromJSON(new FileInputStream("order.json"), po.getClass());
 	   	System.out.println("\n\n######### JSON Unmarshalling #########\n" + po.getOrderNumber());
	}
}