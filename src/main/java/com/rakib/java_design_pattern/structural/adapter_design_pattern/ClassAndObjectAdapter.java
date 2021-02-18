package com.rakib.java_design_pattern.structural.adapter_design_pattern;

import lombok.Data;

@Data
class Employee {
    private String fullName;
    private String jobTitle;
    private String officeLocation;
}

interface Customer {
    String getCustomerName();

    String getCustomerDesignation();

    String getCustomerAddress();
}

class BusinessCard {
    public String designCard(Customer customer) {
        return customer.getCustomerName() + "\n" +
                customer.getCustomerDesignation() + "\n" +
                customer.getCustomerAddress();
    }
}

// make a bridge two different functionality in one class implementation
class EmployeeClassAdapter extends Employee implements Customer {
    @Override
    public String getCustomerName() {
        return this.getFullName();
    }

    @Override
    public String getCustomerDesignation() {
        return this.getJobTitle();
    }

    @Override
    public String getCustomerAddress() {
        return this.getOfficeLocation();
    }
}

class EmployeeObjectAdapter implements Customer {

    private final Employee employee;

    public EmployeeObjectAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getCustomerName() {
        return employee.getFullName();
    }

    @Override
    public String getCustomerDesignation() {
        return employee.getJobTitle();
    }

    @Override
    public String getCustomerAddress() {
        return employee.getOfficeLocation();
    }
}

public class ClassAndObjectAdapter {
    public static void main(String[] args) {
        BusinessCard businessCard = new BusinessCard();
        EmployeeClassAdapter employeeClassAdapter = new EmployeeClassAdapter();
        populateData(employeeClassAdapter);
        String designCardClass = businessCard.designCard(employeeClassAdapter);
        System.out.println(designCardClass);



        Employee employeeObject = new Employee();
        populateData(employeeObject);
        EmployeeObjectAdapter employeeObjectAdapter = new EmployeeObjectAdapter(employeeObject);
        String designCardObject = businessCard.designCard(employeeObjectAdapter);
        System.out.println(designCardObject);
    }

    public static void populateData(Employee employee) {
        employee.setFullName("Rakib");
        employee.setJobTitle("Java Engineer");
        employee.setOfficeLocation("Dhaka, MohakhaliDOHS");
    }
}
