package com.tcc.projeto_framework.api.service;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.projeto_framework.api.database.DatabaseConnectionManager;
import com.tcc.projeto_framework.api.database.dao.PhysicalPersonDao;
import com.tcc.projeto_framework.api.model.PhysicalPerson;
@Service
public class PhysicalPersonFacade {
	@Autowired
	private PhysicalPersonDao physicalPersonDao;

	private final Connection connection;

	public PhysicalPersonFacade() {
		this.connection = DatabaseConnectionManager.getInstance().getConnection();
	}
	
	public PhysicalPerson create(PhysicalPerson person) {
		return physicalPersonDao.insertPhysicalPerson(person, connection);
	}
	
	public Optional<List<PhysicalPerson>> getAll() {
		return physicalPersonDao.getAllPhysicalPerson(connection);
	}
	
	public Optional<PhysicalPerson> getById(int id) {
		return physicalPersonDao.getPhysicalPersonById(id, connection);
	}
}
