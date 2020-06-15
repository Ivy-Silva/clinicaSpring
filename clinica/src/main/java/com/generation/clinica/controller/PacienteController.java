package com.generation.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.clinica.model.PacienteModel;
import com.generation.clinica.repository.PacienteRepository;

@RestController
@RequestMapping("/medico")
@CrossOrigin("*")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	//-------------------------------------
			//início get
			//pegando a medico pelo código
			@GetMapping("/{codPaciente}")
			public ResponseEntity <PacienteModel> 
			GetById(@PathVariable long codPaciente) {
				return repository.findById(codPaciente).
			map(resp->ResponseEntity.ok(resp)).
			orElse(ResponseEntity.notFound().build());
			}//get para código
			
			@GetMapping
			public ResponseEntity<List<PacienteModel>> getAll() {
				return ResponseEntity.ok(repository.findAll());		
			}//get geral
			
			@GetMapping("/medico/{nomePaciente}")
			public ResponseEntity <List<PacienteModel>> 
			getByNomeMedico(@PathVariable String nomePaciente) {
				return ResponseEntity.ok(repository.
						findAllByNomeContainingIgnoreCase(nomePaciente));
			}//get para medico
			
			// fim get
			//------------------------------------
			
			//------------------------------------
			//início post
			@PostMapping
			public ResponseEntity <PacienteModel> Post
			(@RequestBody PacienteModel paciente) {
				return ResponseEntity.status(HttpStatus.CREATED).
						body(repository.save(paciente));
			}
			//fim post
			//--------------------------------------
			
			//--------------------------------------
			//início put
			@PutMapping
			public ResponseEntity <PacienteModel> Put
			(@RequestBody PacienteModel paciente) {
				return ResponseEntity.status(HttpStatus.OK).
						body(repository.save(paciente));
			}
			//fim put
			//--------------------------------------

			//--------------------------------------
			//início delete
			@DeleteMapping("/{codPaciente}")
			public void delete(@PathVariable long codPaciente) {
				repository.deleteById(codPaciente);
			}
			//fim delete
			//--------------------------------------
}
