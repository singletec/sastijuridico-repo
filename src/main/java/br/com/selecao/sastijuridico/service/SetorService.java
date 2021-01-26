package br.com.selecao.sastijuridico.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.selecao.sastijuridico.dto.ColaboradorSetorDTO;
import br.com.selecao.sastijuridico.dto.QuantidadePorSetorDTO;
import br.com.selecao.sastijuridico.model.Setor;
import br.com.selecao.sastijuridico.repository.SetorRepository;
import br.com.selecao.sastijuridico.service.impl.SetorServiceImpl;

@Service
public class SetorService implements SetorServiceImpl{

	@Autowired 
	SetorRepository repository;
	
	public List<Setor> listaSetores() {
		return repository.findAll();
	}
	
	public List<QuantidadePorSetorDTO> quantidadeColaboradoresPorSetor() {
        
        List<QuantidadePorSetorDTO> qtdSetores = repository.findAll().stream().map(q -> 
        	new QuantidadePorSetorDTO(q.getDescricao(), q.getQuantidadesColaboradores())).collect(Collectors.toList());
        
		return qtdSetores;
	}
	
	public List<ColaboradorSetorDTO> colaboradoresPorSetor() {
        
        List<ColaboradorSetorDTO> colaboradoresSetor = repository.findAll().stream().map(q -> 
        		new ColaboradorSetorDTO(q.getDescricao(), ColaboradorSetorDTO.converter(q.getColaboradores())))
        		.collect(Collectors.toList());
        
        
		return colaboradoresSetor;
	}
	
	
}
