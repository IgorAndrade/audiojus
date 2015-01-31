package br.com.audiojus.test.service;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import br.com.audiojus.service.ManterSumulaService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application-config.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class ManterSumulaTest {
	
@Autowired
	private ManterSumulaService service;
@PersistenceContext
private EntityManager em;
	
	@Test
	public void test() {
		assertNotNull("nao injetou",service);
		assertNotNull("nao injetou em",em);
	}
	
	public void salvarTest(){
		Assunto assunto = new Assunto();
		assunto.setAssunto("teste");
		
		em.persist(assunto);
		
		assertNotNull(assunto.getId());
		
		Tribunal tribunal = new Tribunal();
		tribunal.setNome("tst");
		
		em.persist(tribunal);
		assertNotNull(tribunal.getId());
		
		Sumula sumula = new Sumula();
		
		sumula.addAssunto(assunto);
		sumula.setTribunal(tribunal);
		sumula.setNumero(1245);
		
		em.persist(sumula);
	}

}
