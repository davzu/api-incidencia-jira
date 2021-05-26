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

import pe.com.mibanco.serviceManagement.chatbot.dao.ComentarioDao;
import pe.com.mibanco.serviceManagement.chatbot.dto.ComentarioJira;
import pe.com.mibanco.serviceManagement.chatbot.dto.CommentContentJira;
import pe.com.mibanco.serviceManagement.chatbot.dto.WrapCommentContentJira;
import pe.com.mibanco.serviceManagement.chatbot.util.ConexionJira;

@Repository
public class ComentarioDaoImpl implements ComentarioDao {
	
	@Autowired
	private ConexionJira conexionJira;
	
	@Override
	public ComentarioJira obtenerUltimoComentario(String orderKey) {
		String url = conexionJira.getJiraApiUrlBase() + "/issue/SBM-2/comment?orderBy=-created";
		Map<String, String> varsPath = new HashMap<>();
		varsPath.put("orderKey", orderKey);

		HttpEntity<String> request = new HttpEntity<>(conexionJira.getHttpHeaders());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, request, JsonNode.class, varsPath);

		JsonNode jsonNode = response.getBody();
		jsonNode = jsonNode.get("comments");

		if (jsonNode.isEmpty()) {
			return null;
		} else {
			boolean esPublico;
			for (JsonNode objNode : jsonNode) {
				esPublico = objNode.get("jsdPublic").asBoolean();

				if (esPublico) {
					jsonNode = objNode;
					break;
				}
			}
			
			int idComentario = jsonNode.get("id").asInt();
			String fechaCreacion = jsonNode.get("created").asText();
			String autor = jsonNode.at("/author/displayName").asText();
			System.out.println(autor);
			System.out.println(fechaCreacion);
			jsonNode = jsonNode.get("body");
			jsonNode = jsonNode.get("content");
			
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectReader reader = objectMapper.readerFor(new TypeReference<List<WrapCommentContentJira>>(){});
			
			ComentarioJira comentarioJira = null;
			try {
				List<WrapCommentContentJira> wrapContents = reader.readValue(jsonNode);
				
				String comentario = "";
				for (WrapCommentContentJira wrapContent : wrapContents) {
					if(wrapContent.getType().equals("paragraph")) {
						if(!comentario.isEmpty()) {
							comentario += "\r\n";
						}
						for (CommentContentJira commentContent : wrapContent.getContent()) {
							if(commentContent.getType().equals("text")) {
								comentario += commentContent.getText();
							}
						}
					}
				}
				
				comentarioJira = new ComentarioJira(idComentario, comentario, autor, fechaCreacion);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return comentarioJira;
		}
		
	}

}
