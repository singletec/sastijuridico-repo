package br.com.selecao.sastijuridico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.selecao.sastijuridico.dto.ColaboradorDTO;
import br.com.selecao.sastijuridico.model.Colaborador;
import br.com.selecao.sastijuridico.repository.ColaboradorReporitory;
import br.com.selecao.sastijuridico.service.impl.ColaboradorServiceImpl;

@Service
public class ColaboradorService implements ColaboradorServiceImpl{

	@Autowired 
	ColaboradorReporitory repository; 
	
	public List<Colaborador>  listaColaboradores() {
		return repository.findAll();
	}
	
	public List<Colaborador>  buscaColaborador(String nome) {
		return repository.findByNomeLikeIgnoreCase("%" + nome + "%");
	}

	public Colaborador incluir(ColaboradorDTO colaboradorDTO) {
		
		Colaborador colaborador = new Colaborador(colaboradorDTO.getCpf(), colaboradorDTO.getNome(),
										colaboradorDTO.getEmail(), colaboradorDTO.getTelefone(), colaboradorDTO.getSetor());
	
		
		repository.save(colaborador);
		return colaborador;
	}
	
	public Colaborador alterar(ColaboradorDTO colaboradorDTO) {
	
		Colaborador colaborador = new Colaborador(colaboradorDTO.getId(),colaboradorDTO.getCpf(), colaboradorDTO.getNome(),
					colaboradorDTO.getEmail(), colaboradorDTO.getTelefone(), colaboradorDTO.getSetor());
		
		
		repository.save(colaborador);
		return colaborador;
	}
	
	public boolean excluir(Long id) {
		
		boolean retorno = false;
		
		Optional<Colaborador> colaborador = repository.findById(id);
		if (colaborador.isPresent()) {		
			repository.deleteById(id);
			retorno = true;
		}
		
		return retorno;
	}
}
