package br.com.wanderarce.meta.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.wanderarce.meta.challenge.entities.Veiculos;
import br.com.wanderarce.meta.challenge.repositories.VeiculosRepository;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository funcionarioRepository;
	
	public List<Veiculos> all(Veiculos veiculoFilter) {
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny();
		 
		Example<Veiculos> example = Example.of(veiculoFilter, customExampleMatcher);
		
		return funcionarioRepository.findAll(example);
	}
	
	public Optional<Veiculos> findById(Integer id) {
		return funcionarioRepository.findById(id);
	}
	
	public Veiculos save(Veiculos funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public HttpStatus delete(Integer id) {
		Optional<Veiculos> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			funcionarioRepository.delete(funcionario.get());
			return HttpStatus.NO_CONTENT;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
}
