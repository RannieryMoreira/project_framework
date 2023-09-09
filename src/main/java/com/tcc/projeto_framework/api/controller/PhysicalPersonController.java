package com.tcc.projeto_framework.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.projeto_framework.api.model.PhysicalPerson;
import com.tcc.projeto_framework.api.service.PhysicalPersonFacade;

@RestController
@RequestMapping(value = "/physical_persons")
public class PhysicalPersonController {
	@Autowired
	private PhysicalPersonFacade physicalPersonFacade;
	
	@PostMapping
	@ResponseBody
	public PhysicalPerson create(@RequestBody PhysicalPerson person) {
		person.calculateExpense();
		return physicalPersonFacade.create(person);
	}
	
	@GetMapping
	@ResponseBody
	public List<PhysicalPerson> getAll(){
		return physicalPersonFacade.getAll();
	}
}
