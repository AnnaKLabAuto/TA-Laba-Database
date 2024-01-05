package com.solvd.training.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("department")
public class Department {

    @XmlAttribute(name = "idDepartment")
    @JsonProperty("idDepartment")
    private int idDepartment;

    @XmlElement(name = "departmentName")
    @JsonProperty("departmentName")
    private String departmentName;

    @XmlElement(name = "departmentDescription")
    @JsonProperty("departmentDescription")
    private String departmentDescription;

    public Department() {}

    public Department(String departmentName, String departmentDescription) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                '}';
    }
}

