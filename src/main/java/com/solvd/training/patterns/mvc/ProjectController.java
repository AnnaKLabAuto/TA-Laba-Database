package com.solvd.training.patterns.mvc;

import com.solvd.training.model.Project;

public class ProjectController {
    private Project model;
    private ProjectView view;

    public ProjectController(Project model, ProjectView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.displayProjectDetails(model);
    }
}
