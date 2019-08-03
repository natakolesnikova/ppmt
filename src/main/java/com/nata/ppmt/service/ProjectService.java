package com.nata.ppmt.service;

import com.nata.ppmt.persistence.domain.Project;

import java.util.List;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);
    Project getProjectById(String projectId);
    List<Project> getAllProjects();
    void deleteProjectById(String projectId);
}
