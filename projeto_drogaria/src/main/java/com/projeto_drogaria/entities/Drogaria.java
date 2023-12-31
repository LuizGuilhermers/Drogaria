package com.projeto_drogaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "Drogaria")
public class Drogaria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull
	@NotBlank
	private String nome;
	
	@Column 
	@NotNull
	@NotBlank
	@Size (min = 14, message= "Minimo de 14 caracteres")
	private String cnpj;
	
	public Long getId() {
		return id;
	}
	public void setId (Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome (String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj (String cnpj) {
		this.cnpj = cnpj;
	}

}
