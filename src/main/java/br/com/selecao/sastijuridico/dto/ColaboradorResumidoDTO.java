package br.com.selecao.sastijuridico.dto;

import br.com.selecao.sastijuridico.model.Colaborador;

public class ColaboradorResumidoDTO {

	private String nome;
	private String email;
	
	public ColaboradorResumidoDTO(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public ColaboradorResumidoDTO(Colaborador colaborador) {
		this.nome = colaborador.getNome();
		this.email = colaborador.getEmail();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
