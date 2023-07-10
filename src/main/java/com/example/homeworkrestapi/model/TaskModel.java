package com.example.homeworkrestapi.model;


import com.example.homeworkrestapi.types.TaskStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column
//    private Long idProject;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_tasks_date")
    private Date startTasksDate;

    @Column(name = "finish_task_date")
    private Date finishTaskDate;

    @Column(name = "task_status")
    private TaskStatusType taskStatus;

    @ManyToOne
    private ProjectModel project;

}
