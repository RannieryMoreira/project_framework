package com.tcc.projeto_framework.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.projeto_framework.api.model.LegalPerson;
import com.tcc.projeto_framework.api.service.LegalPersonFacade;

@RestController
@RequestMapping(value = "/legal_persons")
public class LegalPersonController {
	@Autowired
	private LegalPersonFacade legalPersonFacade;

	@PostMapping
	@ResponseBody
	public LegalPerson create(@RequestBody LegalPerson person) {
		person.calculateExpense();	
		return legalPersonFacade.create(person);
	}
	
	@GetMapping
	@ResponseBody
	public Optional<List<LegalPerson>> getAll(){
		return legalPersonFacade.getAll();
	}

	@GetMapping("/{id}")
    public Optional<LegalPerson> getPersonById(@PathVariable int id) {
        return legalPersonFacade.getById(id);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> updatePersonById(@RequestBody LegalPerson person, @PathVariable int id) {
		person.calculateExpense();
        return legalPersonFacade.updateById(person, id);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable int id) {
        return legalPersonFacade.deleteById(id);
    }
}
