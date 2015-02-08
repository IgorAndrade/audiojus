package br.com.audiojus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Tribunal;
import br.com.audiojus.service.AssuntoService;
import br.com.audiojus.service.TribunalService;

@RestController
@RequestMapping("/assunto")
public class AssuntoController {
	private static final String SUCCESS = "SUCCESS";
	private static final String ERROR = "ERROR";
	public static final String LISTA = "cadastro/assuntoList";
	public static final String ASSUNTO = "cadastro/assunto";
	@Autowired
	private AssuntoService service;

	@RequestMapping(value = "/novo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ModelAndView assunto(){
		ModelAndView mv = new ModelAndView(ASSUNTO);
		mv.addObject("assunto", new Assunto());
		return mv;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8",
	"application/x-www-form-urlencoded;charset=UTF-8" })
	public ModelAndView salvar(Assunto t) {
		service.salvar(t);
		return listar();
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id) {
		Assunto assunto = service.buscar(id);
		ModelAndView mv = new ModelAndView(ASSUNTO);
		mv.addObject("assunto", assunto);
		return mv;
	}

	@RequestMapping(value = "/apagar", method = {RequestMethod.POST,RequestMethod.DELETE}, produces = "application/json;charset=UTF-8", consumes = {
			"application/json;charset=UTF-8",
			"application/x-www-form-urlencoded;charset=UTF-8" })
	public ResponseEntity<Object> apagar(@RequestBody Assunto a) {
		try {
			service.apagar(a);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.METHOD_FAILURE);
		}
	}
  
	@RequestMapping(value = "/apagar/{id}", method = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET})
	public ModelAndView apagar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView(LISTA);
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			service.apagar(id);
			map.put(SUCCESS, "Apagado com sucesso!");
		} catch(DataIntegrityViolationException violacao){
			map.put(ERROR, "Não foi possivel apagar o tribunal porque o mesmo esta vinculado à alguma sumula");
		} catch (Exception e) {
			map.put(ERROR, e.getMessage());
		}finally{
			map.put("assuntos", service.listar());
			mv.addAllObjects(map);
			return mv;
		}
	}

	@RequestMapping(value = "/listarJson", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<Assunto>> listarJson() {
		return new ResponseEntity<List<Assunto>>(service.listar(),
				HttpStatus.OK);
	}
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView(LISTA);
		mv.addObject("assuntos", service.listar());
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView raiz() {
		return listar();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = "application/json;charset=UTF-8", consumes = {
			"application/json;charset=UTF-8",
			"application/x-www-form-urlencoded;charset=UTF-8" })
	public ResponseEntity<Assunto> buscar(Long id) {
		return new ResponseEntity<Assunto>(service.buscar(id), HttpStatus.OK);
	}

}
