package com.nata.ppmt.service.impl;

import com.nata.ppmt.exception.ProjectIdException;
import com.nata.ppmt.persistence.domain.Project;
import com.nata.ppmt.persistence.repository.ProjectRepository;
import com.nata.ppmt.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }
        catch (Exception e) {
            throw new ProjectIdException("Project ID'"+project.getProjectIdentifier().toUpperCase()+" already exist");
        }
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (isNull(project)) {
            throw new ProjectIdException("Project ID "+ projectId + " does not exist");
        }
        return project;
    }

    @Override
    public void deleteProjectById(String projectId) {
        Project existingProject = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (isNull(existingProject)) {
            throw new ProjectIdException("Project ID " + projectId + " does not exist");
        }

        projectRepository.delete(existingProject);
    }
}
