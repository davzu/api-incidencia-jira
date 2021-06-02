package pe.com.mibanco.serviceManagement.chatbot.model.jira;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WrapCommentContentJira {
	
	private String type;
	private List<CommentContentJira> content;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<CommentContentJira> getContent() {
		return content;
	}
	public void setContent(List<CommentContentJira> content) {
		this.content = content;
	}

}
