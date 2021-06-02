package pe.com.mibanco.serviceManagement.chatbot.model.jira;

public class FieldJira {
	
	private EstadoJira status;
	private UsuarioJira assignee;

	public EstadoJira getStatus() {
		return status;
	}

	public void setStatus(EstadoJira status) {
		this.status = status;
	}

	public UsuarioJira getAssignee() {
		return assignee;
	}

	public void setAssignee(UsuarioJira assignee) {
		this.assignee = assignee;
	}

}
