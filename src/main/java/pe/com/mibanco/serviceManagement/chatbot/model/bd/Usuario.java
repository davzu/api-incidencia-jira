package pe.com.mibanco.serviceManagement.chatbot.model.bd;

public class Usuario {

	private int idUsuario;
	private String email;
	private String codCuenta;
	private String tipoCuenta;
	private String nombreUsuario;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodCuenta() {
		return codCuenta;
	}
	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	
	
}
