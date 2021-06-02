package pe.com.mibanco.serviceManagement.chatbot.constantes;

public enum ChatbotHttpStatus {
	
	NOT_FOUND_USER(4001, "No se encontró el usuario"),
	NOT_FOUND_ISSUE(4002, "No se encontró incidencia"),
	
	FOUND_USER(2001, "Usuario encontrado"),
	FOUND_ISSUES(2002),
	FOUND_LAST_COMMENT(2003),
	FOUND_RESPONSIBLE(2004),
	STATUS_TICKET(2005);
	

	private final int statusCode;
	private final String reason;

	private ChatbotHttpStatus(int statusCode) {
		this.statusCode = statusCode;
		this.reason = "";
	}
	
	private ChatbotHttpStatus(int statusCode, String reason) {
		this.statusCode = statusCode;
		this.reason = reason;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getReason() {
		return reason;
	}
	

}
