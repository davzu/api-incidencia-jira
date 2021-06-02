package pe.com.mibanco.serviceManagement.chatbot.model.jira;

public class ComentarioJira {

	private int idComentario;
	private String comentario;
	private String autor;
	private String fechaCreacion;
	
	public ComentarioJira(int idComentario, String comentario, String autor, String fechaCreacion) {
		this.idComentario = idComentario;
		this.comentario = comentario;
		this.autor = autor;
		this.fechaCreacion = fechaCreacion;
	}
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
}
