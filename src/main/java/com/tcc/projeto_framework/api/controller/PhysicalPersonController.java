package com.tcc.projeto_framework.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tcc.projeto_framework.api.model.PhysicalPerson;
import com.tcc.projeto_framework.api.service.PhysicalPersonFacade;

@RestController
@RequestMapping(value = "/physical_persons")
@CrossOrigin(origins = "*")
public class PhysicalPersonController {
	@Autowired
	private PhysicalPersonFacade physicalPersonFacade;

	@PostMapping
	@ResponseBody
	public PhysicalPerson create(@RequestBody PhysicalPerson person) {
		person.setExpense(person.calculateExpense(person.getSalary()));	
		return physicalPersonFacade.create(person);
	}
	
	@GetMapping
	@ResponseBody
	public Optional<List<PhysicalPerson>> getAll(){
		return physicalPersonFacade.getAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
    public Optional<PhysicalPerson> getPersonById(@PathVariable int id) {
        return physicalPersonFacade.getById(id);
    }
	
	@PutMapping("/{id}")
	@ResponseBody
    public ResponseEntity<?> updatePersonById(@RequestBody PhysicalPerson person, @PathVariable int id) {
		person.setExpense(person.calculateExpense(person.getSalary()));	
        return physicalPersonFacade.updateById(person, id);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable int id) {
        return physicalPersonFacade.deleteById(id);
    }
}
