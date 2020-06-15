package com.generation.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paciente")
public class PacienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codPaciente;
	
	@Column(name="nomePaciente", nullable = false)
	@Size(min=2, max=80)
	private String nomePaciente;
	
	@Column(name="enderecoPaciente", nullable = false)
	@Size(min=2, max=80)
	private String enderecoPaciente;
	
	@Column(name="cepPaciente", nullable = false)
	@Size(min=2, max=80)
	private String cepPaciente;
	
	@Column(name="telefonePaciente", nullable = false)
	@Size(min=9, max=80)
	private String telefone;

	public long getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(long codPaciente) {
		this.codPaciente = codPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public String getCepPaciente() {
		return cepPaciente;
	}

	public void setCepPaciente(String cepPaciente) {
		this.cepPaciente = cepPaciente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
