package pe.com.mibanco.serviceManagement.chatbot.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pe.com.mibanco.serviceManagement.chatbot.dao.IncidenciaDao;
import pe.com.mibanco.serviceManagement.chatbot.model.IncidenciaJira;
import pe.com.mibanco.serviceManagement.chatbot.restError.IssueErrorHandler;
import pe.com.mibanco.serviceManagement.chatbot.util.HttpUtil;

@Repository
public class IncidenciaDaoImpl implements IncidenciaDao {

	@Override
	public IncidenciaJira obtenerIncidencia(String key) {
		String url = "https://davzu.atlassian.net/rest/api/3/issue/{key}";
		Map<String, String> varsPath = new HashMap<>();
		varsPath.put("key", key);

		HttpEntity<String> request = new HttpEntity<>(HttpUtil.getHttpHeaders());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new IssueErrorHandler());
		ResponseEntity<IncidenciaJira> response = 
				restTemplate.exchange(url, HttpMethod.GET, request, IncidenciaJira.class, varsPath);

		IncidenciaJira incidenciaJira = response.getBody();

		return incidenciaJira;
	}

}
