package br.com.audiojus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audiojus.model.Tribunal;
import br.com.audiojus.repository.TribunalRepository;

@Service
public class TribunalServiceImp implements TribunalService {
	
@Autowired
	private TribunalRepository repository;
	
	@Override
	public void salvar(Tribunal t) {
		repository.save(t);
		
	}

	@Override
	public void apagar(Tribunal t) {
	repository.delete(t);
	}

	@Override
	public void apagar(Long id) {
		repository.delete(id);
		
	}

	@Override
	public List<Tribunal> listar() {
		return repository.findAll();
	}

	@Override
	public Tribunal buscar(Long id) {
		return repository.findOne(id);
	}

	public void setRepository(TribunalRepository repository) {
		this.repository = repository;
	}

}
