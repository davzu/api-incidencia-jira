package pe.com.mibanco.serviceManagement.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mibanco.serviceManagement.chatbot.bean.ChatbotResponse;
import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;
import pe.com.mibanco.serviceManagement.chatbot.constantes.Constantes;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.ComentarioJira;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.IncidenciaJira;
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
	
	@GetMapping(value = "/list")
	public ResponseEntity<ChatbotResponse> obtenerIncidencias(@RequestParam String correoUsuario) {
		List<IncidenciaJira> incidencias = incidenciaService.obtenerIncidenciasPorUsuario(correoUsuario);
		String strIncidencias = "";
		for (IncidenciaJira incidencia : incidencias) {
			if(!strIncidencias.isEmpty()) {
				strIncidencias += System.lineSeparator();
			}
			strIncidencias += incidencia.getKey();
		}
		
		ChatbotResponse chatbotResponse = new ChatbotResponse(ChatbotHttpStatus.FOUND_ISSUES.getStatusCode(), 
																strIncidencias, 
																incidencias);
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{key}/estado")
	public ResponseEntity<ChatbotResponse> obtenerEstadoIncidencia(@PathVariable String key) {
		IncidenciaJira incidenciaJira = incidenciaService.obtenerIncidenciaCampo(key, Constantes.FIELD_ISSUE_STATUS);
		ChatbotResponse chatbotResponse = new ChatbotResponse(ChatbotHttpStatus.STATUS_TICKET.getStatusCode(), 
																incidenciaJira.getFields().getStatus().getName(), 
																incidenciaJira.getFields().getStatus());
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{key}/responsable")
	public ResponseEntity<ChatbotResponse> obtenerResponsableIncidencia(@PathVariable String key) {
		IncidenciaJira incidenciaJira = incidenciaService.obtenerIncidenciaCampo(key, Constantes.FIELD_ISSUE_RESPONSIBLE);
		ChatbotResponse chatbotResponse = new ChatbotResponse(
				ChatbotHttpStatus.STATUS_TICKET.getStatusCode(), 
				incidenciaJira.getFields().getAssignee() != null ? incidenciaJira.getFields().getAssignee().getDisplayName()
																: null, 
				incidenciaJira.getFields().getAssignee());
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{key}/ultimo-comentario")
	public ResponseEntity<ChatbotResponse> obtenerUltimoComentario(@PathVariable String key) {
		ComentarioJira comentarioJira = comentarioService.obtenerUltimoComentario(key);
		String mensaje = comentarioJira.getComentario() + System.lineSeparator() +
				"Creado: " + comentarioJira.getFechaCreacion() + System.lineSeparator() +
				"Autor: " + comentarioJira.getAutor();
		
		ChatbotResponse chatbotResponse = new ChatbotResponse(ChatbotHttpStatus.FOUND_LAST_COMMENT.getStatusCode(), 
																mensaje, 
																comentarioJira);
		
		return new ResponseEntity<ChatbotResponse>(chatbotResponse, HttpStatus.OK);
	}

}
