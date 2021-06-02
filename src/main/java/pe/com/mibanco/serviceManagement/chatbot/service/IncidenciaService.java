package pe.com.mibanco.serviceManagement.chatbot.service;

import java.util.List;

import pe.com.mibanco.serviceManagement.chatbot.model.jira.IncidenciaJira;

public interface IncidenciaService {
	
	public IncidenciaJira obtenerIncidencia(String key);
	
	public IncidenciaJira obtenerIncidenciaCampo(String key, String fieldName);
	
	public List<IncidenciaJira> obtenerIncidenciasPorUsuario(String usuario);
	

}
