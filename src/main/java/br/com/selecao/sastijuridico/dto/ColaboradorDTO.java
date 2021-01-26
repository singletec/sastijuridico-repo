package br.com.selecao.sastijuridico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.selecao.sastijuridico.model.Setor;

public class ColaboradorDTO {

	private Long id;
	
	@NotBlank @NotEmpty 
	private String nome;
	
	@NotBlank @NotEmpty 
	private String cpf;
	private String telefone;
	private String email;
	private Setor setor;
	
	public ColaboradorDTO() {
		
	}
	
	public ColaboradorDTO(Long id, String cpf, String nome, String email, String telefone, Setor setor) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.setor = setor;
	}
	
	public ColaboradorDTO(String cpf, String nome, String email, String telefone, Setor setor) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.setor = setor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
}
