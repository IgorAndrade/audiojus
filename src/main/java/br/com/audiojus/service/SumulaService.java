package br.com.audiojus.service;

import java.util.List;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;
import br.com.audiojus.model.Tribunal;

public interface SumulaService extends ManterCadastro<Sumula> {
	public List<Sumula> buscarPorAssunto(Assunto assunto);

	public List<Sumula> buscarPorTribunal(Tribunal tribunal);

}
