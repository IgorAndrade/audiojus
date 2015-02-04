package br.com.audiojus.model;

import java.awt.image.BufferStrategy;
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
	@ManyToOne(fetch=FetchType.EAGER)
	private Tribunal tribunal;
	private boolean free;

	
	
	@OneToMany
	 @JoinTable(name = "Sumula_Assunto", joinColumns = @JoinColumn(name = "sumula_id"), inverseJoinColumns = @JoinColumn(name = "assunto_id"))
	private List<Assunto> assuntos;
	
	public  Sumula() {
	this.assuntos = new ArrayList<Assunto>();
	}
	
	@Override
	public String toString() {
		StringBuffer texto = new StringBuffer();
		texto.append(tribunal.getNome());
		texto.append(" nº ");
		texto.append(numero.toString());
		if(titulo != null && !texto.equals("")){
			texto.append(" - ");
			texto.append(titulo);
		}
		return texto.toString();
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

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sumula other = (Sumula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}
