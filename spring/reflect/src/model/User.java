package model;

public class User {
/*
 * id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `desvribe` varchar(255) NOT NULL
 */
	private int id;
	private String type;
	private String desvribe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesvribe() {
		return desvribe;
	}
	public void setDesvribe(String desvribe) {
		this.desvribe = desvribe;
	}
}
