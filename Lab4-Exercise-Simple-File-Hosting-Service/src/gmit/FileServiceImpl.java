package gmit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FileServiceImpl extends UnicastRemoteObject implements FileService {

	private static final long serialVersionUID = 1L;
	private File file;

	public FileServiceImpl(File f) throws RemoteException {
		this.file = f;
	}

	public File getFile() throws RemoteException {
		return file;
	}

	// request file name as an argument
	public byte[] getFile(String fileName) throws RemoteException {
		byte[] bytes = null;
		try {
			// HNIT: to read a file to a byte array.
			bytes = Files.readAllBytes(new File("/clientFiles/filename.txt").toPath());
		} catch (IOException e) {

			e.printStackTrace();
		}
		// returns the file as a byte array
		return bytes;
	}

	// uploadFile()
	public byte[] uploadFile(String fileName) {
		byte[] bytes = null;
		try {
			FileOutputStream stream = new FileOutputStream("/clientFiles/uploadFile.txt");
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bytes;
	}

	@Override
	public ArrayList<String> getFileName() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void uploadFile(String fileName, byte[] data) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
