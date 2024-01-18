package com.solvd.training.patterns;

import com.solvd.training.patterns.strategy.Payment;

import java.util.ArrayList;
import java.util.List;

public class MockEmployeeExample {
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private double salary;
    private List<String> skills;
    private Payment paymentStrategy;

    public MockEmployeeExample(String firstName, String lastName, String email, String jobTitle, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.skills = new ArrayList<>();
    }

    public MockEmployeeExample() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setPaymentStrategy(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double calculatePayment() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        return paymentStrategy.calculatePayment(this);
    }

    @Override
    public String toString() {
        return "MockEmployeeExample{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}
