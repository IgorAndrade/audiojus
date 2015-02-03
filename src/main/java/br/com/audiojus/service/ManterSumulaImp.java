package br.com.audiojus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;
import br.com.audiojus.model.Tribunal;
import br.com.audiojus.repository.SumulaRepository;

@Service
public class ManterSumulaImp implements ManterSumulaService {
@Autowired
	private SumulaRepository repository;
	
	@Override
	public void apagar(Sumula sumula) {
		repository.delete(sumula);
	}

	@Override
	public void apagar(Long id) {
		repository.delete(id);

	}

	@Override
	public List<Sumula> listar() {
		return repository.findAll();
	}

	@Override
	public Sumula buscar(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void salvar(Sumula sumula) {
		repository.save(sumula);

	}

	@Override
	public List<Sumula> listar(Assunto assunto) {
		return repository.findByAssunto(assunto);
	}

	@Override
	public List<Sumula> listar(Tribunal tribunal) {
		return repository.findByTribunal(tribunal);
	}

	public void setRepository(SumulaRepository repository) {
		this.repository = repository;
	}

}
