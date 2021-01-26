package br.com.selecao.sastijuridico.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.selecao.sastijuridico.dto.ColaboradorDTO;
import br.com.selecao.sastijuridico.dto.ColaboradorSetorDTO;
import br.com.selecao.sastijuridico.dto.QuantidadePorSetorDTO;
import br.com.selecao.sastijuridico.model.Colaborador;
import br.com.selecao.sastijuridico.model.Setor;
import br.com.selecao.sastijuridico.service.impl.ColaboradorServiceImpl;
import br.com.selecao.sastijuridico.service.impl.SetorServiceImpl;

@RestController
@RequestMapping("/sasjurico/v1")
public class SasJuricoController {
	
	@Autowired
	ColaboradorServiceImpl colaboradorService;
	
	@Autowired
	SetorServiceImpl setorService;
	
	@GetMapping("/listacolaboradores")
	public List<Colaborador> listaColaboradores() {
		return colaboradorService.listaColaboradores();
	}
	
	@GetMapping("/buscacolaborador")
	public List<Colaborador> buscacolaborador(String nome) {
		return colaboradorService.buscaColaborador(nome);
	}
	
	@GetMapping("/listasetores")
	public List<Setor> listaSetores() {
		return setorService.listaSetores();
	}
	
	@GetMapping("/listaquantidadecolaboradoressetor")
	public List<QuantidadePorSetorDTO> listaQuantidadeColaboradoresSetor() {
		return setorService.quantidadeColaboradoresPorSetor();
	}
	
	@GetMapping("/listacolaboradoresporsetor")
	public List<ColaboradorSetorDTO> listacolaboradoresporsetor() {
		return setorService.colaboradoresPorSetor();
	}
	
	@PostMapping(path = "/incluir", consumes = {MediaType.APPLICATION_JSON_VALUE})
	@Transactional
	public ResponseEntity<Colaborador> incluirColaborador(@RequestBody @Valid ColaboradorDTO colaboradorDTO,  BindingResult result, 
			UriComponentsBuilder uriBuilder) {
		
		Colaborador colaborador = colaboradorService.incluir(colaboradorDTO);
		
		URI uri = uriBuilder.path("/incluir/{id}").buildAndExpand(colaborador.getId()).toUri();
		return ResponseEntity.created(uri).body(colaborador);
	}
	
	@PutMapping(path = "/alterar", consumes = {MediaType.APPLICATION_JSON_VALUE})
	@Transactional
	public ResponseEntity<Colaborador> alterarColaborador(@RequestBody @Valid ColaboradorDTO colaboradorDTO, UriComponentsBuilder uriBuilder) {
		
		Colaborador colaborador = colaboradorService.alterar(colaboradorDTO);
		
		URI uri = uriBuilder.path("/alterar/{id}").buildAndExpand(colaborador.getId()).toUri();
		return ResponseEntity.created(uri).body(colaborador);
	}

	
	@DeleteMapping(path = "/excluir/{id}")
	@Transactional
	public ResponseEntity<?> excluirColaborador(@PathVariable Long id) {
		
		if (colaboradorService.excluir(id)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	

}
