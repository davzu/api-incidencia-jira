package pe.com.mibanco.serviceManagement.chatbot.handler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import pe.com.mibanco.serviceManagement.chatbot.apierror.EntityNotFoundException;
import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;

public class IssueErrorHandler extends DefaultResponseErrorHandler {

	private static final Logger log = LoggerFactory.getLogger(IssueErrorHandler.class);
	
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		int statusCode = response.getStatusCode().value();
		String body = IOUtils.toString(response.getBody(), StandardCharsets.UTF_8);
		
		log.info(String.valueOf(statusCode));
		log.info(body);
		
		if(statusCode == HttpStatus.NOT_FOUND.value()) {
			throw new EntityNotFoundException(ChatbotHttpStatus.NOT_FOUND_ISSUE);
		}
	}
}
