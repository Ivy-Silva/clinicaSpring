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

import com.generation.clinica.model.FichaModel;
import com.generation.clinica.repository.FichaRepository;

@RestController
@RequestMapping("/ficha")
@CrossOrigin("*")
public class FichaController {
	
	@Autowired
	private FichaRepository repository;
	
	//-------------------------------------
	//início get
	//pegando a especialidade pelo código
	@GetMapping("/{codFicha}")
	public ResponseEntity <FichaModel> 
	GetById(@PathVariable long codFicha) {
		return repository.findById(codFicha).
	map(resp->ResponseEntity.ok(resp)).
	orElse(ResponseEntity.notFound().build());
	}//get para código
	
	@GetMapping
	public ResponseEntity<List<FichaModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());		
	}//get geral
	// fim get
	//------------------------------------

	//------------------------------------
		//início post
		@PostMapping
		public ResponseEntity <FichaModel> Post
		(@RequestBody FichaModel ficha) {
			return ResponseEntity.status(HttpStatus.CREATED).
					body(repository.save(ficha));
		}
		//fim post
		//--------------------------------------
		
		//--------------------------------------
		//início put
		@PutMapping
		public ResponseEntity <FichaModel> Put
		(@RequestBody FichaModel ficha) {
			return ResponseEntity.status(HttpStatus.OK).
					body(repository.save(ficha));
		}
		//fim put
		//--------------------------------------
		
		//--------------------------------------
		//início delete
		@DeleteMapping("/{codFicha}")
		public void delete(@PathVariable long codFicha) {
			repository.deleteById(codFicha);
		}
		//fim delete
		//--------------------------------------
}
