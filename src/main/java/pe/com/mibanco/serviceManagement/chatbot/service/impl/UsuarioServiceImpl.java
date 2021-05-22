package pe.com.mibanco.serviceManagement.chatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mibanco.serviceManagement.chatbot.apierror.EntityNotFoundException;
import pe.com.mibanco.serviceManagement.chatbot.constantes.ChatbotHttpStatus;
import pe.com.mibanco.serviceManagement.chatbot.dao.UsuarioDao;
import pe.com.mibanco.serviceManagement.chatbot.model.UsuarioJira;
import pe.com.mibanco.serviceManagement.chatbot.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UsuarioJira obtenerUsuarioPorEmail(String email) {
		UsuarioJira usuarioJira = usuarioDao.obtenerUsuarioPorEmail(email);
		
		if(!usuarioJira.isActive()) {
			throw new EntityNotFoundException(ChatbotHttpStatus.NOT_FOUND_USER);
		}
		
		return usuarioJira;
	}

}
