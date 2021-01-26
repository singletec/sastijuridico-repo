package br.com.selecao.sastijuridico.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.selecao.sastijuridico.model.Colaborador;

public class ColaboradorSetorDTO {

	private String descricao;
	private List<ColaboradorResumidoDTO> colaborador;

	public ColaboradorSetorDTO(String descricao, List<ColaboradorResumidoDTO> colaborador) {
		this.descricao = descricao;	
		this.colaborador = colaborador;
	}

	public List<ColaboradorResumidoDTO> getColaborador() {
		return colaborador;
	}

	public void setColaborador(List<ColaboradorResumidoDTO> colaborador) {
		this.colaborador = colaborador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static List<ColaboradorResumidoDTO> converter(List<Colaborador> colaboradores) {
        return colaboradores.stream().map(ColaboradorResumidoDTO::new).collect(Collectors.toList());
    }
	
}
