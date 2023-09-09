package com.tcc.projeto_framework.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tcc.projeto_framework.api.model.LegalPerson;

@Service
public class LegalPersonFacade {
private static final Map<Long, LegalPerson> persons = new HashMap<>();
	
	public LegalPerson create(LegalPerson person) {
		Long nextId = persons.keySet().size() + 1L;
		persons.put(nextId, person);
		return person;
	}
	
	public List<LegalPerson> getAll() {
		return new ArrayList<>(persons.values());
	}
}
