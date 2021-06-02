package pe.com.mibanco.serviceManagement.chatbot.model.jira;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidenciaJira {

	private int id;
	private String key;
	private FieldJira fields;
	
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
	public FieldJira getFields() {
		return fields;
	}
	public void setFields(FieldJira fields) {
		this.fields = fields;
	}
	
}
