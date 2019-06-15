
public class MartenData {

	private String time;
	private String tagID;
	private String photoCount;
	
	public MartenData() {
		
		this.time = null;
		this.tagID = null;
		this.photoCount = null;
		
	}
	
	public void insertAll(String[] row) {
		
		this.time = row[0];
		this.tagID = row[1];
		this.photoCount = row[2];
		
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTagID() {
		return tagID;
	}
	
	public void setTagID(String tagID) {
		this.tagID = tagID;
	}
	
	public String getPhotoCount() {
		return photoCount;
	}
	
	public void setPhotoCount(String photoCount) {
		this.photoCount = photoCount;
	}
	
}
