package fr.mediashare.model;

public class FeedBack {
	private boolean success;
	private String message;

	public FeedBack() {}
	
	public FeedBack(boolean success, String message) {
		this.message = message;
		this.success = success;
	}
	
	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
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
