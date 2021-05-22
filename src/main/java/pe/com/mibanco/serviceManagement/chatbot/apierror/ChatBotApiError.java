package pe.com.mibanco.serviceManagement.chatbot.apierror;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ChatBotApiError {
	
	private int code;
	private String reason;
	@JsonIgnore()
	private HttpStatus httpStatus;
	
	public ChatBotApiError(int code, String reason, HttpStatus httpStatus) {
		this.code = code;
		this.reason = reason;
		this.httpStatus = httpStatus;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}	

}
