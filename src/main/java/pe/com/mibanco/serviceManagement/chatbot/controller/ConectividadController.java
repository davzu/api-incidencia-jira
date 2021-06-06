package pe.com.mibanco.serviceManagement.chatbot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mibanco.serviceManagement.chatbot.bean.ChatbotResponse;
import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;

@RestController
@RequestMapping(value = "/conectividad")
public class ConectividadController {

	@GetMapping(value = "/test")
	public ResponseEntity<ChatbotResponse> probarConectivdadApi() {
		ChatbotResponse chatbotResponse = new ChatbotResponse(ChatbotHttpStatus.API_CONNECTION_OK.getStatusCode(), 
																ChatbotHttpStatus.API_CONNECTION_OK.getReason());
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}
	
}
