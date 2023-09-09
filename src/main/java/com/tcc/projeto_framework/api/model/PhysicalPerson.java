package com.tcc.projeto_framework.api.model;

public class PhysicalPerson implements Person {

	private String name;
	private String cpf;
	private double salary;
	private double expense;
	
	public PhysicalPerson(String name, String cpf, double salary) {
		this.name = name;
		this.cpf = cpf;
		this.salary = salary;
	}
	
	@Override
	public void calculateExpense() {
		this.expense = this.salary * 2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}
}
