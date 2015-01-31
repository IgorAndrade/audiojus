package br.com.audiojus.service;

import java.util.List;

public interface ManterCadastro<T> {

	public void salvar(T t);
	
	public void apagar(T t);
	
	public void apagar(Long id);
	
	public List<T> listar();
	
	public T buscar(Long id);
	
}
