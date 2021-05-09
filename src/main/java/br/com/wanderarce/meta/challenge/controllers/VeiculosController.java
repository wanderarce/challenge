package br.com.wanderarce.meta.challenge.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wanderarce.meta.challenge.entities.Veiculos;
import br.com.wanderarce.meta.challenge.services.VeiculosService;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

	@Autowired
	private VeiculosService veiculosService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Veiculos>> all(
			@RequestParam(name = "placa", required = false) String placa,
			@RequestParam(name = "modelo", required = false) String modelo
			) {
		Veiculos veiculo = new Veiculos();
		if(placa != null) veiculo.setPlaca(placa);
		if(modelo != null) veiculo.setModelo(modelo);
		return new ResponseEntity<List<Veiculos>>(veiculosService.all(veiculo), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Veiculos> findBy(@PathVariable Integer id) {
		 Optional<Veiculos> result = veiculosService.findById(id);
		 return new ResponseEntity<Veiculos>(result.get(), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Veiculos> save(@RequestBody Veiculos veiculo) {
		 Veiculos result = veiculosService.save(veiculo);
		 return new ResponseEntity<Veiculos>(result, HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Veiculos> update(@PathVariable Integer id, @RequestBody Veiculos veiculo) {
		 Veiculos result = veiculosService.save(veiculo);
		 return new ResponseEntity<Veiculos>(result, HttpStatus.OK);
	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Veiculos> delete(@PathVariable Integer id) {
		 HttpStatus result = veiculosService.delete(id);
		 return new ResponseEntity<>(result);
	}
	
}
