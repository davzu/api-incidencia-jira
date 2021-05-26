package pe.com.mibanco.serviceManagement.chatbot.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pe.com.mibanco.serviceManagement.chatbot.apierror.EntityNotFoundException;
import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;
import pe.com.mibanco.serviceManagement.chatbot.dao.UsuarioDao;
import pe.com.mibanco.serviceManagement.chatbot.model.UsuarioJira;
import pe.com.mibanco.serviceManagement.chatbot.restError.IssueErrorHandler;
import pe.com.mibanco.serviceManagement.chatbot.util.ConexionJira;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private ConexionJira conexionJira;
	
	@Override
	public UsuarioJira obtenerUsuarioPorEmail(String email) {
		String url = conexionJira.getJiraApiUrlBase() + "/user/search?query={email}";
		Map<String, String> varsPath = new HashMap<>();
		varsPath.put("email", email);

		HttpEntity<String> request = new HttpEntity<>(conexionJira.getHttpHeaders());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new IssueErrorHandler());
		ResponseEntity<List<UsuarioJira>> response = 
				restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<UsuarioJira>>() {}, varsPath);

		List<UsuarioJira> usuarios = response.getBody();
		
		if(usuarios.isEmpty()) {
			throw new EntityNotFoundException(ChatbotHttpStatus.NOT_FOUND_USER);
		}

		UsuarioJira usuarioJira = usuarios.get(0);
		
		return usuarioJira;
	}

}
