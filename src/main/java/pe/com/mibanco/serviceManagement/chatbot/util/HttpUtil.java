package pe.com.mibanco.serviceManagement.chatbot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HttpUtil {
	
	private static String usuario;
	private static String password;
	
	public static HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(usuario, password);
		return headers;
	}

	@Value("${chatbot.http.basicSecurity.user}")
	public void setUsuario(String usuario) {
		HttpUtil.usuario = usuario;
	}
	
	@Value("${chatbot.http.basicSecurity.password}")
	public void setPassword(String password) {
		HttpUtil.password = password;
	}
	
}
