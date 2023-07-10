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

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date startTasksDate;

    @Column
    private Date finishTaskDate;

    @Column
    private TaskStatusType taskStatus;

    @ManyToOne
    private ProjectModel projectModel;

}
