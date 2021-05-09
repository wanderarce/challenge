package br.com.wanderarce.meta.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.wanderarce.meta.challenge.entities.Funcionarios;
import br.com.wanderarce.meta.challenge.entities.Veiculos;
import br.com.wanderarce.meta.challenge.repositories.FuncionariosRepository;

@Service
public class FuncionariosService {

	@Autowired
	private FuncionariosRepository funcionarioRepository;
	
	public List<Funcionarios> all(Funcionarios funcionarioFilter) {
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny();
		 
		Example<Funcionarios> example = Example.of(funcionarioFilter, customExampleMatcher);
		
		return funcionarioRepository.findAll(example);
	}
	
	public Optional<Funcionarios> findById(Integer id) {
		return funcionarioRepository.findById(id);
	}
	
	public Funcionarios save(Funcionarios funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public HttpStatus delete(Integer id) {
		Optional<Funcionarios> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			funcionarioRepository.delete(funcionario.get());
			return HttpStatus.NO_CONTENT;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
}
