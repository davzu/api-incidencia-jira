package pe.com.mibanco.serviceManagement.chatbot.dao;

import pe.com.mibanco.serviceManagement.chatbot.dto.IncidenciaJira;

public interface IncidenciaDao {

	public IncidenciaJira obtenerIncidencia(String key);
	
}
