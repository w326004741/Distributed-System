package ie.gmit.sw;

import java.net.*;
import java.io.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;
import org.apache.xmlrpc.client.util.ClientFactory;
public class Client {
	/* Even though XML-RPC solves the problem of heterogeneous interprocess communication, there are a number of 
	   serious deficiencies in the approach that are evident from the code below:
	
	   1) The client (service requestor) is tightly coupled with the server (service provider). Each execute()
	      method below (command pattern...) requires a special syntax using the service-name.method-name.
	
	   2) There is no service interface. Consequently, service requestors have no way of knowing what methods
	      are exposed by the service provider.
	
	   3) The lack of a service interface tighly couples the requestor and provider, thereby eliminating the
	      possibility of using dynamic proxies to provide a degree of location transparency. As a result, the
	      service requestor is required to go through a multistep process to configure, connect and execute a 
	      remote method.
	
	   4) The service requestor has no way of knowing the endpoint (URL) and no way of switching the wire 
	      protocol from HTTP to SMTP or something else. RMI can do this (from JRMP to IIOP) thanks to the
	      encapsulation provided by dynamic stubs and skeletons.
	
	   5) There is no notion of a registry and thus no way of advertising the service interface (which doesn't 
	      exist anyway...).
	
	   6) All methods must be provided with an object array as an argument, even if the method is not parameterised!
	      Moreover, the return type of the execute() method is an object and must be downcast to be useful. This
	      invites a ClassCastException.
	
	   7) There are only six data types to use and XML-RPC does not support the passing of composite objects as
	      method parameters or return types.	
	*/

	public static void main(String args[]) throws Exception{
				
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://127.0.0.1:8080/xmlrpc"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		
		//Get default message from server
		String message = (String) client.execute("MessageService.getMessage", new Object[]{});
		System.out.println(message);		
		
		//Set message
		message = "Omnia mihi lingua graeca sunt!";
		Boolean messageResult = (Boolean) client.execute("MessageService.setMessage", new Object[]{message});
		System.out.println("State of message object changed...");
		
		//Check new message from server
		message = (String) client.execute("MessageService.getMessage", new Object[]{});
		System.out.println(message);

		//Download the file specified, and write it to disk in the clientFiles directory
  		Object result = client.execute("FileService.downloadFile", new Object[]{new String("serverFiles/test.txt")});
		byte fileData[] = (byte[]) result; // cast the return as type byte array
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream("clientFiles/download.txt");
			stream.write(fileData);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[INFO] File downloaded okay....");
	}
}