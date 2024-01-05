package com.solvd.training.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("company")
public class Company {

    @XmlElementWrapper(name = "clients")
    @XmlElement(name = "client")
    @JsonProperty("clients")
    private List<Client> clients;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    @JsonProperty("departments")
    private List<Department> departments;

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    @JsonProperty("employees")
    private List<Employee> employees;

    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    @JsonProperty("projects")
    private List<Project> projects;

    @XmlElementWrapper(name = "tasks")
    @XmlElement(name = "task")
    @JsonProperty("tasks")
    private List<Task> tasks;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Company{" +
                "clients=" + clients +
                ", departments=" + departments +
                ", employees=" + employees +
                ", projects=" + projects +
                ", tasks=" + tasks +
                '}';
    }
}
