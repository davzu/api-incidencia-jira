package pe.com.mibanco.serviceManagement.chatbot.apierror;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		ChatBotApiError apiError = new ChatBotApiError(ex.getChatbotHttpStatus().getStatusCode(), 
														ex.getChatbotHttpStatus().getReason(),
														HttpStatus.NOT_FOUND);
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ChatBotApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}

}
