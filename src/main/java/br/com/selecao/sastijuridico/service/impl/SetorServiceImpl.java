package br.com.selecao.sastijuridico.service.impl;

import java.util.List;

import br.com.selecao.sastijuridico.dto.ColaboradorSetorDTO;
import br.com.selecao.sastijuridico.dto.QuantidadePorSetorDTO;
import br.com.selecao.sastijuridico.model.Setor;

public interface SetorServiceImpl {
	
	List<Setor> listaSetores();
	
	List<ColaboradorSetorDTO> colaboradoresPorSetor();
	List<QuantidadePorSetorDTO> quantidadeColaboradoresPorSetor();

}
