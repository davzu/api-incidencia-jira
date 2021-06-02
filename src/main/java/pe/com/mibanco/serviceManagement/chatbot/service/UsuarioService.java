package pe.com.mibanco.serviceManagement.chatbot.service;

import pe.com.mibanco.serviceManagement.chatbot.model.jira.UsuarioJira;

public interface UsuarioService {
	
	public UsuarioJira obtenerUsuarioPorEmail(String email);

}
