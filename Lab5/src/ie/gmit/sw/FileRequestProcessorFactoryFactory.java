package ie.gmit.sw;

import org.apache.xmlrpc.*;
import org.apache.xmlrpc.server.*;
public class FileRequestProcessorFactoryFactory implements RequestProcessorFactoryFactory {
	/*
	A request processor is a handler that actually executes a request. It is analogous to a
	remote object in RMI and can also be referred to as a service implementation. The handler
	mapping uses this factory to create instances of RequestProcessorFactoryFactory.RequestProcessorFactory.
	The interface RequestProcessorFactoryFactory (horrible name!) is implemented by classes that are
	effectively playing the role of an abstract factory. 
	*/

    private final RequestProcessorFactory factory = new FileRequestProcessorFactory(); //Eager singleton (Highlander Principle)
    private final FileHandler fh; //Composed instance of the handler

    public FileRequestProcessorFactoryFactory(FileHandler handler) {
		this.fh = handler;
    }

	//Abstract factory method
    public RequestProcessorFactory getRequestProcessorFactory(Class c) throws XmlRpcException {
		return factory;
    }

	//This is the inner factory class
	private class FileRequestProcessorFactory implements RequestProcessorFactory {
		public Object getRequestProcessor(XmlRpcRequest xmlRpcRequest) throws XmlRpcException {
			return fh;
		}
	}
}