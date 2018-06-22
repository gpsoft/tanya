package jp.dip.gpsoft.tanya.model;

public class DiaryEntry {

	private String comment;
	private String timestamp;

	public DiaryEntry(String comment, String timestamp) {
		this.comment = comment;
		this.timestamp = timestamp;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
