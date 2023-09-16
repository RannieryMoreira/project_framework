package com.tcc.projeto_framework.api.model;

public class PhysicalPerson extends Person {

	private Integer id;
	private String name;
	private String cpf;
	private double salary;
	private double expense;

	public PhysicalPerson(Integer id, String name, String cpf, double salary, double expense) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.salary = salary;
		this.expense = expense;
	}


    @Override
    protected double calculateTax(double baseSalary) {
    	double fgts = baseSalary * 0.08;
    	double vacation_fraction = baseSalary * 0.1111;
    	double thirteenth_fraction = baseSalary * 0.0833;
    	double tax = fgts + vacation_fraction + thirteenth_fraction;
        return tax;
    }

    @Override
    protected double calculateBenefitExpenses(double baseSalary) {
    	double food_voucher = 580.0;
    	double transport_voucher = 250;
    	double benefit = food_voucher + transport_voucher;
        return benefit;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setExpense(double expense) {
		this.expense = expense;
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
}
