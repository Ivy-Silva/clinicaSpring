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

	import com.generation.clinica.model.MedicoModel;
	import com.generation.clinica.repository.MedicoRepository;

	@RestController
	@RequestMapping("/medico")
	@CrossOrigin("*")
	public class MedicoController {
		
		@Autowired
		private MedicoRepository repository;
		
		//-------------------------------------
		//início get
		//pegando a medico pelo código
		@GetMapping("/{crm}")
		public ResponseEntity <MedicoModel> 
		GetById(@PathVariable String crm) {
			return repository.findById(crm).
		map(resp->ResponseEntity.ok(resp)).
		orElse(ResponseEntity.notFound().build());
		}//get para código
		
		@GetMapping
		public ResponseEntity<List<MedicoModel>> getAll() {
			return ResponseEntity.ok(repository.findAll());		
		}//get geral
		
		@GetMapping("/medico/{medico}")
		public ResponseEntity <List<MedicoModel>> 
		getByNomeMedico(@PathVariable String nome) {
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}//get para medico
		
		// fim get
		//------------------------------------
		
		//------------------------------------
		//início post
		@PostMapping
		public ResponseEntity <MedicoModel> Post
		(@RequestBody MedicoModel medico) {
			return ResponseEntity.status(HttpStatus.CREATED).
					body(repository.save(medico));
		}
		//fim post
		//--------------------------------------
		
		//--------------------------------------
		//início put
		@PutMapping
		public ResponseEntity <MedicoModel> Put
		(@RequestBody MedicoModel medico) {
			return ResponseEntity.status(HttpStatus.OK).
					body(repository.save(medico));
		}
		//fim put
		//--------------------------------------
		
		//--------------------------------------
		//início delete
		@DeleteMapping("/{crm}")
		public void delete(@PathVariable String crm) {
			repository.deleteById(crm);
		}
		//fim delete
		//--------------------------------------
	}
