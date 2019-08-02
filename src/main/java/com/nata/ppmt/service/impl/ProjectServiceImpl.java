package com.nata.ppmt.service.impl;

import com.nata.ppmt.persistence.domain.Project;
import com.nata.ppmt.persistence.repository.ProjectRepository;
import com.nata.ppmt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveOrUpdateProject(Project project) {
        projectRepository.save(project);
        return project;
    }
}
