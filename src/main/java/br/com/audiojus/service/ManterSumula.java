package br.com.audiojus.service;

import java.util.List;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;
import br.com.audiojus.model.Tribunal;

public interface ManterSumula {

	public void criar(Sumula sumula);
	
	public void apagar(Sumula sumula);
	
	public void apagar(Long idSumula);
	
	public List<Sumula> listar(Assunto assunto);
	
	public List<Sumula> listar(Tribunal tribunal);
	
	public List<Sumula> listar();
}
