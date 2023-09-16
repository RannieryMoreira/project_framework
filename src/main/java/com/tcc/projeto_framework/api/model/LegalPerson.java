package com.tcc.projeto_framework.api.model;

public class LegalPerson implements Person {

	private Integer id;
	private String name;
	private String cnpj;
	private double salary;
	private double expense;

	public LegalPerson(Integer id, String name, String cnpj, double salary, double expense) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.salary = salary;
		this.expense = expense;
	}
	
	@Override
	public void calculateExpense() {
	this.expense = this.salary * 1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
