package com.tcc.projeto_framework.api.service;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcc.projeto_framework.api.database.DatabaseConnectionManager;
import com.tcc.projeto_framework.api.database.dao.LegalPersonDao;
import com.tcc.projeto_framework.api.model.LegalPerson;

@Service
public class LegalPersonFacade {
	@Autowired
	private LegalPersonDao legalPersonDao;

	private final Connection connection;

	public LegalPersonFacade() {
		this.connection = DatabaseConnectionManager.getInstance().getConnection();
	}
	
	public LegalPerson create(LegalPerson person) {
		return legalPersonDao.insertLegalPerson(person, connection);
	}
	
	public Optional<List<LegalPerson>> getAll() {
		return legalPersonDao.getAllLegalPerson(connection);
	}
	
	public Optional<LegalPerson> getById(int id) {
		return legalPersonDao.getLegalPersonById(id, connection);
	}
	
	public ResponseEntity<?> updateById(LegalPerson person, int id) {
		return legalPersonDao.updateLegalPersonById(person, id, connection);
	}

	public ResponseEntity<?> deleteById(int id) {
		return legalPersonDao.deleteLegalPersonById(id, connection);
	}
}
