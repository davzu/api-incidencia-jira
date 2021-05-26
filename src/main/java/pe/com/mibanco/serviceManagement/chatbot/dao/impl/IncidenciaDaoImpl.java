package pe.com.mibanco.serviceManagement.chatbot.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pe.com.mibanco.serviceManagement.chatbot.dao.IncidenciaDao;
import pe.com.mibanco.serviceManagement.chatbot.dto.IncidenciaJira;
import pe.com.mibanco.serviceManagement.chatbot.restError.IssueErrorHandler;
import pe.com.mibanco.serviceManagement.chatbot.util.ConexionJira;

@Repository
public class IncidenciaDaoImpl implements IncidenciaDao {
	
	@Autowired
	private ConexionJira conexionJira;
	
	@Override
	public IncidenciaJira obtenerIncidencia(String key) {
		String url = conexionJira.getJiraApiUrlBase() + "/issue/{key}";
		Map<String, String> varsPath = new HashMap<>();
		varsPath.put("key", key);

		HttpEntity<String> request = new HttpEntity<>(conexionJira.getHttpHeaders());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new IssueErrorHandler());
		ResponseEntity<IncidenciaJira> response = 
				restTemplate.exchange(url, HttpMethod.GET, request, IncidenciaJira.class, varsPath);

		IncidenciaJira incidenciaJira = response.getBody();

		return incidenciaJira;
	}

}
