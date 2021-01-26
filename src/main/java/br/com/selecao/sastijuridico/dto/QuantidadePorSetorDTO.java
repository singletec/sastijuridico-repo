package br.com.selecao.sastijuridico.dto;

public class QuantidadePorSetorDTO {
	
	private String descricao;
	private Integer quantidade;
	
	public QuantidadePorSetorDTO(String descricao, Integer quantidade) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
