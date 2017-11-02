package ie.gmit.sw;

import java.io.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.common.*;
import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.*;

public class XMLServer {
	public static void main(String[] args) throws Exception{
		
		try {
			new XMLServer();
		} catch (IOException e) {
			System.out.println("Could not start server: " + e.getMessage());
		}
	}

	public XMLServer() throws Exception{
		int port = 8080;
		
		System.out.println("[INFO] Starting XML-RPC Server...");

		//Instantiate a new web server to listen as the port number provided as a command line argument
		//WebServer server = new WebServer(Integer.parseInt(args[0]));
		WebServer server = new WebServer(port);

		/* A multithreaded, reusable filter that handles instances of XmlRpcRequest. An instance of 
		   XmlRpcServlet intercepts client requests and dispatches an XmlRpcRequest to the XmlRpcServer.
		 */
		XmlRpcServer xmlRpcServer = server.getXmlRpcServer(); 


		/* The class PropertyHandlerMapping represents a set of key / value pairs, i.e. a map, that relates
		 * the name of a service to a class that implements that service. By default, a new instance of each
		 * imlementing class (called a handler) in generated for each request. A handler can be added using
		 * the following syntax: 		
		 *		
		 *       phm.addHandler("MessageService", ie.gmit.sw.MessageHandler.class);
		 * 
		 * When state must be retained between method invocations, this can be accomplished by implementing 
		 * the interface RequestProcessorFactoryFactory and adding an inner factory class by instantiatiating 
		 * the handler and then specifying the name of the class to handle the request:	
		 *
		 *       MessageHandler mh = new MessageHandler();
		 *       phm.setRequestProcessorFactoryFactory(new MessageRequestProcessorFactoryFactory(mh));
		 * 
		 * Note that the PropertyHandlerMapping acts as a type of "naming service" analogous to the RMIRegistry
		 * and that handlers are based on the Chain of Responsibility pattern.		
		 */		
		PropertyHandlerMapping phm = new PropertyHandlerMapping();

		//Initialise and bind the message service handler
		MessageHandler mh = new MessageHandler();		
		phm.setRequestProcessorFactoryFactory(new MessageRequestProcessorFactoryFactory(mh));
		phm.addHandler("MessageService", ie.gmit.sw.MessageHandler.class);		
		System.out.println("[INFO] MessageService initialised.");

		//Initialise and bind the file service handler
		FileHandler fh = new FileHandler();		
		phm.setRequestProcessorFactoryFactory(new FileRequestProcessorFactoryFactory(fh));
		phm.addHandler("FileService", ie.gmit.sw.FileHandler.class);		
		System.out.println("[INFO] FileService initialised.");

		//Configure the RPC filter with the objects to dispatch requests to
		xmlRpcServer.setHandlerMapping(phm);
		XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
		serverConfig.setEnabledForExtensions(true);
		serverConfig.setContentLengthOptional(false);

		server.start(); //Start the web server
		System.out.println("[INFO] XML-RPC Server running on port " + port);

	}
}