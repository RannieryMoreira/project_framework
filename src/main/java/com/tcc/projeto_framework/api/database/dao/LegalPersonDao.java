package com.tcc.projeto_framework.api.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.tcc.projeto_framework.api.model.LegalPerson;

@Repository
public class LegalPersonDao {
    public LegalPersonDao() {
        
    }

    public LegalPerson insertLegalPerson(LegalPerson person, Connection connection) {
        try {
            String sql = "INSERT INTO legal_persons (name, cnpj, salary, expense) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCnpj());
            statement.setDouble(3, person.getSalary());
            statement.setDouble(4, person.getExpense());

            statement.executeUpdate();

            return person;
        } catch (SQLException e) {
            e.printStackTrace();
            return person;
        }
    }

    public Optional<List<LegalPerson>> getAllLegalPerson(Connection connection) {
        try {
            List<LegalPerson> legalPersonList = new ArrayList<>();

            String sql = "SELECT * FROM legal_persons";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String cnpj = resultSet.getString("cnpj");
                Double salary = resultSet.getDouble("salary");
                Double expense = resultSet.getDouble("expense");

                LegalPerson resultPerson = new LegalPerson(id, name, cnpj, salary, expense);
                legalPersonList.add(resultPerson);
            }

            return legalPersonList.isEmpty() ? Optional.empty() : Optional.of(legalPersonList);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    public Optional<LegalPerson>getLegalPersonById(int id, Connection connection) {
        try {
            String sql = "SELECT * FROM legal_persons WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            LegalPerson person = null;

            if (resultSet.next()) {
                int resultId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String cnpj = resultSet.getString("cnpj");
                Double salary = resultSet.getDouble("salary");
                Double expense = resultSet.getDouble("expense");

                person = new LegalPerson(resultId, name, cnpj, salary, expense);
            }


            return person == null ? Optional.empty() : Optional.of(person);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

	public ResponseEntity<?> updateLegalPersonById(LegalPerson person, int id, Connection connection) {
		try {
            String sql = "UPDATE legal_persons SET name = ?, cnpj = ?, salary = ?, expense = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCnpj());
            statement.setDouble(3, person.getSalary());
            statement.setDouble(4, person.getExpense());
            statement.setInt(5, id);

            int updatedRowsNumber = statement.executeUpdate();
            
            if (updatedRowsNumber == 0) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(person);

        } catch (SQLException e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar a entidade: " + e.getMessage());
        }
	}

	public ResponseEntity<?> deleteLegalPersonById(int id, Connection connection) {
		try {
            String sql = "DELETE FROM legal_persons WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int deletedRowsNumber = statement.executeUpdate();
            
            if (deletedRowsNumber == 0) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().build();

        } catch (SQLException e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir o recurso: " + e.getMessage());
        }
	}
}
