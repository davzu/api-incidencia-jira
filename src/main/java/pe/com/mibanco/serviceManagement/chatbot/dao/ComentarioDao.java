package pe.com.mibanco.serviceManagement.chatbot.dao;

import pe.com.mibanco.serviceManagement.chatbot.dto.ComentarioJira;

public interface ComentarioDao {
	
	public ComentarioJira obtenerUltimoComentario(String orderKey);

}
