package com.solvd.training.patterns.mvc;

import com.solvd.training.model.Project;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class ProjectView {
    public void displayProjectDetails(Project project) {
        LOGGER.info(project);
    }
}
