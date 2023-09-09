package com.tcc.projeto_framework.api.model;

public class LegalPerson implements Person {

	private String name;
	private String cnpj;
	private double salary;
	private double expense;

	public LegalPerson(String name, String cnpj, double salary) {
		this.name = name;
		this.cnpj = cnpj;
		this.salary = salary;
	}
	
	@Override
	public void calculateExpense() {
	this.expense = this.salary * 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
