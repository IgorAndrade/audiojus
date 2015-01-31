package br.com.audiojus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Password {
	@Id @GeneratedValue
	private Long id;
	private String email;
	private String Senha;
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	private Usuario usuario;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
