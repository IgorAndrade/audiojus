package br.com.audiojus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sumula {
	@Id @GeneratedValue
	private Long id;
	private Integer numero;
	private String titulo;
	private String texto;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Tribunal tribunal;
	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(name = "Sumula_Assunto", joinColumns = @JoinColumn(name = "sumula_id"), inverseJoinColumns = @JoinColumn(name = "assunto_id"))
	private List<Assunto> assuntos;
	
	public  Sumula() {
	this.assuntos = new ArrayList<Assunto>();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nº "+numero.toString()+" - "+titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}
	
	public void addAssunto(Assunto assunto){
		assuntos.add(assunto);
	}
}
