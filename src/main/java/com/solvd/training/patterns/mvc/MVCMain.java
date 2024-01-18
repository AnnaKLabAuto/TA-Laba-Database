package com.solvd.training.patterns.mvc;

import com.solvd.training.model.Project;

public class MVCMain {
    public static void main(String[] args) {
        Project projectModel = new Project();
        ProjectView projectView = new ProjectView();
        ProjectController projectController = new ProjectController(projectModel, projectView);
        projectController.updateView();

    }
}
