package com.solvd.training.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.solvd.training.adapters.LocalDateTimeAdapter;
import com.solvd.training.adapters.LocalDateTimeDeserializer;
import com.solvd.training.adapters.LocalDateTimeSerializer;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Date;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("project")
public class Project {

    @XmlAttribute(name = "idProject")
    @JsonProperty("idProject")
    private int idProject;

    @XmlElement(name = "projectName")
    @JsonProperty("projectName")
    private String projectName;

    @XmlElement(name = "projectDescription")
    @JsonProperty("projectDescription")
    private String projectDescription;

    @XmlElement(name = "startDate", required = true)
    @XmlJavaTypeAdapter(type = LocalDateTimeAdapter.class, value = LocalDateTimeAdapter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    @XmlElement(name = "dueDate", required = true)
    @XmlJavaTypeAdapter(type = LocalDateTimeAdapter.class, value = LocalDateTimeAdapter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dueDate;

    public Project() {}

    public Project(int idProject, String projectName, String projectDescription, LocalDateTime startDate, LocalDateTime dueDate) {
        this.idProject = idProject;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProject=" + idProject +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                '}';
    }
}

