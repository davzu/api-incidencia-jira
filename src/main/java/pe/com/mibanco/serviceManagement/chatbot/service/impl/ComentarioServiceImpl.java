package pe.com.mibanco.serviceManagement.chatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mibanco.serviceManagement.chatbot.dao.ComentarioDao;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.ComentarioJira;
import pe.com.mibanco.serviceManagement.chatbot.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	ComentarioDao comentarioDao;
	
	@Override
	public ComentarioJira obtenerUltimoComentario(String orderKey) {
		return comentarioDao.obtenerUltimoComentario(orderKey);
	}

}
