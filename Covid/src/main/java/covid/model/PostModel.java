package covid.model;

public class PostModel {
	private String title;
	private String body;
	private String UserID;	
	private int id;
	
	public PostModel() {
		
	}
	
	public PostModel(String title, String body, String userID, int id) {
		super();
		this.title = title;
		this.body = body;
		this.UserID = userID;
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getUserID() {
		return UserID;
	}
	
	public void setUserID(String userID) {
		UserID = userID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
