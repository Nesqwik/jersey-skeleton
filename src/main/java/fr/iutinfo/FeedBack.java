package fr.iutinfo;

public class FeedBack {
	private int success;
	private String message;

	public FeedBack(int success, String message) {
		this.message = message;
		this.success = success;
	}
	
	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		return success + " : " + message;
	}
	
}
