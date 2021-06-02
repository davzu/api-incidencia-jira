package pe.com.mibanco.serviceManagement.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mibanco.serviceManagement.chatbot.bean.ChatbotResponse;
import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.UsuarioJira;
import pe.com.mibanco.serviceManagement.chatbot.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value="/{email}")
	public ResponseEntity<ChatbotResponse> obtenerUsuario(@PathVariable String email) {
		UsuarioJira usuarioJira = usuarioService.obtenerUsuarioPorEmail(email);
		
		ChatbotResponse chatbotResponse = new ChatbotResponse(ChatbotHttpStatus.FOUND_USER.getStatusCode(),
																ChatbotHttpStatus.FOUND_USER.getReason(), 
																usuarioJira);
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}

}
