package pe.com.mibanco.serviceManagement.chatbot.dao;

import java.util.List;

import pe.com.mibanco.serviceManagement.chatbot.model.jira.IncidenciaJira;

public interface IncidenciaDao {

	public IncidenciaJira obtenerIncidencia(String key);

	public IncidenciaJira obtenerIncidenciaCampo(String key, String fieldName);
	
	public List<IncidenciaJira> obtenerIncidenciasPorUsuario(String usuario);

}
