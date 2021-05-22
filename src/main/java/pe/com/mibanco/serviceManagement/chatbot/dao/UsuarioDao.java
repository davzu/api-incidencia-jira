package pe.com.mibanco.serviceManagement.chatbot.dao;

import pe.com.mibanco.serviceManagement.chatbot.model.UsuarioJira;

public interface UsuarioDao {

	public UsuarioJira obtenerUsuarioPorEmail(String email);
	
}
