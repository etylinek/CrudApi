package com.example.homeworkrestapi.service;


import com.example.homeworkrestapi.model.TaskModel;
import com.example.homeworkrestapi.repository.TaskRepository;
import com.example.homeworkrestapi.utils.errors.TaskNotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;


    public List<TaskModel> getAllTasks(){
        return taskRepository.findAll();
    }

    public TaskModel getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(()-> new TaskNotFoundExeption("Task not found"));
    }

    public TaskModel addTask(TaskModel task){
        return taskRepository.save(task);
    }

    public TaskModel updateTask(TaskModel task){
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
}
