package com.example.homeworkrestapi.controller;


import com.example.homeworkrestapi.model.TaskModel;
import com.example.homeworkrestapi.service.TaskService;
import com.example.homeworkrestapi.utils.errors.TaskNotFoundExeption;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        try {
            return ResponseEntity.ok(taskService.getAllTasks());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<TaskModel> addTask(@RequestBody TaskModel task){
        try {
            return ResponseEntity.ok(taskService.addTask(task));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PatchMapping("/update")
    public  ResponseEntity<TaskModel> updateTask(@RequestBody TaskModel task){
        try{
            return ResponseEntity.ok(taskService.updateTask(task));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteTaskById (@PathVariable Long id){
        try{
            taskService.deleteTaskById(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
