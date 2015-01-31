package br.com.audiojus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;
import br.com.audiojus.model.Tribunal;

public interface ManterSumulaService extends ManterCadastro<Sumula> {

	public void salvar(Sumula sumula);
	
	public List<Sumula> listar(Assunto assunto);
	
	public List<Sumula> listar(Tribunal tribunal);
	
}
