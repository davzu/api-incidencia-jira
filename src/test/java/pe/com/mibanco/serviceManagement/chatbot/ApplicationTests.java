package pe.com.mibanco.serviceManagement.chatbot;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import pe.com.mibanco.serviceManagement.chatbot.model.jira.CommentContentJira;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.IncidenciaJira;
import pe.com.mibanco.serviceManagement.chatbot.model.jira.WrapCommentContentJira;

@SpringBootTest
class ApplicationTests {

//	@Test
	void contextLoads() {
	}
	
//	@Test
	public void interpretarJsonComentario() {		
		String strJson = "{\"startAt\":0,\"maxResults\":1048576,\"total\":4,\"comments\":[{\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10021/comment/10019\",\"id\":\"10019\",\"author\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"body\":{\"version\":1,\"type\":\"doc\",\"content\":[{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Comentario cliente interno 5\"}]},{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Revisi??n del la \"},{\"type\":\"text\",\"text\":\"incidencia \",\"marks\":[{\"type\":\"strong\"}]},{\"type\":\"text\",\"text\":\"el d??a de hoy 23/05/2021 a las 8 de la ma??ana del d??a domingo \"},{\"type\":\"emoji\",\"attrs\":{\"shortName\":\":slight_smile:\",\"id\":\"1f642\",\"text\":\"????\"}},{\"type\":\"text\",\"text\":\" . A la espera de la respuesta.\"}]},{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Banca\"}]},{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"M??vil \"}]},{\"type\":\"mediaSingle\",\"attrs\":{\"layout\":\"align-start\"},\"content\":[{\"type\":\"media\",\"attrs\":{\"id\":\"2f9aed07-b83a-4b0c-932d-e0a9ebb90dc2\",\"type\":\"file\",\"collection\":\"jira-10021-comment-10019\",\"width\":160,\"height\":30,\"occurrenceKey\":\"23ea6bb6-2aeb-4925-85dd-c5a43b52cca3\"}}]},{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Se incluy?? imagen.\"}]}]},\"updateAuthor\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"created\":\"2021-05-23T04:11:13.961-0500\",\"updated\":\"2021-05-23T04:11:13.961-0500\",\"jsdPublic\":true},{\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10021/comment/10018\",\"id\":\"10018\",\"author\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"body\":{\"version\":1,\"type\":\"doc\",\"content\":[{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Comentario cliente interno 4\"}]},{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Revisi??n del la \"},{\"type\":\"text\",\"text\":\"incidencia \",\"marks\":[{\"type\":\"strong\"}]},{\"type\":\"text\",\"text\":\"el d??a de hoy 23/05/2021\"}]}]},\"updateAuthor\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"created\":\"2021-05-23T04:03:17.494-0500\",\"updated\":\"2021-05-23T04:06:14.256-0500\",\"jsdPublic\":true},{\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10021/comment/10017\",\"id\":\"10017\",\"author\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"body\":{\"version\":1,\"type\":\"doc\",\"content\":[{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Comentario 3\"}]}]},\"updateAuthor\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"created\":\"2021-05-23T04:00:06.168-0500\",\"updated\":\"2021-05-23T04:00:06.168-0500\",\"jsdPublic\":false},{\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10021/comment/10015\",\"id\":\"10015\",\"author\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"body\":{\"version\":1,\"type\":\"doc\",\"content\":[{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Comentario 1\"}]}]},\"updateAuthor\":{\"self\":\"https://davzu.atlassian.net/rest/api/3/user?accountId=557058%3Aa89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"accountId\":\"557058:a89368aa-39ce-41f7-8d58-bb1ed33312e1\",\"emailAddress\":\"davzu_90@hotmail.com\",\"avatarUrls\":{\"48x48\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"24x24\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"16x16\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\",\"32x32\":\"https://secure.gravatar.com/avatar/52844037bf66b7e454d8f8626fa9f396?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FD-1.png\"},\"displayName\":\"davzu\",\"active\":true,\"timeZone\":\"America/Lima\",\"accountType\":\"atlassian\"},\"created\":\"2021-05-23T03:58:04.006-0500\",\"updated\":\"2021-05-23T03:58:04.006-0500\",\"jsdPublic\":false}]}";
//		String strJson = "{\"startAt\":0,\"maxResults\":1048576,\"total\":0,\"comments\":[]}";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode;
		try {
			jsonNode = objectMapper.readValue(strJson, JsonNode.class);
			jsonNode = jsonNode.get("comments");
//			boolean hasObject = jsonNode.has(0);
			
			if(jsonNode.isEmpty()) {
				System.out.println("No hay comentarios");
				return;
			}
			
			System.out.println("*****************************");
//			jsonNode = jsonNode.get(0);
			boolean esPublico;
			for (JsonNode objNode : jsonNode) {
		        System.out.println(objNode);
		        esPublico = objNode.get("jsdPublic").asBoolean();
		        
		        if(esPublico) {
		        	jsonNode = objNode;
		        	break;
		        }
		    }
			System.out.println("*****************************");
			
			int idComentario = jsonNode.get("id").asInt();
			String fechaCreacion = jsonNode.get("created").asText();
			String autor = jsonNode.at("/author/displayName").asText();
			System.out.println(idComentario);
			System.out.println(autor);
			System.out.println(fechaCreacion);
			jsonNode = jsonNode.get("body");
			jsonNode = jsonNode.get("content");
			
			ObjectReader reader = objectMapper.readerFor(new TypeReference<List<WrapCommentContentJira>>(){});
			
			List<WrapCommentContentJira> wrapContents = reader.readValue(jsonNode);
			
			String comentario = "";
			for (WrapCommentContentJira wrapContent : wrapContents) {
				if(wrapContent.getType().equals("paragraph")) {
					if(!comentario.isEmpty()) {
						comentario += "\n";
					}
					for (CommentContentJira commentContent : wrapContent.getContent()) {
						if(commentContent.getType().equals("text")) {
							comentario += commentContent.getText();
						}
					}
				}
			}

			System.out.println("Comentario: " + comentario);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void interpretarJsonIncidencias() {
//		String strJson = "{\"expand\":\"schema,names\",\"startAt\":0,\"maxResults\":50,\"total\":4,\"issues\":[{\"expand\":\"operations,versionedRepresentations,editmeta,changelog,renderedFields\",\"id\":\"10029\",\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10029\",\"key\":\"SBM-10\"},{\"expand\":\"operations,versionedRepresentations,editmeta,changelog,renderedFields\",\"id\":\"10028\",\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10028\",\"key\":\"SBM-9\"},{\"expand\":\"operations,versionedRepresentations,editmeta,changelog,renderedFields\",\"id\":\"10027\",\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10027\",\"key\":\"SBM-8\"},{\"expand\":\"operations,versionedRepresentations,editmeta,changelog,renderedFields\",\"id\":\"10026\",\"self\":\"https://davzu.atlassian.net/rest/api/3/issue/10026\",\"key\":\"SBM-7\"}]}";
		String strJson = "{\"startAt\":0,\"maxResults\":50,\"total\":0,\"issues\":[],\"warningMessages\":[\"El valor 'romel_990@hotmail.comc' no existe para el campo 'creator'.\"]}";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode;
		try {
			jsonNode = objectMapper.readValue(strJson, JsonNode.class);
			jsonNode = jsonNode.get("issues");
			
			if(jsonNode.isEmpty()) {
				System.out.println("No hay incidencias");
				return;
			}
			
			ObjectReader reader = objectMapper.readerFor(new TypeReference<List<IncidenciaJira>>(){});
			List<IncidenciaJira> incidencias = reader.readValue(jsonNode);
			
			for (IncidenciaJira incidencia : incidencias) {
				System.out.println(incidencia.getKey());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
