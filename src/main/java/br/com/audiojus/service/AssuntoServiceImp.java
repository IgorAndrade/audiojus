package br.com.audiojus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Tribunal;
import br.com.audiojus.repository.AssuntoRepository;
import br.com.audiojus.repository.TribunalRepository;

@Service
public class AssuntoServiceImp implements AssuntoService {
	
@Autowired
	private AssuntoRepository repository;
	
	@Override
	public void salvar(Assunto t) {
		repository.save(t);
		
	}

	@Override
	public void apagar(Assunto t) {
	repository.delete(t);
	}

	@Override
	public void apagar(Long id) {
		repository.delete(id);
		
	}

	@Override
	public List<Assunto> listar() {
		return repository.findAll();
	}

	@Override
	public Assunto buscar(Long id) {
		return repository.findOne(id);
	}

	public void setRepository(AssuntoRepository repository) {
		this.repository = repository;
	}

}
