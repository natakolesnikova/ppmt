package com.nata.ppmt.persistence.repository;

import com.nata.ppmt.persistence.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


}
