package br.com.audiojus.model;

public class Password {
	private Long id;
	private String email;
	private String Senha;
	public Password(){
		
	}
	public Password(String email, String senha) {
		super();
		this.email = email;
		Senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
