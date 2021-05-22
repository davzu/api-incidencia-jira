package pe.com.mibanco.serviceManagement.chatbot.apierror;

import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;

public class ChatbotException extends RuntimeException {

	protected ChatbotHttpStatus chatbotHttpStatus;

	public ChatbotException(ChatbotHttpStatus chatbotHttpStatus) {
		this.chatbotHttpStatus = chatbotHttpStatus;
	}

	public ChatbotHttpStatus getChatbotHttpStatus() {
		return chatbotHttpStatus;
	}

	public void setChatbotHttpStatus(ChatbotHttpStatus chatbotHttpStatus) {
		this.chatbotHttpStatus = chatbotHttpStatus;
	}
	
	
}
