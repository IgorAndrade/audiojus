package br.com.audiojus.test.service;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;
import br.com.audiojus.model.Tribunal;
import br.com.audiojus.repository.SumulaRepository;
import br.com.audiojus.service.ManterSumulaService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application-config.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class ManterSumulaTest {
	
@Autowired
	private ManterSumulaService service;
@PersistenceContext
private EntityManager em;
@Autowired
	private SumulaRepository repository;
	@Test
	public void test() {
		assertNotNull("nao injetou",service);
		assertNotNull("nao injetou em",em);
		assertNotNull("nao injetou em",repository);
	}
	@Test @Transactional
	public void salvarTest(){
		Assunto assunto = new Assunto();
		assunto.setAssunto("teste");
		
//		em.merge(assunto);
		
		Tribunal tribunal = new Tribunal();
		tribunal.setNome("tst");
		
//		em.merge(tribunal);
		
		Sumula sumula = new Sumula();
		
		sumula.addAssunto(assunto);
		sumula.setTribunal(tribunal);
		sumula.setNumero(1245);
		
		repository.save(sumula);
	//	assertNotNull(sumula.getId());
		
		List<Sumula> list = repository.findByAssunto(assunto);
		assertThat(list, not(empty()));
	}

}
