package com.example.homeworkrestapi.repository;

import com.example.homeworkrestapi.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {


}
