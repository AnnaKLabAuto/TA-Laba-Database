package com.solvd.training.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("task")
public class Task {

    @XmlAttribute(name = "idTask")
    @JsonProperty("idTask")
    private int idTask;

    @XmlElement(name = "taskName")
    @JsonProperty("taskName")
    private String taskName;

    @XmlElement(name = "taskDescription")
    @JsonProperty("taskDescription")
    private String taskDescription;

    @XmlElement(name = "priority")
    @JsonProperty("priority")
    private String priority;

    @XmlElement(name = "status")
    @JsonProperty("status")
    private String status;

    public Task() {}

    public Task(String taskName, String taskDescription, String priority, String status) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.status = status;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idTask=" + idTask +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

