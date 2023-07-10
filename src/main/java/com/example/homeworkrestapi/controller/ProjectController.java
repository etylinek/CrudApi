package com.example.homeworkrestapi.controller;


import com.example.homeworkrestapi.model.ProjectModel;
import com.example.homeworkrestapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
@RequiredArgsConstructor
public class ProjectController {


    private final ProjectService projectService;


    @GetMapping("/all")
    public ResponseEntity<List<ProjectModel>> getAllProjects() {
        try {
            List<ProjectModel> projects = projectService.getProjectList();
            return ResponseEntity.ok(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectModel> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping
    public ResponseEntity<ProjectModel> addProject(@RequestBody ProjectModel project) {
        try {
            return ResponseEntity.ok(projectService.addProject(project));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<ProjectModel> updateProject(@RequestBody ProjectModel project){
        try{
            ProjectModel updatedProject = projectService.updateProject(project);
            return  ResponseEntity.ok(updatedProject);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        try {
            projectService.deleteProject(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
             return ResponseEntity.internalServerError().build();
        }
    }

}
