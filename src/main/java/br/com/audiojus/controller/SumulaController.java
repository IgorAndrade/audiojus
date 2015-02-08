package br.com.audiojus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.audiojus.model.Sumula;
import br.com.audiojus.service.SumulaService;

@RestController
@RequestMapping("/sumula")
public class SumulaController {
	private static final String SUCCESS = "SUCCESS";
	private static final String ERROR = "ERROR";
	public static final String LISTA = "cadastro/sumulaList";
	public static final String SUMULA = "cadastro/sumula";
	@Autowired
	private SumulaService service;

	@RequestMapping(value = "/novo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ModelAndView assunto(){
		ModelAndView mv = new ModelAndView(SUMULA);
		mv.addObject("sumula", new Sumula());
		return mv;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8",
	"application/x-www-form-urlencoded;charset=UTF-8" })
	public ModelAndView salvar(@RequestParam("sumula") Sumula t, @RequestParam("file") MultipartFile file) {
		service.salvar(t);
		return listar();
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id) {
		Sumula sumula = service.buscar(id);
		ModelAndView mv = new ModelAndView(SUMULA);
		mv.addObject("sumula", sumula);
		return mv;
	}

	@RequestMapping(value = "/apagar", method = {RequestMethod.POST,RequestMethod.DELETE}, produces = "application/json;charset=UTF-8", consumes = {
			"application/json;charset=UTF-8",
			"application/x-www-form-urlencoded;charset=UTF-8" })
	public ResponseEntity<Object> apagar(@RequestBody Sumula s) {
		try {
			service.apagar(s);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.METHOD_FAILURE);
		}
	}
  
	@SuppressWarnings("finally")
	@RequestMapping(value = "/apagar/{id}", method = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET})
	public ModelAndView apagar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView(LISTA);
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			service.apagar(id);
			map.put(SUCCESS, "Apagado com sucesso!");
		} catch (Exception e) {
			map.put(ERROR, e.getMessage());
		}finally{
			map.put("sumula", service.listar());
			mv.addAllObjects(map);
			return mv;
		}
	}

	@RequestMapping(value = "/listarJson", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<Sumula>> listarJson() {
		return new ResponseEntity<List<Sumula>>(service.listar(),
				HttpStatus.OK);
	}
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView(LISTA);
		mv.addObject("sumulas", service.listar());
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView raiz() {
		return listar();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = "application/json;charset=UTF-8", consumes = {
			"application/json;charset=UTF-8",
			"application/x-www-form-urlencoded;charset=UTF-8" })
	public ResponseEntity<Sumula> buscar(Long id) {
		return new ResponseEntity<Sumula>(service.buscar(id), HttpStatus.OK);
	}

}
