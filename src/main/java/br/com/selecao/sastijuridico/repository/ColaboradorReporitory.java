package br.com.selecao.sastijuridico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.selecao.sastijuridico.model.Colaborador;

public interface ColaboradorReporitory extends JpaRepository<Colaborador, Long>{
	
	List<Colaborador> findByNomeLikeIgnoreCase(String nome);


}
