package pe.com.mibanco.serviceManagement.chatbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mibanco.serviceManagement.chatbot.dao.IncidenciaDao;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.IncidenciaJira;
import pe.com.mibanco.serviceManagement.chatbot.service.IncidenciaService;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {
	
	@Autowired
	private IncidenciaDao incidenciaDao;

	@Override
	public IncidenciaJira obtenerIncidencia(String key) {
		IncidenciaJira incidenciaJira = incidenciaDao.obtenerIncidencia(key);
		return incidenciaJira;
	}

	@Override
	public IncidenciaJira obtenerIncidenciaCampo(String key, String fieldName) {
		IncidenciaJira incidenciaJira = incidenciaDao.obtenerIncidenciaCampo(key, fieldName);
		return incidenciaJira;
	}

	@Override
	public List<IncidenciaJira> obtenerIncidenciasPorUsuario(String usuario) {
		List<IncidenciaJira> incidencias = incidenciaDao.obtenerIncidenciasPorUsuario(usuario);
		return incidencias;
	}

}
