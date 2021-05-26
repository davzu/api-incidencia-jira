package pe.com.mibanco.serviceManagement.chatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mibanco.serviceManagement.chatbot.dao.IncidenciaDao;
import pe.com.mibanco.serviceManagement.chatbot.dto.IncidenciaJira;
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
	
	

}
