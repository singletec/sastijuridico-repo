package br.com.selecao.sastijuridico.service.impl;

import java.util.List;

import br.com.selecao.sastijuridico.dto.ColaboradorDTO;
import br.com.selecao.sastijuridico.model.Colaborador;


public interface ColaboradorServiceImpl {

	List<Colaborador>  listaColaboradores();
	List<Colaborador>  buscaColaborador(String nome);
	Colaborador incluir(ColaboradorDTO colaboradorDTO);
	Colaborador alterar(ColaboradorDTO colaboradorDTO);
	boolean excluir(Long id);
}
