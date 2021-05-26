package pe.com.mibanco.serviceManagement.chatbot.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ConexionJira {
	
	@Value("${jira.api.url.base}")
	private String jiraApiUrlBase;
	
	@Value("${jira.api.basicSecurity.user}")
	private String apiBasicUsuario;
	
	@Value("${jira.api.basicSecurity.password}")
	private String apiBasicPassword;
	
	private HttpHeaders httpHeaders;
	
	@PostConstruct
	private void postCreation() {
		httpHeaders = new HttpHeaders();
		httpHeaders.setBasicAuth(apiBasicUsuario, apiBasicPassword);
	}

	public String getJiraApiUrlBase() {
		return jiraApiUrlBase;
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

}
