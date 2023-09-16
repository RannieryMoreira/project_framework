package com.tcc.projeto_framework.api.model;

abstract class Person {
    public double calculateExpense(double salary) {
        double tax = calculateTax(salary);
        double benefit = calculateBenefitExpenses(salary);
        return salary + tax + benefit;
    }

    protected abstract double calculateTax(double baseSalary);
    protected abstract double calculateBenefitExpenses(double baseSalary);
}
