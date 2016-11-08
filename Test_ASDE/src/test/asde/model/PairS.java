package test.asde.model;

public class PairS {
	
	private String user;
	private String message;
	
	public PairS(String u, String m) {
		this.setUser(u);
		this.setMessage(m);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}