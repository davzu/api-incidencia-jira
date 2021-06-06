package pe.com.mibanco.serviceManagement.chatbot.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatbotResponse {
	
	@JsonIgnore
	private int code;
	
	@JsonIgnore
	private String message;
	
	@JsonIgnore
	private Object data;
	
	public ChatbotResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ChatbotResponse(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	@JsonProperty(value = "set_attributes")
	public Map<String, Object> getAttributes() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("code", code);
		map.put("message", message);
		
		return map;
	}
	

}
