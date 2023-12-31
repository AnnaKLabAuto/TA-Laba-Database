package com.solvd.training.model;

public class Employee {
    private int idEmployee;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String jobTitle;
    private double salary;
    private boolean isProjectManager;
    private int employmentStatusesId;
    private int leaveTypesId;
    private int departmentsId;

    public Employee(String firstName, String lastName, String email, String phone,
                    String jobTitle, double salary, boolean isProjectManager,
                    int employmentStatusesId, int leaveTypesId, int departmentsId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.isProjectManager = isProjectManager;
        this.employmentStatusesId = employmentStatusesId;
        this.leaveTypesId = leaveTypesId;
        this.departmentsId = departmentsId;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public boolean isProjectManager() {
        return isProjectManager;
    }

    public void setProjectManager(boolean projectManager) {
        isProjectManager = projectManager;
    }

    public int getEmploymentStatusesId() {
        return employmentStatusesId;
    }

    public void setEmploymentStatusesId(int employmentStatusesId) {
        this.employmentStatusesId = employmentStatusesId;
    }

    public int getLeaveTypesId() {
        return leaveTypesId;
    }

    public void setLeaveTypesId(int leaveTypesId) {
        this.leaveTypesId = leaveTypesId;
    }

    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", isProjectManager=" + isProjectManager +
                ", employmentStatusesId=" + employmentStatusesId +
                ", leaveTypesId=" + leaveTypesId +
                ", departmentsId=" + departmentsId +
                '}';
    }
}

