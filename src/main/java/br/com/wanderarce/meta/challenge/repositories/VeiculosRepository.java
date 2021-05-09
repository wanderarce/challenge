package br.com.wanderarce.meta.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wanderarce.meta.challenge.entities.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Integer>{

	
}
