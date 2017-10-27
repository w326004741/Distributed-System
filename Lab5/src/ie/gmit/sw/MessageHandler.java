package ie.gmit.sw;

public class MessageHandler{
	private String message = "Lorem ipsum dolor sit amet";

	public MessageHandler(){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}

	public boolean setMessage(String message){
		this.message = message;
		return true;
	}
}