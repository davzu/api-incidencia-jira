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
import pe.com.mibanco.serviceManagement.chatbot.dto.ComentarioJira;
import pe.com.mibanco.serviceManagement.chatbot.dto.IncidenciaJira;
import pe.com.mibanco.serviceManagement.chatbot.service.ComentarioService;
import pe.com.mibanco.serviceManagement.chatbot.service.IncidenciaService;

@RestController
@RequestMapping(value = "/incidencia")
public class IncidenciaController {

	@Autowired
	private IncidenciaService incidenciaService;
	
	@Autowired
	private ComentarioService comentarioService;

	@GetMapping(value = "/{key}")
	public ResponseEntity<IncidenciaJira> obtenerIncidencia(@PathVariable String key) {
		IncidenciaJira incidenciaJira = incidenciaService.obtenerIncidencia(key);
		return new ResponseEntity<IncidenciaJira>(incidenciaJira, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{key}/estado")
	public ResponseEntity<ChatbotResponse> obtenerEstadoIncidencia(@PathVariable String key) {
		IncidenciaJira incidenciaJira = incidenciaService.obtenerIncidencia(key);
		ChatbotResponse chatbotResponse = new ChatbotResponse(ChatbotHttpStatus.STATUS_TICKET.getStatusCode(), 
																incidenciaJira.getFields().getStatus().getName(), 
																incidenciaJira.getFields().getStatus());
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}
	
	@GetMapping(value="/{key}/ultimo-comentario")
	public ResponseEntity<ChatbotResponse> obtenerUltimoComentario(@PathVariable String key) {
		ComentarioJira comentarioJira = comentarioService.obtenerUltimoComentario(key);
		String mensaje = comentarioJira.getComentario() + 
				"\r\nCreado: " + comentarioJira.getFechaCreacion() + 
				"\r\nAutor: " + comentarioJira.getAutor();
		
		ChatbotResponse chatbotResponse = new ChatbotResponse(ChatbotHttpStatus.FOUND_LAST_COMMENT.getStatusCode(), 
																mensaje, 
																comentarioJira);
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}

}
