package br.com.wanderarce.meta.challenge.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wanderarce.meta.challenge.entities.Funcionarios;
import br.com.wanderarce.meta.challenge.services.FuncionariosService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

	@Autowired
	private FuncionariosService funcionariosService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Funcionarios>> all(
			@RequestParam(name = "cpf", required = false) String cpf,
			@RequestParam(name = "nome", required = false) String nome) {
		Funcionarios funcionario = new Funcionarios();
		if(cpf != null) funcionario.setCpf(cpf);
		if(nome != null) funcionario.setNome(nome);
		
		return new ResponseEntity<List<Funcionarios>>(funcionariosService.all(funcionario), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionarios> findBy(@PathVariable Integer id) {
		 Optional<Funcionarios> result = funcionariosService.findById(id);
		 return new ResponseEntity<Funcionarios>(result.get(), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionarios> save(@Valid @RequestBody Funcionarios funcionario) {
		 Funcionarios result = funcionariosService.save(funcionario);
		 return new ResponseEntity<Funcionarios>(result, HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionarios> update(@PathVariable Integer id, @RequestBody Funcionarios funcionario) {
		 Funcionarios result = funcionariosService.save(funcionario);
		 return new ResponseEntity<Funcionarios>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Funcionarios> delete(@PathVariable Integer id) {
		 HttpStatus result = funcionariosService.delete(id);
		 return new ResponseEntity<>(result);
	}
	
}
