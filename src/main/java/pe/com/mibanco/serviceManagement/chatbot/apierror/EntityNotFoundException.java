package pe.com.mibanco.serviceManagement.chatbot.apierror;

import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;

public class EntityNotFoundException extends ChatbotException {

	public EntityNotFoundException(ChatbotHttpStatus chatbotHttpStatus) {
		super(chatbotHttpStatus);
	}

}
