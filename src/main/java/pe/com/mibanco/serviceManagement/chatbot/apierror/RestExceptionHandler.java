package pe.com.mibanco.serviceManagement.chatbot.apierror;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pe.com.mibanco.serviceManagement.chatbot.bean.ChatbotResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<ChatbotResponse> handleEntityNotFound(EntityNotFoundException ex) {
		ChatbotResponse response = new ChatbotResponse(ex.getChatbotHttpStatus().getStatusCode(), 
														ex.getChatbotHttpStatus().getReason());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
