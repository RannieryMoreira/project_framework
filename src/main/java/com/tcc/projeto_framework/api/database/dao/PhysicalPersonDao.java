package com.tcc.projeto_framework.api.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.tcc.projeto_framework.api.model.PhysicalPerson;

@Repository
public class PhysicalPersonDao {
    public PhysicalPersonDao() {
       
    }

    public PhysicalPerson insertPhysicalPerson(PhysicalPerson person, Connection connection) {
        try {
            String sql = "INSERT INTO physical_persons (name, cpf, salary, expense) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCpf());
            statement.setDouble(3, person.getSalary());
            statement.setDouble(4, person.getExpense());

            statement.executeUpdate();

            return person;
        } catch (SQLException e) {
            e.printStackTrace();
            return person;
        }
    }

    public Optional<List<PhysicalPerson>> getAllPhysicalPerson(Connection connection) {
        try {
            List<PhysicalPerson> physicalPersonList = new ArrayList<>();

            String sql = "SELECT * FROM physical_persons";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String cpf = resultSet.getString("cpf");
                Double salary = resultSet.getDouble("salary");
                Double expense = resultSet.getDouble("expense");

                PhysicalPerson resultPerson = new PhysicalPerson(id, name, cpf, salary, expense);
                physicalPersonList.add(resultPerson);
            }

            return physicalPersonList.isEmpty() ? Optional.empty() : Optional.of(physicalPersonList);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    public Optional<PhysicalPerson>getPhysicalPersonById(int id, Connection connection) {
        try {
            String sql = "SELECT * FROM physical_persons WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            PhysicalPerson person = null;

            if (resultSet.next()) {
                int resultId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String cpf = resultSet.getString("cpf");
                Double salary = resultSet.getDouble("salary");
                Double expense = resultSet.getDouble("expense");

                person = new PhysicalPerson(resultId, name, cpf, salary, expense);
            }


            return person == null ? Optional.empty() : Optional.of(person);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

	public ResponseEntity<?> updatePhysicalPersonById(PhysicalPerson person, int id, Connection connection) {
		try {
            String sql = "UPDATE physical_persons SET name = ?, cpf = ?, salary = ?, expense = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCpf());
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

	public ResponseEntity<?> deletePhysicalPersonById(int id, Connection connection) {
		try {
            String sql = "DELETE FROM physical_persons WHERE id = ?";
            
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
