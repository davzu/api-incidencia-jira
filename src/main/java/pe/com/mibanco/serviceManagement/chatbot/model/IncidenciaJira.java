package pe.com.mibanco.serviceManagement.chatbot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidenciaJira {

	private int id;
	private String key;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return "IncidenciaJira [id=" + id + ", key=" + key + "]";
	}
	
}
