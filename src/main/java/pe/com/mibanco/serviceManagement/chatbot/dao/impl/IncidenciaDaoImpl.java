package pe.com.mibanco.serviceManagement.chatbot.dao.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import pe.com.mibanco.serviceManagement.chatbot.constantes.Constantes;
import pe.com.mibanco.serviceManagement.chatbot.dao.IncidenciaDao;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.IncidenciaJira;
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

	@Override
	public IncidenciaJira obtenerIncidenciaCampo(String key, String fieldName) {
		String url = conexionJira.getJiraApiUrlBase() + "/issue/{key}?fields={fieldName}";
		Map<String, String> varsPath = new HashMap<>();
		varsPath.put("key", key);
		varsPath.put("fieldName", fieldName);

		HttpEntity<String> request = new HttpEntity<>(conexionJira.getHttpHeaders());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new IssueErrorHandler());
		ResponseEntity<IncidenciaJira> response = 
				restTemplate.exchange(url, HttpMethod.GET, request, IncidenciaJira.class, varsPath);

		IncidenciaJira incidenciaJira = response.getBody();

		return incidenciaJira;
	}

	@Override
	public List<IncidenciaJira> obtenerIncidenciasPorUsuario(String usuario) {
		String url = conexionJira.getJiraApiUrlBase() + "/search?jql="
				+ "project = '{projectId}' AND "
				+ "creator = '{creatorEmail}' "
				+ "order by created DESC"
				+ "&fields=null";
		Map<String, String> varsPath = new HashMap<>();
		varsPath.put("projectId", Constantes.JIRA_PROJECT_NAME);
		varsPath.put("creatorEmail", usuario);
		
		HttpEntity<String> request = new HttpEntity<>(conexionJira.getHttpHeaders());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new IssueErrorHandler());
		ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, request, JsonNode.class, varsPath);
		JsonNode jsonNode = response.getBody();
		jsonNode = jsonNode.get("issues");
		
		if(jsonNode.isEmpty()) {
			return null;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectReader reader = objectMapper.readerFor(new TypeReference<List<IncidenciaJira>>() {});
		
		List<IncidenciaJira> incidencias = null;
		try {
			incidencias = reader.readValue(jsonNode);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return incidencias;
	}
	
	

}
