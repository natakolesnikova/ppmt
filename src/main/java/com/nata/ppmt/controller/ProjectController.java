package com.nata.ppmt.controller;

import com.nata.ppmt.persistence.domain.Project;
import com.nata.ppmt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping()
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error: bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }
}
