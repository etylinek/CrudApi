package com.example.homeworkrestapi.service;


import com.example.homeworkrestapi.model.ProjectModel;
import com.example.homeworkrestapi.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {


    private final ProjectRepository projectRepository;

    public List<ProjectModel> getProjectList() {
        return projectRepository.findAll();
    }


    public Optional<ProjectModel> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public ProjectModel addProject(ProjectModel project) {
       return projectRepository.save(project);
    }

    public ProjectModel updateProject(ProjectModel project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }


}
