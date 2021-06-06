package pe.com.mibanco.serviceManagement.chatbot.constantes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiData {
	
	@Value("${jira.project.id}")
	private String jiraProjectId;

	public String getJiraProjectId() {
		return jiraProjectId;
	}	

}
