package com.nata.ppmt.service;

import com.nata.ppmt.persistence.domain.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);
}
