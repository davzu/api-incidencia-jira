package pe.com.mibanco.serviceManagement.chatbot.constantes;

public enum ChatbotHttpStatus {
	
	NOT_FOUND_ISSUE(4001, "No se encontró incidencia");

	private final int statusCode;
	private final String reason;

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
