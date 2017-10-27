package gmit;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FileService extends Remote {
	// getFile(): takes the requested file name as an argument, and returns the
	// file as a byte array
	public byte[] getFile(String fileName) throws RemoteException;

	// getFileNames():returns a list of the names of all files hosted by the
	// service
	public ArrayList<String> getFileName() throws RemoteException;

	public void uploadFile(String fileName, byte[] data) throws RemoteException;

}
