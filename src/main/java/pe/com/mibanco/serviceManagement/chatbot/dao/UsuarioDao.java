package pe.com.mibanco.serviceManagement.chatbot.dao;

import pe.com.mibanco.serviceManagement.chatbot.model.jira.UsuarioJira;

public interface UsuarioDao {

	public UsuarioJira obtenerUsuarioPorEmail(String email);
	
}
