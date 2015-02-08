package br.com.audiojus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;
import br.com.audiojus.model.Tribunal;
import br.com.audiojus.repository.SumulaRepository;
import br.com.audiojus.repository.TribunalRepository;

@Service
public class SumulaServiceImp implements SumulaService {
	
@Autowired
	private SumulaRepository repository;

@Override
public void salvar(Sumula sumula) {
	repository.saveAndFlush(sumula);
}

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
public List<Sumula> buscarPorAssunto(Assunto assunto) {
	return repository.findByAssunto(assunto);
}

@Override
public List<Sumula> buscarPorTribunal(Tribunal tribunal) {
	return repository.findByTribunal(tribunal);
}
	
	
}
