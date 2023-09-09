package com.tcc.projeto_framework.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tcc.projeto_framework.api.model.PhysicalPerson;

@Service
public class PhysicalPersonFacade {
private static final Map<Long, PhysicalPerson> persons = new HashMap<>();
	
	public PhysicalPerson create(PhysicalPerson person) {
		Long nextId = persons.keySet().size() + 1L;
		persons.put(nextId, person);
		return person;
	}
	
	public List<PhysicalPerson> getAll() {
		return new ArrayList<>(persons.values());
	}
}
