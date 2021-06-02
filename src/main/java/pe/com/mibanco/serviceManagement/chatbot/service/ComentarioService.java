package pe.com.mibanco.serviceManagement.chatbot.service;

import pe.com.mibanco.serviceManagement.chatbot.model.jira.ComentarioJira;

public interface ComentarioService {
	
	public ComentarioJira obtenerUltimoComentario(String orderKey);

}
